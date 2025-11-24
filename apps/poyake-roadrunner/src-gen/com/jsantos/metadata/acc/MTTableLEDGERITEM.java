package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableLEDGERITEM extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField LEDGERITEMID = new MTField("ledgerItemId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(LEDGERITEMID);
		{
			LEDGERITEMID.setDataType(MTDataTypes.INT);
			LEDGERITEMID.setNullable(true);
			LEDGERITEMID.setTransient(false);
			LEDGERITEMID.setSequence("acc.Seq_LedgerItem_ledgerItemId");
			LEDGERITEMID.setPrimaryKey(true);
		}
	}

	public MTTableLEDGERITEM(){
		init();
		this.tableName = "LedgerItem";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(LEDGERITEMID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}