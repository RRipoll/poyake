package com.etantolling.testrunner.testevents.eventprocessors.webservices;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.etantolling.testrunner.test.core.dto.EventViewDTO;
import com.etantolling.testrunner.test.core.dto.FileRefDTO;
import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileService  implements ITestEventRunner {

	private static final Logger logger = LoggerFactory.getLogger(FileService.class);
	
	@Override
	public LinkedHashMap<String, Object> runEvent(TestParameterList params,LinkedHashMap<String, Object> storeValues, String testBaseUrl, String appBaseUrl,String appJobUrl) throws Exception {
		try {
		Integer eventId=params.getInt(params.getInputValues(),"EVENT_ID");
		
		ResponseEntity<String> json = ClientWS.call(testBaseUrl+"/rest/files/"+eventId, EventViewDTO.class, HttpMethod.GET, null);
		ObjectMapper mapper = new ObjectMapper();		 
		List<FileRefDTO> fileList = (List<FileRefDTO>) mapper.readValue(json.getBody(), mapper.getTypeFactory().constructCollectionType(List.class, FileRefDTO.class));
		
		RestWebService res= new RestWebService();
		
		for (FileRefDTO fileRefDTO : fileList) {
			
			params.setString(params.getInputValues(), "fileURL", fileRefDTO.getAzureUrl());
			
			String URL=params.getString(params.getInputValues(), "URL");
			
			URL=URL+"?fileURL="+fileRefDTO.getAzureUrl();
			
			((LinkedHashMap<String, Object>)((Hashtable<String, Object>)params.getInputValues()).get("URL")).put("value", URL);
			
			res.runEvent(params, storeValues,testBaseUrl, appJobUrl,appJobUrl);
		
			try {
				showSummary( "/rest/files/"+eventId,  params,  json.getBody(), null,  null);
			} catch (Exception ee) {}
		}
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
