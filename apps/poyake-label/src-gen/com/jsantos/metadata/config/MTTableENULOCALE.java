package com.jsantos.metadata.config;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENULOCALE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ENULOCALEID = new MTField("enuLocaleId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ENULOCALEID);
		{
			ENULOCALEID.setDataType(MTDataTypes.INT);
			ENULOCALEID.setNullable(true);
			ENULOCALEID.setTransient(false);
			ENULOCALEID.setSequence("config.Seq_Enulocale_enuLocaleId");
			ENULOCALEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
			SHORTCODE.getLabels().add(new Label("SHORTLABEL","en_EN","Short Code"));
			SHORTCODE.getLabels().add(new Label("SHORTLABEL","es_ES","Código"));
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","en_EN","Description"));
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","es_ES","Descripción"));
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENULOCALE(){
		init();
		this.tableName = "Enulocale";
		this.schema = "config";
		this.entityType = "TABLE";
		this.primaryKeys.add(ENULOCALEID);
		this.patterns.add("Enumeration");
		this.enumeration= new Enulocale();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}