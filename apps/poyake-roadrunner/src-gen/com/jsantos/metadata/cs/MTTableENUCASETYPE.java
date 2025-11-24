package com.jsantos.metadata.cs;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUCASETYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CASETYPEID = new MTField("caseTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CASETYPEID);
		{
			CASETYPEID.setDataType(MTDataTypes.INT);
			CASETYPEID.setNullable(true);
			CASETYPEID.setTransient(false);
			CASETYPEID.setSequence("cs.Seq_EnuCaseType_caseTypeId");
			CASETYPEID.setPrimaryKey(true);
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
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENUCASETYPE(){
		init();
		this.tableName = "EnuCaseType";
		this.schema = "cs";
		this.entityType = "TABLE";
		this.primaryKeys.add(CASETYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuCaseType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}