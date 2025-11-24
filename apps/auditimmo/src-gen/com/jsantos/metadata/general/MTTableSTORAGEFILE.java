package com.jsantos.metadata.general;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableSTORAGEFILE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField STORAGEFILEID = new MTField("storageFileId");
	public static final MTField URL = new MTField("url");
	public static final MTField MIMETYPE = new MTField("mimeType");
	public static final MTField FILENAME = new MTField("fileName");
	public static final MTField FILEGROUPID = new MTField("fileGroupId");
	public static final MTField POSTINGDATE = new MTField("postingDate");
	public static final MTField ORIGINALFILENAME = new MTField("originalFileName");

	 public static void init(){
		fields.add(STORAGEFILEID);
		{
			STORAGEFILEID.setModelType("INT");
			STORAGEFILEID.setNativeTypeName("INT");
			STORAGEFILEID.setNullable(true);
			STORAGEFILEID.setSequence("general.Seq_StorageFile_storageFileId");
			STORAGEFILEID.setPrimaryKey(true);
		}
		fields.add(URL);
		{
			URL.setModelType("VARCHAR");
			URL.setNativeTypeName("VARCHAR");
			URL.setLength(255);
			URL.setNullable(false);
		}
		fields.add(MIMETYPE);
		{
			MIMETYPE.setModelType("VARCHAR");
			MIMETYPE.setNativeTypeName("VARCHAR");
			MIMETYPE.setLength(70);
			MIMETYPE.setNullable(false);
		}
		fields.add(FILENAME);
		{
			FILENAME.setModelType("VARCHAR");
			FILENAME.setNativeTypeName("VARCHAR");
			FILENAME.setLength(255);
			FILENAME.setNullable(false);
		}
		fields.add(FILEGROUPID);
		{
			FILEGROUPID.setModelType("INT");
			FILEGROUPID.setNativeTypeName("INT");
			FILEGROUPID.setNullable(false);
		}
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setModelType("DATETIME");
			POSTINGDATE.setNativeTypeName("DATETIME");
			POSTINGDATE.setNullable(false);
			POSTINGDATE.setDefaultValue("getDate()");
		}
		fields.add(ORIGINALFILENAME);
		{
			ORIGINALFILENAME.setModelType("VARCHAR");
			ORIGINALFILENAME.setNativeTypeName("VARCHAR");
			ORIGINALFILENAME.setLength(255);
			ORIGINALFILENAME.setNullable(true);
		}
	}

	public MTTableSTORAGEFILE(){
		init();
		this.tableName = "StorageFile";
		this.schema = "general";
		this.entityType = "TABLE";
		this.primaryKeys.add(STORAGEFILEID);
		new Label("","","");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}