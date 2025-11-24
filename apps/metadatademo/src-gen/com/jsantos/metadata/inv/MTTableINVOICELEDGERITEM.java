package com.jsantos.metadata.inv;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableINVOICELEDGERITEM extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField INVOICEID = new MTField("invoiceId");
	public static final MTField LEDGERITEMID = new MTField("ledgerItemId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(INVOICEID);
		{
			INVOICEID.setDataType(MTDataTypes.INT);
			INVOICEID.setNullable(false);
			INVOICEID.setTransient(false);
			INVOICEID.setPrimaryKey(true);
		}
		fields.add(LEDGERITEMID);
		{
			LEDGERITEMID.setDataType(MTDataTypes.INT);
			LEDGERITEMID.setNullable(false);
			LEDGERITEMID.setTransient(false);
			LEDGERITEMID.setPrimaryKey(true);
		}
	}

	public MTTableINVOICELEDGERITEM(){
		init();
		this.tableName = "InvoiceLedgerItem";
		this.schema = "inv";
		this.entityType = "TABLE";
		this.primaryKeys.add(INVOICEID);
		this.primaryKeys.add(LEDGERITEMID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}