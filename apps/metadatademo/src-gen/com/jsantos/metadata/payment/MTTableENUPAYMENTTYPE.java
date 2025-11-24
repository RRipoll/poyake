package com.jsantos.metadata.payment;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUPAYMENTTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PAYMENTTYPEID = new MTField("paymentTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField PAYMENTTYPECLASSID = new MTField("paymentTypeClassId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PAYMENTTYPEID);
		{
			PAYMENTTYPEID.setDataType(MTDataTypes.INT);
			PAYMENTTYPEID.setNullable(true);
			PAYMENTTYPEID.setTransient(false);
			PAYMENTTYPEID.setSequence("payment.Seq_EnuPaymentType_paymentTypeId");
			PAYMENTTYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Type"));
			PAYMENTTYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo"));
			PAYMENTTYPEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(PAYMENTTYPECLASSID);
		{
			PAYMENTTYPECLASSID.setDataType(MTDataTypes.INT);
			PAYMENTTYPECLASSID.setNullable(false);
			PAYMENTTYPECLASSID.setTransient(false);
		}
	}

	public MTTableENUPAYMENTTYPE(){
		init();
		this.tableName = "EnuPaymentType";
		this.schema = "payment";
		this.entityType = "TABLE";
		this.primaryKeys.add(PAYMENTTYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuPaymentType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}