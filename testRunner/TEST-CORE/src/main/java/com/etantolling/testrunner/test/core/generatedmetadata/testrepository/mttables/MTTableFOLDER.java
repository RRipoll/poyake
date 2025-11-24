package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableFOLDER extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField FOLDERID = new MTField("FOLDERID");
	public static final MTField PARENTFOLDERID = new MTField("PARENTFOLDERID");
	public static final MTField DESCRIPTION = new MTField("DESCRIPTION");
	public static final MTField DELETED = new MTField("DELETED");
	static{
		fields.put("FOLDERID",FOLDERID);
		fields.put("PARENTFOLDERID",PARENTFOLDERID);
		fields.put("DESCRIPTION",DESCRIPTION);
		fields.put("DELETED",DELETED);
		
		FOLDERID.setSqlType(3);
		FOLDERID.setColumnSize(10);
		FOLDERID.setNativeTypeName("NUMBER");
		FOLDERID.setDecimalDigits(0);
		FOLDERID.setNullable(0);
		
		PARENTFOLDERID.setSqlType(3);
		PARENTFOLDERID.setColumnSize(10);
		PARENTFOLDERID.setNativeTypeName("NUMBER");
		PARENTFOLDERID.setDecimalDigits(0);
		PARENTFOLDERID.setNullable(1);
		
		DESCRIPTION.setSqlType(12);
		DESCRIPTION.setColumnSize(255);
		DESCRIPTION.setNativeTypeName("VARCHAR2");
		DESCRIPTION.setDecimalDigits(null);
		DESCRIPTION.setNullable(0);
		DELETED.setSqlType(3);
		DELETED.setColumnSize(1);
		DELETED.setNativeTypeName("NUMBER");
		DELETED.setDecimalDigits(0);
		DELETED.setNullable(0);
		
	
		PARENTFOLDERID.setForeignKey("FOLDER");
		for (MTField field:fields.values()) field.setTable("FOLDER");

	}

	public MTTableFOLDER(){
		this.tableName = "FOLDER";
		this.primaryKeys.add(FOLDERID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
