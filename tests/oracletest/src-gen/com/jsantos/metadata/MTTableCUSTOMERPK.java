package com.jsantos.metadata;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableCUSTOMERPK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERID = new MTField("customerId");

	static{
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setNativeTypeName("INT");
			CUSTOMERID.setSequence("Seq_CustomerPk_customerId");
		}
		for (MTField field:fields) field.setTable("CUSTOMERPK");
	}

	public MTTableCUSTOMERPK(){
		this.tableName = "CustomerPk";
		this.entityType = "TABLE";
		this.primaryKeys.add(CUSTOMERID);
		new Label("","","");
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}