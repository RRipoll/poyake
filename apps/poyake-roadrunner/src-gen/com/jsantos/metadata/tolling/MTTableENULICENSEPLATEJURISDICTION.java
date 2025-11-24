package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENULICENSEPLATEJURISDICTION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField LICENSEPLATEJURISDICTIONID = new MTField("licensePlateJurisdictionId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField STATEORPROVICEID = new MTField("stateOrProviceId");
	public static final MTField COUNTRYID = new MTField("countryId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(LICENSEPLATEJURISDICTIONID);
		{
			LICENSEPLATEJURISDICTIONID.setDataType(MTDataTypes.INT);
			LICENSEPLATEJURISDICTIONID.setNullable(true);
			LICENSEPLATEJURISDICTIONID.setTransient(false);
			LICENSEPLATEJURISDICTIONID.setSequence("tolling.Seq_EnuLicensePlateJurisdiction_licensePlateJurisdictionId");
			LICENSEPLATEJURISDICTIONID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
			SHORTCODE.getLabels().add(new Label("SHORTLABEL","en_EN","Jurisdiction"));
			SHORTCODE.getLabels().add(new Label("SHORTLABEL","es_ES","Jurisdicci??n"));
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(STATEORPROVICEID);
		{
			STATEORPROVICEID.setDataType(MTDataTypes.INT);
			STATEORPROVICEID.setNullable(true);
			STATEORPROVICEID.setTransient(false);
		}
		fields.add(COUNTRYID);
		{
			COUNTRYID.setDataType(MTDataTypes.INT);
			COUNTRYID.setNullable(false);
			COUNTRYID.setTransient(false);
		}
	}

	public MTTableENULICENSEPLATEJURISDICTION(){
		init();
		this.tableName = "EnuLicensePlateJurisdiction";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(LICENSEPLATEJURISDICTIONID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuLicensePlateJurisdiction();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}