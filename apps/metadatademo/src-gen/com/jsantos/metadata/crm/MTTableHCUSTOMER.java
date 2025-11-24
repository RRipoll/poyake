package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableHCUSTOMER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERID = new MTField("customerId");
	public static final MTField MAINCONTACTPERSONORCOMPANYID = new MTField("mainContactPersonOrCompanyId");
	public static final MTField MAILINGPOSTALADDRESSID = new MTField("mailingPostalAddressId");
	public static final MTField SHIPPINGPOSTALADDRESSID = new MTField("shippingPostalAddressId");
	public static final MTField CUSTOMERTYPEID = new MTField("customerTypeId");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(false);
			CUSTOMERID.setTransient(false);
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","en_EN","Customer #"));
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Cuenta"));
			CUSTOMERID.getStereoTypes().add("AUTOHISTORYMAINFK");
		}
		fields.add(MAINCONTACTPERSONORCOMPANYID);
		{
			MAINCONTACTPERSONORCOMPANYID.setDataType(MTDataTypes.INT);
			MAINCONTACTPERSONORCOMPANYID.setNullable(false);
			MAINCONTACTPERSONORCOMPANYID.setTransient(false);
			MAINCONTACTPERSONORCOMPANYID.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(MAILINGPOSTALADDRESSID);
		{
			MAILINGPOSTALADDRESSID.setDataType(MTDataTypes.INT);
			MAILINGPOSTALADDRESSID.setNullable(true);
			MAILINGPOSTALADDRESSID.setTransient(false);
		}
		fields.add(SHIPPINGPOSTALADDRESSID);
		{
			SHIPPINGPOSTALADDRESSID.setDataType(MTDataTypes.INT);
			SHIPPINGPOSTALADDRESSID.setNullable(true);
			SHIPPINGPOSTALADDRESSID.setTransient(false);
		}
		fields.add(CUSTOMERTYPEID);
		{
			CUSTOMERTYPEID.setDataType(MTDataTypes.INT);
			CUSTOMERTYPEID.setNullable(false);
			CUSTOMERTYPEID.setTransient(false);
			CUSTOMERTYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Customer Type"));
			CUSTOMERTYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo de Cuenta"));
			CUSTOMERTYPEID.setDefaultValue("1");
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("crm.Seq_HCustomer_revisionId");
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

	public MTTableHCUSTOMER(){
		init();
		this.tableName = "HCustomer";
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