package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableANNOTATION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ANNOTATIONID = new MTField("annotationId");
	public static final MTField ANNOTATIONTYPEID = new MTField("annotationTypeId");
	public static final MTField POSTINGDATE = new MTField("postingDate");
	public static final MTField CUSTOMERID = new MTField("customerId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ANNOTATIONID);
		{
			ANNOTATIONID.setDataType(MTDataTypes.INT);
			ANNOTATIONID.setNullable(true);
			ANNOTATIONID.setTransient(false);
			ANNOTATIONID.setSequence("acc.Seq_Annotation_annotationId");
			ANNOTATIONID.setPrimaryKey(true);
		}
		fields.add(ANNOTATIONTYPEID);
		{
			ANNOTATIONTYPEID.setDataType(MTDataTypes.INT);
			ANNOTATIONTYPEID.setNullable(false);
			ANNOTATIONTYPEID.setTransient(false);
		}
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setDataType(MTDataTypes.DATE);
			POSTINGDATE.setNullable(false);
			POSTINGDATE.setTransient(false);
			POSTINGDATE.getStereoTypes().add("NOGUIINPUT");
			POSTINGDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(false);
			CUSTOMERID.setTransient(false);
		}
	}

	public MTTableANNOTATION(){
		init();
		this.tableName = "Annotation";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(ANNOTATIONID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}