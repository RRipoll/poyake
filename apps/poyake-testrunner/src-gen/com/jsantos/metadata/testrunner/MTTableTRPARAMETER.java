package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableTRPARAMETER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField LABEL = new MTField("label");
	public static final MTField TRPARAMETERTYPEID = new MTField("trParameterTypeId");
	public static final MTField VALUE = new MTField("value");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(LABEL);
		{
			LABEL.setDataType(MTDataTypes.UUID);
			LABEL.setLength(130);
			LABEL.setNullable(false);
			LABEL.setTransient(false);
			LABEL.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(TRPARAMETERTYPEID);
		{
			TRPARAMETERTYPEID.setDataType(MTDataTypes.INT);
			TRPARAMETERTYPEID.setNullable(false);
			TRPARAMETERTYPEID.setTransient(false);
		}
		fields.add(VALUE);
		{
			VALUE.setDataType(MTDataTypes.VARCHAR);
			VALUE.setLength(-1);
			VALUE.setNullable(true);
			VALUE.setTransient(false);
		}
	}

	public MTTableTRPARAMETER(){
		init();
		this.tableName = "TrParameter";
		this.schema = "testrunner";
		this.entityType = "VIEW";
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}