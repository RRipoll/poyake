package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENULICENSEPLATETYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField LICENSEPLATETYPE = new MTField("licensePlateType");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(LICENSEPLATETYPE);
		{
			LICENSEPLATETYPE.setDataType(MTDataTypes.INT);
			LICENSEPLATETYPE.setNullable(true);
			LICENSEPLATETYPE.setTransient(false);
			LICENSEPLATETYPE.setSequence("tolling.Seq_EnuLicensePlateType_licensePlateType");
			LICENSEPLATETYPE.setPrimaryKey(true);
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
			DESCRIPTION.setLength(64);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENULICENSEPLATETYPE(){
		init();
		this.tableName = "EnuLicensePlateType";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(LICENSEPLATETYPE);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuLicensePlateType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}