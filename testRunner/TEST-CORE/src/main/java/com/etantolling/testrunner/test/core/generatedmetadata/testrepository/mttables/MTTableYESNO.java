package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableYESNO extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField YESNOID = new MTField("YESNOID");
	public static final MTField DESCRIPTION = new MTField("DESCRIPTION");
	public static final MTField STARTDATE = new MTField("STARTDATE");
	public static final MTField ENDDATE = new MTField("ENDDATE");
	
	static{
		fields.put("YESNOID",YESNOID);
		fields.put("DESCRIPTION",DESCRIPTION);
		fields.put("STARTDATE",STARTDATE);
		fields.put("ENDDATE",ENDDATE);

		YESNOID.setSqlType(3);
		YESNOID.setColumnSize(1);
		YESNOID.setNativeTypeName("NUMBER");
		YESNOID.setDecimalDigits(0);
		YESNOID.setNullable(0);
		
		DESCRIPTION.setSqlType(12);
		DESCRIPTION.setColumnSize(20);
		DESCRIPTION.setNativeTypeName("VARCHAR2");
		DESCRIPTION.setDecimalDigits(null);
		DESCRIPTION.setNullable(0);
		
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

		for (MTField field:fields.values()) field.setTable("YESNO");

	}

	public MTTableYESNO(){
		this.tableName = "YESNO";
		this.primaryKeys.add(YESNOID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
