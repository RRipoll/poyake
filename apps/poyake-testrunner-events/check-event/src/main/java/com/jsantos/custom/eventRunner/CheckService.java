package com.jsantos.custom.eventRunner;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jsantos.common.constraint.ValidationError;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.extendeddto.StoreValuesTestExtDTO;
import com.jsantos.gui.detail.DefaultDetailContainer;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.metadata.testrunner.CheckParamEventDefinitionDTO;
import com.jsantos.metadata.testrunner.CheckParameterItemDTO;
import com.jsantos.metadata.testrunner.EventStatus;
import com.jsantos.metadata.testrunner.MTTableCHECKPARAMEVENTDEFINITION;
import com.jsantos.metadata.testrunner.StoreValuesEventDTO;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.runningTest.SystemOut;
import com.jsantos.service.ITestEventRunner;

public class CheckService implements ITestEventRunner {

	private static final Logger logger = LoggerFactory.getLogger(CheckService.class);

	@Override
	public StoreValuesTestExtDTO runEvent(IDetachedRecord event, StoreValuesTestExtDTO storeValues) throws Exception {
		StoreValuesEventDTO svm = new StoreValuesEventDTO();
		svm.setEvent(event);
		svm.setEventName(((CheckParamEventDefinitionDTO)event).getEventName());
		svm.setStatus(EventStatus.PROCESSING);
		File file = SystemOut.setSystemOutToFile();
		if (null != file)
			svm.setLog(file.getAbsolutePath());
		storeValues.addStoreValuesEvent(svm);
		ListValues<IValidationError> error=new ListValues<>();
		try {
		ListValues<CheckParameterItemDTO> parameters = (ListValues<CheckParameterItemDTO>) DBValueMapper
				.loadValue(event, MTTableCHECKPARAMEVENTDEFINITION.PARAMETERS);
		svm.setStatus(EventStatus.ERROR);
		showStarting(null, parameters, null);
		
		for (CheckParameterItemDTO itemDTO : parameters) {

			String dbvalue = itemDTO.getValueName();
			String dbcheckValue = itemDTO.getCheckValue();
			Integer checkType = itemDTO.getCheckValueTypeId();
			Integer operator = itemDTO.getOperator();

			String value = storeValues.replacePathValues(dbvalue);
			String checkValue = storeValues.replacePathValues(dbcheckValue);

			String operatorSc = MTtestRunnerData.OPERATOR.getEnumerationValue(operator);

			boolean result = false;

			if(operatorSc.equals("CHECK")) {
				value=storeValues.findValue(value);
				result =value.equals(checkValue);
				
			}else {
				
				switch (operatorSc) {
				case "EQUAL":
					result = value.toString().equals(checkValue.toString());
					break;
				case "NOT_EQUAL":
					result = !value.toString().equals(checkValue.toString());
					break;
				case "LT":
					BigDecimal bdValue = new BigDecimal(value);
					BigDecimal bdCheckValue = new BigDecimal(checkValue);
					result = bdValue.compareTo(bdCheckValue) == -1;
					break;
				case "LE":
					BigDecimal bdValue1 = new BigDecimal(value);
					BigDecimal bdCheckValue1 = new BigDecimal(checkValue);
					result = bdValue1.compareTo(bdCheckValue1) == -1 || bdValue1.compareTo(bdCheckValue1) == 0;
					break;
				case "GE":
					BigDecimal bdValue11 = new BigDecimal(value);
					BigDecimal bdCheckValue11 = new BigDecimal(checkValue);
					result = bdValue11.compareTo(bdCheckValue11) == 1 || bdValue11.compareTo(bdCheckValue11) == 0;
					break;
				case "GT":
					BigDecimal bdValue111 = new BigDecimal(value);
					BigDecimal bdCheckValue111 = new BigDecimal(checkValue);
					result = bdValue111.compareTo(bdCheckValue111) == 1;
					break;
				case "IN":
					List<String> list = new ArrayList<String>(Arrays.asList(checkValue.split(",")));
					result = list.contains(value);
					break;
				case "NOT_IN":
					List<String> list1 = new ArrayList<String>(Arrays.asList(checkValue.split(",")));
					result = !list1.contains(value);
					break;
				case "BETWEEN":
					List<String> list11 = new ArrayList<String>(Arrays.asList(checkValue.split(",")));
					BigDecimal value0 = new BigDecimal(value);
					BigDecimal value1 = new BigDecimal(list11.get(0));
					BigDecimal value2 = new BigDecimal(list11.get(1));
					result = (value0.compareTo(value1) == -1 || value0.compareTo(value1) == 0)
							&& value0.compareTo(value2) == 1;
					break;
				case "LIKE":
					String patt = ".*?" + value + ".*?";
					Pattern regex = Pattern.compile(patt);
					if (regex.matcher(checkValue).matches())
						result = true;
					else
						result = false;
					break;
				case "ILIKE":
					String patt1 = ".*?" + value.toUpperCase() + ".*?";
					Pattern regex1 = Pattern.compile(patt1);
					if (regex1.matcher(checkValue.toUpperCase()).matches())
						result = true;
					else
						result = false;
					break;
				case "_NULL":
					result = null == value;
					break;
				case "NOT_NULL":
					result = null != value;
					break;
				case "CHECK":
					result = value.toString().equals(checkValue.toString());
					break;
				}	
			}
			
			
			
			
			if(!result) {
				ValidationError ve= new ValidationError();
				ve.setMessageCode("Values don't match: " +operatorSc+": dbvalue "+dbvalue +" -> "+value+" should be-> "+checkValue+" ");
				error.add(ve);
			}
		}
		showSummary(null, error.stream().map(e-> e.getMessageCode() ).collect(Collectors.joining(", ")),
				null,error.isEmpty()?"Matches are passes":"Matches are not passes",null);
		if(!error.isEmpty())
			throw new Exception(((CheckParamEventDefinitionDTO)event).getEventName() +": "+ error);
		} catch (Exception e) {
			svm.setStatus(EventStatus.ERROR);
			e.printStackTrace();
			SystemOut.closeFileSystemLog(file);
			throw new Exception(((CheckParamEventDefinitionDTO)event).getEventName() +": "+ e.getMessage(), e);
		}
		SystemOut.closeFileSystemLog(file);
		svm.setStatus(EventStatus.DONE);
		return storeValues;
	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		System.out.println("*** ------------------------------------------ --------------------------------------- ***");
		System.out.println("*** -------------------------- EVENT CHECK_SERVICE START --------------- ***");
		System.out.println("*** ---------------------------------- ----------------------------------------------- ***");
		System.out.println("*** parameters " + parameters);
		//System.out.println("*** JSON " + json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response.getStatusCode = " + responseCode);
		//System.out.println("*** Response = " + responseBody);
		System.out.println("*** errors " + parameters);
		System.out
				.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println("*** -----------------------------EVENT CHECK_SERVICE END -------------- ***");
		System.out
				.println("*** ---------------------------------------------------------------------------------- ***");
	}

	@Override
	public String forEventType() {
		return "CHECK_SERVICE";
	}

	@Override
	public IDetailContainer getDetailContainer() {
		DefaultDetailContainer detail = new DefaultDetailContainer();
		return detail;
	}

	@Override
	public MTTable getMTTable() {
		return MTtestRunnerData.CHECKPARAMEVENTDEFINITION;
	}
}
