package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableTE_RESETDB extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField RESETDBID = new MTField("RESETDBID");
	public static final MTField STARTDATE = new MTField("STARTDATE");
	public static final MTField ENDDATE = new MTField("ENDDATE");
	
	static{
		fields.put("RESETDBID",RESETDBID);
		fields.put("STARTDATE",STARTDATE);
		fields.put("ENDDATE",ENDDATE);
		
		RESETDBID.setSqlType(3);
		RESETDBID.setColumnSize(10);
		RESETDBID.setNativeTypeName("NUMBER");
		RESETDBID.setDecimalDigits(0);
		RESETDBID.setNullable(0);
		
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

		for (MTField field:fields.values()) field.setTable("TE_RESETDB");

	}

	public MTTableTE_RESETDB(){
		this.tableName = "TE_RESETDB";
		this.primaryKeys.add(RESETDBID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
