package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableHPOSTALADDRESS extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField POSTALADDRESSID = new MTField("postalAddressId");
	public static final MTField ADDRESS1 = new MTField("address1");
	public static final MTField ADDRESS2 = new MTField("address2");
	public static final MTField CITY = new MTField("city");
	public static final MTField STATEPROVINCEID = new MTField("stateProvinceId");
	public static final MTField POSTALCODE = new MTField("postalCode");
	public static final MTField BARCODE = new MTField("barcode");
	public static final MTField COORDINATES = new MTField("coordinates");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(POSTALADDRESSID);
		{
			POSTALADDRESSID.setDataType(MTDataTypes.INT);
			POSTALADDRESSID.setNullable(true);
			POSTALADDRESSID.setTransient(false);
			POSTALADDRESSID.getStereoTypes().add("AUTOHISTORYMAINFK");
		}
		fields.add(ADDRESS1);
		{
			ADDRESS1.setDataType(MTDataTypes.VARCHAR);
			ADDRESS1.setLength(256);
			ADDRESS1.setNullable(true);
			ADDRESS1.setTransient(false);
			ADDRESS1.getLabels().add(new Label("SHORTLABEL","es_ES","Dirección"));
		}
		fields.add(ADDRESS2);
		{
			ADDRESS2.setDataType(MTDataTypes.VARCHAR);
			ADDRESS2.setLength(256);
			ADDRESS2.setNullable(true);
			ADDRESS2.setTransient(false);
			ADDRESS2.getLabels().add(new Label("SHORTLABEL","es_ES","Piso y letra"));
		}
		fields.add(CITY);
		{
			CITY.setDataType(MTDataTypes.VARCHAR);
			CITY.setLength(64);
			CITY.setNullable(true);
			CITY.setTransient(false);
			CITY.getLabels().add(new Label("SHORTLABEL","es_ES","Ciudad"));
		}
		fields.add(STATEPROVINCEID);
		{
			STATEPROVINCEID.setDataType(MTDataTypes.INT);
			STATEPROVINCEID.setNullable(false);
			STATEPROVINCEID.setTransient(false);
			STATEPROVINCEID.getLabels().add(new Label("SHORTLABEL","en_EN","State"));
			STATEPROVINCEID.getLabels().add(new Label("SHORTLABEL","es_ES","Provincia"));
			STATEPROVINCEID.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(POSTALCODE);
		{
			POSTALCODE.setDataType(MTDataTypes.VARCHAR);
			POSTALCODE.setLength(10);
			POSTALCODE.setNullable(true);
			POSTALCODE.setTransient(false);
			POSTALCODE.getLabels().add(new Label("SHORTLABEL","en_EN","Postal Code"));
			POSTALCODE.getLabels().add(new Label("SHORTLABEL","es_ES","Código Postal"));
			POSTALCODE.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(BARCODE);
		{
			BARCODE.setDataType(MTDataTypes.VARCHAR);
			BARCODE.setLength(20);
			BARCODE.setNullable(true);
			BARCODE.setTransient(false);
		}
		fields.add(COORDINATES);
		{
			COORDINATES.setDataType(MTDataTypes.VARCHAR);
			COORDINATES.setLength(64);
			COORDINATES.setNullable(true);
			COORDINATES.setTransient(false);
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("crm.Seq_HPostalAddress_revisionId");
			REVISIONID.getStereoTypes().add("NOGUIINPUT");
			REVISIONID.setPrimaryKey(true);
		}
		fields.add(STARTDATE);
		{
			STARTDATE.setDataType(MTDataTypes.DATETIME);
			STARTDATE.setNullable(false);
			STARTDATE.setTransient(false);
			STARTDATE.getStereoTypes().add("NOGUIINPUT");
			STARTDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(ENDDATE);
		{
			ENDDATE.setDataType(MTDataTypes.DATETIME);
			ENDDATE.setNullable(false);
			ENDDATE.setTransient(false);
			ENDDATE.getStereoTypes().add("NOGUIINPUT");
			ENDDATE.setDefaultValue("'2099-01-01'");
		}
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(false);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.getStereoTypes().add("NOGUIINPUT");
			INPUTUSERID.setDefaultValue("1");
		}
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(false);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.getStereoTypes().add("NOGUIINPUT");
			INPUTSOURCEID.setDefaultValue("1");
		}
	}

	public MTTableHPOSTALADDRESS(){
		init();
		this.tableName = "HPostalAddress";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(REVISIONID);
		this.patterns.add("AutoHistory");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}