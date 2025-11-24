package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableVCUSTOMERHISTORY extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField OBJECTTYPE = new MTField("objectType");
	public static final MTField ACTION = new MTField("action");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField ID = new MTField("id");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField PREVREVISIONID = new MTField("prevRevisionId");
	public static final MTField MTTABLE = new MTField("mtTable");
	public static final MTField CUSTOMERID = new MTField("customerId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(STARTDATE);
		{
			STARTDATE.setDataType(MTDataTypes.DATETIME);
			STARTDATE.setNullable(true);
			STARTDATE.setTransient(false);
		}
		fields.add(OBJECTTYPE);
		{
			OBJECTTYPE.setDataType(MTDataTypes.VARCHAR);
			OBJECTTYPE.setLength(64);
			OBJECTTYPE.setNullable(true);
			OBJECTTYPE.setTransient(false);
		}
		fields.add(ACTION);
		{
			ACTION.setDataType(MTDataTypes.VARCHAR);
			ACTION.setLength(64);
			ACTION.setNullable(true);
			ACTION.setTransient(false);
		}
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(true);
			INPUTUSERID.setTransient(false);
		}
		fields.add(ID);
		{
			ID.setDataType(MTDataTypes.INT);
			ID.setNullable(true);
			ID.setTransient(false);
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
		}
		fields.add(PREVREVISIONID);
		{
			PREVREVISIONID.setDataType(MTDataTypes.INT);
			PREVREVISIONID.setNullable(true);
			PREVREVISIONID.setTransient(false);
		}
		fields.add(MTTABLE);
		{
			MTTABLE.setDataType(MTDataTypes.VARCHAR);
			MTTABLE.setLength(64);
			MTTABLE.setNullable(true);
			MTTABLE.setTransient(false);
		}
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
			CUSTOMERID.setSequence("crm.Seq_VCustomerHistory_customerId");
			CUSTOMERID.setPrimaryKey(true);
		}
	}

	public MTTableVCUSTOMERHISTORY(){
		init();
		this.tableName = "VCustomerHistory";
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