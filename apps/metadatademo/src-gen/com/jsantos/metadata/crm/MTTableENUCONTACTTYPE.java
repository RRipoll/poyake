package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUCONTACTTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CONTACTTYPEID = new MTField("contactTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CONTACTTYPEID);
		{
			CONTACTTYPEID.setDataType(MTDataTypes.INT);
			CONTACTTYPEID.setNullable(true);
			CONTACTTYPEID.setTransient(false);
			CONTACTTYPEID.setSequence("crm.Seq_EnuContactType_contactTypeId");
			CONTACTTYPEID.setPrimaryKey(true);
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
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENUCONTACTTYPE(){
		init();
		this.tableName = "EnuContactType";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(CONTACTTYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuContactType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}