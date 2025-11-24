package com.jsantos.metadata.general;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableENUTEMPLATETYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ENUTEMPLATETYPEID = new MTField("enuTemplateTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	 public static void init(){
		fields.add(ENUTEMPLATETYPEID);
		{
			ENUTEMPLATETYPEID.setModelType("INT");
			ENUTEMPLATETYPEID.setNativeTypeName("INT");
			ENUTEMPLATETYPEID.setNullable(true);
			ENUTEMPLATETYPEID.setSequence("general.Seq_EnuTemplateType_enuTemplateTypeId");
			ENUTEMPLATETYPEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setModelType("VARCHAR");
			SHORTCODE.setNativeTypeName("VARCHAR");
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setModelType("VARCHAR");
			DESCRIPTION.setNativeTypeName("VARCHAR");
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENUTEMPLATETYPE(){
		init();
		this.tableName = "EnuTemplateType";
		this.schema = "general";
		this.entityType = "TABLE";
		this.primaryKeys.add(ENUTEMPLATETYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuTemplateType();
		new Label("","","");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}