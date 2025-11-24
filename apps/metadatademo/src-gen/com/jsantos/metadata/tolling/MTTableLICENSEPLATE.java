package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableLICENSEPLATE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField LICENSEPLATEID = new MTField("licensePlateId");
	public static final MTField LICENCEPLATEJURISDICTIONID = new MTField("licencePlateJurisdictionId");
	public static final MTField LPNUMBER = new MTField("lpnumber");
	public static final MTField LICENSEPLATETYPEID = new MTField("licensePlatetypeId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(LICENSEPLATEID);
		{
			LICENSEPLATEID.setDataType(MTDataTypes.INT);
			LICENSEPLATEID.setNullable(true);
			LICENSEPLATEID.setTransient(false);
			LICENSEPLATEID.setSequence("tolling.Seq_LicensePlate_licensePlateId");
			LICENSEPLATEID.setPrimaryKey(true);
		}
		fields.add(LICENCEPLATEJURISDICTIONID);
		{
			LICENCEPLATEJURISDICTIONID.setDataType(MTDataTypes.INT);
			LICENCEPLATEJURISDICTIONID.setNullable(false);
			LICENCEPLATEJURISDICTIONID.setTransient(false);
			LICENCEPLATEJURISDICTIONID.getLabels().add(new Label("SHORTLABEL","en_EN","Jurisdiction"));
			LICENCEPLATEJURISDICTIONID.getLabels().add(new Label("SHORTLABEL","es_ES","Jurisdicci??n"));
		}
		fields.add(LPNUMBER);
		{
			LPNUMBER.setDataType(MTDataTypes.VARCHAR);
			LPNUMBER.setLength(16);
			LPNUMBER.setNullable(false);
			LPNUMBER.setTransient(false);
			LPNUMBER.getLabels().add(new Label("SHORTLABEL","en_EN","License Plate #"));
			LPNUMBER.getLabels().add(new Label("SHORTLABEL","es_ES","Matr??cula"));
			LPNUMBER.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(LICENSEPLATETYPEID);
		{
			LICENSEPLATETYPEID.setDataType(MTDataTypes.INT);
			LICENSEPLATETYPEID.setNullable(false);
			LICENSEPLATETYPEID.setTransient(false);
			LICENSEPLATETYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Plate Type"));
			LICENSEPLATETYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo de Placa"));
		}
	}

	public MTTableLICENSEPLATE(){
		init();
		this.tableName = "LicensePlate";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(LICENSEPLATEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}