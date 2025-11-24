package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableMTTABLEINFO extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField TABLENAME = new MTField("TABLENAME");
	public static final MTField ISENUM = new MTField("ISENUM");
	public static final MTField IDFIELD = new MTField("IDFIELD");

	static{
		fields.put("TABLENAME",TABLENAME);
		fields.put("ISENUM",ISENUM);
		fields.put("IDFIELD",IDFIELD);

		TABLENAME.setSqlType(12);
		TABLENAME.setColumnSize(255);
		TABLENAME.setNativeTypeName("VARCHAR2");
		TABLENAME.setDecimalDigits(null);
		TABLENAME.setNullable(0);
		
		ISENUM.setSqlType(3);
		ISENUM.setColumnSize(1);
		ISENUM.setNativeTypeName("NUMBER");
		ISENUM.setDecimalDigits(0);
		ISENUM.setNullable(1);
		
		IDFIELD.setSqlType(12);
		IDFIELD.setColumnSize(255);
		IDFIELD.setNativeTypeName("VARCHAR2");
		IDFIELD.setDecimalDigits(null);
		IDFIELD.setNullable(1);
		


		for (MTField field:fields.values()) field.setTable("MTTABLEINFO");

	}

	public MTTableMTTABLEINFO(){
		this.tableName = "MTTABLEINFO";
		this.primaryKeys.add(TABLENAME);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
