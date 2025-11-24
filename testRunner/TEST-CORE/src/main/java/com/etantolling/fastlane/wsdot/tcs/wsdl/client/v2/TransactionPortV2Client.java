package com.etantolling.fastlane.wsdot.tcs.wsdl.client.v2;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2.ImageListType;
import com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2.ImageOCRType;
import com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2.ImageOCRsType;
import com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2.ImageTypeType;
import com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2.PlateStateType;
import com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2.TollTransactionV2Request;
import com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2.TollTransactionV2Response;
import com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2.TransponderType;
import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestInputFile;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.core.testing.Wildcards;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TransactionPortV2Client  implements ITestEventRunner{
	private static final Logger logger = LoggerFactory.getLogger(TransactionPortV2Client.class);
	private String tennantname;
	private static final QName SERVICE_NAME = new QName("http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com",
			"TransactionPortV2Service");
	
	public static void main(String args[]) throws java.lang.Exception {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

		URL wsdlURL = new URL("http://localhost:9080/ws/transactionV2.wsdl");
		
		TransactionPortV2Service ss = new TransactionPortV2Service(wsdlURL, SERVICE_NAME);
		TransactionPortV2 port = ss.getTransactionPortV2Soap11();
		{
			logger.info("Invoking toll transaction request...");
			TollTransactionV2Request request = new TollTransactionV2Request();
			request.setFacilityCode("167N");
			request.setPlazaCode("15SW");
			request.setLaneNumber(1);
		
			DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
			request.setTransactionDateTime(datatypeFactory.newXMLGregorianCalendar("2018-11-27T11:32:29"));
			
			request.setEntryFacilityCode("167N");
			request.setEntryPlazaCode("15NW");
			request.setEntryLaneNumber(1);
			request.setEntryTransactionDateTime(datatypeFactory.newXMLGregorianCalendar("2018-11-27T09:32:29"));
			
			request.setSequenceNumber(1234);
			request.setTransactionType("1");
			request.setAvcClassification("2");
			request.setCscClassification("2");
			
			request.setAxleCount(2);
			request.setFareAmount(new BigDecimal("5.80"));
			request.setLaneMode("1");
			request.setReverseDirectionFlag(false);
			request.setTCSStatus("1");
			request.setUnusualOccurrences("2");
			request.setVehicleHeight(new BigDecimal("2"));
			request.setVehicleLength(new BigDecimal("5"));
			request.setVehicleWidth(new BigDecimal("2"));
			request.setVehicleSpeed(50);
			
			TransponderType transponder = new TransponderType();
			transponder.setAgencyCode("78");
			transponder.setDeclarationState("0");
			transponder.setLowBattery(false);
			transponder.setStatus("1");
			transponder.setTransponderID(new BigInteger("1234567890"));
			transponder.setTransponderProtocol("SeGo");
			request.setTransponder(transponder);
			
			ImageListType imageList = new ImageListType();
			imageList.setSelectedImageName("20181212000000_167N_15SW_01_000549_01_BSI.jpg");
			imageList.setSelectedROIImageName("20181212000000_167N_15SW_01_000549_01_BSI.jpg");
			imageList.setImageLocation("20181212/15SW/01");
			ImageOCRsType images = new ImageOCRsType();
			ImageOCRType ocrImage1 = new ImageOCRType();
			ocrImage1.setImageName("20181212000000_167N_15SW_01_000549_01_BSI.jpg");	
			ocrImage1.setImageType(ImageTypeType.BSI);
			ocrImage1.setOcrPlateNumber("AKL5967");
			ocrImage1.setOcrPlateNumberConfidence(99);
			ocrImage1.setOcrPlateState(PlateStateType.CA);
			ocrImage1.setOcrPlateStateConfidence(99);
			ocrImage1.setOcrPlateType("1");
			ocrImage1.setOcrPlateTypeConfidence(99);
			images.getImage().add(ocrImage1);
			
			ImageOCRType ocrImage2 = new ImageOCRType();
			ocrImage2.setImageName("20181212000000_167N_15SW_01_000549_02_FSI.jpg");	
			ocrImage2.setImageType(ImageTypeType.FSI);
			ocrImage2.setOcrPlateNumber("AKL5967");
			ocrImage2.setOcrPlateNumberConfidence(99);
			ocrImage2.setOcrPlateState(PlateStateType.CA);
			ocrImage2.setOcrPlateStateConfidence(99);
			ocrImage2.setOcrPlateType("1");
			ocrImage2.setOcrPlateTypeConfidence(99);
			images.getImage().add(ocrImage2);
			
			ImageOCRType ocrImage3 = new ImageOCRType();
			ocrImage3.setImageName("20181212000000_167N_15SW_01_000549_03_ROI.jpg");	
			ocrImage3.setImageType(ImageTypeType.ROI);
			ocrImage3.setOcrPlateNumber("AKL5967");
			ocrImage3.setOcrPlateNumberConfidence(99);
			ocrImage3.setOcrPlateState(PlateStateType.CA);
			ocrImage3.setOcrPlateStateConfidence(99);
			ocrImage3.setOcrPlateType("1");
			ocrImage3.setOcrPlateTypeConfidence(99);
			images.getImage().add(ocrImage3);
			
			imageList.setImage(images);
			request.setImageList(imageList);
			
			com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2.TollTransactionV2Response response = port
					.tollTransactionV2(request);
			logger.info("TollTransactionV2Response=" + response);

		}
		System.exit(0);
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
		
		void sendTransaction(String appBaseUrl,String url,String json,TestParameterList params) throws JsonParseException, JsonMappingException, IOException {
			
			ObjectMapper mapper = new ObjectMapper();
			List<TollTransactionV2Request> tollTransactionRequests = (List<TollTransactionV2Request>) mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, TollTransactionV2Request.class));
			URL wsdlURL = new URL(appBaseUrl + url);
			
			TransactionPortV2Service ss = new TransactionPortV2Service(wsdlURL, SERVICE_NAME);
			TransactionPortV2 port = ss.getTransactionPortV2Soap11();

			for (TollTransactionV2Request request : tollTransactionRequests) {
				TollTransactionV2Response response = port.tollTransactionV2(request);
				try {
					showSummary(url, params.getInputValues(), json, "200", response.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		@Override
		public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
			System.out.println("*** ------------------------------------------ -------------------------------------- ***");
			System.out.println(
					"*** -------------------------- EVENT TransactionPortV2_TransactionPortSoap START -------------------------------------- ***");
			System.out.println("*** ---------------------------------- ---------------------------------------------- ***");
			System.out.println("*** Request = "+ url);
			System.out.println("parameters "+ parameters);
			System.out.println("JSON "+ json);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("*** Response.getStatusCode = "+ responseCode);
			System.out.println("*** Response = "+ responseBody);

			System.out.println("*** ---------------------------------------------------------------------------------- ***");
			System.out.println(
					"*** -----------------------------EVENT TransactionPortV2_TransactionPortSoap END ------------------- ***");
			System.out.println("*** ---------------------------------------------------------------------------------- ***");
				}

		@Override
		public void showStarting(String url, Object parameters, String json) {
		}
}
