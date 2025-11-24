package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePASS extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PASSID = new MTField("passId");
	public static final MTField FULLPASSNUMBER = new MTField("fullPassNumber");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PASSID);
		{
			PASSID.setDataType(MTDataTypes.INT);
			PASSID.setNullable(true);
			PASSID.setTransient(false);
			PASSID.setSequence("tolling.Seq_Pass_passId");
			PASSID.setPrimaryKey(true);
		}
		fields.add(FULLPASSNUMBER);
		{
			FULLPASSNUMBER.setDataType(MTDataTypes.VARCHAR);
			FULLPASSNUMBER.setLength(128);
			FULLPASSNUMBER.setNullable(true);
			FULLPASSNUMBER.setTransient(false);
		}
	}

	public MTTablePASS(){
		init();
		this.tableName = "Pass";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(PASSID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}