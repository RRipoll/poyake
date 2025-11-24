package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.core.utils.ThreadPool;

public class CicleTestParallelWaiting  implements ITestEventRunner{
	
	//private static final Logger logger = LoggerFactory.getLogger(RestWebService.class);
	
	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params,LinkedHashMap<String, Object> storeValues,String testBaseUrl,String appBaseUrl,String appJobUrl) throws Exception {
		try {
		Integer testId= params.getInt(params.getInputValues(),"testId");
		Integer nCicle= params.getInt(params.getInputValues(),"nCicle");
		Integer nTimes= params.getInt(params.getInputValues(),"nTimes");
		Integer waitingPeriod= params.getInt(params.getInputValues(),"waitingPeriod");

		for(int n=0; n<nCicle; n++) {
		ThreadPool.getPool().execute(new Runnable() {
		    public void run() {
		    	try {
		    		for(int s=0; s<nTimes; s++) {
		    			ThreadPool.getPool().execute(new Runnable() {
		    			    public void run() {
		    			    	try {
		    			    		new RunATest().runTest(testId,storeValues,testBaseUrl,appBaseUrl,appJobUrl);
		    					} catch (Exception e) {
		    						// TODO Auto-generated catch block
		    						e.printStackTrace();
		    					}
		    			    }
		    			});
		    			}
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		});
			Thread.sleep(1000*waitingPeriod);
		}
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
	}
}