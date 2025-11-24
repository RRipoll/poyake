package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableEVENTDEFFOLDER extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField EVENTDEFFOLDERID = new MTField("EVENTDEFFOLDERID");
	public static final MTField PARENTFOLDERID = new MTField("PARENTFOLDERID");
	public static final MTField DESCRIPTION = new MTField("DESCRIPTION");
	public static final MTField STARTDATE = new MTField("STARTDATE");
	public static final MTField ENDDATE = new MTField("ENDDATE");
	public static final MTField DELETED = new MTField("DELETED");
	public static final MTField STEPID = new MTField("STEPID");
	
	static{
		fields.put("EVENTDEFFOLDERID",EVENTDEFFOLDERID);
		fields.put("PARENTFOLDERID",PARENTFOLDERID);
		fields.put("DESCRIPTION",DESCRIPTION);
		fields.put("STARTDATE",STARTDATE);
		fields.put("ENDDATE",ENDDATE);
		fields.put("DELETED",DELETED);
		fields.put("STEPID",STEPID);
		
		
		EVENTDEFFOLDERID.setSqlType(3);
		EVENTDEFFOLDERID.setColumnSize(10);
		EVENTDEFFOLDERID.setNativeTypeName("NUMBER");
		EVENTDEFFOLDERID.setDecimalDigits(0);
		EVENTDEFFOLDERID.setNullable(0);
		
		PARENTFOLDERID.setSqlType(3);
		PARENTFOLDERID.setColumnSize(10);
		PARENTFOLDERID.setNativeTypeName("NUMBER");
		PARENTFOLDERID.setDecimalDigits(0);
		PARENTFOLDERID.setNullable(1);
		
		DESCRIPTION.setSqlType(12);
		DESCRIPTION.setColumnSize(255);
		DESCRIPTION.setNativeTypeName("VARCHAR2");
		DESCRIPTION.setDecimalDigits(null);
		DESCRIPTION.setNullable(1);
		
		DELETED.setSqlType(3);
		DELETED.setColumnSize(1);
		DELETED.setNativeTypeName("NUMBER");
		DELETED.setDecimalDigits(0);
		DELETED.setNullable(1);
		
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
	
		STEPID.setSqlType(3);
		STEPID.setColumnSize(10);
		STEPID.setNativeTypeName("NUMBER");
		STEPID.setDecimalDigits(0);
		STEPID.setNullable(0);

		
		STEPID.setForeignKey("STEP");
		
		
		PARENTFOLDERID.setForeignKey("EVENTDEFFOLDER");
		for (MTField field:fields.values()) field.setTable("EVENTDEFFOLDER");

	}

	public MTTableEVENTDEFFOLDER(){
		this.tableName = "EVENTDEFFOLDER";
		this.primaryKeys.add(EVENTDEFFOLDERID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
