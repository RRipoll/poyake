package com.jsantos.metadata.multi;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableSTREET extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField STREETID = new MTField("streetId");
	public static final MTField ADDRESS = new MTField("address");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(STREETID);
		{
			STREETID.setDataType(MTDataTypes.INT);
			STREETID.setNullable(true);
			STREETID.setTransient(false);
			STREETID.setSequence("multi.Seq_Street_streetId");
			STREETID.setPrimaryKey(true);
		}
		fields.add(ADDRESS);
		{
			ADDRESS.setDataType(MTDataTypes.VARCHAR);
			ADDRESS.setLength(255);
			ADDRESS.setNullable(false);
			ADDRESS.setTransient(false);
			ADDRESS.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableSTREET(){
		init();
		this.tableName = "Street";
		this.schema = "multi";
		this.entityType = "TABLE";
		this.primaryKeys.add(STREETID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}