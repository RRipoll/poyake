package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableEVENTDEFINITION extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField EVENTDEFINITIONID = new MTField("EVENTDEFINITIONID");
	public static final MTField EVENTTYPEID = new MTField("EVENTTYPEID");
	public static final MTField CREATOR = new MTField("CREATOR");
	public static final MTField FOLDERID = new MTField("FOLDERID");
	public static final MTField EVENTNAME = new MTField("EVENTNAME");
	public static final MTField CREATED = new MTField("CREATED");
	public static final MTField DELETED = new MTField("DELETED");
	public static final MTField DESCRIPTION = new MTField("DESCRIPTION");
	public static final MTField STARTDATE = new MTField("STARTDATE");
	public static final MTField ENDDATE = new MTField("ENDDATE");
	public static final MTField RESTEVENT = new MTField("RESTEVENT");
	public static final MTField PARAMETERS = new MTField("PARAMETERS");
	
	static{
		fields.put("EVENTDEFINITIONID",EVENTDEFINITIONID);
		fields.put("EVENTTYPEID",EVENTTYPEID);
		fields.put("CREATOR",CREATOR);
		fields.put("FOLDERID",FOLDERID);
		fields.put("EVENTNAME",EVENTNAME);
		fields.put("CREATED",CREATED);
		fields.put("DELETED",DELETED);
		fields.put("DESCRIPTION",DESCRIPTION);
		fields.put("STARTDATE",STARTDATE);
		fields.put("ENDDATE",ENDDATE);
		fields.put("RESTEVENT",RESTEVENT);
		fields.put("PARAMETERS",PARAMETERS);
		
		EVENTDEFINITIONID.setSqlType(3);
		EVENTDEFINITIONID.setColumnSize(10);
		EVENTDEFINITIONID.setNativeTypeName("NUMBER");
		EVENTDEFINITIONID.setDecimalDigits(0);
		EVENTDEFINITIONID.setNullable(0);
		
		EVENTTYPEID.setSqlType(3);
		EVENTTYPEID.setColumnSize(10);
		EVENTTYPEID.setNativeTypeName("NUMBER");
		EVENTTYPEID.setDecimalDigits(0);
		EVENTTYPEID.setNullable(0);
		
		CREATOR.setSqlType(3);
		CREATOR.setColumnSize(10);
		CREATOR.setNativeTypeName("NUMBER");
		CREATOR.setDecimalDigits(0);
		CREATOR.setNullable(0);
		
		FOLDERID.setSqlType(3);
		FOLDERID.setColumnSize(10);
		FOLDERID.setNativeTypeName("NUMBER");
		FOLDERID.setDecimalDigits(0);
		FOLDERID.setNullable(0);
		
		EVENTNAME.setSqlType(12);
		EVENTNAME.setColumnSize(255);
		EVENTNAME.setNativeTypeName("VARCHAR2");
		EVENTNAME.setDecimalDigits(null);
		EVENTNAME.setNullable(0);
		
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
		
		
		
		DESCRIPTION.setSqlType(12);
		DESCRIPTION.setColumnSize(255);
		DESCRIPTION.setNativeTypeName("VARCHAR2");
		DESCRIPTION.setDecimalDigits(null);
		DESCRIPTION.setNullable(0);
		
		RESTEVENT.setSqlType(3);
		RESTEVENT.setColumnSize(1);
		RESTEVENT.setNativeTypeName("NUMBER");
		RESTEVENT.setDecimalDigits(0);
		RESTEVENT.setNullable(0);

		PARAMETERS.setSqlType(12);
		PARAMETERS.setColumnSize(20);
		PARAMETERS.setNativeTypeName("VARCHAR");
		PARAMETERS.setDecimalDigits(null);
		PARAMETERS.setNullable(0);

		CREATOR.setForeignKey("INPUTUSER");
		EVENTTYPEID.setForeignKey("EVENTTYPE");
		
		
		for (MTField field:fields.values()) field.setTable("EVENTDEFINITION");

	}

	public MTTableEVENTDEFINITION(){
		this.tableName = "EVENTDEFINITION";
		this.primaryKeys.add(EVENTDEFINITIONID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
