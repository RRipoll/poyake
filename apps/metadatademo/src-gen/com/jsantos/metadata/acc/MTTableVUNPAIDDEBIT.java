package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.acc.MTTableLEDGER;
import com.jsantos.metadata.acc.MTTableANNOTATION;

public class MTTableVUNPAIDDEBIT extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField REVISIONID;
	public static final MTField UNALLOCATED = new MTField("unAllocated");
	public static final MTField FULLAMOUNT = new MTField("fullAmount");
	public static final MTField ALLOCATED = new MTField("allocated");
	public static MTField LEDGERITEMID;
	public static MTField CUSTOMERID;

	public static void init(){
		fields = new ArrayList<>();
		REVISIONID = new MTField(MTTableLEDGER.REVISIONID,"revisionId");
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("acc.Seq_VUnpaidDebit_revisionId");
			REVISIONID.setPrimaryKey(true);
		}
		fields.add(UNALLOCATED);
		{
			UNALLOCATED.setDataType(MTDataTypes.MONEY);
			UNALLOCATED.setScale(2);
			UNALLOCATED.setLength(8);
			UNALLOCATED.setNullable(true);
			UNALLOCATED.setTransient(false);
		}
		fields.add(FULLAMOUNT);
		{
			FULLAMOUNT.setDataType(MTDataTypes.MONEY);
			FULLAMOUNT.setScale(2);
			FULLAMOUNT.setLength(8);
			FULLAMOUNT.setNullable(true);
			FULLAMOUNT.setTransient(false);
		}
		fields.add(ALLOCATED);
		{
			ALLOCATED.setDataType(MTDataTypes.MONEY);
			ALLOCATED.setScale(2);
			ALLOCATED.setLength(8);
			ALLOCATED.setNullable(true);
			ALLOCATED.setTransient(false);
		}
		LEDGERITEMID = new MTField(MTTableLEDGER.LEDGERITEMID,"ledgerItemId");
		fields.add(LEDGERITEMID);
		{
			LEDGERITEMID.setDataType(MTDataTypes.INT);
			LEDGERITEMID.setNullable(true);
			LEDGERITEMID.setTransient(false);
		}
		CUSTOMERID = new MTField(MTTableANNOTATION.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
	}

	public MTTableVUNPAIDDEBIT(){
		init();
		this.tableName = "VUnpaidDebit";
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