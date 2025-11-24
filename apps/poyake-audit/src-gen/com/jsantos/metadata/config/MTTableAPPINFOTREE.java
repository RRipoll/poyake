package com.jsantos.metadata.config;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableAPPINFOTREE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField APPINFOTREEID = new MTField("appInfoTreeId");
	public static final MTField PARENTAPPINFOTREEID = new MTField("parentAppInfoTreeId");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField APPINFOID = new MTField("appInfoId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(APPINFOTREEID);
		{
			APPINFOTREEID.setDataType(MTDataTypes.UUID);
			APPINFOTREEID.setLength(130);
			APPINFOTREEID.setNullable(false);
			APPINFOTREEID.setTransient(false);
			APPINFOTREEID.setSequence("config.Seq_AppInfoTree_appInfoTreeId");
			APPINFOTREEID.getStereoTypes().add("FOLDER");
			APPINFOTREEID.setPrimaryKey(true);
		}
		fields.add(PARENTAPPINFOTREEID);
		{
			PARENTAPPINFOTREEID.setDataType(MTDataTypes.UUID);
			PARENTAPPINFOTREEID.setLength(130);
			PARENTAPPINFOTREEID.setNullable(true);
			PARENTAPPINFOTREEID.setTransient(false);
			PARENTAPPINFOTREEID.getStereoTypes().add("PARENTFOLDER");
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(256);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(APPINFOID);
		{
			APPINFOID.setDataType(MTDataTypes.UUID);
			APPINFOID.setLength(130);
			APPINFOID.setNullable(true);
			APPINFOID.setTransient(false);
			APPINFOID.getStereoTypes().add("ITEM");
		}
	}

	public MTTableAPPINFOTREE(){
		init();
		this.tableName = "AppInfoTree";
		this.schema = "config";
		this.entityType = "TABLE";
		this.primaryKeys.add(APPINFOTREEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}