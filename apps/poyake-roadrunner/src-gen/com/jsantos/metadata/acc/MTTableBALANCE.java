package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableBALANCE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERID = new MTField("customerId");
	public static final MTField BALANCEAMOUNT = new MTField("balanceAmount");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(false);
			CUSTOMERID.setTransient(false);
			CUSTOMERID.setSequence("acc.Seq_Balance_customerId");
			CUSTOMERID.setPrimaryKey(true);
		}
		fields.add(BALANCEAMOUNT);
		{
			BALANCEAMOUNT.setDataType(MTDataTypes.MONEY);
			BALANCEAMOUNT.setScale(2);
			BALANCEAMOUNT.setLength(8);
			BALANCEAMOUNT.setNullable(false);
			BALANCEAMOUNT.setTransient(false);
		}
	}

	public MTTableBALANCE(){
		init();
		this.tableName = "Balance";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(CUSTOMERID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}