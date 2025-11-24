package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableHPERSONORCOMPANY extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PERSONORCOMPANYID = new MTField("personOrCompanyId");
	public static final MTField ISCOMPANY = new MTField("isCompany");
	public static final MTField SALUTATION = new MTField("salutation");
	public static final MTField FIRSTNAME = new MTField("firstName");
	public static final MTField MIDDLENAME = new MTField("middleName");
	public static final MTField LASTNAMEORCOMPANYNAME = new MTField("lastNameOrCompanyName");
	public static final MTField SUFFIX = new MTField("suffix");
	public static final MTField DESIGNATION = new MTField("designation");
	public static final MTField DOINGBUSINESSAS = new MTField("doingBusinessAs");
	public static final MTField PHONENUMBERID = new MTField("phoneNumberId");
	public static final MTField EMAILADDRESSID = new MTField("emailAddressId");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PERSONORCOMPANYID);
		{
			PERSONORCOMPANYID.setDataType(MTDataTypes.INT);
			PERSONORCOMPANYID.setNullable(true);
			PERSONORCOMPANYID.setTransient(false);
			PERSONORCOMPANYID.getStereoTypes().add("AUTOHISTORYMAINFK");
		}
		fields.add(ISCOMPANY);
		{
			ISCOMPANY.setDataType(MTDataTypes.BIT);
			ISCOMPANY.setNullable(false);
			ISCOMPANY.setTransient(false);
			ISCOMPANY.setDefaultValue("0");
		}
		fields.add(SALUTATION);
		{
			SALUTATION.setDataType(MTDataTypes.VARCHAR);
			SALUTATION.setLength(6);
			SALUTATION.setNullable(true);
			SALUTATION.setTransient(false);
			SALUTATION.getLabels().add(new Label("SHORTLABEL","es_ES","Saludo"));
		}
		fields.add(FIRSTNAME);
		{
			FIRSTNAME.setDataType(MTDataTypes.VARCHAR);
			FIRSTNAME.setLength(64);
			FIRSTNAME.setNullable(true);
			FIRSTNAME.setTransient(false);
			FIRSTNAME.getLabels().add(new Label("SHORTLABEL","en_EN","First Name"));
			FIRSTNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre"));
			FIRSTNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(MIDDLENAME);
		{
			MIDDLENAME.setDataType(MTDataTypes.VARCHAR);
			MIDDLENAME.setLength(64);
			MIDDLENAME.setNullable(true);
			MIDDLENAME.setTransient(false);
			MIDDLENAME.getLabels().add(new Label("SHORTLABEL","es_ES","Segundo Nombre"));
		}
		fields.add(LASTNAMEORCOMPANYNAME);
		{
			LASTNAMEORCOMPANYNAME.setDataType(MTDataTypes.VARCHAR);
			LASTNAMEORCOMPANYNAME.setLength(64);
			LASTNAMEORCOMPANYNAME.setNullable(false);
			LASTNAMEORCOMPANYNAME.setTransient(false);
			LASTNAMEORCOMPANYNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Last Name"));
			LASTNAMEORCOMPANYNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Apellido"));
			LASTNAMEORCOMPANYNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Apellido o Nombre de Empresa"));
			LASTNAMEORCOMPANYNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(SUFFIX);
		{
			SUFFIX.setDataType(MTDataTypes.VARCHAR);
			SUFFIX.setLength(6);
			SUFFIX.setNullable(true);
			SUFFIX.setTransient(false);
			SUFFIX.getLabels().add(new Label("SHORTLABEL","es_ES","Sufijo"));
		}
		fields.add(DESIGNATION);
		{
			DESIGNATION.setDataType(MTDataTypes.VARCHAR);
			DESIGNATION.setLength(64);
			DESIGNATION.setNullable(true);
			DESIGNATION.setTransient(false);
		}
		fields.add(DOINGBUSINESSAS);
		{
			DOINGBUSINESSAS.setDataType(MTDataTypes.VARCHAR);
			DOINGBUSINESSAS.setLength(128);
			DOINGBUSINESSAS.setNullable(true);
			DOINGBUSINESSAS.setTransient(false);
		}
		fields.add(PHONENUMBERID);
		{
			PHONENUMBERID.setDataType(MTDataTypes.INT);
			PHONENUMBERID.setNullable(true);
			PHONENUMBERID.setTransient(false);
		}
		fields.add(EMAILADDRESSID);
		{
			EMAILADDRESSID.setDataType(MTDataTypes.INT);
			EMAILADDRESSID.setNullable(true);
			EMAILADDRESSID.setTransient(false);
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("crm.Seq_HPersonOrCompany_revisionId");
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

	public MTTableHPERSONORCOMPANY(){
		init();
		this.tableName = "HPersonOrCompany";
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