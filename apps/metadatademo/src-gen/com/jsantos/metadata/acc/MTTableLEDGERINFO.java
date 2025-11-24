package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableLEDGERINFO extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField LEDGERINFOID = new MTField("ledgerInfoId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(LEDGERINFOID);
		{
			LEDGERINFOID.setDataType(MTDataTypes.INT);
			LEDGERINFOID.setNullable(true);
			LEDGERINFOID.setTransient(false);
			LEDGERINFOID.setSequence("acc.Seq_LedgerInfo_ledgerInfoId");
			LEDGERINFOID.setPrimaryKey(true);
		}
	}

	public MTTableLEDGERINFO(){
		init();
		this.tableName = "LedgerInfo";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(LEDGERINFOID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}