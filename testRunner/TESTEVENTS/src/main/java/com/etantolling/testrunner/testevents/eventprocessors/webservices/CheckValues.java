package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;

public class CheckValues implements ITestEventRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(CheckValues.class);
	
	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params,LinkedHashMap<String, Object> storeValues,String testBaseUrl,String appBaseUrl,String appJobUrl) throws Exception {
		try {
		for (String key : params.getInputValues().keySet()) {
			if(params.getOutputValues().containsKey(key) && null!=((Map<String, Object>)params.getInputValues().get(key)).get("value")) {
				String label=(String) ((Map<String, Object>)params.getInputValues().get(key)).get("label");
				if(key.equals("INTEGER") ) {
					if(params.getInt(params.getInputValues(), key)!=params.getInt(params.getOutputValues(), key))
						throw new Exception(label +" don't match");
				}else if(key.equals("TEXT") ) {
					if(!params.getString(params.getInputValues(), key).equals(params.getString(params.getOutputValues(), key)))
						throw new Exception(label +" don't match");
				}else if(key.equals("DATE") ) {
					if(params.getDate(params.getInputValues(), key).getTime()!=params.getDate(params.getOutputValues(), key).getTime())
						throw new Exception(label +" don't match");
				}else if(key.equals("BIGDECIMAL") ) {
					if(!params.getBigDecimal(params.getInputValues(), key).equals(params.getBigDecimal(params.getOutputValues(), key)))
						throw new Exception(label +" don't match");
				}
		}}
		} catch (Exception e) {
            throw new Exception(" EventId: " +params.getInt(params.getInputValues(),"EVENT_ID")+ e.getMessage(),e );			
		}
		return null;
	}
	
	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println("*** ------------------------------------------ -------------------------------------- ***");
		System.out.println("*** -------------------------- EVENT  START -------------------------------------- ***");
		System.out.println("*** ---------------------------------- ---------------------------------------------- ***");
		System.out.println("*** Request = "+ url);
		System.out.println("parameters "+parameters);
		System.out.println("JSON "+json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response.getStatusCode = "+ responseCode);
		System.out.println("*** Response = "+ responseBody);
		
		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println("*** -----------------------------EVENT RestWebService END ------------------- ***");
		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		
	}


	@Override
	public void showStarting(String url, Object parameters, String json) {
		// TODO Auto-generated method stub
		
	}
}