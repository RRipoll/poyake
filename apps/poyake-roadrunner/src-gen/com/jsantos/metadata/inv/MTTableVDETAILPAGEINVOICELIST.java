package com.jsantos.metadata.inv;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.inv.MTTableINVOICE;
import com.jsantos.metadata.inv.MTTableINVOICEDOCUMENT;
import com.jsantos.metadata.common.MTTableSTORAGEFILE;

public class MTTableVDETAILPAGEINVOICELIST extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField INVOICEID;
	public static MTField CREATED;
	public static MTField AMOUNTDUE;
	public static MTField CUSTOMERID;
	public static MTField URL;

	public static void init(){
		fields = new ArrayList<>();
		INVOICEID = new MTField(MTTableINVOICE.INVOICEID,"invoiceid");
		fields.add(INVOICEID);
		{
			INVOICEID.setDataType(MTDataTypes.INT);
			INVOICEID.setNullable(true);
			INVOICEID.setTransient(false);
			INVOICEID.setSequence("inv.Seq_VdetailPageInvoiceList_invoiceid");
			INVOICEID.setPrimaryKey(true);
		}
		CREATED = new MTField(MTTableINVOICE.CREATED,"created");
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATE);
			CREATED.setNullable(true);
			CREATED.setTransient(false);
		}
		AMOUNTDUE = new MTField(MTTableINVOICEDOCUMENT.AMOUNTDUE,"amountDue");
		fields.add(AMOUNTDUE);
		{
			AMOUNTDUE.setDataType(MTDataTypes.MONEY);
			AMOUNTDUE.setScale(2);
			AMOUNTDUE.setLength(8);
			AMOUNTDUE.setNullable(true);
			AMOUNTDUE.setTransient(false);
		}
		CUSTOMERID = new MTField(MTTableINVOICE.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
		URL = new MTField(MTTableSTORAGEFILE.FILENAME,"url");
			URL.getLabels().add(new Label("SHORTLABEL","en_EN","File Name"));
			URL.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre Archivo"));
		fields.add(URL);
		{
			URL.setDataType(MTDataTypes.URL);
			URL.setLength(255);
			URL.setLength(256);
			URL.setNullable(true);
			URL.setTransient(false);
		}
	}

	public MTTableVDETAILPAGEINVOICELIST(){
		init();
		this.tableName = "VdetailPageInvoiceList";
		this.schema = "inv";
		this.entityType = "VIEW";
		this.primaryKeys.add(INVOICEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}