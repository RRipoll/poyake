package com.etantolling.fastlane.sandag.tcs.wsdl.trip.client;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.fastlane.sandag.tcs.wsdl.trip.correction.ReturnCode;
import com.etantolling.fastlane.sandag.tcs.wsdl.trip.correction.TripTransactionCorrection;
import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestInputFile;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TripTransactionCorectionInterfaceClient implements ITestEventRunner{
	private static final Logger logger = LoggerFactory.getLogger(TripTransactionCorectionInterfaceClient.class);
	private String tennantname;
	private static final QName SERVICE_NAME = new QName("http://correction.trip.wsdl.tcs.sandag.fastlane.etantolling.com",
			"TripTransactionCorrectionInterface");
	
	public static void main(String args[]) throws java.lang.Exception {
		URL wsdlURL = new URL("http://localhost:8080/ws/TripTransactionCorrection.wsdl");
		
		TripTransactionCorrectionService ss = new TripTransactionCorrectionService(wsdlURL, SERVICE_NAME);
		TripTransactionCorrectionInterfacePort port = ss.getTripTransactionCorrectionInterfaceHttpPort();
		TripTransactionCorrection request = new TripTransactionCorrection();
		request.setTripSequenceNumber(1234);
		request.setOldFareAmount(new BigDecimal("2.5"));
		request.setNewFareAmount(new BigDecimal("5"));
		
		ReturnCode returnCode = port.sendTripTransactionCorrection(request);
		logger.info("Trip Transaction correction request done. ReturnCode is: "+returnCode.getCode());
	}

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println("*** ------------------------------------------ -------------------------------------- ***");
		System.out.println(
				"*** -------------------------- EVENT TripTransactionCorrection Port_TransactionPortSoap START -------------------------------------- ***");
		System.out.println("*** ---------------------------------- ---------------------------------------------- ***");
		System.out.println("*** Request = "+ url);
		System.out.println("parameters "+ parameters);
		System.out.println("JSON "+ json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response.getStatusCode = "+ responseCode);
		System.out.println("*** Response = "+ responseBody);

		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println(
				"*** -----------------------------EVENT TripTransactionCorrection Port_TransactionPortSoap END ------------------- ***");
		System.out.println("*** ---------------------------------------------------------------------------------- ***");

	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		// TODO Auto-generated method stub
		
	}


	void sendTransaction(String appBaseUrl,String url,String json,TestParameterList params) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		List<TripTransactionCorrection> tollTransactionRequests = (List<TripTransactionCorrection>) mapper.readValue(json,
				mapper.getTypeFactory().constructCollectionType(List.class, TripTransactionCorrection.class));
		URL wsdlURL = new URL(appBaseUrl + url);
		
		TripTransactionCorrectionService ss = new TripTransactionCorrectionService(wsdlURL, SERVICE_NAME);
		TripTransactionCorrectionInterfacePort port = ss.getTripTransactionCorrectionInterfaceHttpPort();

		for (TripTransactionCorrection request : tollTransactionRequests) {
			ReturnCode response = port.sendTripTransactionCorrection(request);
			try {
				showSummary(url, params.getInputValues(), json, "200", response.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params, LinkedHashMap<String, Object> storeValues,
			String testBaseUrl, String appBaseUrl,String appJobUrl) throws Exception {

		String url = params.getString(params.getInputValues(), "URL");
		
		tennantname=(String) storeValues.get("tennantname");
		
		if(null!=params.getInputFiles() && params.getInputFiles().size()>0) {
		   for (TestInputFile file: params.getInputFiles()  ) {
			   
			   File fileJson=new File("tmp.json");
			  
			   URL jUrl=file.getUrl();
			   FileUtils.copyURLToFile(jUrl,fileJson );
			   
			   String json =FileUtils.readFileToString(fileJson);
			   
			   json=TestParameterList.jsonReplace(json, storeValues,params.getWildcards());
			   System.out.println(json);

			   sendTransaction(appBaseUrl,url,json,params);
		   }
			
		}else {
			String json = params.getString(params.getInputValues(), "JSON");
			 System.out.println(" BEFORE REPLACEMENT: " + json);
			 System.out.println(" PARAMETERS: " + storeValues);
			if (StringUtils.isEmpty(json)) 
				System.out.println("json is empty for params: " + params + " storeValues: " + storeValues + " testBaseUrl: " + testBaseUrl + " appBaseURL: " + appBaseUrl + " appJobURL " + appJobUrl);
			 json=TestParameterList.jsonReplace(json, storeValues,params.getWildcards());
			sendTransaction(appBaseUrl,url,json,params);
			 params.setString(params.getInputValues(), "JSON", json);
			 System.out.println("AFTER REPLACEMENT: " + json);
		}
		return null;
	}
	
	
}
