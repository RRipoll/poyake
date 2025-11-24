package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUPROMOTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ENUPROMOTYPEID = new MTField("enuPromoTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ENUPROMOTYPEID);
		{
			ENUPROMOTYPEID.setDataType(MTDataTypes.INT);
			ENUPROMOTYPEID.setNullable(true);
			ENUPROMOTYPEID.setTransient(false);
			ENUPROMOTYPEID.setSequence("tolling.Seq_EnuPromoType_enuPromoTypeId");
			ENUPROMOTYPEID.setPrimaryKey(true);
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

	public MTTableENUPROMOTYPE(){
		init();
		this.tableName = "EnuPromoType";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(ENUPROMOTYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuPromoType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}