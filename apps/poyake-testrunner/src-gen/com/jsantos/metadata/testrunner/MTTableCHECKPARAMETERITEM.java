package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableCHECKPARAMETERITEM extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField VALUENAME = new MTField("valueName");
	public static final MTField OPERATOR = new MTField("operator");
	public static final MTField CHECKVALUETYPEID = new MTField("checkValueTypeId");
	public static final MTField CHECKVALUE = new MTField("checkValue");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(VALUENAME);
		{
			VALUENAME.setDataType(MTDataTypes.VARCHAR);
			VALUENAME.setLength(256);
			VALUENAME.setNullable(false);
			VALUENAME.setTransient(false);
		}
		fields.add(OPERATOR);
		{
			OPERATOR.setDataType(MTDataTypes.INT);
			OPERATOR.setNullable(false);
			OPERATOR.setTransient(false);
		}
		fields.add(CHECKVALUETYPEID);
		{
			CHECKVALUETYPEID.setDataType(MTDataTypes.INT);
			CHECKVALUETYPEID.setNullable(true);
			CHECKVALUETYPEID.setTransient(false);
		}
		fields.add(CHECKVALUE);
		{
			CHECKVALUE.setDataType(MTDataTypes.VARCHAR);
			CHECKVALUE.setLength(256);
			CHECKVALUE.setNullable(true);
			CHECKVALUE.setTransient(false);
		}
	}

	public MTTableCHECKPARAMETERITEM(){
		init();
		this.tableName = "CheckParameterItem";
		this.schema = "testrunner";
		this.entityType = "VIEW";
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}