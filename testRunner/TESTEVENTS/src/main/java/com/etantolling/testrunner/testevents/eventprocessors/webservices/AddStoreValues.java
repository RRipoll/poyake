package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.LinkedHashMap;
import java.util.Map;

import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;

public class AddStoreValues implements ITestEventRunner{
	
	//private static final Logger logger = LoggerFactory.getLogger(RestWebService.class);
	
	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params,LinkedHashMap<String, Object> storeValues,String testBaseUrl,String appBaseUrl,String appJobUrl)  {
		
		boolean onlyIfNotExist=false;
		
		for (String key : params.getInputValues().keySet()) {
			if(key.equals("EVENT_ID") || key.equals("AUTHORIZATION"))continue;
			String label=(String) ((Map<String, Object>)params.getInputValues().get(key)).get("label");
			Object value=((Map<String, Object>)params.getInputValues().get(key)).get("value");
			if(null!=params.getOutputValues().get(key))
					value=((Map<String, Object>)params.getOutputValues().get(key)).get("value");
			if(key.equals("OnlyIfNotExists")) { onlyIfNotExist=value.equals("true");continue;}
			if(null!=value) {
				if(onlyIfNotExist && null!=storeValues.get(label))continue;
				if(value instanceof String && ((String) value).startsWith("<"))
					for (String name : storeValues.keySet()) {
						if(value.equals("<"+name+">"))
							value=storeValues.get(name);
					}
				storeValues.put(label, value);
				//params.getInputValues().remove(label);
			}
		System.out.println("Store Value: "+ label + "=" + value.toString()   );
		}
		return storeValues;
	}
	
	
	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		// TODO Auto-generated method stub
		
	}
}