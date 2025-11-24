package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.testrunner.MTTableEVENTDEFINITION;

public class MTTableRUNTESTEVENTDEFINITION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField EVENTDEFINITIONUUID = new MTField("eventDefinitionUuid");
	public static MTField EVENTTYPEID;
	public static final MTField EVENTNAME = new MTField("eventName");
	public static MTField DESCRIPTION;
	public static final MTField SELECTED = new MTField("selected");
	public static final MTField TESTID = new MTField("testId");
	public static final MTField REPETITIONNUMBER = new MTField("repetitionNumber");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(EVENTDEFINITIONUUID);
		{
			EVENTDEFINITIONUUID.setDataType(MTDataTypes.UUID);
			EVENTDEFINITIONUUID.setLength(130);
			EVENTDEFINITIONUUID.setNullable(true);
			EVENTDEFINITIONUUID.setTransient(false);
			EVENTDEFINITIONUUID.setSequence("testrunner.Seq_RunTestEventDefinition_eventDefinitionUuid");
			EVENTDEFINITIONUUID.setPrimaryKey(true);
		}
		EVENTTYPEID = new MTField(MTTableEVENTDEFINITION.EVENTTYPEID,"eventTypeId");
		fields.add(EVENTTYPEID);
		{
			EVENTTYPEID.setDataType(MTDataTypes.UUID);
			EVENTTYPEID.setLength(130);
			EVENTTYPEID.setNullable(false);
			EVENTTYPEID.setTransient(false);
		}
		fields.add(EVENTNAME);
		{
			EVENTNAME.setDataType(MTDataTypes.VARCHAR);
			EVENTNAME.setLength(64);
			EVENTNAME.setNullable(false);
			EVENTNAME.setTransient(false);
			EVENTNAME.getStereoTypes().add("DESCRIPTION");
		}
		DESCRIPTION = new MTField(MTTableEVENTDEFINITION.DESCRIPTION,"description");
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
		}
		fields.add(SELECTED);
		{
			SELECTED.setDataType(MTDataTypes.EVENTSELECTED);
			SELECTED.setNullable(true);
			SELECTED.setTransient(false);
			SELECTED.setDefaultValue("1");
		}
		fields.add(TESTID);
		{
			TESTID.setDataType(MTDataTypes.UUID);
			TESTID.setLength(130);
			TESTID.setNullable(true);
			TESTID.setTransient(false);
		}
		fields.add(REPETITIONNUMBER);
		{
			REPETITIONNUMBER.setDataType(MTDataTypes.INT);
			REPETITIONNUMBER.setNullable(false);
			REPETITIONNUMBER.setTransient(false);
			REPETITIONNUMBER.setDefaultValue("1");
		}
	}

	public MTTableRUNTESTEVENTDEFINITION(){
		init();
		this.tableName = "RunTestEventDefinition";
		this.schema = "testrunner";
		this.entityType = "VIEW";
		this.primaryKeys.add(EVENTDEFINITIONUUID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}