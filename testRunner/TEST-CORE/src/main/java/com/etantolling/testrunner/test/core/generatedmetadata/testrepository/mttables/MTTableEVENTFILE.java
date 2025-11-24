package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableEVENTFILE extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField EVENTFILEID = new MTField("EVENTFILEID");
	public static final MTField EVENTID = new MTField("EVENTID");
	public static final MTField FILEREFID = new MTField("FILEREFID");
	public static final MTField STARTDATE = new MTField("STARTDATE");
	public static final MTField ENDDATE = new MTField("ENDDATE");
	
	static{
		fields.put("EVENTFILEID",EVENTFILEID);
		fields.put("EVENTID",EVENTID);
		fields.put("FILEREFID",FILEREFID);
		fields.put("STARTDATE",STARTDATE);
		fields.put("ENDDATE",ENDDATE);
		
		EVENTFILEID.setSqlType(3);
		EVENTFILEID.setColumnSize(10);
		EVENTFILEID.setNativeTypeName("NUMBER");
		EVENTFILEID.setDecimalDigits(0);
		EVENTFILEID.setNullable(0);
		
		EVENTID.setSqlType(3);
		EVENTID.setColumnSize(10);
		EVENTID.setNativeTypeName("NUMBER");
		EVENTID.setDecimalDigits(0);
		EVENTID.setNullable(0);
		
		FILEREFID.setSqlType(3);
		FILEREFID.setColumnSize(10);
		FILEREFID.setNativeTypeName("NUMBER");
		FILEREFID.setDecimalDigits(0);
		FILEREFID.setNullable(0);
		
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

		EVENTID.setForeignKey("EVENT");
		FILEREFID.setForeignKey("FILEREF");
		for (MTField field:fields.values()) field.setTable("EVENTFILE");

	}

	public MTTableEVENTFILE(){
		this.tableName = "EVENTFILE";
		this.primaryKeys.add(EVENTFILEID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
