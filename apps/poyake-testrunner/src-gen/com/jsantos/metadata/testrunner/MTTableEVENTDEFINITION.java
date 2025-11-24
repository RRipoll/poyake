package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableEVENTDEFINITION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField EVENTDEFINITIONUUID = new MTField("eventDefinitionUuid");
	public static final MTField EVENTTYPEID = new MTField("eventTypeId");
	public static final MTField EVENTNAME = new MTField("eventName");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField EVENTDEFINITION = new MTField("eventDefinition");
	public static final MTField CREATED = new MTField("created");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(EVENTDEFINITIONUUID);
		{
			EVENTDEFINITIONUUID.setDataType(MTDataTypes.UUID);
			EVENTDEFINITIONUUID.setLength(130);
			EVENTDEFINITIONUUID.setNullable(true);
			EVENTDEFINITIONUUID.setTransient(false);
			EVENTDEFINITIONUUID.setSequence("testrunner.Seq_EventDefinition_eventDefinitionUuid");
			EVENTDEFINITIONUUID.setPrimaryKey(true);
		}
		fields.add(EVENTTYPEID);
		{
			EVENTTYPEID.setDataType(MTDataTypes.UUID);
			EVENTTYPEID.setLength(130);
			EVENTTYPEID.setNullable(false);
			EVENTTYPEID.setTransient(false);
			EVENTTYPEID.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(EVENTNAME);
		{
			EVENTNAME.setDataType(MTDataTypes.VARCHAR);
			EVENTNAME.setLength(64);
			EVENTNAME.setNullable(false);
			EVENTNAME.setTransient(false);
			EVENTNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(EVENTDEFINITION);
		{
			EVENTDEFINITION.setDataType(MTDataTypes.EVENT);
			EVENTDEFINITION.setNullable(true);
			EVENTDEFINITION.setTransient(false);
		}
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(false);
			CREATED.setTransient(false);
			CREATED.getStereoTypes().add("NOGUIINPUT");
			CREATED.setDefaultValue("getPostingDate()");
		}
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(false);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.getStereoTypes().add("NOGUIINPUT");
			INPUTUSERID.setDefaultValue("1");
		}
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(false);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.getStereoTypes().add("NOGUIINPUT");
			INPUTSOURCEID.setDefaultValue("1");
		}
	}

	public MTTableEVENTDEFINITION(){
		init();
		this.tableName = "EventDefinition";
		this.schema = "testrunner";
		this.entityType = "TABLE";
		this.primaryKeys.add(EVENTDEFINITIONUUID);
		this.patterns.add("Audited");
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}