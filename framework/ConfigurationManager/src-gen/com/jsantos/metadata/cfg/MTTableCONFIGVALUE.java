package com.jsantos.metadata.cfg;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableCONFIGVALUE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CONFIGKEYID = new MTField("configKeyId");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField VALUE = new MTField("value");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");

	static{
		fields.add(CONFIGKEYID);
		{
			CONFIGKEYID.setNativeTypeName("INT");
			CONFIGKEYID.getStereoTypes().add("AUTOHISTORYMAINFK");
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setNativeTypeName("INT");
			REVISIONID.setSequence("cfg.Seq_ConfigValue_revisionId");
		}
		fields.add(VALUE);
		{
			VALUE.setNativeTypeName("VARCHAR");
			VALUE.setLength(64);
		}
		fields.add(STARTDATE);
		{
			STARTDATE.setNativeTypeName("DATETIME");
			STARTDATE.setNullable(false);
		}
		fields.add(ENDDATE);
		{
			ENDDATE.setNativeTypeName("DATETIME");
			ENDDATE.setNullable(false);
		}
		for (MTField field:fields) field.setTable("CONFIGVALUE");
	}

	public MTTableCONFIGVALUE(){
		this.tableName = "ConfigValue";
		this.schema = "cfg";
		this.entityType = "TABLE";
		this.primaryKeys.add(REVISIONID);
		this.patterns.add("AutoHistory");
		new Label("","","");
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}