package com.etantolling.testrunner.testserver.rs.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.tomcat.util.ExceptionUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, value= {"cause", "stackTrace", "message", "localizedMessage", "suppressed"})
public class TollApiException extends Exception {

	private static final long serialVersionUID = 8261606342471094743L;

	@JsonIgnore
	private TollApiError error = TollApiError.UNKNOWN_ERROR;
	
	private String verb;
	private String url;
	private String body;

	public TollApiException(TollApiError tollApiError) {
		this.error = tollApiError;
	}

	public TollApiException(TollApiError tollApiError, String message) {
		super(message);
		this.error = tollApiError;
	}

	@Deprecated
	public TollApiException(String message) {
		super(message);
	}

	public TollApiException(TollApiError tollApiError, Throwable cause) {
		super(cause);
		this.error = tollApiError;
	}

	public TollApiException(TollApiError tollApiError, String message, Throwable cause) {
		super(message, cause);
		this.error = tollApiError;
	}
	
	@Deprecated
	public TollApiException(Throwable cause) {
		super(cause);
	}
	
	@Deprecated
	public TollApiException(String message, Throwable cause) {
		super(message, cause);
	}
	
	@JsonAnyGetter
	public Map<String, Object> tollApiErrorProperties() {
		Map<String, Object> properties = new LinkedHashMap<>();
		properties.put("verb", verb);
		properties.put("url", url);
		properties.put("body", body);
		properties.put("errorName", error.name());
		properties.put("errorCode", error.getCode());
		properties.put("errorCodeDescription", error.getCodeDescription());
		// TODO: disable this if it is not in dev mode:
		properties.put("errorMessage", this.getMessage());
		properties.put("errorStackTrace", this.getStackTrace().toString());
		
		return properties;
	}

	public TollApiError getError() {
		return error;
	}

	public void setError(TollApiError error) {
		this.error = error;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
