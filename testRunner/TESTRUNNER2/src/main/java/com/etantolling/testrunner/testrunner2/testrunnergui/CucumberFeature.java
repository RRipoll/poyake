package com.etantolling.testrunner.testrunner2.testrunnergui;

import java.sql.Connection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.etantolling.testrunner.test.core.dto.EventViewDTO;
import com.etantolling.testrunner.test.core.dto.FileRefDTO;
import com.etantolling.testrunner.test.core.dto.TestViewDTO;
import com.etantolling.testrunner.test.core.testing.IEventProcessorFactory;
import com.etantolling.testrunner.test.core.testing.TestInputFile;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.core.testrun.TestRun;
import com.etantolling.testrunner.test.core.utils.Pair;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.misc.MiscUtility;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CucumberFeature {
	
	TestRun tr;
	Boolean isStarted;
	TestViewDTO test;
	Integer currentRunningEventId = null;
	 IEventProcessorFactory eventProcessorFactory;
	 
	public StringBuilder sb = new StringBuilder();
	 
	public String runToTargetDate(TestRun tr,IEventProcessorFactory eventProcessorFactory) throws Exception {
		
		this.eventProcessorFactory = eventProcessorFactory;
		this.tr = tr;
		
		ResponseEntity<String> json = ClientWS.call(DesktopHelper.getTestServerUrl("/rest/test/" + tr.getTestId()), TestViewDTO.class, HttpMethod.GET, null);
		ObjectMapper mapper = new ObjectMapper();
		test = (TestViewDTO) mapper.readValue(json.getBody(), TestViewDTO.class);
		
		{
			sb.append("Feature: ").append("\r\n");
			sb.append("\t\t").append("Background: ").append("\r\n");
			sb.append("\r\n");
			sb.append("\r\n");
			sb.append("\t\t#").append((null==test.getDescription()?"":test.getDescription())).append("\r\n");
			sb.append("\t\t#").append((null==test.getNotes()?"":test.getNotes())).append("\r\n");
			sb.append("\t\t#").append("TestId="+test.getTestId()).append("\r\n");
			sb.append("@"+test.getOwner()).append("").append((null==test.getKeywords()?"":"@"+test.getKeywords()).replaceAll(" ", " @")).append("\r\n");
			sb.append("\r\n");
			sb.append("\r\n");
			sb.append("\t").append("Scenario: ").append((null==test.getDescription()?"":test.getDescription())).append("\r\n");
			sb.append("Given baseUri is http://localhost:8085/TESTSERVER-RS/").append("\r\n");
			sb.append("Given I set Content-Type header to application/json").append("\r\n");
			sb.append("Given I set Accept header to application/json").append("\r\n");
			sb.append("Given I set body to").append("\r\n");
			sb.append("\"\"\"").append("\r\n");
			sb.append("{").append("\r\n");
			sb.append("}").append("\r\n");
			sb.append("\"\"\"").append("\r\n");
			sb.append("When I PUT /rest/test/"+test.getTestId()+"/run-in/localhost%3A8080").append("\r\n");
			sb.append("Then response code should be 200").append("\r\n");
			sb.append("").append("\r\n");
		}

		return sb.toString();
	}

	public void setDetailsForFirstRun(Boolean bResetDatabase) throws Exception {

		Connection conn = MainDb.getConnection();
		try {
			if (bResetDatabase) {
				{
					sb.append("\r\n");
					sb.append("\t").append("Scenario: ").append("Reset DB").append("\r\n");
			
					sb.append("\t\t").append("Given ").append("Reset DB").append("\r\n");
				
					sb.append("\r\n");
					sb.append("\t\t").append("Then ").append("Check Reset DB ").append("\r\n");
				}
			}
		} finally {
			conn.close();
		}
	}

	public void runTest() throws Exception {

		ResponseEntity<String> json = ClientWS.call(
				DesktopHelper.getTestServerUrl("/rest/events/" + tr.getTestId()), EventViewDTO.class,
				HttpMethod.GET, null);
		ObjectMapper mapper = new ObjectMapper();
		List<EventViewDTO> eventList = mapper.readValue(json.getBody(),
				mapper.getTypeFactory().constructCollectionType(List.class, EventViewDTO.class));

		Vector<Pair<Date, Integer>> events = new Vector<Pair<Date, Integer>>();
		for (EventViewDTO ev : eventList) {
			
				events.add(new Pair<Date, Integer>(null, ev.getEventId()));
		}

		for (Pair<Date, Integer> event : events) {
			runEvent(eventList.stream().filter(x -> x.getEventId().intValue() == event.getRight()).findFirst().get());
		}
	}


	private void endTest(Date targetDate){
		
		sb.append("\t").append("Scenario: ").append("endding test").append("\r\n");
		
	}

	public void runEvent(EventViewDTO event) throws Exception {
		
		ResponseEntity<String> json = ClientWS.call(
				DesktopHelper.getTestServerUrl("/rest/tablename/" + event.getEventDefinitionId()), String.class,
				HttpMethod.GET, null);
		String dataTableName = json.getBody();
		
		TestParameterList parameterList = new TestParameterList();
		parameterList.setInt(parameterList.getInputValues(),"EVENT_ID", event.getEventId());

		if (null != dataTableName) {
			ResponseEntity<String> jsonEventData = ClientWS.call(
					DesktopHelper.getTestServerUrl("/rest/eventdef/" + dataTableName + "/"  ),
					String.class, HttpMethod.GET, null);
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
			Map<String, Object> eventData = mapper.readValue(jsonEventData.getBody(),
					mapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class));
			if(eventData.containsKey("TE_EVETDEFID")){
				LinkedHashMap<String, Object> par=(LinkedHashMap<String, Object>) new MiscUtility().getObjectFromString((String) eventData.get("PARAMETERS"));
				parameterList.setEventData(parameterList.getInputValues(),par);
			}else{
				parameterList.setEventData(parameterList.getInputValues(),eventData);
			}
		}

		parameterList.setInputFiles(getFileList(event.getEventId()));

		{
			sb.append("\r\n");
			sb.append("\t").append("Scenario: ").append(event.getDescription()).append("\r\n");
			sb.append("\r\n");
			
			String step= "";
			
			switch (event.getStepId()) {
			case 1:
				step="Given ";
				break;
			case 2:
				step="When ";
				break;
			case 3:
				step="Then ";
				break;
			default:
				step="Given ";
			}
			
			
			sb.append("\t\t").append(step).append("run Event number "+event.getEventId()).append("\r\n");

			sb.append("\t\t\t#").append(""+event.getManualDescription()).append("\r\n");
			
			sb.append("\t\t\t#").append(""+event.getAutomaticDescription()).append("\r\n");
			
			sb.append("\t\t\t#").append("event Type="+event.getEventType()).append("\r\n");
			
			Map<String, Object> values=parameterList.getInputValues();
			if(null!=values && values.size()>0){
				
				sb.append("\t\t\t#").append("values: ").append("\r\n");

				for (String value : values.keySet()) {
					if(values.containsKey("TE_EVENTDEFID") && value.equals("PARAMETERS")){
					
						LinkedHashMap<String , Object> paramlist= (LinkedHashMap<String, Object>) new MiscUtility().getObjectFromString((String) values.get(value));
						for (String pValue : paramlist.keySet()) {
							sb.append("\t\t\t\t#").append(pValue+": ").append(paramlist.get(pValue)).append("\r\n");
						
						}
					}else 
						sb.append("\t\t\t\t#").append(value+": ").append(values.get(value)).append("\r\n");
				}
				
				Vector<TestInputFile> files=parameterList.getInputFiles();
				if(null!=files && files.size()>0){
					sb.append("\t\t\t").append("files to updated: ").append("\r\n");

						for (TestInputFile file : files) {
							sb.append("\t\t\t\t").append(file.getUrl()).append("\r\n");
				}  

			}
			sb.append("\r\n");
			
			}	
		}
	}

	@SuppressWarnings("unchecked")
	private Vector<TestInputFile> getFileList(Integer eventId) throws Exception {
		Vector<TestInputFile> inputFiles = new Vector<TestInputFile>();

		ResponseEntity<String> json = ClientWS.call(DesktopHelper.getTestServerUrl("/rest/files/" + eventId),
				EventViewDTO.class, HttpMethod.GET, null);
		ObjectMapper mapper = new ObjectMapper();
		List<FileRefDTO> fileList = (List<FileRefDTO>) mapper.readValue(json.getBody(),
				mapper.getTypeFactory().constructCollectionType(List.class, FileRefDTO.class));

		for (FileRefDTO f : fileList) {
			inputFiles.add(new TestInputFile(f.getAzureUrl()));
		}
		return inputFiles;
	}
}
