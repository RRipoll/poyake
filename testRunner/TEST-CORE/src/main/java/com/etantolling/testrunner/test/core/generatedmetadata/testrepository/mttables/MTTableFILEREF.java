package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableFILEREF extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField FILEREFID = new MTField("FILEREFID");
	public static final MTField FILETYPEID = new MTField("FILETYPEID");
	public static final MTField FOLDERID = new MTField("FOLDERID");
	public static final MTField AZUREURL = new MTField("AZUREURL");
	public static final MTField NAME = new MTField("NAME");
	public static final MTField DESCRIPTION = new MTField("DESCRIPTION");
	public static final MTField DELETED = new MTField("DELETED");
	public static final MTField MIMETYPE = new MTField("MIMETYPE");

	static{
		fields.put("FILEREFID",FILEREFID);
		fields.put("FILETYPEID",FILETYPEID);
		fields.put("FOLDERID",FOLDERID);
		fields.put("AZUREURL",AZUREURL);
		fields.put("NAME",NAME);
		fields.put("DESCRIPTION",DESCRIPTION);
		fields.put("DELETED",DELETED);
		fields.put("MIMETYPE",MIMETYPE);

		FILEREFID.setSqlType(3);
		FILEREFID.setColumnSize(10);
		FILEREFID.setNativeTypeName("NUMBER");
		FILEREFID.setDecimalDigits(0);
		FILEREFID.setNullable(0);
		
		FILETYPEID.setSqlType(3);
		FILETYPEID.setColumnSize(10);
		FILETYPEID.setNativeTypeName("NUMBER");
		FILETYPEID.setDecimalDigits(0);
		FILETYPEID.setNullable(0);
		
		FOLDERID.setSqlType(3);
		FOLDERID.setColumnSize(10);
		FOLDERID.setNativeTypeName("NUMBER");
		FOLDERID.setDecimalDigits(0);
		FOLDERID.setNullable(1);
		
		AZUREURL.setSqlType(12);
		AZUREURL.setColumnSize(255);
		AZUREURL.setNativeTypeName("VARCHAR2");
		AZUREURL.setDecimalDigits(null);
		AZUREURL.setNullable(0);
		
		NAME.setSqlType(12);
		NAME.setColumnSize(255);
		NAME.setNativeTypeName("VARCHAR2");
		NAME.setDecimalDigits(null);
		NAME.setNullable(0);
		
		DESCRIPTION.setSqlType(12);
		DESCRIPTION.setColumnSize(255);
		DESCRIPTION.setNativeTypeName("VARCHAR2");
		DESCRIPTION.setDecimalDigits(null);
		DESCRIPTION.setNullable(1);
		
		DELETED.setSqlType(3);
		DELETED.setColumnSize(1);
		DELETED.setNativeTypeName("NUMBER");
		DELETED.setDecimalDigits(0);
		DELETED.setNullable(0);
		
		MIMETYPE.setSqlType(12);
		MIMETYPE.setColumnSize(255);
		MIMETYPE.setNativeTypeName("VARCHAR2");
		MIMETYPE.setDecimalDigits(null);
		MIMETYPE.setNullable(1);
		


		FILETYPEID.setForeignKey("FILETYPE");
		FOLDERID.setForeignKey("FOLDER");
		for (MTField field:fields.values()) field.setTable("FILEREF");

	}

	public MTTableFILEREF(){
		this.tableName = "FILEREF";
		this.primaryKeys.add(FILEREFID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
