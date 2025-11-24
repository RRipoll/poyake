package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUCUSTOMERTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERTYPEID = new MTField("customerTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CUSTOMERTYPEID);
		{
			CUSTOMERTYPEID.setDataType(MTDataTypes.INT);
			CUSTOMERTYPEID.setNullable(false);
			CUSTOMERTYPEID.setTransient(false);
			CUSTOMERTYPEID.setSequence("crm.Seq_EnuCustomerType_customerTypeId");
			CUSTOMERTYPEID.setPrimaryKey(true);
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

	public MTTableENUCUSTOMERTYPE(){
		init();
		this.tableName = "EnuCustomerType";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(CUSTOMERTYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuCustomerType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}