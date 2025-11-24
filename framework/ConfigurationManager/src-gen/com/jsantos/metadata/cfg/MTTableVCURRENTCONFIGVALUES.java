package com.jsantos.metadata.cfg;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableVCURRENTCONFIGVALUES extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CONFIGKEYID = new MTField("configKeyId");
	public static final MTField FULLPATH = new MTField("fullPath");
	public static final MTField VALUE = new MTField("value");

	static{
		fields.add(CONFIGKEYID);
		{
			CONFIGKEYID.setNativeTypeName("INT");
		}
		fields.add(FULLPATH);
		{
			FULLPATH.setNativeTypeName("VARCHAR");
			FULLPATH.setLength(2048);
		}
		fields.add(VALUE);
		{
			VALUE.setNativeTypeName("VARCHAR");
			VALUE.setLength(32);
		}
		for (MTField field:fields) field.setTable("VCURRENTCONFIGVALUES");
	}

	public MTTableVCURRENTCONFIGVALUES(){
		this.tableName = "VCurrentConfigValues";
		this.schema = "cfg";
		this.entityType = "VIEW";
		new Label("","","");
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}