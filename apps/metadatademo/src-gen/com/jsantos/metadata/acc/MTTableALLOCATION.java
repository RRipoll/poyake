package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableALLOCATION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ALLOCATIONID = new MTField("allocationId");
	public static final MTField CREDITREVISIONID = new MTField("creditRevisionId");
	public static final MTField DEBITREVISIONID = new MTField("debitRevisionId");
	public static final MTField AMOUNT = new MTField("amount");
	public static final MTField STARTANNOTATIONID = new MTField("startAnnotationId");
	public static final MTField ENDANNOTATIONID = new MTField("endAnnotationId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ALLOCATIONID);
		{
			ALLOCATIONID.setDataType(MTDataTypes.INT);
			ALLOCATIONID.setNullable(true);
			ALLOCATIONID.setTransient(false);
			ALLOCATIONID.setSequence("acc.Seq_Allocation_allocationId");
			ALLOCATIONID.setPrimaryKey(true);
		}
		fields.add(CREDITREVISIONID);
		{
			CREDITREVISIONID.setDataType(MTDataTypes.INT);
			CREDITREVISIONID.setNullable(false);
			CREDITREVISIONID.setTransient(false);
		}
		fields.add(DEBITREVISIONID);
		{
			DEBITREVISIONID.setDataType(MTDataTypes.INT);
			DEBITREVISIONID.setNullable(false);
			DEBITREVISIONID.setTransient(false);
		}
		fields.add(AMOUNT);
		{
			AMOUNT.setDataType(MTDataTypes.MONEY);
			AMOUNT.setScale(2);
			AMOUNT.setLength(8);
			AMOUNT.setNullable(false);
			AMOUNT.setTransient(false);
		}
		fields.add(STARTANNOTATIONID);
		{
			STARTANNOTATIONID.setDataType(MTDataTypes.INT);
			STARTANNOTATIONID.setNullable(false);
			STARTANNOTATIONID.setTransient(false);
		}
		fields.add(ENDANNOTATIONID);
		{
			ENDANNOTATIONID.setDataType(MTDataTypes.INT);
			ENDANNOTATIONID.setNullable(true);
			ENDANNOTATIONID.setTransient(false);
		}
	}

	public MTTableALLOCATION(){
		init();
		this.tableName = "Allocation";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(ALLOCATIONID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}