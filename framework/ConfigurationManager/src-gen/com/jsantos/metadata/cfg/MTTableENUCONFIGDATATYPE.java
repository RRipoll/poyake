package com.jsantos.metadata.cfg;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableENUCONFIGDATATYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CONFIGURATIONDATATYPE = new MTField("configurationDataType");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	static{
		fields.add(CONFIGURATIONDATATYPE);
		{
			CONFIGURATIONDATATYPE.setNativeTypeName("INT");
			CONFIGURATIONDATATYPE.setSequence("cfg.Seq_EnuConfigDataType_configurationDataType");
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setNativeTypeName("VARCHAR");
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setNativeTypeName("VARCHAR");
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(false);
		}
		for (MTField field:fields) field.setTable("ENUCONFIGDATATYPE");
	}

	public MTTableENUCONFIGDATATYPE(){
		this.tableName = "EnuConfigDataType";
		this.schema = "cfg";
		this.entityType = "TABLE";
		this.primaryKeys.add(CONFIGURATIONDATATYPE);
		this.patterns.add("Enumeration");
		new Label("","","");
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}