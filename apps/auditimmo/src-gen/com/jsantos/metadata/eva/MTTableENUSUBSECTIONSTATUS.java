package com.jsantos.metadata.eva;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableENUSUBSECTIONSTATUS extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField SUBSECTIONSTATUSID = new MTField("subSectionStatusId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	 public static void init(){
		fields.add(SUBSECTIONSTATUSID);
		{
			SUBSECTIONSTATUSID.setModelType("INT");
			SUBSECTIONSTATUSID.setNativeTypeName("INT");
			SUBSECTIONSTATUSID.setNullable(true);
			SUBSECTIONSTATUSID.setSequence("eva.Seq_EnuSubSectionstatus_subSectionStatusId");
			SUBSECTIONSTATUSID.setPrimaryKey(true);
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
			DESCRIPTION.setLength(128);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENUSUBSECTIONSTATUS(){
		init();
		this.tableName = "EnuSubSectionstatus";
		this.schema = "eva";
		this.entityType = "TABLE";
		this.primaryKeys.add(SUBSECTIONSTATUSID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuSubSectionstatus();
		new Label("","","");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}