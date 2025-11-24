package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableCUSTOMERVEHICLE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERVEHICLEID = new MTField("customerVehicleId");
	public static final MTField CUSTOMERID = new MTField("customerId");
	public static final MTField VEHICLEID = new MTField("vehicleId");
	public static final MTField EFFECTIVESTARTDATE = new MTField("effectiveStartDate");
	public static final MTField EFFECTIVEENDDATE = new MTField("effectiveEndDate");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CUSTOMERVEHICLEID);
		{
			CUSTOMERVEHICLEID.setDataType(MTDataTypes.INT);
			CUSTOMERVEHICLEID.setNullable(true);
			CUSTOMERVEHICLEID.setTransient(false);
			CUSTOMERVEHICLEID.setSequence("tolling.Seq_CustomerVehicle_customerVehicleId");
			CUSTOMERVEHICLEID.setPrimaryKey(true);
		}
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(false);
			CUSTOMERID.setTransient(false);
		}
		fields.add(VEHICLEID);
		{
			VEHICLEID.setDataType(MTDataTypes.INT);
			VEHICLEID.setNullable(false);
			VEHICLEID.setTransient(false);
		}
		fields.add(EFFECTIVESTARTDATE);
		{
			EFFECTIVESTARTDATE.setDataType(MTDataTypes.DATETIME);
			EFFECTIVESTARTDATE.setNullable(false);
			EFFECTIVESTARTDATE.setTransient(false);
			EFFECTIVESTARTDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(EFFECTIVEENDDATE);
		{
			EFFECTIVEENDDATE.setDataType(MTDataTypes.DATETIME);
			EFFECTIVEENDDATE.setNullable(false);
			EFFECTIVEENDDATE.setTransient(false);
			EFFECTIVEENDDATE.setDefaultValue("'2099-01-01'");
		}
	}

	public MTTableCUSTOMERVEHICLE(){
		init();
		this.tableName = "CustomerVehicle";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(CUSTOMERVEHICLEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}