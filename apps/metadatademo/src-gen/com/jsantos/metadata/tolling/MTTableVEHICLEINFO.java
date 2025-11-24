package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableVEHICLEINFO extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField VEHICLEID = new MTField("vehicleId");
	public static final MTField LICENSEPLATEID = new MTField("licensePlateId");
	public static final MTField COLOR = new MTField("color");
	public static final MTField MAKE = new MTField("make");
	public static final MTField MODEL = new MTField("model");
	public static final MTField VEHICLECLASSID = new MTField("vehicleClassId");
	public static final MTField STYLE = new MTField("style");
	public static final MTField AXLES = new MTField("axles");
	public static final MTField MODELYEAR = new MTField("modelYear");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(VEHICLEID);
		{
			VEHICLEID.setDataType(MTDataTypes.INT);
			VEHICLEID.setNullable(false);
			VEHICLEID.setTransient(false);
			VEHICLEID.getLabels().add(new Label("SHORTLABEL","en_EN","Vehicle #"));
			VEHICLEID.getLabels().add(new Label("SHORTLABEL","es_ES","# Veh??culo"));
			VEHICLEID.getStereoTypes().add("AUTOHISTORYMAINFK");
			VEHICLEID.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(LICENSEPLATEID);
		{
			LICENSEPLATEID.setDataType(MTDataTypes.INT);
			LICENSEPLATEID.setNullable(false);
			LICENSEPLATEID.setTransient(false);
			LICENSEPLATEID.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(COLOR);
		{
			COLOR.setDataType(MTDataTypes.VARCHAR);
			COLOR.setLength(100);
			COLOR.setNullable(true);
			COLOR.setTransient(false);
		}
		fields.add(MAKE);
		{
			MAKE.setDataType(MTDataTypes.VARCHAR);
			MAKE.setLength(255);
			MAKE.setNullable(true);
			MAKE.setTransient(false);
			MAKE.getLabels().add(new Label("SHORTLABEL","es_ES","Fabricante"));
		}
		fields.add(MODEL);
		{
			MODEL.setDataType(MTDataTypes.VARCHAR);
			MODEL.setLength(255);
			MODEL.setNullable(true);
			MODEL.setTransient(false);
			MODEL.getLabels().add(new Label("SHORTLABEL","es_ES","Modelo"));
		}
		fields.add(VEHICLECLASSID);
		{
			VEHICLECLASSID.setDataType(MTDataTypes.INT);
			VEHICLECLASSID.setNullable(true);
			VEHICLECLASSID.setTransient(false);
			VEHICLECLASSID.getLabels().add(new Label("SHORTLABEL","en_EN","Class"));
			VEHICLECLASSID.getLabels().add(new Label("SHORTLABEL","es_ES","Clase"));
		}
		fields.add(STYLE);
		{
			STYLE.setDataType(MTDataTypes.VARCHAR);
			STYLE.setLength(20);
			STYLE.setNullable(true);
			STYLE.setTransient(false);
			STYLE.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo"));
		}
		fields.add(AXLES);
		{
			AXLES.setDataType(MTDataTypes.INT);
			AXLES.setNullable(true);
			AXLES.setTransient(false);
			AXLES.getLabels().add(new Label("SHORTLABEL","es_ES","Ejes"));
		}
		fields.add(MODELYEAR);
		{
			MODELYEAR.setDataType(MTDataTypes.INT);
			MODELYEAR.setNullable(true);
			MODELYEAR.setTransient(false);
			MODELYEAR.getLabels().add(new Label("SHORTLABEL","en_EN","Model Year"));
			MODELYEAR.getLabels().add(new Label("SHORTLABEL","es_ES","A??o"));
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("tolling.Seq_VehicleInfo_revisionId");
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

	public MTTableVEHICLEINFO(){
		init();
		this.tableName = "VehicleInfo";
		this.schema = "tolling";
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