package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUANNOTATIONTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ANNOTATIONTYPEID = new MTField("annotationTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ANNOTATIONTYPEID);
		{
			ANNOTATIONTYPEID.setDataType(MTDataTypes.INT);
			ANNOTATIONTYPEID.setNullable(true);
			ANNOTATIONTYPEID.setTransient(false);
			ANNOTATIONTYPEID.setSequence("acc.Seq_EnuAnnotationType_annotationTypeId");
			ANNOTATIONTYPEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(false);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(false);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENUANNOTATIONTYPE(){
		init();
		this.tableName = "EnuAnnotationType";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(ANNOTATIONTYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuAnnotationType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}