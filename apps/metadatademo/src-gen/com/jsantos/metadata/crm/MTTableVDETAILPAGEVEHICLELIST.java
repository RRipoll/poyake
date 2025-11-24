package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.tolling.MTTableVEHICLEINFO;
import com.jsantos.metadata.tolling.MTTableLICENSEPLATE;
import com.jsantos.metadata.tolling.MTTableCUSTOMERVEHICLE;

public class MTTableVDETAILPAGEVEHICLELIST extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField VEHICLEID;
	public static MTField LPNUMBER;
	public static MTField LICENCEPLATEJURISDICTIONID;
	public static MTField LICENSEPLATETYPEID;
	public static MTField VEHICLECLASSID;
	public static MTField CUSTOMERID;

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
			VEHICLEID.setSequence("crm.Seq_VDetailPageVehicleList_vehicleId");
			VEHICLEID.setPrimaryKey(true);
		}
		LPNUMBER = new MTField(MTTableLICENSEPLATE.LPNUMBER,"lpNumber");
			LPNUMBER.getLabels().add(new Label("SHORTLABEL","en_EN","License Plate #"));
			LPNUMBER.getLabels().add(new Label("SHORTLABEL","es_ES","Matr??cula"));
		fields.add(LPNUMBER);
		{
			LPNUMBER.setDataType(MTDataTypes.VARCHAR);
			LPNUMBER.setLength(16);
			LPNUMBER.setNullable(true);
			LPNUMBER.setTransient(false);
		}
		LICENCEPLATEJURISDICTIONID = new MTField(MTTableLICENSEPLATE.LICENCEPLATEJURISDICTIONID,"licencePlateJurisdictionId");
			LICENCEPLATEJURISDICTIONID.getLabels().add(new Label("SHORTLABEL","en_EN","Jurisdiction"));
			LICENCEPLATEJURISDICTIONID.getLabels().add(new Label("SHORTLABEL","es_ES","Jurisdicci??n"));
		fields.add(LICENCEPLATEJURISDICTIONID);
		{
			LICENCEPLATEJURISDICTIONID.setDataType(MTDataTypes.INT);
			LICENCEPLATEJURISDICTIONID.setNullable(true);
			LICENCEPLATEJURISDICTIONID.setTransient(false);
		}
		LICENSEPLATETYPEID = new MTField(MTTableLICENSEPLATE.LICENSEPLATETYPEID,"licensePlateTypeId");
			LICENSEPLATETYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Plate Type"));
			LICENSEPLATETYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo de Placa"));
		fields.add(LICENSEPLATETYPEID);
		{
			LICENSEPLATETYPEID.setDataType(MTDataTypes.INT);
			LICENSEPLATETYPEID.setNullable(true);
			LICENSEPLATETYPEID.setTransient(false);
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
	}

	public MTTableVDETAILPAGEVEHICLELIST(){
		init();
		this.tableName = "VDetailPageVehicleList";
		this.schema = "crm";
		this.entityType = "VIEW";
		this.primaryKeys.add(VEHICLEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}