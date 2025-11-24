package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUCOUNTRY extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField COUNTRYID = new MTField("countryId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(COUNTRYID);
		{
			COUNTRYID.setDataType(MTDataTypes.INT);
			COUNTRYID.setNullable(true);
			COUNTRYID.setTransient(false);
			COUNTRYID.setSequence("crm.Seq_EnuCountry_countryId");
			COUNTRYID.setPrimaryKey(true);
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

	public MTTableENUCOUNTRY(){
		init();
		this.tableName = "EnuCountry";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(COUNTRYID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuCountry();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}