package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableTRIPINFO extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField TRIPID = new MTField("tripId");
	public static final MTField FAREAMOUNT = new MTField("fareAmount");
	public static final MTField LANEEXITDATE = new MTField("laneExitDate");
	public static final MTField GANTRYID = new MTField("gantryId");
	public static final MTField LANEENTRYDATE = new MTField("laneEntryDate");
	public static final MTField LICENSEPLATEID = new MTField("licensePlateId");
	public static final MTField PASSID = new MTField("passId");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(TRIPID);
		{
			TRIPID.setDataType(MTDataTypes.INT);
			TRIPID.setNullable(false);
			TRIPID.setTransient(false);
			TRIPID.getLabels().add(new Label("SHORTLABEL","en_EN","Trip #"));
			TRIPID.getLabels().add(new Label("SHORTLABEL","es_ES","# Tr??nsito"));
			TRIPID.getStereoTypes().add("AUTOHISTORYMAINFK");
		}
		fields.add(FAREAMOUNT);
		{
			FAREAMOUNT.setDataType(MTDataTypes.MONEY);
			FAREAMOUNT.setScale(2);
			FAREAMOUNT.setLength(8);
			FAREAMOUNT.setNullable(false);
			FAREAMOUNT.setTransient(false);
			FAREAMOUNT.getLabels().add(new Label("SHORTLABEL","en_EN","Amount"));
			FAREAMOUNT.getLabels().add(new Label("SHORTLABEL","es_ES","Cantidad"));
		}
		fields.add(LANEEXITDATE);
		{
			LANEEXITDATE.setDataType(MTDataTypes.DATE);
			LANEEXITDATE.setNullable(false);
			LANEEXITDATE.setTransient(false);
			LANEEXITDATE.getLabels().add(new Label("SHORTLABEL","en_EN","Lane Exit Date"));
			LANEEXITDATE.getLabels().add(new Label("SHORTLABEL","es_ES","Fecha de Salida"));
		}
		fields.add(GANTRYID);
		{
			GANTRYID.setDataType(MTDataTypes.INT);
			GANTRYID.setNullable(false);
			GANTRYID.setTransient(false);
		}
		fields.add(LANEENTRYDATE);
		{
			LANEENTRYDATE.setDataType(MTDataTypes.DATE);
			LANEENTRYDATE.setNullable(true);
			LANEENTRYDATE.setTransient(false);
			LANEENTRYDATE.getLabels().add(new Label("SHORTLABEL","en_EN","Lane Entry Date"));
			LANEENTRYDATE.getLabels().add(new Label("SHORTLABEL","es_ES","Fecha de Entrada"));
		}
		fields.add(LICENSEPLATEID);
		{
			LICENSEPLATEID.setDataType(MTDataTypes.INT);
			LICENSEPLATEID.setNullable(true);
			LICENSEPLATEID.setTransient(false);
		}
		fields.add(PASSID);
		{
			PASSID.setDataType(MTDataTypes.INT);
			PASSID.setNullable(true);
			PASSID.setTransient(false);
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("tolling.Seq_TripInfo_revisionId");
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

	public MTTableTRIPINFO(){
		init();
		this.tableName = "TripInfo";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(REVISIONID);
		this.patterns.add("AutoHistory");
		this.getLabels().add(new Label("SHORTLABEL","en_EN","Trip"));
		this.getLabels().add(new Label("SHORTLABEL","es_ES","Tr??nsito"));
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}