package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableVEHICLE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField VEHICLEID = new MTField("vehicleId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(VEHICLEID);
		{
			VEHICLEID.setDataType(MTDataTypes.INT);
			VEHICLEID.setNullable(true);
			VEHICLEID.setTransient(false);
			VEHICLEID.setSequence("tolling.Seq_Vehicle_vehicleId");
			VEHICLEID.setPrimaryKey(true);
		}
	}

	public MTTableVEHICLE(){
		init();
		this.tableName = "Vehicle";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(VEHICLEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}