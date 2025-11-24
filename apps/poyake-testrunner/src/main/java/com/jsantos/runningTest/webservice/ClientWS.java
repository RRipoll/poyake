package com.jsantos.runningTest.webservice;


import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.util.ListValues;
import com.jsantos.metadata.testrunner.TrParameterDTO;

public class ClientWS {
	protected static final Logger logger = LoggerFactory.getLogger(ClientWS.class);

	static boolean showLog=false;
	
	public static ResponseEntity<String> call(String urlRequest, HttpMethod httpMethod) throws Exception {
		
		return call(urlRequest, null, httpMethod, null);
	}

	public static ResponseEntity<String> call(String urlRequest, Object jsonRequest, HttpMethod httpMethod, ListValues<TrParameterDTO> httpHeaderRequest) throws Exception {
		return call(urlRequest, jsonRequest, httpMethod, MediaType.APPLICATION_JSON, httpHeaderRequest);
	}

	public static ResponseEntity<String> call(URI uri, Object jsonRequest, HttpMethod httpMethod, HashMap<String, String> httpHeaderRequest) throws Exception {
		return call(uri, jsonRequest, httpMethod, MediaType.APPLICATION_JSON, httpHeaderRequest);
	}
	
	public static ResponseEntity<String> call(URI uri, Object request, HttpMethod httpMethod, MediaType mediaType, HashMap<String, String> httpHeaderRequest) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonRequestString = null;
		if (request instanceof String) {
			jsonRequestString = (String) request;
		}
		else {
			jsonRequestString = mapper.writeValueAsString(request);
		}
		if(isShowLog())logger.info("*** Calling rest web service {} {}", httpMethod, uri);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(mediaType);
		if (httpHeaderRequest != null) {
			httpHeaderRequest.forEach((key, value) -> httpHeaders.set(key, value));
		}
		HttpEntity<String> entity = new HttpEntity<String>(jsonRequestString, httpHeaders);
		ResponseEntity<String> response = new RestTemplate().exchange(uri, httpMethod, entity, String.class);
		
		try {
			Object jsonResponse = mapper.readValue(response.getBody().toString(), Object.class);
			String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonResponse);
			if(isShowLog())logger.debug("*** Response.body (JSON) = \n{}", indented);
		} catch (Exception ex) {
			if(isShowLog())logger.warn("It is not JSON format");
			if(isShowLog())logger.debug("*** Response.body = {}", response.getBody());
		}
		return response;
	}
		
	public static ResponseEntity<String> call(String urlRequest, Object request, HttpMethod httpMethod, MediaType mediaType, ListValues<TrParameterDTO> httpHeaderRequest) throws Exception {
		
		System.out.println(	urlRequest	);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonRequestString = null;
		if (request instanceof String) {
			jsonRequestString = (String) request;
		}
		else {
			jsonRequestString = mapper.writeValueAsString(request);
		}
		if(isShowLog())logger.info("*** Calling rest web service {} {} {}", httpMethod, urlRequest);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(mediaType);
		if (httpHeaderRequest != null) {
			for (TrParameterDTO trParameterDTO : httpHeaderRequest) {
				httpHeaders.set(trParameterDTO.getLabel(), trParameterDTO.getValue());
			}
			if(isShowLog())logger.info("*** header {} ", httpHeaders.toString());
		}
		HttpEntity<String> entity = new HttpEntity<String>(jsonRequestString, httpHeaders);
		
		ResponseEntity<String> response = new RestTemplate().exchange(urlRequest, httpMethod, entity, String.class);
		
		try {
			Object jsonResponse = mapper.readValue(response.getBody().toString(), Object.class);
			String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonResponse);
			if(isShowLog())logger.debug("*** Response.body (JSON) = \n{}", indented);
		} catch (Exception ex) {
			// is not it a JSON format?
			if(isShowLog())logger.warn("It is not JSON format");
			if(isShowLog())logger.debug("*** Response.body = {}", response.getBody());
		}
		return response;
	}
	
	public static ResponseEntity<Map> call2(String urlRequest, Object jsonRequest, HttpMethod httpMethod, HashMap<String, String> httpHeaderRequest) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonRequestString = null;
		if (jsonRequest instanceof String) {
			jsonRequestString = (String) jsonRequest;
		}
		else {
			jsonRequestString = mapper.writeValueAsString(jsonRequest);
		}
		ResponseEntity<Map> response = null;
		RestTemplate restTemplate = new RestTemplate();
		if(isShowLog())logger.info("*** Calling rest web service {} {}", httpMethod, urlRequest);
		if (httpMethod == HttpMethod.GET) {
			response = restTemplate.getForEntity(urlRequest, Map.class);
		} else {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			if (httpHeaderRequest != null) {
				httpHeaderRequest.forEach((key, value) -> httpHeaders.set(key, value));
			}
			HttpEntity<String> entity = new HttpEntity<String>(jsonRequestString, httpHeaders);
			response = new RestTemplate().exchange(urlRequest, httpMethod, entity, Map.class);
		}

		try {
			Object jsonResponse = mapper.readValue(response.getBody().toString(), Object.class);
			String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonResponse);
			if(isShowLog())logger.info("*** Response.body (JSON) = \n{}", indented);
		} catch (Exception ex) {
			// is it not a JSON format?  logback
			if(isShowLog())logger.warn("It is not JSON format");
			if(isShowLog())logger.info("*** Response.body = {}", response.getBody());
		}
		return response;
	}

	public HttpHeaders getHttpHeaders(String jsonHeader) throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (jsonHeader != null && !jsonHeader.trim().isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();
			HttpHeader httpHeader = objectMapper.readValue(jsonHeader, HttpHeader.class);
			requestHeaders.set("inputSourceCode", httpHeader.getInputSourceCode());
			requestHeaders.set("inputUserId", httpHeader.getInputUserId());
			requestHeaders.set("api_key", httpHeader.getApi_key());
			if(isShowLog())logger.info("*** Calling using httpHeader = {}", httpHeader);
		}
		return requestHeaders;
	}
	
	public static void downloadFile(String urlRequest, Path destPath) throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<byte[]> response = restTemplate.exchange(urlRequest, HttpMethod.GET, entity, byte[].class,
				"1");

		if (response.getStatusCode() == HttpStatus.OK) {
			Files.write(destPath, response.getBody());
		}
	}

	public static boolean isShowLog() {
		return showLog;
	}

	public static void setShowLog(boolean showLog) {
		ClientWS.showLog = showLog;
	}
}
