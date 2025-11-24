package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableTESTRUNFILE extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField TESTRUNFILEID = new MTField("TESTRUNFILEID");
	public static final MTField TESTRUNID = new MTField("TESTRUNID");
	public static final MTField EVENTID = new MTField("EVENTID");
	public static final MTField ORIGINALPATH = new MTField("ORIGINALPATH");
	public static final MTField ACTUALPATH = new MTField("ACTUALPATH");

	static{
		fields.put("TESTRUNFILEID",TESTRUNFILEID);
		fields.put("TESTRUNID",TESTRUNID);
		fields.put("EVENTID",EVENTID);
		fields.put("ORIGINALPATH",ORIGINALPATH);
		fields.put("ACTUALPATH",ACTUALPATH);

		TESTRUNFILEID.setSqlType(3);
		TESTRUNFILEID.setColumnSize(10);
		TESTRUNFILEID.setNativeTypeName("NUMBER");
		TESTRUNFILEID.setDecimalDigits(0);
		TESTRUNFILEID.setNullable(0);
		
		TESTRUNID.setSqlType(3);
		TESTRUNID.setColumnSize(10);
		TESTRUNID.setNativeTypeName("NUMBER");
		TESTRUNID.setDecimalDigits(0);
		TESTRUNID.setNullable(0);
		
		EVENTID.setSqlType(3);
		EVENTID.setColumnSize(10);
		EVENTID.setNativeTypeName("NUMBER");
		EVENTID.setDecimalDigits(0);
		EVENTID.setNullable(0);
		
		ORIGINALPATH.setSqlType(12);
		ORIGINALPATH.setColumnSize(255);
		ORIGINALPATH.setNativeTypeName("VARCHAR2");
		ORIGINALPATH.setDecimalDigits(null);
		ORIGINALPATH.setNullable(0);
		
		ACTUALPATH.setSqlType(12);
		ACTUALPATH.setColumnSize(255);
		ACTUALPATH.setNativeTypeName("VARCHAR2");
		ACTUALPATH.setDecimalDigits(null);
		ACTUALPATH.setNullable(0);
		


		TESTRUNID.setForeignKey("TESTRUN");
		for (MTField field:fields.values()) field.setTable("TESTRUNFILE");

	}

	public MTTableTESTRUNFILE(){
		this.tableName = "TESTRUNFILE";
		this.primaryKeys.add(TESTRUNFILEID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
