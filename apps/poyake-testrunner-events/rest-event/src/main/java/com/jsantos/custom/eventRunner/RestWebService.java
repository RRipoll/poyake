package com.jsantos.custom.eventRunner;

import java.io.File;

import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.extendeddto.StoreValuesTestExtDTO;
import com.jsantos.gui.detail.DefaultDetailContainer;
import com.jsantos.metadata.MTrestRunnerData;
import com.jsantos.metadata.testrunner.EventStatus;
import com.jsantos.metadata.testrunner.MTTableRESTEVENTDEFINITION;
import com.jsantos.metadata.testrunner.RestEventDefinitionDTO;
import com.jsantos.metadata.testrunner.StoreValuesEventDTO;
import com.jsantos.metadata.testrunner.TrParameterDTO;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.runningTest.SystemOut;
import com.jsantos.runningTest.webservice.ClientWS;
import com.jsantos.service.ITestEventRunner;

public class RestWebService implements ITestEventRunner {

	//private static final Logger logger = LoggerFactory.getLogger(RestWebService.class);

	public String createURL(RestEventDefinitionDTO event, StoreValuesTestExtDTO storeValues) throws Exception {
		String urlRequest = event.getUrl();
		if (null == urlRequest)
			throw new Exception("URL is null");
		if (urlRequest.startsWith("/")) {
			urlRequest = storeValues.getApp_Api_Url() + urlRequest;
		}
		return urlRequest;
	}

	@Override
	public StoreValuesTestExtDTO runEvent(IDetachedRecord event, StoreValuesTestExtDTO storeValues) throws Exception {
		ResponseEntity<String> response = null;
		StoreValuesEventDTO svm = new StoreValuesEventDTO();
		svm.setEvent(event);
		svm.setEventName(((RestEventDefinitionDTO) event).getEventName());
		svm.setStatus(EventStatus.PROCESSING);
		File file = SystemOut.setSystemOutToFile();
		if (null != file)
			svm.setLog(file.getAbsolutePath());
		storeValues.addStoreValuesEvent(svm);
		try {
			String urlRequest = createURL((RestEventDefinitionDTO) event, storeValues);
			String jsonRequest = ((RestEventDefinitionDTO) event).getJson();
			if (null != jsonRequest) {
				jsonRequest = jsonRequest.replace("\n", " ");
				jsonRequest = storeValues.replacePathValues(jsonRequest);
			}
			String httpMethod = MTrestRunnerData.HTTPMETHOD
					.getEnumerationValue(((RestEventDefinitionDTO) event).getHttpMethod());
			Object param=DBValueMapper.loadValue(event,
					MTTableRESTEVENTDEFINITION.PARAMETERS);
			ListValues<TrParameterDTO> parameters=new ListValues<TrParameterDTO>();
			if(!(param instanceof DBValueMapper.Null)) 
				parameters = (ListValues<TrParameterDTO>) param;
			urlRequest = setRequestParams(urlRequest, parameters);
			urlRequest = storeValues.replacePathValues(urlRequest);
			try {
				showStarting(urlRequest, parameters, jsonRequest);
				response = ClientWS.call(urlRequest, jsonRequest, HttpMethod.valueOf(httpMethod), parameters);
			} catch (Exception e) {
				String message = e.getMessage() + " / " + e.getCause();
				svm.setStatus(EventStatus.ERROR);
				if (e instanceof HttpStatusCodeException) {
					try {
						message = ((HttpStatusCodeException) e).getResponseBodyAsString();
						/*
						String errorMessage = e.getMessage();
						String errorName = ((HttpStatusCodeException) e).getResponseBodyAsString();
						if (!errorMessage.contains("400"))
							try {
								JSONObject jsonObj = new JSONObject(message);
								errorName = jsonObj.get("errorName").toString();
								Object errorCode = jsonObj.get("errorCode");
								Object errorCodeDescription = jsonObj.get("errorCodeDescription");
								errorMessage = jsonObj.get("errorMessage").toString();
								Object errorStackTrace = jsonObj.get("errorStackTrace");
								System.out.println("*** ERROR *** = "+ e.getMessage());
								System.out.println("errorName = "+ errorName);
								System.out.println("errorCode= = "+ errorCode);
								System.out.println("errorCodeDescription= = "+ errorCodeDescription);
								System.out.println("errorMessage= = "+ errorMessage);
								System.out.println("errorStackTrace= = "+ errorStackTrace);
							} catch (Exception e2) {
							}
							
							https://mazerunnerapi.azurewebsites.net/api/Game/a787854b-d82b-4795-8289-c10047339654?code=CTLH2JGw02ntEMlwXANzIegaNFGi/vSE34NSvgar5WYFb1x349z8jw==
							https://mazerunnerapi.azurewebsites.net/api/Game/4e029a62-ec89-4ce3-a05f-19d553f5ec80?code=bINetL5Vm7pVuoPm/SXIMi9Niv3D9DxpPQ8tDPbsyJ0J4KZfSQl/yA==
							
							*/
						showSummary(urlRequest, parameters, jsonRequest, message, null);
						throw new Exception(message, e);
					} catch (Exception ee) {
						//System.out.println(ee.getMessage());
					}
				}
				throw new Exception(message + " ", e);
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				Object jsonResponse = mapper.readValue(response.getBody(), Object.class);
			} catch (Exception ex) {
				System.out.println("It is not JSON format");
				System.out.println("*** Response.body = "+ response.getBody());
			}
			if (response.getBody() != null) {
				if (!(response.getStatusCode() == HttpStatus.ACCEPTED || response.getStatusCode() == HttpStatus.CREATED
						|| response.getStatusCode() == HttpStatus.CONTINUE
						|| response.getStatusCode() == HttpStatus.FOUND || response.getStatusCode() == HttpStatus.OK)) {
					try {
						showSummary(urlRequest, parameters, jsonRequest, response.getStatusCode().toString(),
								response.getBody().toString());
					} catch (Exception ee) {
					}
					throw new Exception("Test error: " + " " + response.getBody());
				}
			}
			try {
				showSummary(urlRequest, parameters, jsonRequest, response.getStatusCode().toString(),
						response.getBody());
			} catch (Exception ee) {
			}

		} catch (Exception e) {
			svm.setStatus(EventStatus.ERROR);
			if (null != response && response.hasBody())
				svm.setData(response.getBody());
			e.printStackTrace();
			SystemOut.closeFileSystemLog(file);
			throw new Exception(((RestEventDefinitionDTO) event).getEventName() + ": " + e.getMessage(), e);
		}

		svm.setData(response.getBody());
		SystemOut.closeFileSystemLog(file);
		svm.setStatus(EventStatus.DONE);
		return storeValues;
	}

	private String setRequestParams(String urlRequest, ListValues<TrParameterDTO> parameters) {

		for (TrParameterDTO key : parameters) {
			urlRequest = urlRequest.replace("{" + key.getLabel() + "}", key.getValue());
		}
		return urlRequest;
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

	@Override
	public String forEventType() {
		return "REST_SERVICE";
	}

	@Override
	public IDetailContainer getDetailContainer() {
		DefaultDetailContainer detail = new DefaultDetailContainer();
		// detail.setSearchName(forEventType());
		return detail;
	}

	@Override
	public MTTable getMTTable() {

		return MTrestRunnerData.RESTEVENTDEFINITION;
	}

	/*
	@Override
	public Component getRowDescription(IDetachedRecord event) {
		RestEventDefinitionDTO apd = ((RestEventDefinitionDTO) event);
		return new Label(apd.getEventTypeId() + " : " + apd.getEventName() + " / " + apd.getDescription());
	}
*/
}