package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableTURISTA extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField TURISTAID = new MTField("turistaId");
	public static final MTField COUNTRYID = new MTField("countryId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(TURISTAID);
		{
			TURISTAID.setDataType(MTDataTypes.INT);
			TURISTAID.setNullable(true);
			TURISTAID.setTransient(false);
			TURISTAID.setSequence("crm.Seq_Turista_turistaId");
			TURISTAID.setPrimaryKey(true);
		}
		fields.add(COUNTRYID);
		{
			COUNTRYID.setDataType(MTDataTypes.INT);
			COUNTRYID.setNullable(true);
			COUNTRYID.setTransient(false);
		}
	}

	public MTTableTURISTA(){
		init();
		this.tableName = "Turista";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(TURISTAID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}