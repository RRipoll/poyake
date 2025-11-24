package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePERSONORCOMPANYPK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PERSONORCOMPANYID = new MTField("personOrCompanyId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PERSONORCOMPANYID);
		{
			PERSONORCOMPANYID.setDataType(MTDataTypes.INT);
			PERSONORCOMPANYID.setNullable(true);
			PERSONORCOMPANYID.setTransient(false);
			PERSONORCOMPANYID.setSequence("crm.Seq_PersonOrCompanyPk_personOrCompanyId");
			PERSONORCOMPANYID.setPrimaryKey(true);
		}
	}

	public MTTablePERSONORCOMPANYPK(){
		init();
		this.tableName = "PersonOrCompanyPk";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(PERSONORCOMPANYID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}