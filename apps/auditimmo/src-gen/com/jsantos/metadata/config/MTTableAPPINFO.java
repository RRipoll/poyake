package com.jsantos.metadata.config;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableAPPINFO extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField APPINFOID = new MTField("appInfoId");
	public static final MTField SKEY = new MTField("sKey");
	public static final MTField SVALUE = new MTField("sValue");

	 public static void init(){
		fields.add(APPINFOID);
		{
			APPINFOID.setModelType("INT");
			APPINFOID.setNativeTypeName("INT");
			APPINFOID.setNullable(false);
			APPINFOID.setSequence("config.Seq_AppInfo_appInfoId");
			APPINFOID.setPrimaryKey(true);
		}
		fields.add(SKEY);
		{
			SKEY.setModelType("VARCHAR");
			SKEY.setNativeTypeName("VARCHAR");
			SKEY.setLength(250);
			SKEY.setNullable(false);
		}
		fields.add(SVALUE);
		{
			SVALUE.setModelType("VARCHAR");
			SVALUE.setNativeTypeName("VARCHAR");
			SVALUE.setLength(8000);
			SVALUE.setNullable(true);
		}
	}

	public MTTableAPPINFO(){
		init();
		this.tableName = "AppInfo";
		this.schema = "config";
		this.entityType = "TABLE";
		this.primaryKeys.add(APPINFOID);
		new Label("","","");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}