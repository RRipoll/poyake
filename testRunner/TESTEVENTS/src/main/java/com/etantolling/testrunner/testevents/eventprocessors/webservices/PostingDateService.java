package com.etantolling.testrunner.testevents.eventprocessors.webservices;

public class PostingDateService {

	
	public void getPostingDate(String appBaseUrl) {
		
		String urlRequest = "/api/testrunner/posting-date";
		if (urlRequest.startsWith("/")) {
			urlRequest = appBaseUrl + urlRequest;
		}
	}
}
