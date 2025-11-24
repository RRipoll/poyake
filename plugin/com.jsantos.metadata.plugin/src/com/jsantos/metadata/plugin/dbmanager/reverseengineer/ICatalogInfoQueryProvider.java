package com.jsantos.metadata.plugin.dbmanager.reverseengineer;

public interface ICatalogInfoQueryProvider {

	public String getTableListSql();
	public String getFieldListSql();
	public String getPrimaryKeyListSql();
	public String getForeignKeyListSql();
	public String getColumnDefaultListSql();
	public String getUniqueColumnListSql();
	public String getViewsDDLSql();
}
