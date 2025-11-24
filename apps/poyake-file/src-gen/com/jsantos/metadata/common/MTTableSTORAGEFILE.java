package com.jsantos.metadata.common;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableSTORAGEFILE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField STORAGEFILEID = new MTField("storageFileId");
	public static final MTField LOCATION = new MTField("location");
	public static final MTField PROVIDER = new MTField("provider");
	public static final MTField MIMETYPE = new MTField("mimeType");
	public static final MTField FILENAME = new MTField("fileName");
	public static final MTField FILEGROUPID = new MTField("fileGroupId");
	public static final MTField ORIGINALFILENAME = new MTField("originalFileName");
	public static final MTField TAGS = new MTField("tags");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField CREATED = new MTField("created");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(STORAGEFILEID);
		{
			STORAGEFILEID.setDataType(MTDataTypes.INT);
			STORAGEFILEID.setNullable(false);
			STORAGEFILEID.setTransient(false);
			STORAGEFILEID.getStereoTypes().add("AUTOHISTORYMAINFK");
		}
		fields.add(LOCATION);
		{
			LOCATION.setDataType(MTDataTypes.URL);
			LOCATION.setLength(256);
			LOCATION.setNullable(false);
			LOCATION.setTransient(false);
		}
		fields.add(PROVIDER);
		{
			PROVIDER.setDataType(MTDataTypes.VARCHAR);
			PROVIDER.setLength(70);
			PROVIDER.setNullable(true);
			PROVIDER.setTransient(false);
		}
		fields.add(MIMETYPE);
		{
			MIMETYPE.setDataType(MTDataTypes.VARCHAR);
			MIMETYPE.setLength(70);
			MIMETYPE.setNullable(false);
			MIMETYPE.setTransient(false);
		}
		fields.add(FILENAME);
		{
			FILENAME.setDataType(MTDataTypes.VARCHAR);
			FILENAME.setLength(255);
			FILENAME.setNullable(false);
			FILENAME.setTransient(false);
			FILENAME.getLabels().add(new Label("SHORTLABEL","en_EN","File Name"));
			FILENAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre Archivo"));
		}
		fields.add(FILEGROUPID);
		{
			FILEGROUPID.setDataType(MTDataTypes.INT);
			FILEGROUPID.setNullable(false);
			FILEGROUPID.setTransient(false);
		}
		fields.add(ORIGINALFILENAME);
		{
			ORIGINALFILENAME.setDataType(MTDataTypes.VARCHAR);
			ORIGINALFILENAME.setLength(255);
			ORIGINALFILENAME.setNullable(true);
			ORIGINALFILENAME.setTransient(false);
			ORIGINALFILENAME.getLabels().add(new Label("SHORTLABEL","en_EN","Original Name"));
			ORIGINALFILENAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre Original"));
			ORIGINALFILENAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(TAGS);
		{
			TAGS.setDataType(MTDataTypes.VARCHAR);
			TAGS.setLength(255);
			TAGS.setNullable(true);
			TAGS.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","en_EN","Description"));
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","es_ES","Descripción"));
		}
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(false);
			CREATED.setTransient(false);
			CREATED.getLabels().add(new Label("SHORTLABEL","en_EN","Created By"));
			CREATED.getLabels().add(new Label("SHORTLABEL","es_ES","Creado por"));
			CREATED.getStereoTypes().add("NOGUIINPUT");
			CREATED.setDefaultValue("getPostingDate()");
		}
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(false);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
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
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("common.Seq_StorageFile_revisionId");
			REVISIONID.getStereoTypes().add("NOGUIINPUT");
			REVISIONID.setPrimaryKey(true);
		}
		fields.add(STARTDATE);
		{
			STARTDATE.setDataType(MTDataTypes.DATETIME);
			STARTDATE.setNullable(false);
			STARTDATE.setTransient(false);
			STARTDATE.getStereoTypes().add("NOGUIINPUT");
			STARTDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(ENDDATE);
		{
			ENDDATE.setDataType(MTDataTypes.DATETIME);
			ENDDATE.setNullable(false);
			ENDDATE.setTransient(false);
			ENDDATE.getStereoTypes().add("NOGUIINPUT");
			ENDDATE.setDefaultValue("'2099-01-01'");
		}
	}

	public MTTableSTORAGEFILE(){
		init();
		this.tableName = "StorageFile";
		this.schema = "common";
		this.entityType = "TABLE";
		this.primaryKeys.add(REVISIONID);
		this.patterns.add("Audited");
		this.patterns.add("AutoHistory");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}