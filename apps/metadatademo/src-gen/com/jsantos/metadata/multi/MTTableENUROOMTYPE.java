package com.jsantos.metadata.multi;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUROOMTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ROOMTYPEID = new MTField("roomTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ROOMTYPEID);
		{
			ROOMTYPEID.setDataType(MTDataTypes.INT);
			ROOMTYPEID.setNullable(true);
			ROOMTYPEID.setTransient(false);
			ROOMTYPEID.setSequence("multi.Seq_EnuRoomType_roomTypeId");
			ROOMTYPEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(false);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(false);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENUROOMTYPE(){
		init();
		this.tableName = "EnuRoomType";
		this.schema = "multi";
		this.entityType = "TABLE";
		this.primaryKeys.add(ROOMTYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuRoomType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}