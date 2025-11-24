package com.jsantos.metadata.common;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableTEMPLATE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField TEMPLATEID = new MTField("templateId");
	public static final MTField ENUTEMPLATETYPEID = new MTField("enuTemplateTypeId");
	public static final MTField ENULOCALEID = new MTField("enuLocaleId");
	public static final MTField CREATED = new MTField("created");
	public static final MTField BODY = new MTField("body");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(TEMPLATEID);
		{
			TEMPLATEID.setDataType(MTDataTypes.INT);
			TEMPLATEID.setNullable(true);
			TEMPLATEID.setTransient(false);
			TEMPLATEID.setSequence("common.Seq_Template_templateId");
			TEMPLATEID.getStereoTypes().add("DESCRIPTION");
			TEMPLATEID.setPrimaryKey(true);
		}
		fields.add(ENUTEMPLATETYPEID);
		{
			ENUTEMPLATETYPEID.setDataType(MTDataTypes.INT);
			ENUTEMPLATETYPEID.setNullable(true);
			ENUTEMPLATETYPEID.setTransient(false);
		}
		fields.add(ENULOCALEID);
		{
			ENULOCALEID.setDataType(MTDataTypes.INT);
			ENULOCALEID.setNullable(true);
			ENULOCALEID.setTransient(false);
			ENULOCALEID.setDefaultValue("3082");
		}
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(false);
			CREATED.setTransient(false);
			CREATED.getStereoTypes().add("NOGUIINPUT");
			CREATED.setDefaultValue("getPostingDate()");
		}
		fields.add(BODY);
		{
			BODY.setDataType(MTDataTypes.VARCHAR);
			BODY.setLength(8000);
			BODY.setNullable(true);
			BODY.setTransient(false);
			BODY.getLabels().add(new Label("SHORTLABEL","en_EN","Template definition"));
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

	public MTTableTEMPLATE(){
		init();
		this.tableName = "Template";
		this.schema = "common";
		this.entityType = "TABLE";
		this.primaryKeys.add(TEMPLATEID);
		this.patterns.add("Audited");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}