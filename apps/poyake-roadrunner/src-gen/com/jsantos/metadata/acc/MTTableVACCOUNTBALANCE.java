package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.acc.MTTableANNOTATION;

public class MTTableVACCOUNTBALANCE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField CUSTOMERID;
	public static final MTField BALANCE = new MTField("balance");

	public static void init(){
		fields = new ArrayList<>();
		CUSTOMERID = new MTField(MTTableANNOTATION.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
			CUSTOMERID.setSequence("acc.Seq_VAccountBalance_customerId");
			CUSTOMERID.setPrimaryKey(true);
		}
		fields.add(BALANCE);
		{
			BALANCE.setDataType(MTDataTypes.MONEY);
			BALANCE.setScale(2);
			BALANCE.setLength(8);
			BALANCE.setNullable(true);
			BALANCE.setTransient(false);
		}
	}

	public MTTableVACCOUNTBALANCE(){
		init();
		this.tableName = "VAccountBalance";
		this.schema = "acc";
		this.entityType = "VIEW";
		this.primaryKeys.add(CUSTOMERID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}