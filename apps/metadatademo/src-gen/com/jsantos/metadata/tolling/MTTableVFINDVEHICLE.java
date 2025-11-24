package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.tolling.MTTableVEHICLEINFO;
import com.jsantos.metadata.tolling.MTTableENULICENSEPLATEJURISDICTION;
import com.jsantos.metadata.tolling.MTTableLICENSEPLATE;
import com.jsantos.metadata.tolling.MTTableCUSTOMERVEHICLE;

public class MTTableVFINDVEHICLE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField VEHICLEID;
	public static MTField SHORTCODE;
	public static MTField LPNUMBER;
	public static MTField MAKE;
	public static MTField MODEL;
	public static MTField MODELYEAR;
	public static MTField COLOR;
	public static MTField AXLES;
	public static MTField VEHICLECLASSID;
	public static MTField CUSTOMERID;
	public static MTField LICENSEPLATEID;

	public static void init(){
		fields = new ArrayList<>();
		VEHICLEID = new MTField(MTTableVEHICLEINFO.VEHICLEID,"vehicleId");
			VEHICLEID.getLabels().add(new Label("SHORTLABEL","en_EN","Vehicle #"));
			VEHICLEID.getLabels().add(new Label("SHORTLABEL","es_ES","# Veh??culo"));
		fields.add(VEHICLEID);
		{
			VEHICLEID.setDataType(MTDataTypes.INT);
			VEHICLEID.setNullable(true);
			VEHICLEID.setTransient(false);
			VEHICLEID.setSequence("tolling.Seq_VFindVehicle_vehicleId");
			VEHICLEID.setPrimaryKey(true);
		}
		SHORTCODE = new MTField(MTTableENULICENSEPLATEJURISDICTION.SHORTCODE,"shortCode");
			SHORTCODE.getLabels().add(new Label("SHORTLABEL","en_EN","Jurisdiction"));
			SHORTCODE.getLabels().add(new Label("SHORTLABEL","es_ES","Jurisdicci??n"));
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		LPNUMBER = new MTField(MTTableLICENSEPLATE.LPNUMBER,"lpnumber");
			LPNUMBER.getLabels().add(new Label("SHORTLABEL","en_EN","License Plate #"));
			LPNUMBER.getLabels().add(new Label("SHORTLABEL","es_ES","Matr??cula"));
		fields.add(LPNUMBER);
		{
			LPNUMBER.setDataType(MTDataTypes.VARCHAR);
			LPNUMBER.setLength(16);
			LPNUMBER.setNullable(true);
			LPNUMBER.setTransient(false);
		}
		MAKE = new MTField(MTTableVEHICLEINFO.MAKE,"make");
			MAKE.getLabels().add(new Label("SHORTLABEL","es_ES","Fabricante"));
		fields.add(MAKE);
		{
			MAKE.setDataType(MTDataTypes.VARCHAR);
			MAKE.setLength(255);
			MAKE.setNullable(true);
			MAKE.setTransient(false);
		}
		MODEL = new MTField(MTTableVEHICLEINFO.MODEL,"model");
			MODEL.getLabels().add(new Label("SHORTLABEL","es_ES","Modelo"));
		fields.add(MODEL);
		{
			MODEL.setDataType(MTDataTypes.VARCHAR);
			MODEL.setLength(255);
			MODEL.setNullable(true);
			MODEL.setTransient(false);
		}
		MODELYEAR = new MTField(MTTableVEHICLEINFO.MODELYEAR,"modelYear");
			MODELYEAR.getLabels().add(new Label("SHORTLABEL","en_EN","Model Year"));
			MODELYEAR.getLabels().add(new Label("SHORTLABEL","es_ES","A??o"));
		fields.add(MODELYEAR);
		{
			MODELYEAR.setDataType(MTDataTypes.INT);
			MODELYEAR.setNullable(true);
			MODELYEAR.setTransient(false);
		}
		COLOR = new MTField(MTTableVEHICLEINFO.COLOR,"color");
		fields.add(COLOR);
		{
			COLOR.setDataType(MTDataTypes.VARCHAR);
			COLOR.setLength(100);
			COLOR.setNullable(true);
			COLOR.setTransient(false);
		}
		AXLES = new MTField(MTTableVEHICLEINFO.AXLES,"axles");
			AXLES.getLabels().add(new Label("SHORTLABEL","es_ES","Ejes"));
		fields.add(AXLES);
		{
			AXLES.setDataType(MTDataTypes.INT);
			AXLES.setNullable(true);
			AXLES.setTransient(false);
		}
		VEHICLECLASSID = new MTField(MTTableVEHICLEINFO.VEHICLECLASSID,"vehicleClassId");
			VEHICLECLASSID.getLabels().add(new Label("SHORTLABEL","en_EN","Class"));
			VEHICLECLASSID.getLabels().add(new Label("SHORTLABEL","es_ES","Clase"));
		fields.add(VEHICLECLASSID);
		{
			VEHICLECLASSID.setDataType(MTDataTypes.INT);
			VEHICLECLASSID.setNullable(true);
			VEHICLECLASSID.setTransient(false);
		}
		CUSTOMERID = new MTField(MTTableCUSTOMERVEHICLE.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
		LICENSEPLATEID = new MTField(MTTableLICENSEPLATE.LICENSEPLATEID,"licensePlateId");
		fields.add(LICENSEPLATEID);
		{
			LICENSEPLATEID.setDataType(MTDataTypes.INT);
			LICENSEPLATEID.setNullable(true);
			LICENSEPLATEID.setTransient(false);
		}
	}

	public MTTableVFINDVEHICLE(){
		init();
		this.tableName = "VFindVehicle";
		this.schema = "tolling";
		this.entityType = "VIEW";
		this.primaryKeys.add(VEHICLEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}