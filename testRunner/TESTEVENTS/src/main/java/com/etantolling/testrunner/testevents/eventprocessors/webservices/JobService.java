package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobService implements ITestEventRunner {

	
	private static final Logger logger = LoggerFactory.getLogger(JobService.class);
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params,LinkedHashMap<String, Object> storeValues, String testBaseUrl, String appBaseUrl,String appJobUrl) throws Exception {
		try {
		String jobName=params.getString(params.getInputValues(),"jobName");
		Integer timeout=params.getInt(params.getInputValues(),"maxTime-sec")*1000;
		
		RestWebService res= new RestWebService();
		
		long startTime = System.currentTimeMillis();
		
		 showStarting(appJobUrl, params, null);
		
		 res.runEvent(params, storeValues,testBaseUrl, appJobUrl,appJobUrl);
		
		while (System.currentTimeMillis() - startTime < timeout) {
			
			String getJobInstancesURl=appJobUrl+"/api/jobinstances?jobname="+jobName+"&startindex=0&pagesize=100";
			try {
				ResponseEntity<String> response =ClientWS.call(getJobInstancesURl, HttpMethod.valueOf("GET"));
			
				Object jsonResponse = mapper.readValue(response.getBody().toString(), Object.class);
				
				LinkedHashMap <String,Object> responseMap=	(LinkedHashMap<String,Object>) jsonResponse;
				
				ArrayList <LinkedHashMap <String,Object>> instances= (ArrayList<LinkedHashMap<String, Object>>) responseMap.get("jobInstances");
				
				LinkedHashMap<String, Object> lastInstance=instances.get(0);
				
				Integer lastInstanceId=(Integer) lastInstance.get("id");
				
				{
					String getJobExecutionsByJobInstanceId=appJobUrl+"/api/jobexecutionpages?jobinstanceid="+lastInstanceId+"&startindex=0&pagesize=100";
				
					response =ClientWS.call(getJobExecutionsByJobInstanceId, HttpMethod.valueOf("GET"));
				
					jsonResponse = mapper.readValue(response.getBody().toString(), Object.class);
				
					responseMap=	(LinkedHashMap<String,Object>) jsonResponse;
				
					ArrayList <LinkedHashMap <String,Object>> jobExecutions= (ArrayList<LinkedHashMap<String, Object>>) responseMap.get("jobExecutions");
				
					LinkedHashMap<String, Object> lastjobExecution=jobExecutions.get(0);
				
					String lastStatus=(String) lastjobExecution.get("status");
				
					if(lastStatus.equals("COMPLETED")) {
						try {
							showSummary(getJobInstancesURl, params.getInputValues(), "200", "", jsonResponse.toString());
						} catch (Exception e) {	}
						return null;
					}
					if(lastStatus.equals("FAILED")) {
						try {
							showSummary(getJobInstancesURl, params.getInputValues(), "200", "", jsonResponse.toString());
						} catch (Exception e) {	}
						throw new Exception(jobName+" FAILED :"+ response.getBody().toString());
					}
					
				}	
				TimeUnit.MILLISECONDS.sleep(50L);
				
			} catch (HttpClientErrorException e) {
				logger.error("*** ERROR *** = \n{}", e.getResponseBodyAsString());
				showSummary(getJobInstancesURl, params.getInputValues(),e.getResponseBodyAsString() , "", e.getMessage());
				throw new Exception(jobName+" FAILED :",e);
			}
		}
		log.error("Ops! Timeout reached.");
		throw new InterruptedException("Timeout reached!");
		} catch (Exception e) {
            throw new Exception(" EventId: " +params.getInt(params.getInputValues(),"EVENT_ID")+ e.getMessage(),e );			
		}
		
	}

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response.getStatusCode = "+ responseCode);
		System.out.println("*** Response = "+ responseBody);
		
		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println("*** -----------------------------EVENT Job Service END ------------------- ***");
		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		
	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		System.out.println("*** ------------------------------------------ -------------------------------------- ***");
		System.out.println("*** -------------------------- EVENT Job Service START -------------------------------------- ***");
		System.out.println("*** ---------------------------------- ---------------------------------------------- ***");
		System.out.println("*** Request = "+ url);
		System.out.println("parameters "+parameters);
		System.out.println("JSON "+json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	}

}
