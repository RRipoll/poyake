package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.tolling.MTTablePROBLEMATICPLATE;
import com.jsantos.metadata.tolling.MTTableLICENSEPLATE;
import com.jsantos.metadata.tolling.MTTableCUSTOMERVEHICLE;

public class MTTableVPROBLEMATICPLATE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField PROBLEMATICPLATEID;
	public static MTField LICENCEPLATEJURISDICTIONID;
	public static MTField LPNUMBER;
	public static MTField CUSTOMERID;
	public static MTField PROBLEMATICPLATEREASONID;
	public static MTField NOTES;

	public static void init(){
		fields = new ArrayList<>();
		PROBLEMATICPLATEID = new MTField(MTTablePROBLEMATICPLATE.PROBLEMATICPLATEID,"problematicPlateId");
		fields.add(PROBLEMATICPLATEID);
		{
			PROBLEMATICPLATEID.setDataType(MTDataTypes.INT);
			PROBLEMATICPLATEID.setNullable(true);
			PROBLEMATICPLATEID.setTransient(false);
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
		CUSTOMERID = new MTField(MTTableCUSTOMERVEHICLE.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
		PROBLEMATICPLATEREASONID = new MTField(MTTablePROBLEMATICPLATE.PROBLEMATICPLATEREASONID,"problematicPlateReasonId");
		fields.add(PROBLEMATICPLATEREASONID);
		{
			PROBLEMATICPLATEREASONID.setDataType(MTDataTypes.INT);
			PROBLEMATICPLATEREASONID.setNullable(true);
			PROBLEMATICPLATEREASONID.setTransient(false);
		}
		NOTES = new MTField(MTTablePROBLEMATICPLATE.NOTES,"notes");
		fields.add(NOTES);
		{
			NOTES.setDataType(MTDataTypes.VARCHAR);
			NOTES.setLength(512);
			NOTES.setNullable(true);
			NOTES.setTransient(false);
		}
	}

	public MTTableVPROBLEMATICPLATE(){
		init();
		this.tableName = "VProblematicPlate";
		this.schema = "tolling";
		this.entityType = "VIEW";
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}