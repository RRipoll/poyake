package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableFILETYPE extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField FILETYPEID = new MTField("FILETYPEID");
	public static final MTField FILETYPENAME = new MTField("FILETYPENAME");

	static{
		fields.put("FILETYPEID",FILETYPEID);
		fields.put("FILETYPENAME",FILETYPENAME);

		FILETYPEID.setSqlType(3);
		FILETYPEID.setColumnSize(10);
		FILETYPEID.setNativeTypeName("NUMBER");
		FILETYPEID.setDecimalDigits(0);
		FILETYPEID.setNullable(0);
		
		FILETYPENAME.setSqlType(12);
		FILETYPENAME.setColumnSize(255);
		FILETYPENAME.setNativeTypeName("VARCHAR2");
		FILETYPENAME.setDecimalDigits(null);
		FILETYPENAME.setNullable(0);
		


		for (MTField field:fields.values()) field.setTable("FILETYPE");

	}

	public MTTableFILETYPE(){
		this.tableName = "FILETYPE";
		this.primaryKeys.add(FILETYPEID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
