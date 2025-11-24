package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableEVENTDEFFOLDER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField EVENTDEFFOLDERUUID = new MTField("eventdeffolderUuid");
	public static final MTField PARENTFOLDERUUID = new MTField("parentfolderUuid");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField EVENTDEFINITIONUUID = new MTField("eventDefinitionUuid");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(EVENTDEFFOLDERUUID);
		{
			EVENTDEFFOLDERUUID.setDataType(MTDataTypes.UUID);
			EVENTDEFFOLDERUUID.setLength(130);
			EVENTDEFFOLDERUUID.setNullable(false);
			EVENTDEFFOLDERUUID.setTransient(false);
			EVENTDEFFOLDERUUID.setSequence("testrunner.Seq_EventDefFolder_eventdeffolderUuid");
			EVENTDEFFOLDERUUID.getStereoTypes().add("FOLDER");
			EVENTDEFFOLDERUUID.setPrimaryKey(true);
		}
		fields.add(PARENTFOLDERUUID);
		{
			PARENTFOLDERUUID.setDataType(MTDataTypes.UUID);
			PARENTFOLDERUUID.setLength(130);
			PARENTFOLDERUUID.setNullable(true);
			PARENTFOLDERUUID.setTransient(false);
			PARENTFOLDERUUID.getStereoTypes().add("PARENTFOLDER");
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(EVENTDEFINITIONUUID);
		{
			EVENTDEFINITIONUUID.setDataType(MTDataTypes.UUID);
			EVENTDEFINITIONUUID.setLength(130);
			EVENTDEFINITIONUUID.setNullable(true);
			EVENTDEFINITIONUUID.setTransient(false);
			EVENTDEFINITIONUUID.getStereoTypes().add("ITEM");
		}
	}

	public MTTableEVENTDEFFOLDER(){
		init();
		this.tableName = "EventDefFolder";
		this.schema = "testrunner";
		this.entityType = "TABLE";
		this.primaryKeys.add(EVENTDEFFOLDERUUID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}