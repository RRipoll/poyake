package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.LinkedHashMap;
import java.util.Map;

import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;

public class RemoveStoreValues implements ITestEventRunner{
	
	//private static final Logger logger = LoggerFactory.getLogger(RestWebService.class);
	
	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params,LinkedHashMap<String, Object> storeValues,String testBaseUrl,String appBaseUrl,String appJobUrl) throws Exception {
		try {
		storeValues.clear();
		
		} catch (Exception e) {
            throw new Exception(" EventId: " +params.getInt(params.getInputValues(),"EVENT_ID")+ e.getMessage(),e );			
		}
		return null;
	}
	
	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		// TODO Auto-generated method stub
		
	}
}