package com.jsantos.metadata.inv;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.crm.MTTableHPOSTALADDRESS;
import com.jsantos.metadata.crm.MTTableENUSTATEPROVINCE;
import com.jsantos.metadata.inv.MTTableINVOICE;
import com.jsantos.metadata.tolling.MTTableLICENSEPLATE;
import com.jsantos.metadata.inv.MTTableINVOICEDOCUMENT;

public class MTTableVINVOICEHEADER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField RECIPIENTNAME = new MTField("recipientName");
	public static MTField ADDRESS1;
	public static MTField ADDRESS2;
	public static MTField CITY;
	public static MTField POSTALCODE;
	public static MTField STATE;
	public static MTField NOTICEDATE;
	public static MTField DUEDATE;
	public static MTField CUSTOMERID;
	public static MTField INVOICEID;
	public static MTField LPNUMBER;
	public static MTField TOTALDUE;

	public static void init(){
		fields = new ArrayList<>();
		fields.add(RECIPIENTNAME);
		{
			RECIPIENTNAME.setDataType(MTDataTypes.VARCHAR);
			RECIPIENTNAME.setNullable(true);
			RECIPIENTNAME.setTransient(false);
		}
		ADDRESS1 = new MTField(MTTableHPOSTALADDRESS.ADDRESS1,"address1");
			ADDRESS1.getLabels().add(new Label("SHORTLABEL","es_ES","Direcci??n"));
		fields.add(ADDRESS1);
		{
			ADDRESS1.setDataType(MTDataTypes.VARCHAR);
			ADDRESS1.setLength(256);
			ADDRESS1.setNullable(true);
			ADDRESS1.setTransient(false);
		}
		ADDRESS2 = new MTField(MTTableHPOSTALADDRESS.ADDRESS2,"address2");
			ADDRESS2.getLabels().add(new Label("SHORTLABEL","es_ES","Piso y letra"));
		fields.add(ADDRESS2);
		{
			ADDRESS2.setDataType(MTDataTypes.VARCHAR);
			ADDRESS2.setLength(256);
			ADDRESS2.setNullable(true);
			ADDRESS2.setTransient(false);
		}
		CITY = new MTField(MTTableHPOSTALADDRESS.CITY,"city");
			CITY.getLabels().add(new Label("SHORTLABEL","es_ES","Ciudad"));
		fields.add(CITY);
		{
			CITY.setDataType(MTDataTypes.VARCHAR);
			CITY.setLength(64);
			CITY.setNullable(true);
			CITY.setTransient(false);
		}
		POSTALCODE = new MTField(MTTableHPOSTALADDRESS.POSTALCODE,"postalCode");
			POSTALCODE.getLabels().add(new Label("SHORTLABEL","en_EN","Postal Code"));
			POSTALCODE.getLabels().add(new Label("SHORTLABEL","es_ES","C??digo Postal"));
		fields.add(POSTALCODE);
		{
			POSTALCODE.setDataType(MTDataTypes.VARCHAR);
			POSTALCODE.setLength(10);
			POSTALCODE.setNullable(true);
			POSTALCODE.setTransient(false);
		}
		STATE = new MTField(MTTableENUSTATEPROVINCE.SHORTCODE,"state");
		fields.add(STATE);
		{
			STATE.setDataType(MTDataTypes.VARCHAR);
			STATE.setLength(3);
			STATE.setNullable(true);
			STATE.setTransient(false);
		}
		NOTICEDATE = new MTField(MTTableINVOICE.CREATED,"noticeDate");
		fields.add(NOTICEDATE);
		{
			NOTICEDATE.setDataType(MTDataTypes.DATE);
			NOTICEDATE.setNullable(true);
			NOTICEDATE.setTransient(false);
		}
		DUEDATE = new MTField(MTTableINVOICE.CREATED,"dueDate");
		fields.add(DUEDATE);
		{
			DUEDATE.setDataType(MTDataTypes.DATE);
			DUEDATE.setNullable(true);
			DUEDATE.setTransient(false);
		}
		CUSTOMERID = new MTField(MTTableINVOICE.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
		INVOICEID = new MTField(MTTableINVOICE.INVOICEID,"invoiceId");
		fields.add(INVOICEID);
		{
			INVOICEID.setDataType(MTDataTypes.INT);
			INVOICEID.setNullable(true);
			INVOICEID.setTransient(false);
			INVOICEID.setSequence("inv.Seq_VinvoiceHeader_invoiceId");
			INVOICEID.setPrimaryKey(true);
		}
		LPNUMBER = new MTField(MTTableLICENSEPLATE.LPNUMBER,"lpnumber");
			LPNUMBER.getLabels().add(new Label("SHORTLABEL","en_EN","License Plate #"));
			LPNUMBER.getLabels().add(new Label("SHORTLABEL","es_ES","Matr??cula"));
		fields.add(LPNUMBER);
		{
			LPNUMBER.setDataType(MTDataTypes.VARCHAR);
			LPNUMBER.setLength(16);
			LPNUMBER.setNullable(true);
			LPNUMBER.setTransient(false);
		}
		TOTALDUE = new MTField(MTTableINVOICEDOCUMENT.AMOUNTDUE,"totalDue");
		fields.add(TOTALDUE);
		{
			TOTALDUE.setDataType(MTDataTypes.MONEY);
			TOTALDUE.setScale(2);
			TOTALDUE.setLength(8);
			TOTALDUE.setNullable(true);
			TOTALDUE.setTransient(false);
		}
	}

	public MTTableVINVOICEHEADER(){
		init();
		this.tableName = "VinvoiceHeader";
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