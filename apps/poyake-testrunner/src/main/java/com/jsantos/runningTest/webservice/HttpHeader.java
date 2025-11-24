package com.jsantos.runningTest.webservice;


public class HttpHeader {
	private String inputSourceCode;
	private String inputUserId;
	private String api_key;

	public HttpHeader() {
	}
	
	public HttpHeader(String inputSourceCode, String inputUserId) {
		this.inputSourceCode = inputSourceCode;
		this.inputUserId = inputUserId;
	}

	public HttpHeader(String inputSourceCode, String inputUserId, String api_key) {
		this.inputSourceCode = inputSourceCode;
		this.inputUserId = inputUserId;
		this.api_key = api_key;
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	public String getInputUserId() {
		return inputUserId;
	}

	public void setInputUserId(String inputUserId) {
		this.inputUserId = inputUserId;
	}

	public String getInputSourceCode() {
		return inputSourceCode;
	}

	public void setInputSourceCode(String inputSourceCode) {
		this.inputSourceCode = inputSourceCode;
	}

	@Override
	public String toString() {
		return "HttpHeader [inputSourceCode=" + inputSourceCode + ", inputUserId=" + inputUserId + ", api_key=" + api_key + "]";
	}
}