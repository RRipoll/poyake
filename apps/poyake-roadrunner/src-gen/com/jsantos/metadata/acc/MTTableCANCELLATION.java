package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableCANCELLATION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CANCELLEDREVISIONID = new MTField("cancelledRevisionId");
	public static final MTField CANCELLINGREVISIONID = new MTField("cancellingRevisionId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CANCELLEDREVISIONID);
		{
			CANCELLEDREVISIONID.setDataType(MTDataTypes.INT);
			CANCELLEDREVISIONID.setNullable(false);
			CANCELLEDREVISIONID.setTransient(false);
			CANCELLEDREVISIONID.setPrimaryKey(true);
		}
		fields.add(CANCELLINGREVISIONID);
		{
			CANCELLINGREVISIONID.setDataType(MTDataTypes.INT);
			CANCELLINGREVISIONID.setNullable(false);
			CANCELLINGREVISIONID.setTransient(false);
			CANCELLINGREVISIONID.setPrimaryKey(true);
		}
	}

	public MTTableCANCELLATION(){
		init();
		this.tableName = "Cancellation";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(CANCELLEDREVISIONID);
		this.primaryKeys.add(CANCELLINGREVISIONID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}