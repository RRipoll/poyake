package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.acc.MTTableANNOTATION;
import com.jsantos.metadata.acc.MTTableLEDGER;
import com.jsantos.metadata.tolling.MTTableTRIP;
import com.jsantos.metadata.payment.MTTablePAYMENT;

public class MTTableVTRANSACTIONHISTORY extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField POSTINGDATE;
	public static MTField LEDGERITEMID;
	public static MTField TRANSACTIONTYPEID;
	public static MTField AMOUNT;
	public static MTField BALANCE;
	public static MTField TRIPID;
	public static MTField PAYMENTID;
	public static MTField CUSTOMERID;

	public static void init(){
		fields = new ArrayList<>();
		POSTINGDATE = new MTField(MTTableANNOTATION.POSTINGDATE,"postingDate");
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setDataType(MTDataTypes.DATE);
			POSTINGDATE.setNullable(true);
			POSTINGDATE.setTransient(false);
		}
		LEDGERITEMID = new MTField(MTTableLEDGER.LEDGERITEMID,"ledgerItemId");
		fields.add(LEDGERITEMID);
		{
			LEDGERITEMID.setDataType(MTDataTypes.INT);
			LEDGERITEMID.setNullable(true);
			LEDGERITEMID.setTransient(false);
		}
		TRANSACTIONTYPEID = new MTField(MTTableLEDGER.TRANSACTIONTYPEID,"transactionTypeId");
		fields.add(TRANSACTIONTYPEID);
		{
			TRANSACTIONTYPEID.setDataType(MTDataTypes.INT);
			TRANSACTIONTYPEID.setNullable(true);
			TRANSACTIONTYPEID.setTransient(false);
		}
		AMOUNT = new MTField(MTTableLEDGER.AMOUNT,"amount");
		fields.add(AMOUNT);
		{
			AMOUNT.setDataType(MTDataTypes.MONEY);
			AMOUNT.setScale(2);
			AMOUNT.setLength(8);
			AMOUNT.setNullable(true);
			AMOUNT.setTransient(false);
		}
		BALANCE = new MTField(MTTableLEDGER.BALANCE,"balance");
		fields.add(BALANCE);
		{
			BALANCE.setDataType(MTDataTypes.MONEY);
			BALANCE.setScale(2);
			BALANCE.setLength(8);
			BALANCE.setNullable(true);
			BALANCE.setTransient(false);
		}
		TRIPID = new MTField(MTTableTRIP.TRIPID,"tripId");
		fields.add(TRIPID);
		{
			TRIPID.setDataType(MTDataTypes.INT);
			TRIPID.setNullable(true);
			TRIPID.setTransient(false);
			TRIPID.setSequence("acc.Seq_VTransactionHistory_tripId");
			TRIPID.setPrimaryKey(true);
		}
		PAYMENTID = new MTField(MTTablePAYMENT.PAYMENTID,"paymentId");
		fields.add(PAYMENTID);
		{
			PAYMENTID.setDataType(MTDataTypes.INT);
			PAYMENTID.setNullable(true);
			PAYMENTID.setTransient(false);
		}
		CUSTOMERID = new MTField(MTTableANNOTATION.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
	}

	public MTTableVTRANSACTIONHISTORY(){
		init();
		this.tableName = "VTransactionHistory";
		this.schema = "acc";
		this.entityType = "VIEW";
		this.primaryKeys.add(TRIPID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}