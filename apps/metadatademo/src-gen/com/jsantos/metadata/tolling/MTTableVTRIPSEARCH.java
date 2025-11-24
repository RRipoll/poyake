package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.tolling.MTTableTRIPINFO;
import com.jsantos.metadata.tolling.MTTableLICENSEPLATE;

public class MTTableVTRIPSEARCH extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField TRIPID;
	public static MTField FAREAMOUNT;
	public static MTField LANEENTRYDATE;
	public static MTField LANEEXITDATE;
	public static MTField LICENCEPLATEJURISDICTIONID;
	public static MTField LPNUMBER;
	public static MTField LICENSEPLATETYPEID;
	public static MTField PASSID;

	public static void init(){
		fields = new ArrayList<>();
		TRIPID = new MTField(MTTableTRIPINFO.TRIPID,"tripId");
			TRIPID.getLabels().add(new Label("SHORTLABEL","en_EN","Trip #"));
			TRIPID.getLabels().add(new Label("SHORTLABEL","es_ES","# Tr??nsito"));
		fields.add(TRIPID);
		{
			TRIPID.setDataType(MTDataTypes.INT);
			TRIPID.setNullable(true);
			TRIPID.setTransient(false);
			TRIPID.setSequence("tolling.Seq_VTripSearch_tripId");
			TRIPID.setPrimaryKey(true);
		}
		FAREAMOUNT = new MTField(MTTableTRIPINFO.FAREAMOUNT,"fareAmount");
			FAREAMOUNT.getLabels().add(new Label("SHORTLABEL","en_EN","Amount"));
			FAREAMOUNT.getLabels().add(new Label("SHORTLABEL","es_ES","Cantidad"));
		fields.add(FAREAMOUNT);
		{
			FAREAMOUNT.setDataType(MTDataTypes.MONEY);
			FAREAMOUNT.setScale(2);
			FAREAMOUNT.setLength(8);
			FAREAMOUNT.setNullable(true);
			FAREAMOUNT.setTransient(false);
		}
		LANEENTRYDATE = new MTField(MTTableTRIPINFO.LANEENTRYDATE,"laneEntryDate");
			LANEENTRYDATE.getLabels().add(new Label("SHORTLABEL","en_EN","Lane Entry Date"));
			LANEENTRYDATE.getLabels().add(new Label("SHORTLABEL","es_ES","Fecha de Entrada"));
		fields.add(LANEENTRYDATE);
		{
			LANEENTRYDATE.setDataType(MTDataTypes.DATE);
			LANEENTRYDATE.setNullable(true);
			LANEENTRYDATE.setTransient(false);
		}
		LANEEXITDATE = new MTField(MTTableTRIPINFO.LANEEXITDATE,"laneExitDate");
			LANEEXITDATE.getLabels().add(new Label("SHORTLABEL","en_EN","Lane Exit Date"));
			LANEEXITDATE.getLabels().add(new Label("SHORTLABEL","es_ES","Fecha de Salida"));
		fields.add(LANEEXITDATE);
		{
			LANEEXITDATE.setDataType(MTDataTypes.DATE);
			LANEEXITDATE.setNullable(true);
			LANEEXITDATE.setTransient(false);
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
		LICENSEPLATETYPEID = new MTField(MTTableLICENSEPLATE.LICENSEPLATETYPEID,"licensePlatetypeId");
			LICENSEPLATETYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Plate Type"));
			LICENSEPLATETYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo de Placa"));
		fields.add(LICENSEPLATETYPEID);
		{
			LICENSEPLATETYPEID.setDataType(MTDataTypes.INT);
			LICENSEPLATETYPEID.setNullable(true);
			LICENSEPLATETYPEID.setTransient(false);
		}
		PASSID = new MTField(MTTableTRIPINFO.PASSID,"passId");
		fields.add(PASSID);
		{
			PASSID.setDataType(MTDataTypes.INT);
			PASSID.setNullable(true);
			PASSID.setTransient(false);
		}
	}

	public MTTableVTRIPSEARCH(){
		init();
		this.tableName = "VTripSearch";
		this.schema = "tolling";
		this.entityType = "VIEW";
		this.primaryKeys.add(TRIPID);
		this.getLabels().add(new Label("SHORTLABEL","en_EN","Trip"));
		this.getLabels().add(new Label("SHORTLABEL","es_ES","Tr??nsito"));
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}