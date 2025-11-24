package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableINPUTUSER extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField INPUTUSERID = new MTField("INPUTUSERID");
	public static final MTField USERNAME = new MTField("USERNAME");
	public static final MTField PASSWORD = new MTField("PASSWORD");
	public static final MTField STARTDATE = new MTField("STARTDATE");
	public static final MTField ENDDATE = new MTField("ENDDATE");
	public static final MTField DELETED = new MTField("DELETED");
	static{
		fields.put("INPUTUSERID",INPUTUSERID);
		fields.put("USERNAME",USERNAME);
		fields.put("PASSWORD",PASSWORD);
		fields.put("STARTDATE",STARTDATE);
		fields.put("ENDDATE",ENDDATE);
		fields.put("DELETED",DELETED);
		INPUTUSERID.setSqlType(3);
		INPUTUSERID.setColumnSize(10);
		INPUTUSERID.setNativeTypeName("NUMBER");
		INPUTUSERID.setDecimalDigits(0);
		INPUTUSERID.setNullable(0);
		
		USERNAME.setSqlType(12);
		USERNAME.setColumnSize(255);
		USERNAME.setNativeTypeName("VARCHAR2");
		USERNAME.setDecimalDigits(null);
		USERNAME.setNullable(0);
		
		PASSWORD.setSqlType(12);
		PASSWORD.setColumnSize(255);
		PASSWORD.setNativeTypeName("VARCHAR2");
		PASSWORD.setDecimalDigits(null);
		PASSWORD.setNullable(0);
		DELETED.setSqlType(3);
		DELETED.setColumnSize(1);
		DELETED.setNativeTypeName("NUMBER");
		DELETED.setDecimalDigits(0);
		DELETED.setNullable(0);
		
		STARTDATE.setSqlType(93);
		STARTDATE.setColumnSize(11);
		STARTDATE.setNativeTypeName("TIMESTAMP(6)");
		STARTDATE.setDecimalDigits(6);
		STARTDATE.setNullable(0);
	
		ENDDATE.setSqlType(93);
		ENDDATE.setColumnSize(11);
		ENDDATE.setNativeTypeName("TIMESTAMP(6)");
		ENDDATE.setDecimalDigits(6);
		ENDDATE.setNullable(0);
	

		for (MTField field:fields.values()) field.setTable("INPUTUSER");

	}

	public MTTableINPUTUSER(){
		this.tableName = "INPUTUSER";
		this.primaryKeys.add(INPUTUSERID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
