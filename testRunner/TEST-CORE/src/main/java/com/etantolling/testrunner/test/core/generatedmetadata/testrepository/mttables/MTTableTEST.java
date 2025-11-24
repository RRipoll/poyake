package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableTEST extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField TESTID = new MTField("TESTID");
	public static final MTField OWNER = new MTField("OWNER");
	public static final MTField FOLDERID = new MTField("FOLDERID");
	public static final MTField TESTNAME = new MTField("TESTNAME");
	public static final MTField DESCRIPTION = new MTField("DESCRIPTION");
	public static final MTField NOTES = new MTField("NOTES");
	public static final MTField CREATED = new MTField("CREATED");
	public static final MTField DELETED = new MTField("DELETED");
	public static final MTField STARTDATE = new MTField("STARTDATE");
	public static final MTField ENDDATE = new MTField("ENDDATE");
	public static final MTField REGRESSIONTEST = new MTField("REGRESSIONTEST");
	public static final MTField RUNNIGHTLYSCRIPTS = new MTField("RUNNIGHTLYSCRIPTS");
	public static final MTField KEYWORDS = new MTField("KEYWORDS");
	//public static final MTField STARTTESTDATE = new MTField("STARTTESTDATE");
	//public static final MTField ENDTESTDATE = new MTField("ENDTESTDATE");
	
	
	static{
		fields.put("TESTID",TESTID);
		fields.put("OWNER",OWNER);
		fields.put("FOLDERID",FOLDERID);
		fields.put("TESTNAME",TESTNAME);
		fields.put("DESCRIPTION",DESCRIPTION);
		fields.put("NOTES",NOTES);
		fields.put("CREATED",CREATED);
		fields.put("DELETED",DELETED);
		fields.put("STARTDATE",STARTDATE);
		fields.put("ENDDATE",ENDDATE);
		//fields.put("STARTTESTDATE",STARTTESTDATE);
		//fields.put("ENDTESTDATE",ENDTESTDATE);
		
		fields.put("REGRESSIONTEST",REGRESSIONTEST);
		fields.put("RUNNIGHTLYSCRIPTS",RUNNIGHTLYSCRIPTS);
		fields.put("KEYWORDS",KEYWORDS);

		TESTID.setSqlType(3);
		TESTID.setColumnSize(10);
		TESTID.setNativeTypeName("NUMBER");
		TESTID.setDecimalDigits(0);
		TESTID.setNullable(0);
		
		OWNER.setSqlType(3);
		OWNER.setColumnSize(10);
		OWNER.setNativeTypeName("NUMBER");
		OWNER.setDecimalDigits(0);
		OWNER.setNullable(0);
		
		FOLDERID.setSqlType(3);
		FOLDERID.setColumnSize(10);
		FOLDERID.setNativeTypeName("NUMBER");
		FOLDERID.setDecimalDigits(0);
		FOLDERID.setNullable(0);
		
		TESTNAME.setSqlType(12);
		TESTNAME.setColumnSize(255);
		TESTNAME.setNativeTypeName("VARCHAR2");
		TESTNAME.setDecimalDigits(null);
		TESTNAME.setNullable(0);
		
		DESCRIPTION.setSqlType(12);
		DESCRIPTION.setColumnSize(255);
		DESCRIPTION.setNativeTypeName("VARCHAR2");
		DESCRIPTION.setDecimalDigits(null);
		DESCRIPTION.setNullable(1);
		
		NOTES.setSqlType(12);
		NOTES.setColumnSize(1024);
		NOTES.setNativeTypeName("VARCHAR2");
		NOTES.setDecimalDigits(null);
		NOTES.setNullable(1);
		
		CREATED.setSqlType(93);
		CREATED.setColumnSize(11);
		CREATED.setNativeTypeName("TIMESTAMP(6)");
		CREATED.setDecimalDigits(6);
		CREATED.setNullable(0);
		
		DELETED.setSqlType(3);
		DELETED.setColumnSize(1);
		DELETED.setNativeTypeName("NUMBER");
		DELETED.setDecimalDigits(0);
		DELETED.setNullable(0);
		
		STARTDATE.setSqlType(93);
		STARTDATE.setColumnSize(11);
		STARTDATE.setNativeTypeName("TIMESTAMP(6)");
		STARTDATE.setDecimalDigits(6);
		STARTDATE.setNullable(1);
		
		ENDDATE.setSqlType(93);
		ENDDATE.setColumnSize(11);
		ENDDATE.setNativeTypeName("TIMESTAMP(6)");
		ENDDATE.setDecimalDigits(6);
		ENDDATE.setNullable(1);

		/*
		STARTTESTDATE.setSqlType(93);
		STARTTESTDATE.setColumnSize(11);
		STARTTESTDATE.setNativeTypeName("TIMESTAMP(6)");
		STARTTESTDATE.setDecimalDigits(6);
		STARTTESTDATE.setNullable(1);
		
		ENDTESTDATE.setSqlType(93);
		ENDTESTDATE.setColumnSize(11);
		ENDTESTDATE.setNativeTypeName("TIMESTAMP(6)");
		ENDTESTDATE.setDecimalDigits(6);
		ENDTESTDATE.setNullable(1);
*/
		
		
		REGRESSIONTEST.setSqlType(3);
		REGRESSIONTEST.setColumnSize(1);
		REGRESSIONTEST.setNativeTypeName("NUMBER");
		REGRESSIONTEST.setDecimalDigits(0);
		REGRESSIONTEST.setNullable(1);
		
		RUNNIGHTLYSCRIPTS.setSqlType(3);
		RUNNIGHTLYSCRIPTS.setColumnSize(1);
		RUNNIGHTLYSCRIPTS.setNativeTypeName("NUMBER");
		RUNNIGHTLYSCRIPTS.setDecimalDigits(0);
		RUNNIGHTLYSCRIPTS.setNullable(1);
		
		KEYWORDS.setSqlType(12);
		KEYWORDS.setColumnSize(255);
		KEYWORDS.setNativeTypeName("VARCHAR2");
		KEYWORDS.setDecimalDigits(null);
		KEYWORDS.setNullable(1);
		


		FOLDERID.setForeignKey("FOLDER");
		OWNER.setForeignKey("INPUTUSER");
		REGRESSIONTEST.setForeignKey("YESNO");
		RUNNIGHTLYSCRIPTS.setForeignKey("YESNO");
		for (MTField field:fields.values()) field.setTable("TEST");

	}

	public MTTableTEST(){
		this.tableName = "TEST";
		this.primaryKeys.add(TESTID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
