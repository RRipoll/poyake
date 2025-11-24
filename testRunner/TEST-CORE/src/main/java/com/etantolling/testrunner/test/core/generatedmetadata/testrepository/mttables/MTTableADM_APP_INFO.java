package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableADM_APP_INFO extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField SKEY = new MTField("SKEY");
	public static final MTField SVALUE = new MTField("SVALUE");

	static{
		fields.put("SKEY",SKEY);
		fields.put("SVALUE",SVALUE);

		SKEY.setSqlType(12);
		SKEY.setColumnSize(255);
		SKEY.setNativeTypeName("VARCHAR2");
		SKEY.setDecimalDigits(null);
		SKEY.setNullable(0);
		
		SVALUE.setSqlType(12);
		SVALUE.setColumnSize(255);
		SVALUE.setNativeTypeName("VARCHAR2");
		SVALUE.setDecimalDigits(null);
		SVALUE.setNullable(0);
		


		for (MTField field:fields.values()) field.setTable("ADM_APP_INFO");

	}

	public MTTableADM_APP_INFO(){
		this.tableName = "ADM_APP_INFO";
		this.primaryKeys.add(SKEY);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
