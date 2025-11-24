package com.etantolling.testrunner.testserver.rs.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.etantolling.testrunner.test.core.dto.EventDTO;
import com.etantolling.testrunner.test.core.dto.EventViewDTO;
import com.etantolling.testrunner.test.core.dto.FileRefDTO;
import com.etantolling.testrunner.test.core.dto.FolderDTO;
import com.etantolling.testrunner.test.core.dto.HistoryDTO;
import com.etantolling.testrunner.test.core.dto.TestViewDTO;
import com.etantolling.testrunner.test.core.facade.TestFacade;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.RunATest;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest")
@Api(value = "Test util", description = "")
public class TestServerRestController {
	private static final Logger logger = LoggerFactory.getLogger(TestServerRestController.class);
	
	@ApiOperation(value = "Get all test events", notes = "Get all events by testId")
	@RequestMapping(value = "/events/{testId}", method = RequestMethod.GET)
	public List<EventViewDTO> getEvents(@PathVariable("testId") Integer testId) throws Exception {
		logger.info("*** getEvents");
		try {
			return new TestFacade().searchEvents(testId);
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Get event", notes = "Get event by eventId")
	@RequestMapping(value = "/event/{eventId}", method = RequestMethod.GET)
	public List<EventViewDTO> getEvent(@PathVariable("eventId") Integer eventId) throws Exception {
		logger.info("*** getEvent");
		try {
			return new TestFacade().searchEvent(eventId);
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Get folders", notes = "Get folders")
	@RequestMapping(value = "/folders", method = RequestMethod.GET)
	public List<FolderDTO> getEvent() throws Exception {
		logger.info("*** getEvent");
		try {
			return new TestFacade().showFolder();
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Get all tests", notes = "Get all tests")
	@RequestMapping(value = "/tests", method = RequestMethod.GET)
	public List<TestViewDTO> getTests() throws Exception {
		logger.info("*** getTests");
		try {
			return new TestFacade().findAllTests();
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Get test", notes = "Get all tests")
	@RequestMapping(value = "/test/{testId}", method = RequestMethod.GET)
	public TestViewDTO getTest(@PathVariable("testId") Integer testId) throws Exception {
		logger.info("*** getTest {}", testId);
		try {
			return new TestFacade().findTest(testId);
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Run a test", notes = "Run a test")
	@RequestMapping(value = "/test/{testId}/run-in/{path-to-bos:.*}", method = RequestMethod.GET)
	public LinkedHashMap<String, Object> getTest(@PathVariable("testId") Integer testId, @PathVariable("path-to-bos") String pathToBos) throws Exception {
		logger.info("*** getTest {} in Bos {}", testId, pathToBos);
		try {

			String appPath = pathToBos;
			String bosUrl;
			String jobUrl;
			if (appPath.contains("|")) {
				bosUrl = appPath.substring(0, appPath.indexOf("|"));
				jobUrl = appPath.substring(appPath.indexOf("|") + 1, appPath.length());
			}
			else {
				bosUrl = appPath;
				jobUrl = appPath.substring(0, appPath.length() - 2) + "81";
			}

			ResponseEntity<String> response = ClientWS.call("http://" + bosUrl + "/api/sandbox/token/sa", Map.class, HttpMethod.GET, null);
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> jsonResponse = mapper.readValue(response.getBody().toString(), Map.class);
			String token = "Bearer " + jsonResponse.get("token");
			LinkedHashMap<String, Object> storeValues = new LinkedHashMap<>();
			storeValues.put("AUTHORIZATION", token);
			return new RunATest().runTest(testId, storeValues, "http://localhost:8085/TESTSERVER-RS", "http://" + bosUrl, "http://" + jobUrl);
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw new Exception("TestId:"+ testId + " "+ex.getMessage(),ex);
		}
	}

	@ApiOperation(value = "Get table name", notes = "Get table name")
	@RequestMapping(value = "/eventdef/{tableName}/{dataRecordPk}", method = RequestMethod.GET)
	public Map<String, Object> getEventDef(@PathVariable("tableName") String tableName, @PathVariable("dataRecordPk") String dataRecordPk) throws Exception {
		logger.info("*** getEventDef tableName = {}; dataRecordPk = {}", tableName, dataRecordPk);
		try {
			return new TestFacade().getEventDef(tableName, dataRecordPk);
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Create a new event", notes = "Create a new event")
	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public Integer createEvent(@RequestBody EventDTO eventDTO) throws Exception {
		logger.info("*** createEvent {}", eventDTO);
		try {
			return new TestFacade().createEvent(eventDTO);
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Get all file list by event", notes = "Get all file list by event")
	@RequestMapping(value = "/files/{eventId}", method = RequestMethod.GET)
	public List<FileRefDTO> getFiles(@PathVariable("eventId") Integer eventId) throws Exception {
		logger.info("*** getFiles {}", eventId);
		try {
			return new TestFacade().searchEventFiles(eventId);
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Get all file list by event", notes = "Get all file list by event")
	@RequestMapping(value = "/file/{fileRefId}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getFile(@PathVariable("fileRefId") Integer fileRefId) throws Exception {
		logger.info("*** getFile {}", fileRefId);
		try {
			String url = new TestFacade().findFileUrl(fileRefId);
			if (url == null) {
				throw new Exception("FileRefId does not exist.");
			}
			UrlResource pdfFile = new UrlResource("file://" + url);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");

			return ResponseEntity.ok().headers(headers).contentLength(pdfFile.contentLength()).contentType(MediaType.parseMediaType("application/octet-stream"))
					.body(new InputStreamResource(pdfFile.getInputStream()));
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Get all HISTORY list by event", notes = "Get all HISTORY list by event")
	@RequestMapping(value = "/history/{testId}", method = RequestMethod.GET)
	public List<HistoryDTO> getHystoryByTestId(@PathVariable("testId") Integer testId) throws Exception {
		logger.info("*** get {}", testId);
		try {
			return new TestFacade().getHystory(testId);
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

	@ApiOperation(value = "Create a new hystory", notes = "Create a new hystory")
	@RequestMapping(value = "/history", method = RequestMethod.POST)
	public HistoryDTO createHistory(@RequestBody HistoryDTO historyDTO) throws Exception {
		logger.info("*** createEvent {}", historyDTO);
		try {
			return new TestFacade().createHistory(historyDTO);
		} catch (Exception ex) {
			logger.error("ERROR STACKTRACE:", ex);
			throw ex;
		}
	}

}
