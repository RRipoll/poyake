package com.jsantos.metadata.payment;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUPAYMENTTYPECLASS extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PAYMENTTYPECLASSID = new MTField("paymentTypeClassId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PAYMENTTYPECLASSID);
		{
			PAYMENTTYPECLASSID.setDataType(MTDataTypes.INT);
			PAYMENTTYPECLASSID.setNullable(true);
			PAYMENTTYPECLASSID.setTransient(false);
			PAYMENTTYPECLASSID.setSequence("payment.Seq_EnuPaymentTypeClass_paymentTypeClassId");
			PAYMENTTYPECLASSID.setPrimaryKey(true);
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
	}

	public MTTableENUPAYMENTTYPECLASS(){
		init();
		this.tableName = "EnuPaymentTypeClass";
		this.schema = "payment";
		this.entityType = "TABLE";
		this.primaryKeys.add(PAYMENTTYPECLASSID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuPaymentTypeClass();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}