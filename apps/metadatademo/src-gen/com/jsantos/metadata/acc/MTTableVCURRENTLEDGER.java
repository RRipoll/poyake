package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.acc.MTTableLEDGER;

public class MTTableVCURRENTLEDGER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField REVISIONID;
	public static MTField LEDGERITEMID;
	public static MTField LEDGERINFOID;
	public static MTField TRANSACTIONTYPEID;
	public static MTField LEDGERTYPEID;
	public static MTField ANNOTATIONID;
	public static MTField AMOUNT;
	public static MTField BALANCE;

	public static void init(){
		fields = new ArrayList<>();
		REVISIONID = new MTField(MTTableLEDGER.REVISIONID,"revisionId");
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("acc.Seq_VCurrentLedger_revisionId");
			REVISIONID.setPrimaryKey(true);
		}
		LEDGERITEMID = new MTField(MTTableLEDGER.LEDGERITEMID,"ledgerItemId");
		fields.add(LEDGERITEMID);
		{
			LEDGERITEMID.setDataType(MTDataTypes.INT);
			LEDGERITEMID.setNullable(true);
			LEDGERITEMID.setTransient(false);
		}
		LEDGERINFOID = new MTField(MTTableLEDGER.LEDGERINFOID,"ledgerInfoId");
		fields.add(LEDGERINFOID);
		{
			LEDGERINFOID.setDataType(MTDataTypes.INT);
			LEDGERINFOID.setNullable(true);
			LEDGERINFOID.setTransient(false);
		}
		TRANSACTIONTYPEID = new MTField(MTTableLEDGER.TRANSACTIONTYPEID,"transactionTypeId");
		fields.add(TRANSACTIONTYPEID);
		{
			TRANSACTIONTYPEID.setDataType(MTDataTypes.INT);
			TRANSACTIONTYPEID.setNullable(true);
			TRANSACTIONTYPEID.setTransient(false);
		}
		LEDGERTYPEID = new MTField(MTTableLEDGER.LEDGERTYPEID,"ledgerTypeId");
		fields.add(LEDGERTYPEID);
		{
			LEDGERTYPEID.setDataType(MTDataTypes.INT);
			LEDGERTYPEID.setNullable(true);
			LEDGERTYPEID.setTransient(false);
		}
		ANNOTATIONID = new MTField(MTTableLEDGER.ANNOTATIONID,"annotationId");
		fields.add(ANNOTATIONID);
		{
			ANNOTATIONID.setDataType(MTDataTypes.INT);
			ANNOTATIONID.setNullable(true);
			ANNOTATIONID.setTransient(false);
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
	}

	public MTTableVCURRENTLEDGER(){
		init();
		this.tableName = "VCurrentLedger";
		this.schema = "acc";
		this.entityType = "VIEW";
		this.primaryKeys.add(REVISIONID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}