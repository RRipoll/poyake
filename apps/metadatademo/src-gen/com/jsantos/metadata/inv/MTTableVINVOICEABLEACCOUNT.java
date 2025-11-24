package com.jsantos.metadata.inv;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.acc.MTTableVACCOUNTBALANCE;

public class MTTableVINVOICEABLEACCOUNT extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERID = new MTField("customerId");
	public static MTField BALANCE;

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
			CUSTOMERID.setSequence("inv.Seq_VInvoiceableAccount_customerId");
			CUSTOMERID.setPrimaryKey(true);
		}
		BALANCE = new MTField(MTTableVACCOUNTBALANCE.BALANCE,"balance");
		fields.add(BALANCE);
		{
			BALANCE.setDataType(MTDataTypes.MONEY);
			BALANCE.setScale(2);
			BALANCE.setLength(8);
			BALANCE.setNullable(true);
			BALANCE.setTransient(false);
		}
	}

	public MTTableVINVOICEABLEACCOUNT(){
		init();
		this.tableName = "VInvoiceableAccount";
		this.schema = "inv";
		this.entityType = "VIEW";
		this.primaryKeys.add(CUSTOMERID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}