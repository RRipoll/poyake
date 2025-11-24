package com.jsantos.metadata.general;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableTEMPLATE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField TEMPLATEID = new MTField("templateId");
	public static final MTField ENUTEMPLATETYPEID = new MTField("enuTemplateTypeId");
	public static final MTField ENULOCALEID = new MTField("enuLocaleId");
	public static final MTField POSTINGDATE = new MTField("postingDate");
	public static final MTField BODY = new MTField("body");

	 public static void init(){
		fields.add(TEMPLATEID);
		{
			TEMPLATEID.setModelType("INT");
			TEMPLATEID.setNativeTypeName("INT");
			TEMPLATEID.setNullable(true);
			TEMPLATEID.setSequence("general.Seq_Template_templateId");
			TEMPLATEID.setPrimaryKey(true);
		}
		fields.add(ENUTEMPLATETYPEID);
		{
			ENUTEMPLATETYPEID.setModelType("INT");
			ENUTEMPLATETYPEID.setNativeTypeName("INT");
			ENUTEMPLATETYPEID.setNullable(true);
		}
		fields.add(ENULOCALEID);
		{
			ENULOCALEID.setModelType("INT");
			ENULOCALEID.setNativeTypeName("INT");
			ENULOCALEID.setNullable(true);
			ENULOCALEID.setDefaultValue("3082");
		}
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setModelType("DATE");
			POSTINGDATE.setNativeTypeName("DATE");
			POSTINGDATE.setNullable(false);
			POSTINGDATE.setDefaultValue("getDate()");
		}
		fields.add(BODY);
		{
			BODY.setModelType("VARCHAR");
			BODY.setNativeTypeName("VARCHAR");
			BODY.setLength(8000);
			BODY.setNullable(true);
		}
	}

	public MTTableTEMPLATE(){
		init();
		this.tableName = "Template";
		this.schema = "general";
		this.entityType = "TABLE";
		this.primaryKeys.add(TEMPLATEID);
		new Label("","","");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}