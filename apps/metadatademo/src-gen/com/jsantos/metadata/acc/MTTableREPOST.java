package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableREPOST extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField FROMREVISIONID = new MTField("fromRevisionId");
	public static final MTField TOREVISIONID = new MTField("toRevisionId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(FROMREVISIONID);
		{
			FROMREVISIONID.setDataType(MTDataTypes.INT);
			FROMREVISIONID.setNullable(false);
			FROMREVISIONID.setTransient(false);
			FROMREVISIONID.setPrimaryKey(true);
		}
		fields.add(TOREVISIONID);
		{
			TOREVISIONID.setDataType(MTDataTypes.INT);
			TOREVISIONID.setNullable(false);
			TOREVISIONID.setTransient(false);
			TOREVISIONID.setPrimaryKey(true);
		}
	}

	public MTTableREPOST(){
		init();
		this.tableName = "Repost";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(FROMREVISIONID);
		this.primaryKeys.add(TOREVISIONID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}