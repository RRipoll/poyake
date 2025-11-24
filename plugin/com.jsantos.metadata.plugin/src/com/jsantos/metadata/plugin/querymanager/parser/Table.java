package com.jsantos.metadata.plugin.querymanager.parser;

public class Table {
	String tableAlias;
	String fullTableName;
	
	
	public String getTableAlias() {
		return tableAlias;
	}
	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}
	public String getFullTableName() {
		return fullTableName;
	}
	public void setFullTableName(String fullTablename) {
		this.fullTableName = fullTablename;
	}
	
	public String getTableName() {
		if (fullTableName.contains("."))
			return fullTableName.split("\\.")[1];
		return fullTableName;
	}
	
}
