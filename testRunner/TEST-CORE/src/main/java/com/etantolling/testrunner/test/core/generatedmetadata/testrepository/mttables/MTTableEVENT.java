package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableEVENT extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField EVENTID = new MTField("EVENTID");
	public static final MTField EVENTDEFINITIONID = new MTField("EVENTDEFINITIONID");
	public static final MTField TESTID = new MTField("TESTID");
	//public static final MTField POSTINGDATE = new MTField("POSTINGDATE");
	public static final MTField EVENTORDER = new MTField("EVENTORDER");
	public static final MTField AUTOMATICDESCRIPTION = new MTField("AUTOMATICDESCRIPTION");
	public static final MTField MANUALDESCRIPTION = new MTField("MANUALDESCRIPTION");
	public static final MTField DELETED = new MTField("DELETED");

	public static final MTField STARTDATE = new MTField("STARTDATE");
	public static final MTField ENDDATE = new MTField("ENDDATE");
	public static final MTField PARAMETERS = new MTField("PARAMETERS");
	
	static{
		fields.put("EVENTID",EVENTID);
		fields.put("EVENTDEFINITIONID",EVENTDEFINITIONID);
		fields.put("TESTID",TESTID);
		//fields.put("POSTINGDATE",POSTINGDATE);
		fields.put("STARTDATE",STARTDATE);
		fields.put("ENDDATE",ENDDATE);

		fields.put("EVENTORDER",EVENTORDER);
		fields.put("AUTOMATICDESCRIPTION",AUTOMATICDESCRIPTION);
		fields.put("MANUALDESCRIPTION",MANUALDESCRIPTION);
		fields.put("DELETED",DELETED);
		fields.put("PARAMETERS",PARAMETERS);
		
		EVENTID.setSqlType(3);
		EVENTID.setColumnSize(10);
		EVENTID.setNativeTypeName("NUMBER");
		EVENTID.setDecimalDigits(0);
		EVENTID.setNullable(0);
		
		EVENTDEFINITIONID.setSqlType(3);
		EVENTDEFINITIONID.setColumnSize(10);
		EVENTDEFINITIONID.setNativeTypeName("NUMBER");
		EVENTDEFINITIONID.setDecimalDigits(0);
		EVENTDEFINITIONID.setNullable(0);
		
		TESTID.setSqlType(3);
		TESTID.setColumnSize(10);
		TESTID.setNativeTypeName("NUMBER");
		TESTID.setDecimalDigits(0);
		TESTID.setNullable(0);
		
		
		//POSTINGDATE.setSqlType(93);
		//POSTINGDATE.setColumnSize(11);
		//POSTINGDATE.setNativeTypeName("TIMESTAMP(6)");
		//POSTINGDATE.setDecimalDigits(6);
		//POSTINGDATE.setNullable(0);
		
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
	
		PARAMETERS.setSqlType(12);
		PARAMETERS.setColumnSize(20);
		PARAMETERS.setNativeTypeName("VARCHAR");
		PARAMETERS.setDecimalDigits(null);
		PARAMETERS.setNullable(0);
		
		
		EVENTORDER.setSqlType(3);
		EVENTORDER.setColumnSize(3);
		EVENTORDER.setNativeTypeName("NUMBER");
		EVENTORDER.setDecimalDigits(0);
		EVENTORDER.setNullable(0);
		
		AUTOMATICDESCRIPTION.setSqlType(12);
		AUTOMATICDESCRIPTION.setColumnSize(255);
		AUTOMATICDESCRIPTION.setNativeTypeName("VARCHAR2");
		AUTOMATICDESCRIPTION.setDecimalDigits(null);
		AUTOMATICDESCRIPTION.setNullable(1);
		
		MANUALDESCRIPTION.setSqlType(12);
		MANUALDESCRIPTION.setColumnSize(255);
		MANUALDESCRIPTION.setNativeTypeName("VARCHAR2");
		MANUALDESCRIPTION.setDecimalDigits(null);
		MANUALDESCRIPTION.setNullable(1);
		
		DELETED.setSqlType(3);
		DELETED.setColumnSize(1);
		DELETED.setNativeTypeName("NUMBER");
		DELETED.setDecimalDigits(0);
		DELETED.setNullable(0);
		

		EVENTDEFINITIONID.setForeignKey("EVENTDEFINITION");
		TESTID.setForeignKey("TEST");
		for (MTField field:fields.values()) field.setTable("EVENT");

	}

	public MTTableEVENT(){
		this.tableName = "EVENT";
		this.primaryKeys.add(EVENTID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
