package com.jsantos.metadata.multi;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.multi.MTTableSTREET;

public class MTTableVSTREET extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField STREETID;
	public static MTField ADDRESS;
	public static final MTField HOMES = new MTField("homes");

	public static void init(){
		fields = new ArrayList<>();
		STREETID = new MTField(MTTableSTREET.STREETID,"streetId");
		fields.add(STREETID);
		{
			STREETID.setDataType(MTDataTypes.INT);
			STREETID.setNullable(true);
			STREETID.setTransient(false);
			STREETID.setSequence("multi.Seq_VStreet_streetId");
			STREETID.setPrimaryKey(true);
		}
		ADDRESS = new MTField(MTTableSTREET.ADDRESS,"address");
		fields.add(ADDRESS);
		{
			ADDRESS.setDataType(MTDataTypes.VARCHAR);
			ADDRESS.setLength(255);
			ADDRESS.setNullable(true);
			ADDRESS.setTransient(false);
		}
		fields.add(HOMES);
		{
			HOMES.setDataType(MTDataTypes.MULTIPLEOBJECT);
			HOMES.setLength(8000);
			HOMES.setNullable(false);
			HOMES.setTransient(false);
		}
	}

	public MTTableVSTREET(){
		init();
		this.tableName = "VStreet";
		this.schema = "multi";
		this.entityType = "VIEW";
		this.primaryKeys.add(STREETID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}