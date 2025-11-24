package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableADM_SQL_LOG extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField ENVIRONMENT = new MTField("ENVIRONMENT");
	public static final MTField TESTNUMBER = new MTField("TESTNUMBER");
	public static final MTField TIMESTAMP = new MTField("TIMESTAMP");
	public static final MTField ELAPSEDMS = new MTField("ELAPSEDMS");
	public static final MTField SQLTYPE = new MTField("SQLTYPE");
	public static final MTField CONNECTIONID = new MTField("CONNECTIONID");
	public static final MTField STATEMENTID = new MTField("STATEMENTID");
	public static final MTField PREPAREDSTATEMENT = new MTField("PREPAREDSTATEMENT");
	public static final MTField STATEMENT = new MTField("STATEMENT");

	static{
		fields.put("ENVIRONMENT",ENVIRONMENT);
		fields.put("TESTNUMBER",TESTNUMBER);
		fields.put("TIMESTAMP",TIMESTAMP);
		fields.put("ELAPSEDMS",ELAPSEDMS);
		fields.put("SQLTYPE",SQLTYPE);
		fields.put("CONNECTIONID",CONNECTIONID);
		fields.put("STATEMENTID",STATEMENTID);
		fields.put("PREPAREDSTATEMENT",PREPAREDSTATEMENT);
		fields.put("STATEMENT",STATEMENT);

		ENVIRONMENT.setSqlType(12);
		ENVIRONMENT.setColumnSize(50);
		ENVIRONMENT.setNativeTypeName("VARCHAR2");
		ENVIRONMENT.setDecimalDigits(null);
		ENVIRONMENT.setNullable(1);
		
		TESTNUMBER.setSqlType(12);
		TESTNUMBER.setColumnSize(10);
		TESTNUMBER.setNativeTypeName("VARCHAR2");
		TESTNUMBER.setDecimalDigits(null);
		TESTNUMBER.setNullable(1);
		
		TIMESTAMP.setSqlType(93);
		TIMESTAMP.setColumnSize(11);
		TIMESTAMP.setNativeTypeName("TIMESTAMP(6)");
		TIMESTAMP.setDecimalDigits(6);
		TIMESTAMP.setNullable(1);
		
		ELAPSEDMS.setSqlType(3);
		ELAPSEDMS.setColumnSize(10);
		ELAPSEDMS.setNativeTypeName("NUMBER");
		ELAPSEDMS.setDecimalDigits(0);
		ELAPSEDMS.setNullable(1);
		
		SQLTYPE.setSqlType(12);
		SQLTYPE.setColumnSize(20);
		SQLTYPE.setNativeTypeName("VARCHAR2");
		SQLTYPE.setDecimalDigits(null);
		SQLTYPE.setNullable(1);
		
		CONNECTIONID.setSqlType(12);
		CONNECTIONID.setColumnSize(20);
		CONNECTIONID.setNativeTypeName("VARCHAR2");
		CONNECTIONID.setDecimalDigits(null);
		CONNECTIONID.setNullable(1);
		
		STATEMENTID.setSqlType(3);
		STATEMENTID.setColumnSize(10);
		STATEMENTID.setNativeTypeName("NUMBER");
		STATEMENTID.setDecimalDigits(0);
		STATEMENTID.setNullable(1);
		
		PREPAREDSTATEMENT.setSqlType(2005);
		PREPAREDSTATEMENT.setColumnSize(4000);
		PREPAREDSTATEMENT.setNativeTypeName("CLOB");
		PREPAREDSTATEMENT.setDecimalDigits(null);
		PREPAREDSTATEMENT.setNullable(1);
		
		STATEMENT.setSqlType(2005);
		STATEMENT.setColumnSize(4000);
		STATEMENT.setNativeTypeName("CLOB");
		STATEMENT.setDecimalDigits(null);
		STATEMENT.setNullable(1);
		


		for (MTField field:fields.values()) field.setTable("ADM_SQL_LOG");

	}

	public MTTableADM_SQL_LOG(){
		this.tableName = "ADM_SQL_LOG";
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
