package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestWebService implements ITestEventRunner {

	private static final Logger logger = LoggerFactory.getLogger(RestWebService.class);

	public String createURL(TestParameterList params, LinkedHashMap<String, Object> storeValues, String testBaseUrl,
			String appBaseUrl, String appJobUrl) throws Exception {

		String urlRequest = params.getString(params.getInputValues(), "URL");
		if (null == urlRequest)
			throw new Exception("URL is null");
		if (urlRequest.startsWith("/")) {
			urlRequest = appBaseUrl + urlRequest;
		}
		return urlRequest;

	}

	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params, LinkedHashMap<String, Object> storeValues,
			String testBaseUrl, String appBaseUrl, String appJobUrl) throws Exception {
		try {
			String urlRequest = createURL(params, storeValues, testBaseUrl, appBaseUrl, appJobUrl);

			String jsonRequest = params.getString(params.getInputValues(), "JSON");
			if (null != jsonRequest)
				jsonRequest = jsonRequest.replace("\n", "");

			String httpMethod = params.getString(params.getInputValues(), "HTTPMETHOD");

			Map getParameters = getParamenters(params.getInputValues());

			urlRequest = setRequestParams(urlRequest, getParameters);
			ResponseEntity<String> response = null;
			try {
				showStarting(urlRequest, getParameters, jsonRequest);
				response = ClientWS.call(urlRequest, jsonRequest, HttpMethod.valueOf(httpMethod),
						(HashMap<String, String>) getParameters);
			} catch (Exception e) {
				String message = e.getMessage() + " / " + e.getCause();
				if (e instanceof HttpStatusCodeException) {
					try {
						message = ((HttpStatusCodeException) e).getResponseBodyAsString();
						String errorMessage=e.getMessage();
						String errorName=((HttpStatusCodeException) e).getResponseBodyAsString();
						if(!errorMessage.contains("400"))
						try {
							JSONObject jsonObj = new JSONObject(message);
							errorName = jsonObj.get("errorName").toString();
							Object errorCode = jsonObj.get("errorCode");
							Object errorCodeDescription = jsonObj.get("errorCodeDescription");
							errorMessage = jsonObj.get("errorMessage").toString();
							Object errorStackTrace = jsonObj.get("errorStackTrace");

							logger.error("*** ERROR *** = \n{}", e.getMessage());
							logger.error("errorName \n{}", errorName);
							logger.error("errorCode= \n{}", errorCode);
							logger.error("errorCodeDescription= \n{}", errorCodeDescription);
							logger.error("errorMessage= \n{}", errorMessage);
							logger.error("errorStackTrace= \n{}", errorStackTrace);
						} catch (Exception e2) {
							// TODO: handle exception
						}
						showSummary(urlRequest, getParameters, jsonRequest, errorName,
								errorMessage);
						throw new Exception(errorMessage,e);
					} catch (Exception ee) {
					   System.out.println(ee.getMessage());
					}
				}
				throw new Exception(message + " " + params.toString(), e);
			}
			ObjectMapper mapper = new ObjectMapper();
			params.getStoreJson().addJsonString( params.getInputValues().get("EVENT_ID").toString(), response.getBody());
			try {
				Object jsonResponse = mapper.readValue(response.getBody().toString(), Object.class);
				getResultsParams(jsonResponse, params.getOutputValues());

			} catch (Exception ex) {
				logger.info("It is not JSON format");
				logger.info("*** Response.body = {}", response.getBody());
				if (params.getOutputValues().size() > 0) {
					String respond = response.getBody();
					if (null != respond) {
						for (String element : params.getOutputValues().keySet()) {
							((LinkedHashMap<String, Object>) params.getOutputValues().get(element)).put("value",
									respond);
						}
					}
				}
			}
			if (response.getBody() != null) {
				if (!(response.getStatusCode() == HttpStatus.ACCEPTED || response.getStatusCode() == HttpStatus.CREATED
						|| response.getStatusCode() == HttpStatus.CONTINUE
						|| response.getStatusCode() == HttpStatus.FOUND || response.getStatusCode() == HttpStatus.OK)) {
					try {
						showSummary(urlRequest, getParameters, jsonRequest, response.getStatusCode().toString(),
								response.getBody().toString());
					} catch (Exception ee) {
					}
					throw new Exception("Test error: " + params.toString() + " " + response.getBody());
				}
			}
			try {
				showSummary(urlRequest, getParameters, jsonRequest, response.getStatusCode().toString(),
						response.getBody().toString());
			} catch (Exception ee) {
			}

		} catch (Exception e) {
			throw new Exception(" EventId: " +params.getString(params.getInputValues(),"EVENT_ID")+ e.getMessage(), e);
		}
		return null;
	}

	private HashMap<String, String> getParamenters(Map<String, Object> inputValues) throws Exception {

		HashMap<String, String> retValue = new LinkedHashMap<String, String>();

		for (String item : inputValues.keySet()) {
			if (item.equals("JSON"))
				continue;
			String value = null;
			if (inputValues.get(item) instanceof Map) {
				if (!(boolean) ((LinkedHashMap<String, Object>) inputValues.get(item)).get("isInput"))
					continue;
				try {
					value = ((Map<String, Object>) inputValues.get(item)).get("value").toString();
				} catch (Exception e) {
					throw new Exception(item + " " + value + " is null ");
				}

			} else
				value = inputValues.get(item).toString();
			retValue.put(item, value);

		}

		return retValue;
	}

	private String setRequestParams(String urlRequest, Map<String, String> inputValues) {

		
		for (String key : inputValues.keySet()) {
 
			if (key.equals("page")) 
				urlRequest += (urlRequest.contains("?")?"&":"?")+"page={page}";
			if (key.equals("size")) 
				urlRequest += (urlRequest.contains("?")?"&":"?")+"size={size}";
			if (key.equals("orderBy")) 
				urlRequest += (urlRequest.contains("?")?"&":"?")+"orderBy={orderBy}";
			urlRequest = urlRequest.replace("{" + key + "}", inputValues.get(key));
		}
		
		return urlRequest;

		/*
		 * urlRequest=urlRequest+"?";
		 * 
		 * for (String key : inputValues.keySet()) {
		 * if(urlRequest.contains(key))continue; if(key.equals("HTTPMETHOD") ||
		 * key.equals("AUTHORIZATION") ||key.equals("URL")
		 * ||key.equals("EVENT_ID"))continue;
		 * 
		 * if(urlRequest.endsWith("?")) urlRequest+=""+key+"={"+key+"}"; else
		 * urlRequest+="&"+key+"={"+key+"}";
		 * urlRequest=urlRequest.replace("{"+key+"}",inputValues.get(key) ); }
		 * if(urlRequest.endsWith("?")) urlRequest=urlRequest.replace("?", ""); return
		 * urlRequest;
		 * 
		 */
	}

	private void getResultsParams(Object jsonResponse, Map<String, Object> outputValues) {

		LinkedHashMap<String, Object> clone = (LinkedHashMap<String, Object>) ((LinkedHashMap) outputValues).clone();

		if (null != jsonResponse) {
			if (jsonResponse instanceof ArrayList) {
				ArrayList<Object> array = (ArrayList) jsonResponse;
				for (Object object : array) {
					getResultsParams(object, outputValues);
				}
			} else if (jsonResponse instanceof Map) {
				LinkedHashMap<String, Object> respon = (LinkedHashMap<String, Object>) jsonResponse;
				for (String item : respon.keySet()) {
					if (respon.get(item) instanceof LinkedHashMap)
						getResultsParams(item, outputValues);
					else if (respon.get(item) instanceof ArrayList)
						for (Object arrayItem : (ArrayList) respon.get(item)) {
							getResultsParams(arrayItem, outputValues);
						}
					else {
						for (String output : clone.keySet()) {
							if (output.equals(item)) {
								Object value = respon.get(output);
								if (value instanceof Double)
									value = BigDecimal.valueOf((Double) value);
								((LinkedHashMap<String, Object>) outputValues.get(output)).put("value", value);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		System.out
				.println("*** ------------------------------------------ --------------------------------------- ***");
		System.out.println("*** -------------------------- EVENT RestWebService START --------------- ***");
		System.out
				.println("*** ---------------------------------- ----------------------------------------------- ***");
		System.out.println("*** Request = " + url);
		System.out.println("*** parameters " + parameters);
		System.out.println("*** JSON " + json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response.getStatusCode = " + responseCode);
		System.out.println("*** Response = " + responseBody);

		System.out
				.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println("*** -----------------------------EVENT RestWebService END -------------- ***");
		System.out
				.println("*** ---------------------------------------------------------------------------------- ***");
	}
}