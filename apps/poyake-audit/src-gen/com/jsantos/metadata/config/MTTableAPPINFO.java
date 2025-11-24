package com.jsantos.metadata.config;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableAPPINFO extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField APPINFOID = new MTField("appInfoId");
	public static final MTField SKEY = new MTField("sKey");
	public static final MTField TYPE = new MTField("type");
	public static final MTField SVALUE = new MTField("sValue");
	public static final MTField INPUTUSERGROUPID = new MTField("inputUserGroupId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(APPINFOID);
		{
			APPINFOID.setDataType(MTDataTypes.UUID);
			APPINFOID.setLength(130);
			APPINFOID.setNullable(false);
			APPINFOID.setTransient(false);
			APPINFOID.setSequence("config.Seq_AppInfo_appInfoId");
			APPINFOID.setPrimaryKey(true);
		}
		fields.add(SKEY);
		{
			SKEY.setDataType(MTDataTypes.VARCHAR);
			SKEY.setLength(250);
			SKEY.setNullable(false);
			SKEY.setTransient(false);
			SKEY.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(TYPE);
		{
			TYPE.setDataType(MTDataTypes.INT);
			TYPE.setNullable(true);
			TYPE.setTransient(false);
		}
		fields.add(SVALUE);
		{
			SVALUE.setDataType(MTDataTypes.VARCHAR);
			SVALUE.setLength(8000);
			SVALUE.setNullable(true);
			SVALUE.setTransient(false);
			SVALUE.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(INPUTUSERGROUPID);
		{
			INPUTUSERGROUPID.setDataType(MTDataTypes.INT);
			INPUTUSERGROUPID.setNullable(false);
			INPUTUSERGROUPID.setTransient(false);
			INPUTUSERGROUPID.getStereoTypes().add("DESCRIPTION");
			INPUTUSERGROUPID.setDefaultValue("1");
		}
	}

	public MTTableAPPINFO(){
		init();
		this.tableName = "AppInfo";
		this.schema = "config";
		this.entityType = "TABLE";
		this.primaryKeys.add(APPINFOID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}