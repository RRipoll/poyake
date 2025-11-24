package com.jsantos.metadata.plugin.querymanager.parser;

import com.jsantos.metadata.plugin.metaDsl.Attribute;

public class TableColumn extends Column{
	String tableName;
	String columnName;
	String alias;
	Table tableRef;
	Attribute attribute;
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Table getTableRef() {
		return tableRef;
	}
	public void setTableRef(Table tableRef) {
		this.tableRef = tableRef;
	}
	
	public String getOutputName() {
		if (null !=alias) return alias;
		return columnName;
	}
	public Attribute getAttribute() {
		return attribute;
	}
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
	
}
