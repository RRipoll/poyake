package com.jsantos.metadata.payment;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.payment.MTTablePAYMENTMETHOD;
import com.jsantos.metadata.payment.MTTableENUPAYMENTTYPE;
import com.jsantos.metadata.crm.MTTableCUSTOMERPAYMENTMETHOD;

public class MTTableVPAYMENTMETHODS extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField PAYMENTMETHODID;
	public static MTField PAYMENTTYPECLASSID;
	public static MTField PAYMENTTYPEID;
	public static final MTField NUMBER = new MTField("number");
	public static MTField CUSTOMERID;

	public static void init(){
		fields = new ArrayList<>();
		PAYMENTMETHODID = new MTField(MTTablePAYMENTMETHOD.PAYMENTMETHODID,"paymentMethodId");
		fields.add(PAYMENTMETHODID);
		{
			PAYMENTMETHODID.setDataType(MTDataTypes.INT);
			PAYMENTMETHODID.setNullable(true);
			PAYMENTMETHODID.setTransient(false);
		}
		PAYMENTTYPECLASSID = new MTField(MTTableENUPAYMENTTYPE.PAYMENTTYPECLASSID,"paymentTypeClassId");
		fields.add(PAYMENTTYPECLASSID);
		{
			PAYMENTTYPECLASSID.setDataType(MTDataTypes.INT);
			PAYMENTTYPECLASSID.setNullable(true);
			PAYMENTTYPECLASSID.setTransient(false);
		}
		PAYMENTTYPEID = new MTField(MTTablePAYMENTMETHOD.PAYMENTTYPEID,"paymentTypeId");
			PAYMENTTYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Type"));
			PAYMENTTYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo"));
		fields.add(PAYMENTTYPEID);
		{
			PAYMENTTYPEID.setDataType(MTDataTypes.INT);
			PAYMENTTYPEID.setNullable(true);
			PAYMENTTYPEID.setTransient(false);
		}
		fields.add(NUMBER);
		{
			NUMBER.setDataType(MTDataTypes.VARCHAR);
			NUMBER.setNullable(true);
			NUMBER.setTransient(false);
		}
		CUSTOMERID = new MTField(MTTableCUSTOMERPAYMENTMETHOD.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
	}

	public MTTableVPAYMENTMETHODS(){
		init();
		this.tableName = "VPaymentMethods";
		this.schema = "payment";
		this.entityType = "VIEW";
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}