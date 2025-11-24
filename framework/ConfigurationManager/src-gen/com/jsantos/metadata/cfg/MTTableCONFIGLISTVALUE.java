package com.jsantos.metadata.cfg;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableCONFIGLISTVALUE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CONFIGSETVALUEID = new MTField("configSetValueId");
	public static final MTField CONFIGKEYID = new MTField("configKeyId");
	public static final MTField VALUE = new MTField("value");

	static{
		fields.add(CONFIGSETVALUEID);
		{
			CONFIGSETVALUEID.setNativeTypeName("INT");
			CONFIGSETVALUEID.setSequence("cfg.Seq_ConfigListValue_configSetValueId");
		}
		fields.add(CONFIGKEYID);
		{
			CONFIGKEYID.setNativeTypeName("INT");
		}
		fields.add(VALUE);
		{
			VALUE.setNativeTypeName("VARCHAR");
			VALUE.setLength(64);
		}
		for (MTField field:fields) field.setTable("CONFIGLISTVALUE");
	}

	public MTTableCONFIGLISTVALUE(){
		this.tableName = "ConfigListValue";
		this.schema = "cfg";
		this.entityType = "TABLE";
		this.primaryKeys.add(CONFIGSETVALUEID);
		new Label("","","");
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}