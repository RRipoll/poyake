package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.LinkedHashMap;
import java.util.Map;

import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.core.testingws.TestRunner;
import com.etantolling.testrunner.test.core.testrun.TestRun;
import com.etantolling.testrunner.testevents.TestEventFactory;

public class RunATestConditional implements ITestEventRunner{
	
	//private static final Logger logger = LoggerFactory.getLogger(RestWebService.class);
	
	@Override
	public 	LinkedHashMap<String, Object> runEvent(TestParameterList params,LinkedHashMap<String, Object> storeValues,String testBaseUrl,String appBaseUrl,String appJobUrl) throws Exception {
		
		String label=(String) ((Map<String, Object>)params.getInputValues().get("condition")).get("label");
		Object value=((Map<String, Object>)params.getInputValues().get("condition")).get("value");
		
		Object storeValue=storeValues.get(label);
		if(label.equals("condition"))
			storeValue=storeValues.get(value.toString());
		boolean go=false;
		if(null==storeValue)
			go=true;
		else if (value.toString()==storeValue.toString())
			go=true;
		else return storeValues;
		
		Integer testId= params.getInt(params.getInputValues(),"testId");
		return runTest(testId,storeValues,testBaseUrl,appBaseUrl,appJobUrl);
	}

	public LinkedHashMap<String, Object> runTest(Integer testId,LinkedHashMap<String, Object> storeValues,String testBaseUrl,String appBaseUrl,String appJobUrl) throws Exception {
		try {
		showStarting(null, testId, null);
		
		TestRun tr = new TestRun();
		tr.setTestId(testId);
		TestRunner trc =new TestRunner(testId,new TestEventFactory(),testBaseUrl,appBaseUrl,appJobUrl);
		if(null!=storeValues)trc.setStoreValues(storeValues);
		trc.runToTargetEvent(null);
		return trc.getStoreValues();
		} catch (Exception e) {
            throw new Exception(" TestId: "+testId +" "+e.getMessage(),e );			
		}
	}
	
	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		
		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println("*** -----------------------------EVENT Run A Test END -------------- ***");
		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		
	
	}
	@Override
	public void showStarting(String url, Object parameters, String json) {
		System.out.println("*** ------------------------------------------ --------------------------------------- ***");
		System.out.println("*** -------------------------- EVENT Run A Test START --------------- ***");
		System.out.println("*** ---------------------------------- ----------------------------------------------- ***");
		System.out.println("*** parameters "+parameters.toString());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}