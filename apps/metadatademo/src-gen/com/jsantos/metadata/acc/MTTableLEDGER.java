package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableLEDGER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField LEDGERITEMID = new MTField("ledgerItemId");
	public static final MTField LEDGERINFOID = new MTField("ledgerInfoId");
	public static final MTField TRANSACTIONTYPEID = new MTField("transactionTypeId");
	public static final MTField LEDGERTYPEID = new MTField("ledgerTypeId");
	public static final MTField ANNOTATIONID = new MTField("annotationId");
	public static final MTField AMOUNT = new MTField("amount");
	public static final MTField BALANCE = new MTField("balance");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("acc.Seq_Ledger_revisionId");
			REVISIONID.setPrimaryKey(true);
		}
		fields.add(LEDGERITEMID);
		{
			LEDGERITEMID.setDataType(MTDataTypes.INT);
			LEDGERITEMID.setNullable(false);
			LEDGERITEMID.setTransient(false);
		}
		fields.add(LEDGERINFOID);
		{
			LEDGERINFOID.setDataType(MTDataTypes.INT);
			LEDGERINFOID.setNullable(false);
			LEDGERINFOID.setTransient(false);
		}
		fields.add(TRANSACTIONTYPEID);
		{
			TRANSACTIONTYPEID.setDataType(MTDataTypes.INT);
			TRANSACTIONTYPEID.setNullable(false);
			TRANSACTIONTYPEID.setTransient(false);
		}
		fields.add(LEDGERTYPEID);
		{
			LEDGERTYPEID.setDataType(MTDataTypes.INT);
			LEDGERTYPEID.setNullable(false);
			LEDGERTYPEID.setTransient(false);
		}
		fields.add(ANNOTATIONID);
		{
			ANNOTATIONID.setDataType(MTDataTypes.INT);
			ANNOTATIONID.setNullable(false);
			ANNOTATIONID.setTransient(false);
		}
		fields.add(AMOUNT);
		{
			AMOUNT.setDataType(MTDataTypes.MONEY);
			AMOUNT.setScale(2);
			AMOUNT.setLength(8);
			AMOUNT.setNullable(false);
			AMOUNT.setTransient(false);
		}
		fields.add(BALANCE);
		{
			BALANCE.setDataType(MTDataTypes.MONEY);
			BALANCE.setScale(2);
			BALANCE.setLength(8);
			BALANCE.setNullable(false);
			BALANCE.setTransient(false);
		}
	}

	public MTTableLEDGER(){
		init();
		this.tableName = "Ledger";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(REVISIONID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}