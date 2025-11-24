package com.etantolling.testrunner.test.core.utils;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

public class Recorder {
	private static final Logger log = LoggerFactory.getLogger(Recorder.class);

	/**
	 * 
	 * It's used for an event of creation
	 * @param urlConverter
	 * @param dto
	 * @param urlRestWs
	 * @throws SQLException
	 */
	public static void recordEvent(String urlConverter, Object dto, String urlRestWs, HttpMethod httpMethod) {
		// if you place WS_URS as class constant you will get next error: "java.lang.ExceptionInInitializerError: null"
	    
		/*
		String WS_URL = "http://localhost:" + EnvironmentHelper.getTomcatPort() + "/nh-rs";
		try {
			if (Session.isMacroRecording()) {
				log.info("*** # macroEventList.size = {}", Session.getRecordedEvents().getEventList().size());
				// What's the json format for the object newCustomer? Just NH-RS knows how to do that conversion, so call it:
//				ResponseEntity<String> response = template.postForEntity(WS_URL + urlConverter, dto, String.class);
				HttpHeaders requestHeaders = new HttpHeaders();
				requestHeaders.setContentType(MediaType.APPLICATION_JSON);
				
				HttpEntity<Object> entity = new HttpEntity<Object>(dto, requestHeaders);
				ResponseEntity<String> response = null;
				try {
					log.info("*** calling converter {}", WS_URL + urlConverter);
					response = new RestTemplate().exchange(WS_URL + urlConverter, HttpMethod.POST, entity, String.class);
				} catch (Exception ex) {
					log.error("ERROR STACKTRACE: ", ex);;
				}
				
				HttpStatus status = response.getStatusCode();
				String jsonResponse = response.getBody();
				// TODO: check jsonResponse errors
				log.info("*** json WS.status = {}", status);
				log.info("*** json WS.body = {}", jsonResponse);
				
				recordEvent(urlRestWs, jsonResponse, httpMethod);
			}
		} catch (Exception ex) {
			log.error("ERROR STACKTRACE: ", ex);;
			log.error("Error trying to record the macro");
		}
		*/
	}	

	/**
	 * It's used for an event of updating
	 * @param urlConverter Will be like "/rest/coverter/xxxx"
	 * @param dto
	 * @param urlRestWs	will be like "/rest/xxxx"
	 * @param id Identification (PK) o the object to update
	 * @throws SQLException
	 */
	public static void recordEvent(String urlConverter, Object dto, String urlRestWs, Integer id, HttpMethod httpMethod) {
		if (urlRestWs.endsWith("/")) {
			recordEvent(urlConverter, dto, urlRestWs + id, httpMethod);
		}
		else {
			recordEvent(urlConverter, dto, urlRestWs + "/" + id, httpMethod);
		}
	}	
	
	public static void recordEvent(String urlRestWs, String json, HttpMethod httpMethod) {
		/*
		try {
			if (Session.isMacroRecording()) {
				Session.recordMacroEvent(urlRestWs, json, httpMethod.name());
				log.info("*** # macroEventList.size = {}", Session.getRecordedEvents().getEventList().size());
				log.info("*** macroEventList = {}", Session.getRecordedEvents().getEventList());
			}
		} catch (Exception e) {
			log.error("ERROR STACKTRACE: ", e);
			log.error("Error trying to record the macro");
		}
		*/
	}
	

}
