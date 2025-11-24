package com.jsantos.metadata.config;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableENULOCALE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ENULOCALEID = new MTField("enuLocaleId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	 public static void init(){
		fields.add(ENULOCALEID);
		{
			ENULOCALEID.setModelType("INT");
			ENULOCALEID.setNativeTypeName("INT");
			ENULOCALEID.setNullable(true);
			ENULOCALEID.setSequence("config.Seq_Enulocale_enuLocaleId");
			ENULOCALEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setModelType("VARCHAR");
			SHORTCODE.setNativeTypeName("VARCHAR");
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setModelType("VARCHAR");
			DESCRIPTION.setNativeTypeName("VARCHAR");
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENULOCALE(){
		init();
		this.tableName = "Enulocale";
		this.schema = "config";
		this.entityType = "TABLE";
		this.primaryKeys.add(ENULOCALEID);
		this.patterns.add("Enumeration");
		this.enumeration= new Enulocale();
		new Label("","","");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}