package com.jsantos.metadata.cfg;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableENUCONFIGKEYTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CONFIGKEYTYPEID = new MTField("configKeyTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	static{
		fields.add(CONFIGKEYTYPEID);
		{
			CONFIGKEYTYPEID.setNativeTypeName("INT");
			CONFIGKEYTYPEID.setSequence("cfg.Seq_EnuConfigKeyType_configKeyTypeId");
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
		for (MTField field:fields) field.setTable("ENUCONFIGKEYTYPE");
	}

	public MTTableENUCONFIGKEYTYPE(){
		this.tableName = "EnuConfigKeyType";
		this.schema = "cfg";
		this.entityType = "TABLE";
		this.primaryKeys.add(CONFIGKEYTYPEID);
		this.patterns.add("Enumeration");
		new Label("","","");
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}