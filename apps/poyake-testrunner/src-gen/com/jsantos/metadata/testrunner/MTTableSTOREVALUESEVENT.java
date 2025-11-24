package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableSTOREVALUESEVENT extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField STOREVALUESEVENTID = new MTField("storeValuesEventid");
	public static final MTField EVENTNAME = new MTField("eventName");
	public static final MTField DATA = new MTField("data");
	public static final MTField LOG = new MTField("log");
	public static final MTField STATUS = new MTField("status");
	public static final MTField EVENT = new MTField("event");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(STOREVALUESEVENTID);
		{
			STOREVALUESEVENTID.setDataType(MTDataTypes.UUID);
			STOREVALUESEVENTID.setLength(130);
			STOREVALUESEVENTID.setNullable(true);
			STOREVALUESEVENTID.setTransient(false);
			STOREVALUESEVENTID.setSequence("testrunner.Seq_StoreValuesEvent_storeValuesEventid");
			STOREVALUESEVENTID.setPrimaryKey(true);
		}
		fields.add(EVENTNAME);
		{
			EVENTNAME.setDataType(MTDataTypes.VARCHAR);
			EVENTNAME.setNullable(true);
			EVENTNAME.setTransient(false);
			EVENTNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(DATA);
		{
			DATA.setDataType(MTDataTypes.JSON);
			DATA.setLength(-1);
			DATA.setNullable(true);
			DATA.setTransient(false);
		}
		fields.add(LOG);
		{
			LOG.setDataType(MTDataTypes.VARCHAR);
			LOG.setNullable(true);
			LOG.setTransient(false);
		}
		fields.add(STATUS);
		{
			STATUS.setDataType(MTDataTypes.INT);
			STATUS.setNullable(true);
			STATUS.setTransient(false);
			STATUS.setDefaultValue("1");
		}
		fields.add(EVENT);
		{
			EVENT.setDataType(MTDataTypes.EVENT);
			EVENT.setNullable(true);
			EVENT.setTransient(false);
			EVENT.getStereoTypes().add("NOGUIINPUT");
		}
	}

	public MTTableSTOREVALUESEVENT(){
		init();
		this.tableName = "StoreValuesEvent";
		this.schema = "testrunner";
		this.entityType = "VIEW";
		this.primaryKeys.add(STOREVALUESEVENTID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}