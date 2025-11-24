package com.jsantos.metadata.recorder;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENURECORDERTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ENURECORDERTYPEID = new MTField("enuRecorderTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ENURECORDERTYPEID);
		{
			ENURECORDERTYPEID.setDataType(MTDataTypes.INT);
			ENURECORDERTYPEID.setNullable(true);
			ENURECORDERTYPEID.setTransient(false);
			ENURECORDERTYPEID.setSequence("recorder.Seq_EnuRecorderType_enuRecorderTypeId");
			ENURECORDERTYPEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENURECORDERTYPE(){
		init();
		this.tableName = "EnuRecorderType";
		this.schema = "recorder";
		this.entityType = "TABLE";
		this.primaryKeys.add(ENURECORDERTYPEID);
		this.patterns.add("Enumeration");
		this.stereotypes.add("RECORDER");
		this.enumeration= new EnuRecorderType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}