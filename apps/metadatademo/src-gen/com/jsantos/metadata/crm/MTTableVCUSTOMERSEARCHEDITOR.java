package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.crm.MTTableHCUSTOMER;
import com.jsantos.metadata.crm.MTTableHPHONENUMBER;
import com.jsantos.metadata.crm.MTTableHEMAILADDRESS;

public class MTTableVCUSTOMERSEARCHEDITOR extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField CUSTOMERID;
	public static MTField CUSTOMERTYPEID;
	public static final MTField FULLNAME = new MTField("fullName");
	public static final MTField MAILINGADDRESS = new MTField("mailingAddress");
	public static MTField PHONENUMER;
	public static MTField EMAIL;

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
			CUSTOMERID.setSequence("crm.Seq_VCustomerSearchEditor_customerId");
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
			FULLNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(MAILINGADDRESS);
		{
			MAILINGADDRESS.setDataType(MTDataTypes.VARCHAR);
			MAILINGADDRESS.setNullable(true);
			MAILINGADDRESS.setTransient(false);
		}
		PHONENUMER = new MTField(MTTableHPHONENUMBER.NUMBER,"phonenumer");
			PHONENUMER.getLabels().add(new Label("SHORTLABEL","es_ES","N??mero Tlfn"));
		fields.add(PHONENUMER);
		{
			PHONENUMER.setDataType(MTDataTypes.VARCHAR);
			PHONENUMER.setLength(14);
			PHONENUMER.setNullable(true);
			PHONENUMER.setTransient(false);
		}
		EMAIL = new MTField(MTTableHEMAILADDRESS.ADDRESS,"email");
			EMAIL.getLabels().add(new Label("SHORTLABEL","en_EN","email"));
			EMAIL.getLabels().add(new Label("SHORTLABEL","es_ES","email"));
		fields.add(EMAIL);
		{
			EMAIL.setDataType(MTDataTypes.EMAIL);
			EMAIL.setLength(64);
			EMAIL.setNullable(true);
			EMAIL.setTransient(false);
		}
	}

	public MTTableVCUSTOMERSEARCHEDITOR(){
		init();
		this.tableName = "VCustomerSearchEditor";
		this.schema = "crm";
		this.entityType = "VIEW";
		this.primaryKeys.add(CUSTOMERID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}