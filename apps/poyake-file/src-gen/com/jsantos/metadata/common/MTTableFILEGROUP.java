package com.jsantos.metadata.common;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableFILEGROUP extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField FILEGROUPID = new MTField("fileGroupId");
	public static final MTField CREATED = new MTField("created");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(FILEGROUPID);
		{
			FILEGROUPID.setDataType(MTDataTypes.INT);
			FILEGROUPID.setNullable(true);
			FILEGROUPID.setTransient(false);
			FILEGROUPID.setSequence("common.Seq_FileGroup_fileGroupId");
			FILEGROUPID.setPrimaryKey(true);
		}
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(false);
			CREATED.setTransient(false);
			CREATED.getStereoTypes().add("NOGUIINPUT");
			CREATED.setDefaultValue("getPostingDate()");
		}
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(false);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.getStereoTypes().add("NOGUIINPUT");
			INPUTUSERID.setDefaultValue("1");
		}
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(false);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.getStereoTypes().add("NOGUIINPUT");
			INPUTSOURCEID.setDefaultValue("1");
		}
	}

	public MTTableFILEGROUP(){
		init();
		this.tableName = "FileGroup";
		this.schema = "common";
		this.entityType = "TABLE";
		this.primaryKeys.add(FILEGROUPID);
		this.patterns.add("Audited");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}