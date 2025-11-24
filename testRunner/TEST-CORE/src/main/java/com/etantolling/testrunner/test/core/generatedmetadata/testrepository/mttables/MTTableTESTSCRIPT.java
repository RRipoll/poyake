package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableTESTSCRIPT extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField TESTSCRIPT = new MTField("TESTSCRIPT");
	public static final MTField NAME = new MTField("NAME");

	static{
		fields.put("TESTSCRIPT",TESTSCRIPT);
		fields.put("NAME",NAME);

		TESTSCRIPT.setSqlType(3);
		TESTSCRIPT.setColumnSize(10);
		TESTSCRIPT.setNativeTypeName("NUMBER");
		TESTSCRIPT.setDecimalDigits(0);
		TESTSCRIPT.setNullable(0);
		
		NAME.setSqlType(12);
		NAME.setColumnSize(100);
		NAME.setNativeTypeName("VARCHAR2");
		NAME.setDecimalDigits(null);
		NAME.setNullable(0);
		


		for (MTField field:fields.values()) field.setTable("TESTSCRIPT");

	}

	public MTTableTESTSCRIPT(){
		this.tableName = "TESTSCRIPT";
		this.primaryKeys.add(TESTSCRIPT);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
