package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.client;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.CurrencyType;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.Image;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.ImageListType;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.ReturnCode;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.TransactionListType;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.TransactionType;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.TransponderStatusCodesType;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.TransponderType;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.TransponderTypeCodesType;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.TripTransaction;
import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestInputFile;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TripTransactionInterfaceClient implements ITestEventRunner{
	private static final Logger logger = LoggerFactory.getLogger(TripTransactionInterfaceClient.class);
	private String tennantname;
	private static final QName SERVICE_NAME = new QName("http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com",
			"TripTransactionInterface");
	
	public static void main(String args[]) throws java.lang.Exception {
		URL wsdlURL = new URL("http://localhost:8080/ws/TripTransaction.wsdl");
		
		TripTransactionInterfaceService ss = new TripTransactionInterfaceService(wsdlURL, SERVICE_NAME);
		TripTransactionInterfacePort port = ss.getTripTransactionInterfaceHttpPort();
		TripTransaction request = new TripTransaction();
		request.setExitFacilityCode("01");
		request.setExitPlazaCode("9001");
		request.setExitLaneNumber(1);
		DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
		request.setExitTransactionDateTime(datatypeFactory.newXMLGregorianCalendar("2019-06-01T09:32:29"));		
		request.setEntryFacilityCode("01");
		request.setEntryPlazaCode("9001");
		request.setEntryLaneNumber(1);
		request.setEntryTransactionDateTime(datatypeFactory.newXMLGregorianCalendar("2019-06-01T09:32:29"));
		request.setTripSequenceNumber(222);
		request.setTransactionType(TransactionType.AVI);
		request.setPostAVCclassification("2");
		request.setPreAVCclassification("2");
		request.setIndicatedClassification("2");
		TransponderType transponder = new TransponderType();
		transponder.getTag().add("1234567890");
		transponder.setIssuingAgencyCode("134583");
		transponder.setTransponderId("1234567890");
		transponder.setTransponderProtocol("T21");
		transponder.setTransponderTypeCode(TransponderTypeCodesType.N);
		transponder.setTransponderStatusCode(TransponderStatusCodesType.N);
		request.setTransponder(transponder);
		request.setTripPlateNumber("AAA111");
		request.setTripPlateState("CA");
		request.setTripPlateType("PAS");
		request.setExpectedFareAmount(new BigDecimal("2.5"));
		request.setFareAmount(new BigDecimal("2.5"));
		request.setExpectedFareAmount(new BigDecimal("2.5"));
		request.setCurrency(CurrencyType.USD);
		request.setCcReferenceNumber("1");
		request.setNonRevenue(false);
		request.setRepeatViolator(false);
		request.setRepeatViolatorNotificationSent(false);
		request.setReverseDirectionFlag(false);
		request.setHOVviolationFlag(false);
		request.setLaneMode("1");
		request.setDegradedMode(false);
		request.setNonRevenuePresent(false);
		
		TransactionListType transactionList = new TransactionListType();
		transactionList.setFacilityCode("01");
		transactionList.setPlazaCode("9001");
		transactionList.setLaneNumber(1);
		transactionList.setTransactionTimestamp(datatypeFactory.newXMLGregorianCalendar("2019-06-01T09:32:29"));
		transactionList.setTransactionId(1);
		ImageListType imageList = new ImageListType();
		imageList.setImageLocation("imageLocation");
		imageList.setImageName("imageName");
		imageList.setImageAttribute("imageAttribute");
		Image image = new Image();
		image.setImageName("imageName");
		image.setImageType("ROI");
		image.setOcrPlateNumber("AAA111");
		image.setOcrPlateState("CA");
		image.setOcrPlateType("PAS");
		image.setOcrPlateNumberConfidence(99);
		image.setOcrPlateStateConfidence(99);
		image.setOcrPlateTypeConfidence(99);
		imageList.getImage().add(image);
		imageList.setPlateNumber("AAA111");
		imageList.setPlateState("CA");
		imageList.setPlateType( "PAS");
		imageList.setPlateNumberConfidence(99);
		imageList.setPlateTypeConfidence(99);
		
		imageList.setPrimeImage(true);
		
		imageList.setPrimeImage(true);
		
		transactionList.setImageList(imageList);
		request.setTransactionList(transactionList);
		ReturnCode returnCode = port.sendTransactionData(request);
		logger.info("Trip Transaction request done. ReturnCode is: "+returnCode.getCode());
	}

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println("*** ------------------------------------------ -------------------------------------- ***");
		System.out.println(
				"*** -------------------------- EVENT TripTransactionPort_TransactionPortSoap START -------------------------------------- ***");
		System.out.println("*** ---------------------------------- ---------------------------------------------- ***");
		System.out.println("*** Request = "+ url);
		System.out.println("parameters "+ parameters);
		System.out.println("JSON "+ json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response.getStatusCode = "+ responseCode);
		System.out.println("*** Response = "+ responseBody);

		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println(
				"*** -----------------------------EVENT TripTransactionPort_TransactionPortSoap END ------------------- ***");
		System.out.println("*** ---------------------------------------------------------------------------------- ***");

	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		// TODO Auto-generated method stub
		
	}


	void sendTransaction(String appBaseUrl,String url,String json,TestParameterList params) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		List<TripTransaction> tollTransactionRequests = (List<TripTransaction>) mapper.readValue(json,
				mapper.getTypeFactory().constructCollectionType(List.class, TripTransaction.class));
		URL wsdlURL = new URL(appBaseUrl + url);
		
		TripTransactionInterfaceService ss = new TripTransactionInterfaceService(wsdlURL, SERVICE_NAME);
		TripTransactionInterfacePort port = ss.getTripTransactionInterfaceHttpPort();

		for (TripTransaction request : tollTransactionRequests) {
			ReturnCode response = port.sendTransactionData(request);
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
