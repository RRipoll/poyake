package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableTESTSCRIPTITEM extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField TESTSCRIPTITEMID = new MTField("TESTSCRIPTITEMID");
	public static final MTField TESTID = new MTField("TESTID");

	static{
		fields.put("TESTSCRIPTITEMID",TESTSCRIPTITEMID);
		fields.put("TESTID",TESTID);

		TESTSCRIPTITEMID.setSqlType(3);
		TESTSCRIPTITEMID.setColumnSize(10);
		TESTSCRIPTITEMID.setNativeTypeName("NUMBER");
		TESTSCRIPTITEMID.setDecimalDigits(0);
		TESTSCRIPTITEMID.setNullable(0);
		
		TESTID.setSqlType(3);
		TESTID.setColumnSize(10);
		TESTID.setNativeTypeName("NUMBER");
		TESTID.setDecimalDigits(0);
		TESTID.setNullable(0);
		


		TESTID.setForeignKey("TEST");
		for (MTField field:fields.values()) field.setTable("TESTSCRIPTITEM");

	}

	public MTTableTESTSCRIPTITEM(){
		this.tableName = "TESTSCRIPTITEM";
		this.primaryKeys.add(TESTSCRIPTITEMID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
