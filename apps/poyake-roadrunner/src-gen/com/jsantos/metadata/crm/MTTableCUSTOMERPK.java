package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableCUSTOMERPK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERID = new MTField("customerId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
			CUSTOMERID.setSequence("crm.Seq_CustomerPk_customerId");
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","en_EN","Customer #"));
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Cuenta"));
			CUSTOMERID.setPrimaryKey(true);
		}
	}

	public MTTableCUSTOMERPK(){
		init();
		this.tableName = "CustomerPk";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(CUSTOMERID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}