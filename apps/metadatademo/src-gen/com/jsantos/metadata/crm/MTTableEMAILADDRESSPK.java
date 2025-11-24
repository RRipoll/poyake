package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableEMAILADDRESSPK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField EMAILADDRESSID = new MTField("emailAddressId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(EMAILADDRESSID);
		{
			EMAILADDRESSID.setDataType(MTDataTypes.INT);
			EMAILADDRESSID.setNullable(true);
			EMAILADDRESSID.setTransient(false);
			EMAILADDRESSID.setSequence("crm.Seq_EmailAddressPk_emailAddressId");
			EMAILADDRESSID.setPrimaryKey(true);
		}
	}

	public MTTableEMAILADDRESSPK(){
		init();
		this.tableName = "EmailAddressPk";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(EMAILADDRESSID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}