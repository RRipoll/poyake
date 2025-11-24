package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableEVENTSTATUS extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField EVENTSTATUSID = new MTField("eventStatusId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(EVENTSTATUSID);
		{
			EVENTSTATUSID.setDataType(MTDataTypes.INT);
			EVENTSTATUSID.setNullable(true);
			EVENTSTATUSID.setTransient(false);
			EVENTSTATUSID.setSequence("testrunner.Seq_EventStatus_eventStatusId");
			EVENTSTATUSID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(false);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(false);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableEVENTSTATUS(){
		init();
		this.tableName = "EventStatus";
		this.schema = "testrunner";
		this.entityType = "TABLE";
		this.primaryKeys.add(EVENTSTATUSID);
		this.patterns.add("Enumeration");
		this.enumeration= new EventStatus();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}