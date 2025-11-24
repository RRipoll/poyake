package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUSTATEPROVINCE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField STATEPROVINCEID = new MTField("stateProvinceId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField ABBR = new MTField("abbr");
	public static final MTField COUNTRYID = new MTField("countryId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(STATEPROVINCEID);
		{
			STATEPROVINCEID.setDataType(MTDataTypes.INT);
			STATEPROVINCEID.setNullable(true);
			STATEPROVINCEID.setTransient(false);
			STATEPROVINCEID.setSequence("crm.Seq_EnuStateProvince_stateProvinceId");
			STATEPROVINCEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(3);
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
		fields.add(ABBR);
		{
			ABBR.setDataType(MTDataTypes.VARCHAR);
			ABBR.setLength(2);
			ABBR.setNullable(true);
			ABBR.setTransient(false);
		}
		fields.add(COUNTRYID);
		{
			COUNTRYID.setDataType(MTDataTypes.INT);
			COUNTRYID.setNullable(false);
			COUNTRYID.setTransient(false);
		}
	}

	public MTTableENUSTATEPROVINCE(){
		init();
		this.tableName = "EnuStateProvince";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(STATEPROVINCEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuStateProvince();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}