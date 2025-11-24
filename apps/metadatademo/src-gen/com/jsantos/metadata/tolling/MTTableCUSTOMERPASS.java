package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableCUSTOMERPASS extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERPASSID = new MTField("customerPassId");
	public static final MTField CUSTOMERID = new MTField("customerId");
	public static final MTField PASSID = new MTField("passId");
	public static final MTField STARTEFFECTIVEDATE = new MTField("startEffectiveDate");
	public static final MTField ENDEFFECTIVEDATE = new MTField("endEffectiveDate");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CUSTOMERPASSID);
		{
			CUSTOMERPASSID.setDataType(MTDataTypes.INT);
			CUSTOMERPASSID.setNullable(true);
			CUSTOMERPASSID.setTransient(false);
			CUSTOMERPASSID.setSequence("tolling.Seq_CustomerPass_customerPassId");
			CUSTOMERPASSID.setPrimaryKey(true);
		}
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(false);
			CUSTOMERID.setTransient(false);
		}
		fields.add(PASSID);
		{
			PASSID.setDataType(MTDataTypes.INT);
			PASSID.setNullable(false);
			PASSID.setTransient(false);
		}
		fields.add(STARTEFFECTIVEDATE);
		{
			STARTEFFECTIVEDATE.setDataType(MTDataTypes.DATETIME);
			STARTEFFECTIVEDATE.setNullable(false);
			STARTEFFECTIVEDATE.setTransient(false);
			STARTEFFECTIVEDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(ENDEFFECTIVEDATE);
		{
			ENDEFFECTIVEDATE.setDataType(MTDataTypes.DATETIME);
			ENDEFFECTIVEDATE.setNullable(false);
			ENDEFFECTIVEDATE.setTransient(false);
			ENDEFFECTIVEDATE.setDefaultValue("'2099-01-01'");
		}
	}

	public MTTableCUSTOMERPASS(){
		init();
		this.tableName = "CustomerPass";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(CUSTOMERPASSID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}