package com.jsantos.metadata.config;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableAPPDATATYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField APPDATATYPEID = new MTField("appDataTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(APPDATATYPEID);
		{
			APPDATATYPEID.setDataType(MTDataTypes.INT);
			APPDATATYPEID.setNullable(true);
			APPDATATYPEID.setTransient(false);
			APPDATATYPEID.setSequence("config.Seq_AppDataType_appDataTypeId");
			APPDATATYPEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(false);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(false);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableAPPDATATYPE(){
		init();
		this.tableName = "AppDataType";
		this.schema = "config";
		this.entityType = "TABLE";
		this.primaryKeys.add(APPDATATYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new AppDataType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}