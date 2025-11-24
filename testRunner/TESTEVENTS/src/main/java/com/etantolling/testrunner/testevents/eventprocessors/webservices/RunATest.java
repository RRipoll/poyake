package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.core.testing.Wildcards;
import com.etantolling.testrunner.test.core.testingws.TestRunner;
import com.etantolling.testrunner.test.core.testrun.TestRun;
import com.etantolling.testrunner.testevents.TestEventFactory;

public class RunATest implements ITestEventRunner{
	
	//private static final Logger logger = LoggerFactory.getLogger(RestWebService.class);
	Wildcards wildcards = new Wildcards();
	
	@Override
	public 	LinkedHashMap<String, Object> runEvent(TestParameterList params,LinkedHashMap<String, Object> storeValues,String testBaseUrl,String appBaseUrl,String appJobUrl) throws Exception {
		try {
			Integer testId= params.getInt(params.getInputValues(),"testId");
			wildcards=params.getWildcards();
			return runTest(testId,storeValues,testBaseUrl,appBaseUrl,appJobUrl);
			} catch (Exception e) {
				throw new Exception(" EventId: " +params.getInt(params.getInputValues(),"EVENT_ID")+ e.getMessage(),e );			
			}
	}

	public LinkedHashMap<String, Object> runTest(Integer testId,LinkedHashMap<String, Object> storeValues,String testBaseUrl,String appBaseUrl,String appJobUrl) throws Exception {
		
		showStarting(null, testId, null);
		
		TestRun tr = new TestRun();
		tr.setTestId(testId);
		TestRunner trc =new TestRunner(testId,new TestEventFactory(),testBaseUrl,appBaseUrl,appJobUrl);
		if(null!=storeValues)trc.setStoreValues(storeValues);
		trc.setWildcards(wildcards);
		trc.runToTargetEvent(null);
		return trc.getStoreValues();
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
