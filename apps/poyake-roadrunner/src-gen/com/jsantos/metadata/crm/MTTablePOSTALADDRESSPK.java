package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePOSTALADDRESSPK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField POSTALADDRESSID = new MTField("postalAddressId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(POSTALADDRESSID);
		{
			POSTALADDRESSID.setDataType(MTDataTypes.INT);
			POSTALADDRESSID.setNullable(true);
			POSTALADDRESSID.setTransient(false);
			POSTALADDRESSID.setSequence("crm.Seq_PostalAddressPk_postalAddressId");
			POSTALADDRESSID.setPrimaryKey(true);
		}
	}

	public MTTablePOSTALADDRESSPK(){
		init();
		this.tableName = "PostalAddressPk";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(POSTALADDRESSID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}