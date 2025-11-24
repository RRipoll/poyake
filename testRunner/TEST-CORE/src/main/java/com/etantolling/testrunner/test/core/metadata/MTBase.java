package com.etantolling.testrunner.test.core.metadata;

import java.util.LinkedHashMap;

public abstract class MTBase {
	protected static LinkedHashMap<String, MTTable> tables = new LinkedHashMap<String, MTTable>();
	protected static LinkedHashMap<String, MTEnumeration> enums = new LinkedHashMap<String, MTEnumeration>();

	public static MTTable getTable(String tableName) {
		return tables.get(tableName.toUpperCase());
	}

	public static LinkedHashMap<String, MTTable> getTables() {
		return tables;
	}

	public static LinkedHashMap<String, MTEnumeration> getEnums() {
		return enums;
	}
	
	public static MTEnumeration getEnum(String enumName) {
		return enums.get(enumName.toUpperCase());
	}
}
