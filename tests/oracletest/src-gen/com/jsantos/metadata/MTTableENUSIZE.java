package com.jsantos.metadata;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableENUSIZE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField SIZEID = new MTField("sizeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPION = new MTField("descripion");

	static{
		fields.add(SIZEID);
		{
			SIZEID.setNativeTypeName("INT");
			SIZEID.setSequence("Seq_EnuSize_sizeId");
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setNativeTypeName("VARCHAR");
			SHORTCODE.setLength(10);
		}
		fields.add(DESCRIPION);
		{
			DESCRIPION.setNativeTypeName("VARCHAR");
			DESCRIPION.setLength(64);
		}
		for (MTField field:fields) field.setTable("ENUSIZE");
	}

	public MTTableENUSIZE(){
		this.tableName = "EnuSize";
		this.entityType = "TABLE";
		this.primaryKeys.add(SIZEID);
		new Label("","","");
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}