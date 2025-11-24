package com.jsantos.metadata.cs;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUCASEPRIORITY extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CASEPRIORITYID = new MTField("casePriorityId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CASEPRIORITYID);
		{
			CASEPRIORITYID.setDataType(MTDataTypes.INT);
			CASEPRIORITYID.setNullable(true);
			CASEPRIORITYID.setTransient(false);
			CASEPRIORITYID.setSequence("cs.Seq_EnuCasePriority_casePriorityId");
			CASEPRIORITYID.setPrimaryKey(true);
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

	public MTTableENUCASEPRIORITY(){
		init();
		this.tableName = "EnuCasePriority";
		this.schema = "cs";
		this.entityType = "TABLE";
		this.primaryKeys.add(CASEPRIORITYID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuCasePriority();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}