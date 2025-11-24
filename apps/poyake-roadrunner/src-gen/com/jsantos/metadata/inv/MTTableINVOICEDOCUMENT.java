package com.jsantos.metadata.inv;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableINVOICEDOCUMENT extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField INVOICEDOCUMENTID = new MTField("invoiceDocumentId");
	public static final MTField INVOICEID = new MTField("invoiceId");
	public static final MTField AMOUNTDUE = new MTField("amountDue");
	public static final MTField SENTTOPOSTALADDRESSREVISIONID = new MTField("sentToPostalAddressRevisionId");
	public static final MTField FILEGROUPID = new MTField("fileGroupId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(INVOICEDOCUMENTID);
		{
			INVOICEDOCUMENTID.setDataType(MTDataTypes.INT);
			INVOICEDOCUMENTID.setNullable(true);
			INVOICEDOCUMENTID.setTransient(false);
			INVOICEDOCUMENTID.setSequence("inv.Seq_InvoiceDocument_invoiceDocumentId");
			INVOICEDOCUMENTID.setPrimaryKey(true);
		}
		fields.add(INVOICEID);
		{
			INVOICEID.setDataType(MTDataTypes.INT);
			INVOICEID.setNullable(false);
			INVOICEID.setTransient(false);
		}
		fields.add(AMOUNTDUE);
		{
			AMOUNTDUE.setDataType(MTDataTypes.MONEY);
			AMOUNTDUE.setScale(2);
			AMOUNTDUE.setLength(8);
			AMOUNTDUE.setNullable(false);
			AMOUNTDUE.setTransient(false);
			AMOUNTDUE.setDefaultValue("0");
		}
		fields.add(SENTTOPOSTALADDRESSREVISIONID);
		{
			SENTTOPOSTALADDRESSREVISIONID.setDataType(MTDataTypes.INT);
			SENTTOPOSTALADDRESSREVISIONID.setNullable(true);
			SENTTOPOSTALADDRESSREVISIONID.setTransient(false);
		}
		fields.add(FILEGROUPID);
		{
			FILEGROUPID.setDataType(MTDataTypes.FILE_GROUP);
			FILEGROUPID.setNullable(true);
			FILEGROUPID.setTransient(false);
		}
	}

	public MTTableINVOICEDOCUMENT(){
		init();
		this.tableName = "InvoiceDocument";
		this.schema = "inv";
		this.entityType = "TABLE";
		this.primaryKeys.add(INVOICEDOCUMENTID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}