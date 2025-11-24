package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUVEHICLECLASS extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField VEHICLECLASSID = new MTField("vehicleClassId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField VEHICLECLASSTYPEID = new MTField("vehicleClassTypeId");
	public static final MTField AIGCODE = new MTField("aigCode");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(VEHICLECLASSID);
		{
			VEHICLECLASSID.setDataType(MTDataTypes.INT);
			VEHICLECLASSID.setNullable(true);
			VEHICLECLASSID.setTransient(false);
			VEHICLECLASSID.setSequence("tolling.Seq_EnuVehicleClass_vehicleClassId");
			VEHICLECLASSID.setPrimaryKey(true);
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
			DESCRIPTION.setLength(128);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(VEHICLECLASSTYPEID);
		{
			VEHICLECLASSTYPEID.setDataType(MTDataTypes.INT);
			VEHICLECLASSTYPEID.setNullable(true);
			VEHICLECLASSTYPEID.setTransient(false);
		}
		fields.add(AIGCODE);
		{
			AIGCODE.setDataType(MTDataTypes.INT);
			AIGCODE.setNullable(true);
			AIGCODE.setTransient(false);
		}
	}

	public MTTableENUVEHICLECLASS(){
		init();
		this.tableName = "EnuVehicleClass";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(VEHICLECLASSID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuVehicleClass();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}