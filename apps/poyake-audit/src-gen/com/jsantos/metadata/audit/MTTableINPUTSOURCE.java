package com.jsantos.metadata.audit;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableINPUTSOURCE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(true);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.setSequence("audit.Seq_InputSource_inputSourceId");
			INPUTSOURCEID.getLabels().add(new Label("SHORTLABEL","en_EN","Source #"));
			INPUTSOURCEID.getLabels().add(new Label("SHORTLABEL","es_ES","# Origen"));
			INPUTSOURCEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(false);
			SHORTCODE.setTransient(false);
			SHORTCODE.getLabels().add(new Label("SHORTLABEL","en_EN","Short Code"));
			SHORTCODE.getLabels().add(new Label("SHORTLABEL","es_ES","Código"));
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(64);
			DESCRIPTION.setNullable(false);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","en_EN","Description"));
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","es_ES","Descripción"));
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableINPUTSOURCE(){
		init();
		this.tableName = "InputSource";
		this.schema = "audit";
		this.entityType = "TABLE";
		this.primaryKeys.add(INPUTSOURCEID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}