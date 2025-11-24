package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.tolling.MTTableTRIP;
import com.jsantos.metadata.payment.MTTablePAYMENT;
import com.jsantos.metadata.acc.MTTableALLOCATION;

public class MTTableVTRIPPAYMENT extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField TRIPID;
	public static MTField PAYMENTID;
	public static MTField PAYMENTAMOUNT;
	public static MTField ALLOCATEDAMOUNT;
	public static MTField POSTINGDATE;

	public static void init(){
		fields = new ArrayList<>();
		TRIPID = new MTField(MTTableTRIP.TRIPID,"tripId");
		fields.add(TRIPID);
		{
			TRIPID.setDataType(MTDataTypes.INT);
			TRIPID.setNullable(true);
			TRIPID.setTransient(false);
			TRIPID.setSequence("acc.Seq_VTripPayment_tripId");
			TRIPID.setPrimaryKey(true);
		}
		PAYMENTID = new MTField(MTTablePAYMENT.PAYMENTID,"paymentId");
		fields.add(PAYMENTID);
		{
			PAYMENTID.setDataType(MTDataTypes.INT);
			PAYMENTID.setNullable(true);
			PAYMENTID.setTransient(false);
		}
		PAYMENTAMOUNT = new MTField(MTTablePAYMENT.AMOUNT,"paymentAmount");
		fields.add(PAYMENTAMOUNT);
		{
			PAYMENTAMOUNT.setDataType(MTDataTypes.MONEY);
			PAYMENTAMOUNT.setScale(2);
			PAYMENTAMOUNT.setLength(8);
			PAYMENTAMOUNT.setNullable(true);
			PAYMENTAMOUNT.setTransient(false);
		}
		ALLOCATEDAMOUNT = new MTField(MTTableALLOCATION.AMOUNT,"allocatedAmount");
		fields.add(ALLOCATEDAMOUNT);
		{
			ALLOCATEDAMOUNT.setDataType(MTDataTypes.MONEY);
			ALLOCATEDAMOUNT.setScale(2);
			ALLOCATEDAMOUNT.setLength(8);
			ALLOCATEDAMOUNT.setNullable(true);
			ALLOCATEDAMOUNT.setTransient(false);
		}
		POSTINGDATE = new MTField(MTTablePAYMENT.POSTINGDATE,"postingDate");
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setDataType(MTDataTypes.DATE);
			POSTINGDATE.setNullable(true);
			POSTINGDATE.setTransient(false);
		}
	}

	public MTTableVTRIPPAYMENT(){
		init();
		this.tableName = "VTripPayment";
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