package com.jsantos.metadata.cs;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableCUSTOMERCASE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CUSTOMERCASEID = new MTField("customercaseId");
	public static final MTField CUSTOMERID = new MTField("customerId");
	public static final MTField CSCASEID = new MTField("csCaseId");
	public static final MTField CREATED = new MTField("created");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CUSTOMERCASEID);
		{
			CUSTOMERCASEID.setDataType(MTDataTypes.INT);
			CUSTOMERCASEID.setNullable(true);
			CUSTOMERCASEID.setTransient(false);
			CUSTOMERCASEID.setSequence("cs.Seq_CustomerCase_customercaseId");
			CUSTOMERCASEID.setPrimaryKey(true);
		}
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(false);
			CUSTOMERID.setTransient(false);
			CUSTOMERID.getStereoTypes().add("LINK");
		}
		fields.add(CSCASEID);
		{
			CSCASEID.setDataType(MTDataTypes.INT);
			CSCASEID.setNullable(false);
			CSCASEID.setTransient(false);
			CSCASEID.getStereoTypes().add("LINK");
		}
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(false);
			CREATED.setTransient(false);
			CREATED.getStereoTypes().add("NOGUIINPUT");
			CREATED.setDefaultValue("getPostingDate()");
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

	public MTTableCUSTOMERCASE(){
		init();
		this.tableName = "CustomerCase";
		this.schema = "cs";
		this.entityType = "TABLE";
		this.primaryKeys.add(CUSTOMERCASEID);
		this.patterns.add("Audited");
		this.stereotypes.add("LINKTABLE");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}