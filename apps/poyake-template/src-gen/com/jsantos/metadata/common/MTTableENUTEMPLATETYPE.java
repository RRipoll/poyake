package com.jsantos.metadata.common;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUTEMPLATETYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ENUTEMPLATETYPEID = new MTField("enuTemplateTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ENUTEMPLATETYPEID);
		{
			ENUTEMPLATETYPEID.setDataType(MTDataTypes.INT);
			ENUTEMPLATETYPEID.setNullable(true);
			ENUTEMPLATETYPEID.setTransient(false);
			ENUTEMPLATETYPEID.setSequence("common.Seq_EnuTemplateType_enuTemplateTypeId");
			ENUTEMPLATETYPEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENUTEMPLATETYPE(){
		init();
		this.tableName = "EnuTemplateType";
		this.schema = "common";
		this.entityType = "TABLE";
		this.primaryKeys.add(ENUTEMPLATETYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuTemplateType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}