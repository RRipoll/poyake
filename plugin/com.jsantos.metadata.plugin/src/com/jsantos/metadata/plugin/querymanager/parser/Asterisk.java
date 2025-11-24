package com.jsantos.metadata.plugin.querymanager.parser;

public class Asterisk extends Column{
	String tableName;
	Table tableRef;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Table getTableRef() {
		return tableRef;
	}

	public void setTableRef(Table tableRef) {
		this.tableRef = tableRef;
	}
	
	
}
