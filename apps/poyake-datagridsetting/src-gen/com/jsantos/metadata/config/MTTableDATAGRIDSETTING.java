package com.jsantos.metadata.config;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableDATAGRIDSETTING extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField DATAGRIDSETTINGID = new MTField("dataGridSettingId");
	public static final MTField SEARCHNAME = new MTField("searchName");
	public static final MTField DATA = new MTField("data");
	public static final MTField CREATED = new MTField("created");
	public static final MTField INPUTUSERGROUPID = new MTField("inputUserGroupId");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(DATAGRIDSETTINGID);
		{
			DATAGRIDSETTINGID.setDataType(MTDataTypes.UUID);
			DATAGRIDSETTINGID.setLength(130);
			DATAGRIDSETTINGID.setNullable(false);
			DATAGRIDSETTINGID.setTransient(false);
			DATAGRIDSETTINGID.setSequence("config.Seq_DatagridSetting_dataGridSettingId");
			DATAGRIDSETTINGID.setPrimaryKey(true);
		}
		fields.add(SEARCHNAME);
		{
			SEARCHNAME.setDataType(MTDataTypes.VARCHAR);
			SEARCHNAME.setLength(250);
			SEARCHNAME.setNullable(false);
			SEARCHNAME.setTransient(false);
			SEARCHNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Search Name"));
			SEARCHNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre Busqueda"));
			SEARCHNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(DATA);
		{
			DATA.setDataType(MTDataTypes.DATASETTING);
			DATA.setLength(-1);
			DATA.setNullable(false);
			DATA.setTransient(false);
			DATA.getLabels().add(new Label("SHORTLABEL","en_EN","Data"));
			DATA.getLabels().add(new Label("SHORTLABEL","es_ES","Datos"));
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
		fields.add(INPUTUSERGROUPID);
		{
			INPUTUSERGROUPID.setDataType(MTDataTypes.INT);
			INPUTUSERGROUPID.setNullable(false);
			INPUTUSERGROUPID.setTransient(false);
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
	}

	public MTTableDATAGRIDSETTING(){
		init();
		this.tableName = "DatagridSetting";
		this.schema = "config";
		this.entityType = "TABLE";
		this.primaryKeys.add(DATAGRIDSETTINGID);
		this.patterns.add("Audited");
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}