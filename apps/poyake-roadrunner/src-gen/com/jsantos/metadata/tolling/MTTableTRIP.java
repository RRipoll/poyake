package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableTRIP extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField TRIPID = new MTField("tripId");
	public static final MTField LEDGERINFOID = new MTField("ledgerInfoId");
	public static final MTField LEDGERITEMID = new MTField("ledgerItemId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(TRIPID);
		{
			TRIPID.setDataType(MTDataTypes.INT);
			TRIPID.setNullable(true);
			TRIPID.setTransient(false);
			TRIPID.setSequence("tolling.Seq_Trip_tripId");
			TRIPID.setPrimaryKey(true);
		}
		fields.add(LEDGERINFOID);
		{
			LEDGERINFOID.setDataType(MTDataTypes.INT);
			LEDGERINFOID.setNullable(false);
			LEDGERINFOID.setTransient(false);
		}
		fields.add(LEDGERITEMID);
		{
			LEDGERITEMID.setDataType(MTDataTypes.INT);
			LEDGERITEMID.setNullable(false);
			LEDGERITEMID.setTransient(false);
		}
	}

	public MTTableTRIP(){
		init();
		this.tableName = "Trip";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(TRIPID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}