package com.jsantos.metadata.payment;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePAYMENTMETHOD extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PAYMENTMETHODID = new MTField("paymentMethodId");
	public static final MTField PAYMENTTYPEID = new MTField("paymentTypeId");
	public static final MTField CCNUMBER = new MTField("ccNumber");
	public static final MTField ACCOUNTNUMBER = new MTField("accountNumber");
	public static final MTField CHECKNUMBER = new MTField("checkNumber");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PAYMENTMETHODID);
		{
			PAYMENTMETHODID.setDataType(MTDataTypes.INT);
			PAYMENTMETHODID.setNullable(true);
			PAYMENTMETHODID.setTransient(false);
			PAYMENTMETHODID.setSequence("payment.Seq_PaymentMethod_paymentMethodId");
			PAYMENTMETHODID.setPrimaryKey(true);
		}
		fields.add(PAYMENTTYPEID);
		{
			PAYMENTTYPEID.setDataType(MTDataTypes.INT);
			PAYMENTTYPEID.setNullable(false);
			PAYMENTTYPEID.setTransient(false);
			PAYMENTTYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Type"));
			PAYMENTTYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo"));
		}
		fields.add(CCNUMBER);
		{
			CCNUMBER.setDataType(MTDataTypes.VARCHAR);
			CCNUMBER.setLength(16);
			CCNUMBER.setNullable(true);
			CCNUMBER.setTransient(false);
		}
		fields.add(ACCOUNTNUMBER);
		{
			ACCOUNTNUMBER.setDataType(MTDataTypes.VARCHAR);
			ACCOUNTNUMBER.setLength(32);
			ACCOUNTNUMBER.setNullable(true);
			ACCOUNTNUMBER.setTransient(false);
		}
		fields.add(CHECKNUMBER);
		{
			CHECKNUMBER.setDataType(MTDataTypes.VARCHAR);
			CHECKNUMBER.setLength(32);
			CHECKNUMBER.setNullable(true);
			CHECKNUMBER.setTransient(false);
		}
	}

	public MTTablePAYMENTMETHOD(){
		init();
		this.tableName = "PaymentMethod";
		this.schema = "payment";
		this.entityType = "TABLE";
		this.primaryKeys.add(PAYMENTMETHODID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}