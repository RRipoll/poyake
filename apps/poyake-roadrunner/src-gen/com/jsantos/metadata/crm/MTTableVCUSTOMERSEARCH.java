package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.crm.MTTableHCUSTOMER;
import com.jsantos.metadata.crm.MTTableHPERSONORCOMPANY;
import com.jsantos.metadata.crm.MTTableHPHONENUMBER;
import com.jsantos.metadata.crm.MTTableHEMAILADDRESS;
import com.jsantos.metadata.inv.MTTableINVOICE;

public class MTTableVCUSTOMERSEARCH extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField CUSTOMERID;
	public static MTField CUSTOMERTYPEID;
	public static final MTField FULLNAME = new MTField("fullName");
	public static final MTField MAILINGADDRESS = new MTField("mailingAddress");
	public static MTField FIRSTNAME;
	public static MTField LASTNAMEORCOMPANYNAME;
	public static MTField NUMBER;
	public static MTField ADDRESS;
	public static final MTField LASTINVOICE = new MTField("lastInvoice");
	public static MTField LASTINVOICEID;

	public static void init(){
		fields = new ArrayList<>();
		CUSTOMERID = new MTField(MTTableHCUSTOMER.CUSTOMERID,"customerId");
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","en_EN","Customer #"));
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Cuenta"));
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
			CUSTOMERID.setSequence("crm.Seq_VCustomerSearch_customerId");
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","en_EN","Customer #"));
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Cuenta"));
			CUSTOMERID.setPrimaryKey(true);
		}
		CUSTOMERTYPEID = new MTField(MTTableHCUSTOMER.CUSTOMERTYPEID,"customerTypeId");
			CUSTOMERTYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Customer Type"));
			CUSTOMERTYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo de Cuenta"));
		fields.add(CUSTOMERTYPEID);
		{
			CUSTOMERTYPEID.setDataType(MTDataTypes.INT);
			CUSTOMERTYPEID.setNullable(true);
			CUSTOMERTYPEID.setTransient(false);
		}
		fields.add(FULLNAME);
		{
			FULLNAME.setDataType(MTDataTypes.VARCHAR);
			FULLNAME.setLength(256);
			FULLNAME.setNullable(true);
			FULLNAME.setTransient(false);
			FULLNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Full Name"));
			FULLNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre Completo"));
			FULLNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(MAILINGADDRESS);
		{
			MAILINGADDRESS.setDataType(MTDataTypes.VARCHAR);
			MAILINGADDRESS.setLength(256);
			MAILINGADDRESS.setNullable(true);
			MAILINGADDRESS.setTransient(false);
			MAILINGADDRESS.getLabels().add(new Label("SHORTLABEL","en_EN","Mailing Address"));
			MAILINGADDRESS.getLabels().add(new Label("SHORTLABEL","es_ES","Direcci??n"));
		}
		FIRSTNAME = new MTField(MTTableHPERSONORCOMPANY.FIRSTNAME,"firstName");
			FIRSTNAME.getLabels().add(new Label("SHORTLABEL","en_EN","First Name"));
			FIRSTNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre"));
		fields.add(FIRSTNAME);
		{
			FIRSTNAME.setDataType(MTDataTypes.VARCHAR);
			FIRSTNAME.setLength(64);
			FIRSTNAME.setNullable(true);
			FIRSTNAME.setTransient(false);
		}
		LASTNAMEORCOMPANYNAME = new MTField(MTTableHPERSONORCOMPANY.LASTNAMEORCOMPANYNAME,"lastNameOrCompanyName");
			LASTNAMEORCOMPANYNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Last Name"));
			LASTNAMEORCOMPANYNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Apellido"));
			LASTNAMEORCOMPANYNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Apellido o Nombre de Empresa"));
		fields.add(LASTNAMEORCOMPANYNAME);
		{
			LASTNAMEORCOMPANYNAME.setDataType(MTDataTypes.VARCHAR);
			LASTNAMEORCOMPANYNAME.setLength(64);
			LASTNAMEORCOMPANYNAME.setNullable(true);
			LASTNAMEORCOMPANYNAME.setTransient(false);
		}
		NUMBER = new MTField(MTTableHPHONENUMBER.NUMBER,"number");
			NUMBER.getLabels().add(new Label("SHORTLABEL","es_ES","Número Tlfn"));
		fields.add(NUMBER);
		{
			NUMBER.setDataType(MTDataTypes.VARCHAR);
			NUMBER.setLength(14);
			NUMBER.setNullable(true);
			NUMBER.setTransient(false);
		}
		ADDRESS = new MTField(MTTableHEMAILADDRESS.ADDRESS,"address");
			ADDRESS.getLabels().add(new Label("SHORTLABEL","en_EN","email"));
			ADDRESS.getLabels().add(new Label("SHORTLABEL","es_ES","email"));
		fields.add(ADDRESS);
		{
			ADDRESS.setDataType(MTDataTypes.VARCHAR);
			ADDRESS.setLength(64);
			ADDRESS.setNullable(true);
			ADDRESS.setTransient(false);
		}
		fields.add(LASTINVOICE);
		{
			LASTINVOICE.setDataType(MTDataTypes.VARCHAR);
			LASTINVOICE.setLength(256);
			LASTINVOICE.setNullable(true);
			LASTINVOICE.setTransient(false);
		}
		LASTINVOICEID = new MTField(MTTableINVOICE.INVOICEID,"lastInvoiceId");
		fields.add(LASTINVOICEID);
		{
			LASTINVOICEID.setDataType(MTDataTypes.INT);
			LASTINVOICEID.setNullable(true);
			LASTINVOICEID.setTransient(false);
		}
	}

	public MTTableVCUSTOMERSEARCH(){
		init();
		this.tableName = "VCustomerSearch";
		this.schema = "crm";
		this.entityType = "VIEW";
		this.primaryKeys.add(CUSTOMERID);
		this.getLabels().add(new Label("SHORTLABEL","en_EN","Account"));
		this.getLabels().add(new Label("SHORTLABEL","es_ES","Cuenta"));
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}