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
import com.jsantos.metadata.MTparamRunnerData;
import com.jsantos.metadata.testrunner.AddParameterDefinitionDTO;
import com.jsantos.metadata.testrunner.EventStatus;
import com.jsantos.metadata.testrunner.MTTableADDPARAMETERDEFINITION;
import com.jsantos.metadata.testrunner.StoreValuesEventDTO;
import com.jsantos.metadata.testrunner.TrParameterDTO;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.runningTest.SystemOut;
import com.jsantos.service.ITestEventRunner;

public class AddParameterService implements ITestEventRunner {

	private static final Logger logger = LoggerFactory.getLogger(AddParameterService.class);

	@Override
	public StoreValuesTestExtDTO runEvent(IDetachedRecord event, StoreValuesTestExtDTO storeValues) throws Exception {
		StoreValuesEventDTO svm=new StoreValuesEventDTO();
		svm.setEvent(event);
		svm.setEventName(((AddParameterDefinitionDTO)event).getEventName());
		svm.setStatus(EventStatus.PROCESSING);
		File file=SystemOut.setSystemOutToFile();
		if(null!=file)svm.setLog(file.getAbsolutePath());
		storeValues.addStoreValuesEvent(svm);
		try {
			
			
			ListValues<TrParameterDTO> parameters = (ListValues<TrParameterDTO>) DBValueMapper.loadValue(event,MTTableADDPARAMETERDEFINITION.PARAMETERS);
			MapValues<Object> params =  new MapValues<>();
			
			showStarting(null, parameters, null);
			
			for (TrParameterDTO object : parameters) {
				params.add(object.getLabel(), object.getValue());
			}
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			String body = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(params));
			svm.setData(body);
			
			
			showSummary(null, parameters, null,null,body);

		} catch (Exception e) {
			svm.setStatus(EventStatus.ERROR);
			e.printStackTrace();
			SystemOut.closeFileSystemLog(file);
			throw new Exception(((AddParameterDefinitionDTO)event).getEventName() +": "+ e.getMessage(), e);
		}
		
	    SystemOut.closeFileSystemLog(file);
	    svm.setStatus(EventStatus.DONE);
		return storeValues;
	}





	@Override
	public void showStarting(String url, Object parameters, String json) {
		System.out.println("*** ------------------------------------------ --------------------------------------- ***");
		System.out.println("*** -------------------------- EVENT ADD_PARAMETERS START --------------- ***");
		System.out.println("*** ---------------------------------- ----------------------------------------------- ***");
		System.out.println("*** parameters " + parameters);
		System.out.println("*** JSON " + json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response = " + responseBody);
		
		System.out.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println("*** -----------------------------EVENT ADD_PARAMETERS END -------------- ***");
		System.out.println("*** ---------------------------------------------------------------------------------- ***");
	}

	@Override
	public String forEventType() {
		return "ADD_PARAMETERS";
	}

	


	@Override
	public IDetailContainer getDetailContainer() {
		DefaultDetailContainer detail=new DefaultDetailContainer();
		//detail.setSearchName(forEventType());
		return detail;
	}





	@Override
	public MTTable getMTTable() {
		
		return MTparamRunnerData.ADDPARAMETERDEFINITION;
	}

}