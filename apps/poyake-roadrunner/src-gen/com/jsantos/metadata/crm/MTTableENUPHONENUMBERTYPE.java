package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUPHONENUMBERTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PHONENUMBERTYPEID = new MTField("phoneNumberTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PHONENUMBERTYPEID);
		{
			PHONENUMBERTYPEID.setDataType(MTDataTypes.INT);
			PHONENUMBERTYPEID.setNullable(true);
			PHONENUMBERTYPEID.setTransient(false);
			PHONENUMBERTYPEID.setSequence("crm.Seq_EnuPhoneNumberType_phoneNumberTypeId");
			PHONENUMBERTYPEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENUPHONENUMBERTYPE(){
		init();
		this.tableName = "EnuPhoneNumberType";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(PHONENUMBERTYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuPhoneNumberType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}