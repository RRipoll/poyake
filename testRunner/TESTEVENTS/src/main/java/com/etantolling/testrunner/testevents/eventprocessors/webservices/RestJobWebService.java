package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.testing.TestParameterList;

public class RestJobWebService extends RestWebService {
	
	@Override
	public  String createURL(TestParameterList params,LinkedHashMap<String, Object> storeValues,String testBaseUrl,String appBaseUrl,String appJobUrl) throws Exception {
		try {
		String urlRequest = params.getString(params.getInputValues(),"URL");
		if (null==urlRequest) throw new Exception("URL is null");
		if (urlRequest.startsWith("/")) {
			urlRequest = appJobUrl + urlRequest;
		}
		return urlRequest;
		} catch (Exception e) {
            throw new Exception(" EventId: " +params.getInt(params.getInputValues(),"EVENT_ID")+ e.getMessage(),e );			
		}
	}
	
}
	