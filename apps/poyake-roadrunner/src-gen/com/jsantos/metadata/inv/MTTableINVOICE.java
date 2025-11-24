package com.jsantos.metadata.inv;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableINVOICE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField INVOICEID = new MTField("invoiceId");
	public static final MTField CREATED = new MTField("created");
	public static final MTField CUSTOMERID = new MTField("customerId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(INVOICEID);
		{
			INVOICEID.setDataType(MTDataTypes.INT);
			INVOICEID.setNullable(true);
			INVOICEID.setTransient(false);
			INVOICEID.setSequence("inv.Seq_Invoice_invoiceId");
			INVOICEID.setPrimaryKey(true);
		}
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATE);
			CREATED.setNullable(false);
			CREATED.setTransient(false);
			CREATED.setDefaultValue("getPostingDate()");
		}
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(false);
			CUSTOMERID.setTransient(false);
		}
	}

	public MTTableINVOICE(){
		init();
		this.tableName = "Invoice";
		this.schema = "inv";
		this.entityType = "TABLE";
		this.primaryKeys.add(INVOICEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}