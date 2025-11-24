package com.jsantos.metadata.config;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePOSTINGDATE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField POSTINGDATEID = new MTField("postingDateId");
	public static final MTField POSTINGDATE = new MTField("postingDate");
	public static final MTField LASTUPDATED = new MTField("lastUpdated");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(POSTINGDATEID);
		{
			POSTINGDATEID.setDataType(MTDataTypes.INT);
			POSTINGDATEID.setNullable(true);
			POSTINGDATEID.setTransient(false);
			POSTINGDATEID.setSequence("config.Seq_PostingDate_postingDateId");
			POSTINGDATEID.setPrimaryKey(true);
		}
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setDataType(MTDataTypes.DATETIME);
			POSTINGDATE.setNullable(false);
			POSTINGDATE.setTransient(false);
			POSTINGDATE.setDefaultValue("CURRENT_TIMESTAMP");
		}
		fields.add(LASTUPDATED);
		{
			LASTUPDATED.setDataType(MTDataTypes.DATETIME);
			LASTUPDATED.setNullable(false);
			LASTUPDATED.setTransient(false);
			LASTUPDATED.setDefaultValue("CURRENT_TIMESTAMP");
		}
	}

	public MTTablePOSTINGDATE(){
		init();
		this.tableName = "PostingDate";
		this.schema = "config";
		this.entityType = "TABLE";
		this.primaryKeys.add(POSTINGDATEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}