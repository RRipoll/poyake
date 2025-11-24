package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePHONENUMBERPK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PHONENUMBERID = new MTField("phoneNumberId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PHONENUMBERID);
		{
			PHONENUMBERID.setDataType(MTDataTypes.INT);
			PHONENUMBERID.setNullable(true);
			PHONENUMBERID.setTransient(false);
			PHONENUMBERID.setSequence("crm.Seq_PhoneNumberPK_phoneNumberId");
			PHONENUMBERID.setPrimaryKey(true);
		}
	}

	public MTTablePHONENUMBERPK(){
		init();
		this.tableName = "PhoneNumberPK";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(PHONENUMBERID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}