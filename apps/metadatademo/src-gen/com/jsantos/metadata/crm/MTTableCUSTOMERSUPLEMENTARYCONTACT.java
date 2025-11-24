package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableCUSTOMERSUPLEMENTARYCONTACT extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERID = new MTField("customerId");
	public static final MTField PERSONORCOMPANYID = new MTField("personOrCompanyId");
	public static final MTField CONTACTTYPEID = new MTField("contactTypeId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
			CUSTOMERID.setPrimaryKey(true);
		}
		fields.add(PERSONORCOMPANYID);
		{
			PERSONORCOMPANYID.setDataType(MTDataTypes.INT);
			PERSONORCOMPANYID.setNullable(true);
			PERSONORCOMPANYID.setTransient(false);
			PERSONORCOMPANYID.setPrimaryKey(true);
		}
		fields.add(CONTACTTYPEID);
		{
			CONTACTTYPEID.setDataType(MTDataTypes.INT);
			CONTACTTYPEID.setNullable(true);
			CONTACTTYPEID.setTransient(false);
		}
	}

	public MTTableCUSTOMERSUPLEMENTARYCONTACT(){
		init();
		this.tableName = "CustomerSuplementaryContact";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(CUSTOMERID);
		this.primaryKeys.add(PERSONORCOMPANYID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}