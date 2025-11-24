package com.jsantos.metadata.inv;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.tolling.MTTableTRIP;
import com.jsantos.metadata.tolling.MTTableTRIPINFO;
import com.jsantos.metadata.tolling.MTTableLICENSEPLATE;
import com.jsantos.metadata.tolling.MTTableCUSTOMERVEHICLE;
import com.jsantos.metadata.inv.MTTableINVOICELEDGERITEM;

public class MTTableVITEMINVOICEDETAIL extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField LANEEXITDATE = new MTField("laneExitDate");
	public static MTField TRIPID;
	public static MTField PASSID;
	public static MTField LPNUMBER;
	public static MTField FAREAMOUNT;
	public static MTField CUSTOMERID;
	public static MTField INVOICEID;

	public static void init(){
		fields = new ArrayList<>();
		fields.add(LANEEXITDATE);
		{
			LANEEXITDATE.setDataType(MTDataTypes.DATETIME);
			LANEEXITDATE.setNullable(true);
			LANEEXITDATE.setTransient(false);
		}
		TRIPID = new MTField(MTTableTRIP.TRIPID,"tripId");
		fields.add(TRIPID);
		{
			TRIPID.setDataType(MTDataTypes.INT);
			TRIPID.setNullable(true);
			TRIPID.setTransient(false);
		}
		PASSID = new MTField(MTTableTRIPINFO.PASSID,"passId");
		fields.add(PASSID);
		{
			PASSID.setDataType(MTDataTypes.INT);
			PASSID.setNullable(true);
			PASSID.setTransient(false);
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
		FAREAMOUNT = new MTField(MTTableTRIPINFO.FAREAMOUNT,"fareAmount");
			FAREAMOUNT.getLabels().add(new Label("SHORTLABEL","en_EN","Amount"));
			FAREAMOUNT.getLabels().add(new Label("SHORTLABEL","es_ES","Cantidad"));
		fields.add(FAREAMOUNT);
		{
			FAREAMOUNT.setDataType(MTDataTypes.MONEY);
			FAREAMOUNT.setScale(2);
			FAREAMOUNT.setLength(8);
			FAREAMOUNT.setNullable(true);
			FAREAMOUNT.setTransient(false);
		}
		CUSTOMERID = new MTField(MTTableCUSTOMERVEHICLE.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
		INVOICEID = new MTField(MTTableINVOICELEDGERITEM.INVOICEID,"invoiceId");
		fields.add(INVOICEID);
		{
			INVOICEID.setDataType(MTDataTypes.INT);
			INVOICEID.setNullable(true);
			INVOICEID.setTransient(false);
			INVOICEID.setSequence("inv.Seq_VitemInvoiceDetail_invoiceId");
			INVOICEID.setPrimaryKey(true);
		}
	}

	public MTTableVITEMINVOICEDETAIL(){
		init();
		this.tableName = "VitemInvoiceDetail";
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