package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTEnuEVENTTYPE;
import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

@SuppressWarnings("unused")
public class MTTableEVENTTYPE extends MTTable{

	private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

	public static final MTField EVENTTYPEID = new MTField("EVENTTYPEID");
	public static final MTField EVENTTYPENAME = new MTField("EVENTTYPENAME");

	static{
		fields.put("EVENTTYPEID",EVENTTYPEID);
		fields.put("EVENTTYPENAME",EVENTTYPENAME);

		EVENTTYPEID.setSqlType(3);
		EVENTTYPEID.setColumnSize(10);
		EVENTTYPEID.setNativeTypeName("NUMBER");
		EVENTTYPEID.setDecimalDigits(0);
		EVENTTYPEID.setNullable(0);
		
		EVENTTYPENAME.setSqlType(12);
		EVENTTYPENAME.setColumnSize(255);
		EVENTTYPENAME.setNativeTypeName("VARCHAR2");
		EVENTTYPENAME.setDecimalDigits(null);
		EVENTTYPENAME.setNullable(1);
		


		for (MTField field:fields.values()) field.setTable("EVENTTYPE");

	}

	public MTTableEVENTTYPE(){
		this.tableName = "EVENTTYPE";
		this.isEnumeration=true;
		this.enumeration = new MTEnuEVENTTYPE();
		this.idField="EVENTTYPENAME";
		this.primaryKeys.add(EVENTTYPEID);
	}

	@Override
	public LinkedHashMap<String, MTField> getFields() {
		return fields;
	}
}
