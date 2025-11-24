package com.jsantos.custom.eventRunner;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.extendeddto.StoreValuesTestExtDTO;
import com.jsantos.gui.detail.DefaultDetailContainer;
import com.jsantos.metadata.MTrunTestRunnerData;
import com.jsantos.metadata.testrunner.EventStatus;
import com.jsantos.metadata.testrunner.RunTestEventDefinitionDTO;
import com.jsantos.metadata.testrunner.StoreValuesEventDTO;
import com.jsantos.metadata.testrunner.TestDTO;
import com.jsantos.metadata.testrunner.TrParameterDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.runningTest.SystemOut;
import com.jsantos.runningTest.TestRunner;
import com.jsantos.service.ITestEventRunner;

public class RunTestEventService implements ITestEventRunner {

	private static final Logger logger = LoggerFactory.getLogger(RunTestEventService.class);

	@Override
	public StoreValuesTestExtDTO runEvent(IDetachedRecord event, StoreValuesTestExtDTO storeValues) throws Exception {
		StoreValuesEventDTO svm=new StoreValuesEventDTO();
		svm.setEvent(event);
		svm.setEventName(((RunTestEventDefinitionDTO)event).getEventName());
		svm.setStatus(EventStatus.PROCESSING);
		File file=SystemOut.setSystemOutToFile();
		if(null!=file)svm.setLog(file.getAbsolutePath());
		storeValues.addStoreValuesEvent(svm);
		try {
			
			Integer repetitionNumber=((RunTestEventDefinitionDTO)event).getRepetitionNumber();
			Object testId=((RunTestEventDefinitionDTO)event).getTestId();
			MapValues<Object> params =  new MapValues<>();
			
			showStarting(null, testId, null);
			
			for (int i=0;i<repetitionNumber;i++) {
				
				new TestRunner( (TestDTO) new TestDTO().findByPk(testId), storeValues).runTest();;
			}
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			String body = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(params));
			svm.setData(body);
			
			
			showSummary(null, testId, null,null,body);

		} catch (Exception e) {
			svm.setStatus(EventStatus.ERROR);
			e.printStackTrace();
			SystemOut.closeFileSystemLog(file);
			throw new Exception(((RunTestEventDefinitionDTO)event).getEventName() +": "+ e.getMessage(), e);
		}
		
	    SystemOut.closeFileSystemLog(file);
	    svm.setStatus(EventStatus.DONE);
		return storeValues;
	}

	private String setRequestParams(String urlRequest, ListValues<TrParameterDTO> parameters) {

		for (TrParameterDTO key : parameters) {
			urlRequest = urlRequest.replace("{" + key.getLabel() + "}", key.getValue());
		}
		return urlRequest;
	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		System.out
				.println("*** ------------------------------------------ --------------------------------------- ***");
		System.out.println("*** -------------------------- EVENT RestWebService START --------------- ***");
		System.out
				.println("*** ---------------------------------- ----------------------------------------------- ***");
		System.out.println("*** Request = " + url);
		System.out.println("*** parameters " + parameters);
		System.out.println("*** JSON " + json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response.getStatusCode = " + responseCode);
		System.out.println("*** Response = " + responseBody);

		System.out
				.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println("*** -----------------------------EVENT RestWebService END -------------- ***");
		System.out
				.println("*** ---------------------------------------------------------------------------------- ***");
	}

	@Override
	public String forEventType() {
		return "RUN_TEST_SERVICE";
	}

	@Override
	public IDetailContainer getDetailContainer() {
		DefaultDetailContainer detail = new DefaultDetailContainer();
		// detail.setSearchName(forEventType());
		return detail;
	}

	@Override
	public MTTable getMTTable() {

		return MTrunTestRunnerData.RUNTESTEVENTDEFINITION;
	}

	
}