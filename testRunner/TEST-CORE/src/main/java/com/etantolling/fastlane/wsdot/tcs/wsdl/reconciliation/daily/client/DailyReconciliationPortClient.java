package com.etantolling.fastlane.wsdot.tcs.wsdl.reconciliation.daily.client;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.fastlane.wsdot.tcs.wsdl.reconciliation.daily.ArrayElement;
import com.etantolling.fastlane.wsdot.tcs.wsdl.reconciliation.daily.ArrayListType;
import com.etantolling.fastlane.wsdot.tcs.wsdl.reconciliation.daily.DailyReconciliationRequest;
import com.etantolling.fastlane.wsdot.tcs.wsdl.reconciliation.daily.DailyReconciliationResponse;
import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestInputFile;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.core.testing.Wildcards;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DailyReconciliationPortClient implements ITestEventRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(DailyReconciliationPortClient.class);
	private static final QName SERVICE_NAME = new QName("http://daily.reconciliation.wsdl.tcs.wsdot.fastlane.etantolling.com",
			"DailyReconciliationPortService");
	private String tennantname;
	
	public DailyReconciliationPortClient() {
	}

	
	public static void main(String args[]) throws java.lang.Exception {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

		URL wsdlURL = DailyReconciliationPortService.WSDL_LOCATION	;
		
		if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
		
		DailyReconciliationPortService ss = new DailyReconciliationPortService(wsdlURL, SERVICE_NAME);
		DailyReconciliationPort port = ss.getDailyReconciliationPortSoap11();
		{
			System.out.println("Invoking dailyReconciliation...");
			DailyReconciliationRequest request = new DailyReconciliationRequest();

		
			DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
			XMLGregorianCalendar from = datatypeFactory.newXMLGregorianCalendar("2010-07-27T00:00:00");
			XMLGregorianCalendar to = datatypeFactory.newXMLGregorianCalendar("2010-07-28T00:00:00");

			request.setFromDateTime(from);
			request.setToDateTime(to);
			
			ArrayListType array = new ArrayListType();
			ArrayElement element1 = new ArrayElement();
			element1.setFacilityCode("167N");
			element1.setPlazaCode("15SW");
			element1.setLaneNumber(1);
			element1.setTransactionType("1");
			element1.setAvcClassification("1");
			element1.setTransactionCount(500);
			array.getArrayElement().add(element1);
			ArrayElement element2 = new ArrayElement();
			element2.setFacilityCode("167N");
			element2.setPlazaCode("15SW");
			element2.setLaneNumber(1);
			element2.setTransactionType("1");
			element2.setAvcClassification("2");
			element2.setTransactionCount(500);
			array.getArrayElement().add(element2);
			request.setArrayList(array);
			
			
			
			com.etantolling.fastlane.wsdot.tcs.wsdl.reconciliation.daily.DailyReconciliationResponse response = port
					.dailyReconciliation(request);
			System.out.println("DailyReconciliationResponse=" + response);

		}
		System.exit(0);
	}

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println("*** ------------------------------------------ -------------------------------------- ***");
		System.out.println(
				"*** -------------------------- EVENT DailyReconciliation START -------------------------------------- ***");
		System.out.println("*** ---------------------------------- ---------------------------------------------- ***");
		System.out.println("*** Request = "+ url);
		System.out.println("parameters "+ parameters);
		System.out.println("JSON "+ json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response.getStatusCode = "+ responseCode);
		System.out.println("*** Response = "+ responseBody);

		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println(
				"*** -----------------------------EVENT DailyReconciliation END ------------------- ***");
		System.out.println("*** ---------------------------------------------------------------------------------- ***");

		
	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params, LinkedHashMap<String, Object> storeValues,
			String testBaseUrl, String appBaseUrl, String appJobUrl) throws Exception {

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
	
	void sendTransaction(String appBaseUrl,String url,String json,TestParameterList params) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		List<DailyReconciliationRequest> dailyReconciliationRequests = (List<DailyReconciliationRequest>) mapper.readValue(json,
				mapper.getTypeFactory().constructCollectionType(List.class, DailyReconciliationRequest.class));

		URL wsdlURL = new URL(appBaseUrl + url);
		
		DailyReconciliationPortService ss = new DailyReconciliationPortService(wsdlURL, SERVICE_NAME);
		DailyReconciliationPort port = ss.getDailyReconciliationPortSoap11();

		for (DailyReconciliationRequest request : dailyReconciliationRequests) {
			DailyReconciliationResponse response = port.dailyReconciliation(request);
			try {
				showSummary(url, params.getInputValues(), json, "200", response.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
