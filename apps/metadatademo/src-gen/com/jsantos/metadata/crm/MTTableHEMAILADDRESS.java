package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableHEMAILADDRESS extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField EMAILADDRESSID = new MTField("emailAddressId");
	public static final MTField ADDRESS = new MTField("address");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(EMAILADDRESSID);
		{
			EMAILADDRESSID.setDataType(MTDataTypes.INT);
			EMAILADDRESSID.setNullable(false);
			EMAILADDRESSID.setTransient(false);
			EMAILADDRESSID.getStereoTypes().add("AUTOHISTORYMAINFK");
		}
		fields.add(ADDRESS);
		{
			ADDRESS.setDataType(MTDataTypes.EMAIL);
			ADDRESS.setLength(64);
			ADDRESS.setNullable(false);
			ADDRESS.setTransient(false);
			ADDRESS.getLabels().add(new Label("SHORTLABEL","en_EN","email"));
			ADDRESS.getLabels().add(new Label("SHORTLABEL","es_ES","email"));
			ADDRESS.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("crm.Seq_HEmailAddress_revisionId");
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

	public MTTableHEMAILADDRESS(){
		init();
		this.tableName = "HEmailAddress";
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