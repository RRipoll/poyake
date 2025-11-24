package com.etantolling.testrunner.test.core.testingws;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.dto.EventViewDTO;
import com.etantolling.testrunner.test.core.dto.FileRefDTO;
import com.etantolling.testrunner.test.core.dto.TestViewDTO;
import com.etantolling.testrunner.test.core.facade.dao.ApplicationLogDAO;
import com.etantolling.testrunner.test.core.testing.IEventProcessorFactory;
import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.test.core.testing.TestInputFile;
import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.etantolling.testrunner.test.core.testing.Wildcards;
import com.etantolling.testrunner.test.core.utils.JsonStore;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;
import com.etantolling.testrunner.test.utils.db.Sequence;
import com.etantolling.testrunner.test.utils.misc.MiscUtility;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestRunner {

	private static final Logger log = LoggerFactory.getLogger(TestRunner.class);
		
	Integer testId;
	TestViewDTO test;
	List<EventViewDTO> eventList;
	public Integer currentRunningEventId = null;
	Vector<Integer> eventsIdRun = new Vector<Integer>();

	Boolean isStarted = false;
	public boolean bTestSuccess = true;
	public boolean warningExists = false;
	public String errorMessage = null;
	public StringBuilder warningMessage = new StringBuilder();
	boolean showLog = false;

	IEventProcessorFactory eventProcessorFactory;
	String testServerUrl;
	String appServerUrl;
	String appJobUrl;

	LinkedHashMap<String, Object> storeValues = new LinkedHashMap<>();
	JsonStore storeJson= new JsonStore();
	
	
	

	Wildcards wildcards = new Wildcards();

	private String defaultAuthorization;

	public LinkedHashMap<String, Object> getStoreValues() {
		return storeValues;
	}

	public void setStoreValues(LinkedHashMap<String, Object> storeValues) {
		this.storeValues = storeValues;
	}
	
	
	

	public TestRunner(Integer testId, IEventProcessorFactory eventProcessorFactory, String testServerUrl,
			String appServerUrl, String appJobUrl) throws Exception {
		this.testId = testId;
		this.testServerUrl = testServerUrl;
		this.appServerUrl = appServerUrl;
		this.appJobUrl = appJobUrl;

		this.eventProcessorFactory = eventProcessorFactory;

		ResponseEntity<String> json = ClientWS.call(testServerUrl + "/rest/test/" + testId, TestViewDTO.class,
				HttpMethod.GET, null);
		ObjectMapper mapper = new ObjectMapper();
		test = (TestViewDTO) mapper.readValue(json.getBody(), TestViewDTO.class);
	}

	public void runToTargetEvent(Integer stopEventId) throws Exception {

		if (isShowLog())
			log.info("Target Event: " + stopEventId);

		try {
			runTest(testId, stopEventId);
		} catch (Exception e) {
			// log.error("ERROR STACKTRACE:",e);
			bTestSuccess = false;
			errorMessage = "Running eventId: " + currentRunningEventId + "\r\n Error: " + e.getMessage();
			throw new Exception("TestId="+testId+ " "+ e.getMessage(),e);
		}
	}

	@SuppressWarnings("unchecked")
	public void runTest(Integer testId, Integer stopEventId) throws Exception {
		this.testId = testId;

		ResponseEntity<String> json = ClientWS.call(testServerUrl + "/rest/events/" + testId, EventViewDTO.class,
				HttpMethod.GET, null);
		ObjectMapper mapper = new ObjectMapper();
		eventList = (List<EventViewDTO>) mapper.readValue(json.getBody(),
				mapper.getTypeFactory().constructCollectionType(List.class, EventViewDTO.class));

		Date currentSystemDate = SystemDatesDAO.getPostingDateTime();
		if (isShowLog())
			log.info("Event list. CurrentSystemDate: " + currentSystemDate);

		for (EventViewDTO ev : eventList) {
			currentRunningEventId = ev.getEventId();
			if (eventsIdRun.contains(currentRunningEventId))
				continue;
			if (null != stopEventId && currentRunningEventId == stopEventId.intValue()) {
				runEventCicle(ev);
				break;
			} else
				runEventCicle(ev);
		}
	}

	public Integer runEventCicle(EventViewDTO ev) throws Exception {
		if (isShowLog())
			log.info(ev.getEventId() + " " + ev.getManualDescription());

		currentRunningEventId = ev.getEventId();

		runEvent(currentRunningEventId);

		eventsIdRun.add(currentRunningEventId);
		return currentRunningEventId;
	}

	public void runEvent(int eventId) throws Exception {

		if (isShowLog())
			log.info("Running eventId: " + eventId);

		EventViewDTO event = eventList.stream().filter(x -> x.getEventId().intValue() == eventId).findFirst().get();

		int eventDefinitionId = event.getEventDefinitionId();
		int eventTypeId = event.getEventTypeId();
		String eventData = event.getParameters();

		TestParameterList parameterList = new TestParameterList();
		parameterList.setWildcards(wildcards);
		parameterList.setInt(parameterList.getInputValues(), "EVENT_ID", eventId);
		parameterList.setStoreJson(storeJson);
		
		ITestEventRunner eventRunner = null;

		eventRunner = eventProcessorFactory.getEventRunner(eventDefinitionId, eventTypeId);

		LinkedHashMap<String, Object> par = (LinkedHashMap<String, Object>) new MiscUtility()
				.getObjectFromString((String) eventData);
		parameterList.setInputData(parameterList.getInputValues(), par);
		checkAuthorization(parameterList.getInputValues());
		parameterList.setOutputData(parameterList.getOutputValues(), par);
		parameterList.checkStoreValues(storeValues);

		parameterList.setInputFiles(getFileList(eventId));

		Integer loggedInputSourceCode = EnvironmentHelper.getInputSourceCode();
		EnvironmentHelper.setInputSourceCode(0);

		if (!checkConditions(parameterList.getInputValues()))
			return;
		LinkedHashMap<String, Object> returnValues = eventRunner.runEvent(parameterList, storeValues, testServerUrl,
				appServerUrl, appJobUrl);
		setStoreParamenter(parameterList);
		if (null != returnValues)
			storeValues.putAll(returnValues);

		EnvironmentHelper.setInputSourceCode(loggedInputSourceCode);
	}

	private void checkAuthorization(Map<String, Object> inputValues) {
		LinkedHashMap<String, Object> aItem = new LinkedHashMap<String, Object>();
		String token = defaultAuthorization;
		if (null != storeValues.get("AUTHORIZATION"))
			token = (String) storeValues.get("AUTHORIZATION");
		aItem.put("type", "test");
		aItem.put("value", token);
		aItem.put("isInput", true);
		aItem.put("isOutput", false);
		aItem.put("label", "AUTHORIZATION");
		aItem.put("isVariable", false);
		inputValues.put("AUTHORIZATION", aItem);
	}

	private boolean checkConditions(Map<String, Object> inputValues) {

		boolean retValue = true;

		for (String iVKey : inputValues.keySet()) {
			if (iVKey.equals("EVENT_ID"))
				continue;
			String type = (String) ((LinkedHashMap<String, Object>) inputValues.get(iVKey)).get("type");
			if (!type.startsWith("Conditional"))
				continue;
			Object storeValue = storeValues.get(iVKey);
			if (type.equals("Conditional-Null")) {
				if (null != storeValue)
					retValue = false;
				break;
			} else if (type.equals("Conditional-Not-Null")) {
				if (null == storeValue)
					retValue = false;
				break;
			} else if (type.equals("Conditional-Equal")) {
				Object value = ((LinkedHashMap<String, Object>) inputValues.get(iVKey)).get("value");
				if (null == storeValue || !storeValue.toString().trim().equals(value.toString().trim())) {
					retValue = false;
					break;
				}
			}
		}
		return retValue;
	}

	private void setStoreParamenter(TestParameterList parameterList) {
		log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<store Value>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (String output : parameterList.getOutputValues().keySet()) {
			if (output.equals("Store Value"))
				continue;
			String label = (String) ((LinkedHashMap<String, Object>) parameterList.getOutputValues().get(output))
					.get("label");
			Object value = ((LinkedHashMap<String, Object>) parameterList.getOutputValues().get(output)).get("value");
			if (label.equals("AUTHORIZATION"))
				value = "Bearer " + value;
			storeValues.put(label, value);
			log.info("store Value: " + label + ": " + value);
		}
	}

	@SuppressWarnings("unchecked")
	private Vector<TestInputFile> getFileList(Integer eventId) throws Exception {
		Vector<TestInputFile> inputFiles = new Vector<TestInputFile>();

		ResponseEntity<String> json = ClientWS.call(testServerUrl + "/rest/files/" + eventId, EventViewDTO.class,
				HttpMethod.GET, null);
		ObjectMapper mapper = new ObjectMapper();
		List<FileRefDTO> fileList = (List<FileRefDTO>) mapper.readValue(json.getBody(),
				mapper.getTypeFactory().constructCollectionType(List.class, FileRefDTO.class));

		for (FileRefDTO f : fileList) {
			inputFiles.add(new TestInputFile(f.getAzureUrl()));
		}
		return inputFiles;
	}

	public Integer createNewTestRunnerId(Integer creator) throws SQLException {

		String sql = "INSERT INTO TESTREPOSITORY.TESTRUN (TESTRUNID,TESTID,CREATOR,LOGDATA,EXITSTATUS,CREATED,DELETED) "
				+ "VALUES (:TESTRUNID,:TESTID,:CREATOR,:LOGDATA,:EXITSTATUS,sysdate,0)";
		Integer testrunId = null;
		Connection conn = MainDb.getConnection();
		try {
			testrunId = Sequence.next(conn, "TESTREPOSITORY.SEQ_TESTRUN");
			NamedParameterStatement npst = new NamedParameterStatement(conn, sql);
			npst.setInt("TESTRUNID", testrunId);
			npst.setInt("TESTID", testId);
			npst.setInt("CREATOR", creator);
			npst.execute();
			npst.close();
		} finally {
			conn.close();
		}

		return testrunId;
	}

	public void deleteFiles(Integer testRunnerId) throws IOException {

		if (isShowLog())
			log.info(EnvironmentHelper.getNasshareEnvironmentPath());
		if (isShowLog())
			log.info(EnvironmentHelper.getNasshareFileSystemPath());

		File envFolder = new File(EnvironmentHelper.getNasshareEnvironmentPath());

		try {
			envFolder.mkdirs();
			File[] children = envFolder.listFiles();
			for (File child : children)
				FileUtils.deleteDirectory(child);
		} catch (Exception e) {
			log.error("ERROR STACKTRACE:", e);
		}
	}

	private void resetFolders(final Connection connection) throws SQLException {
		final String nasshare = "/nasshare";
		final String OUTPUT = "output";
		final String INPUT = "input";
		ResultSet rs = null;
		PreparedStatement pst = null;
		String environmentName = null;

		try {
			pst = connection.prepareStatement("select svalue from adm_app_info where skey='DATABASE_ID'");
			rs = pst.executeQuery();
			if (rs.next()) {
				environmentName = rs.getString(1);
			}
		} finally {
			if (rs != null)
				rs.close();

			if (pst != null)
				pst.close();
		}

		if (environmentName != null) {
			List<String> inputFolders = new ArrayList<String>();
			List<String> outputFolders = new ArrayList<String>();
			try (final PreparedStatement pstAdmFtp = connection
					.prepareStatement("select outputftpfolder, inputftpfolder from adm_ftpinfo")) {
				try (final ResultSet rsAdmFtp = pstAdmFtp.executeQuery()) {
					while (rsAdmFtp.next()) {
						final String outFolder = rsAdmFtp.getString(1);
						if (outFolder != null) {
							outputFolders.add(outFolder.trim());
						}

						final String inFolder = rsAdmFtp.getString(2);
						if (inFolder != null) {
							inputFolders.add(inFolder.trim());
						}
					}
				}
			}

			final StringBuilder pathInput = new StringBuilder();
			pathInput.append(nasshare.toString()).append(File.separator).append(environmentName).append(File.separator)
					.append(INPUT).append(File.separator);
			File iagInputFolder = new File(pathInput.toString());
			if (iagInputFolder.exists() && iagInputFolder.isDirectory()) {
				try {
					FileUtils.deleteDirectory(iagInputFolder);
				} catch (IOException e) {
					log.error("Unable to remove iag input folder", e);
				}
			}

			final StringBuilder pathOutput = new StringBuilder();
			pathOutput.append(nasshare.toString()).append(File.separator).append(environmentName).append(File.separator)
					.append(OUTPUT);
			File iagOutputFolder = new File(pathOutput.toString());
			if (iagOutputFolder.exists() && iagOutputFolder.isDirectory()) {
				try {
					FileUtils.deleteDirectory(iagOutputFolder);
				} catch (IOException e) {
					log.error("Unable to remove iag output folder", e);
				}
			}

			final File nasshareFolder = new File(nasshare + File.separator + environmentName);
			if (nasshareFolder.isDirectory()) {
				final File[] filesInNasshare = nasshareFolder.listFiles();
				for (int i = 0; i < filesInNasshare.length; i++) {
					final File fileInNasshare = filesInNasshare[i];
					if (fileInNasshare.exists() && fileInNasshare.isDirectory()) {
						try {
							if (!outputFolders.contains(fileInNasshare.getName())
									&& !inputFolders.contains(fileInNasshare.getName())) {
								FileUtils.deleteDirectory(fileInNasshare);
							} else {
								FileUtils.cleanDirectory(fileInNasshare);
							}
						} catch (IOException e) {
							log.error("Unable to remove folders", e);
						}
					}
				}
			}
		} else {
			log.info("Unable to find environment name to delete folders");
		}
	}

	private void checkApplicationLog() throws SQLException {
		try (Connection conn = MainDb.getConnection()) {
			List<String> appLogs = new ApplicationLogDAO().list(conn, 4);
			for (final String logMsg : appLogs) {
				warningExists = true;
				warningMessage.append(logMsg).append("\r\n");
			}
			log.info("Application log summary: " + warningMessage);
		}
	}

	public String getDefaultAuthorization() {
		return defaultAuthorization;
	}

	public void setDefaultAuthorization(String defaultAuthorization) {
		this.defaultAuthorization = defaultAuthorization;
		if (null == storeValues.get("AUTHORIZATION"))
			storeValues.put("AUTHORIZATION", defaultAuthorization);
	}

	public boolean isShowLog() {
		return showLog;
	}

	public void setShowLog(boolean showLog) {
		this.showLog = showLog;
	}

	public Wildcards getWildcards() {
		return wildcards;
	}

	public void setWildcards(Wildcards wildcards) {
		this.wildcards = wildcards;
	}
}