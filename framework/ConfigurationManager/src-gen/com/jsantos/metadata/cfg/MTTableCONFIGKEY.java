package com.jsantos.metadata.cfg;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableCONFIGKEY extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CONFIGKEYID = new MTField("configKeyId");
	public static final MTField FULLPATH = new MTField("fullPath");
	public static final MTField CONFIGKEYTYPEID = new MTField("configKeyTypeId");
	public static final MTField CONFIGDATATYPEID = new MTField("configDataTypeId");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField DEFAULTVALUE = new MTField("defaultValue");
	public static final MTField ISSTATIC = new MTField("isStatic");

	static{
		fields.add(CONFIGKEYID);
		{
			CONFIGKEYID.setNativeTypeName("INT");
			CONFIGKEYID.setSequence("cfg.Seq_ConfigKey_configKeyId");
		}
		fields.add(FULLPATH);
		{
			FULLPATH.setNativeTypeName("VARCHAR");
			FULLPATH.setLength(2048);
		}
		fields.add(CONFIGKEYTYPEID);
		{
			CONFIGKEYTYPEID.setNativeTypeName("INT");
			CONFIGKEYTYPEID.setNullable(false);
		}
		fields.add(CONFIGDATATYPEID);
		{
			CONFIGDATATYPEID.setNativeTypeName("INT");
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setNativeTypeName("VARCHAR");
			DESCRIPTION.setLength(64);
			DESCRIPTION.setNullable(false);
		}
		fields.add(DEFAULTVALUE);
		{
			DEFAULTVALUE.setNativeTypeName("VARCHAR");
			DEFAULTVALUE.setLength(64);
		}
		fields.add(ISSTATIC);
		{
			ISSTATIC.setNativeTypeName("BIT");
			ISSTATIC.setNullable(false);
		}
		for (MTField field:fields) field.setTable("CONFIGKEY");
	}

	public MTTableCONFIGKEY(){
		this.tableName = "ConfigKey";
		this.schema = "cfg";
		this.entityType = "TABLE";
		this.primaryKeys.add(CONFIGKEYID);
		new Label("","","");
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}