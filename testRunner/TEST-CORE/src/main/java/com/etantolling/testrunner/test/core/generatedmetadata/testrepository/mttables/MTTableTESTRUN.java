package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableTESTRUN extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField TESTRUNID = new MTField("TESTRUNID");
	public static final MTField TESTID = new MTField("TESTID");
	public static final MTField CREATOR = new MTField("CREATOR");
	public static final MTField LOGDATA = new MTField("LOGDATA");
	public static final MTField EXITSTATUS = new MTField("EXITSTATUS");
	public static final MTField STARTDATE = new MTField("STARTDATE");
	public static final MTField ENDDATE = new MTField("ENDDATE");
	public static final MTField CREATED = new MTField("CREATED");
	
	public static final MTField DELETED = new MTField("DELETED");

	static{
		fields.put("TESTRUNID",TESTRUNID);
		fields.put("TESTID",TESTID);
		fields.put("CREATOR",CREATOR);
		fields.put("LOGDATA",LOGDATA);
		fields.put("EXITSTATUS",EXITSTATUS);
		fields.put("DELETED",DELETED);
		fields.put("STARTDATE",STARTDATE);
		fields.put("ENDDATE",ENDDATE);
		fields.put("CREATED",CREATED);
		TESTRUNID.setSqlType(3);
		TESTRUNID.setColumnSize(10);
		TESTRUNID.setNativeTypeName("NUMBER");
		TESTRUNID.setDecimalDigits(0);
		TESTRUNID.setNullable(0);
		
		TESTID.setSqlType(3);
		TESTID.setColumnSize(10);
		TESTID.setNativeTypeName("NUMBER");
		TESTID.setDecimalDigits(0);
		TESTID.setNullable(0);
		
		CREATOR.setSqlType(3);
		CREATOR.setColumnSize(10);
		CREATOR.setNativeTypeName("NUMBER");
		CREATOR.setDecimalDigits(0);
		CREATOR.setNullable(0);
		
		LOGDATA.setSqlType(2005);
		LOGDATA.setColumnSize(4000);
		LOGDATA.setNativeTypeName("CLOB");
		LOGDATA.setDecimalDigits(null);
		LOGDATA.setNullable(1);
		
		EXITSTATUS.setSqlType(3);
		EXITSTATUS.setColumnSize(1);
		EXITSTATUS.setNativeTypeName("NUMBER");
		EXITSTATUS.setDecimalDigits(0);
		EXITSTATUS.setNullable(0);
		
		CREATED.setSqlType(93);
		CREATED.setColumnSize(11);
		CREATED.setNativeTypeName("TIMESTAMP(6)");
		CREATED.setDecimalDigits(6);
		CREATED.setNullable(0);
		DELETED.setSqlType(3);
		DELETED.setColumnSize(1);
		DELETED.setNativeTypeName("NUMBER");
		DELETED.setDecimalDigits(0);
		DELETED.setNullable(0);
		
		STARTDATE.setSqlType(93);
		STARTDATE.setColumnSize(11);
		STARTDATE.setNativeTypeName("TIMESTAMP(6)");
		STARTDATE.setDecimalDigits(6);
		STARTDATE.setNullable(0);
	
		ENDDATE.setSqlType(93);
		ENDDATE.setColumnSize(11);
		ENDDATE.setNativeTypeName("TIMESTAMP(6)");
		ENDDATE.setDecimalDigits(6);
		ENDDATE.setNullable(0);
	

		CREATOR.setForeignKey("INPUTUSER");
		TESTID.setForeignKey("TEST");
		for (MTField field:fields.values()) field.setTable("TESTRUN");

	}

	public MTTableTESTRUN(){
		this.tableName = "TESTRUN";
		this.primaryKeys.add(TESTRUNID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
