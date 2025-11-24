package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.etantolling.fastlane.sandag.tcs.wsdl.transaction.TransactionPort_Sandag_Client;
import com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.TransactionPort_Wasdot_Client;
import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;

public class TransactionPort_Client implements ITestEventRunner{

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response.getStatusCode = "+ responseCode);
		System.out.println("*** Response = "+ responseBody);
		System.out.println("JSON "+ json);
		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println(
				"*** -----------------------------EVENT TransactionPort_TransactionPortSoap END ------------------- ***");
		System.out.println("*** ---------------------------------------------------------------------------------- ***");

	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		System.out.println("*** ------------------------------------------ -------------------------------------- ***");
		System.out.println(
				"*** -------------------------- EVENT TransactionPort_TransactionPortSoap START -------------------------------------- ***");
		System.out.println("*** ---------------------------------- ---------------------------------------------- ***");
		System.out.println("*** Request = "+ url);
		System.out.println("parameters "+ parameters);
		System.out.println("JSON "+ json);
	}

	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params, LinkedHashMap<String, Object> storeValues,
		String testBaseUrl, String appBaseUrl, String appJobUrl) throws Exception  {
		try {
		String tennantName;
		if(!storeValues.containsKey("tennantName")) {
			HashMap parameters=new HashMap<String, Object>();
			parameters.put("AUTENTICATION", storeValues.get("AUTORIZATION"));
			ResponseEntity response=ClientWS.call(appBaseUrl+"/api/business-config/tennantname" , Map.class, HttpMethod.GET, parameters );
			tennantName = response.getBody().toString();
			storeValues.put("tennantName", tennantName);
		}else tennantName=(String) storeValues.get("tennantName");
		
		showStarting("/ws/transaction.wsdl",params,null);
		LinkedHashMap<String, Object> retValue=null;
		if(tennantName.equals("WSDOT"))
			
				retValue= new TransactionPort_Wasdot_Client().runEvent(params, storeValues,
						 testBaseUrl, appBaseUrl, appJobUrl);
			
		else 
			retValue= new TransactionPort_Sandag_Client().runEvent(params, storeValues,
					 testBaseUrl, appBaseUrl, appJobUrl);
		return retValue;
		} catch (Exception e) {
			e.printStackTrace();
			showStarting("/ws/transaction.wsdl", params,null);
			throw new Exception(" EventId: " +params.getInt(params.getInputValues(),"EVENT_ID")+ e.getMessage(),e);
		}
		
		
	}
}
