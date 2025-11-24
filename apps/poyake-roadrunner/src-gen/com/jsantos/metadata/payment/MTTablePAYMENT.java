package com.jsantos.metadata.payment;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePAYMENT extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PAYMENTID = new MTField("paymentId");
	public static final MTField AMOUNT = new MTField("amount");
	public static final MTField PAYMENTTYPEID = new MTField("paymentTypeId");
	public static final MTField POSTINGDATE = new MTField("postingDate");
	public static final MTField LEDGERINFOID = new MTField("ledgerInfoId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PAYMENTID);
		{
			PAYMENTID.setDataType(MTDataTypes.INT);
			PAYMENTID.setNullable(true);
			PAYMENTID.setTransient(false);
			PAYMENTID.setSequence("payment.Seq_Payment_paymentId");
			PAYMENTID.setPrimaryKey(true);
		}
		fields.add(AMOUNT);
		{
			AMOUNT.setDataType(MTDataTypes.MONEY);
			AMOUNT.setScale(2);
			AMOUNT.setLength(8);
			AMOUNT.setNullable(false);
			AMOUNT.setTransient(false);
		}
		fields.add(PAYMENTTYPEID);
		{
			PAYMENTTYPEID.setDataType(MTDataTypes.INT);
			PAYMENTTYPEID.setNullable(false);
			PAYMENTTYPEID.setTransient(false);
			PAYMENTTYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Type"));
			PAYMENTTYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo"));
		}
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setDataType(MTDataTypes.DATE);
			POSTINGDATE.setNullable(true);
			POSTINGDATE.setTransient(false);
			POSTINGDATE.getStereoTypes().add("NOGUIINPUT");
			POSTINGDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(LEDGERINFOID);
		{
			LEDGERINFOID.setDataType(MTDataTypes.INT);
			LEDGERINFOID.setNullable(true);
			LEDGERINFOID.setTransient(false);
		}
	}

	public MTTablePAYMENT(){
		init();
		this.tableName = "Payment";
		this.schema = "payment";
		this.entityType = "TABLE";
		this.primaryKeys.add(PAYMENTID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}