package com.jsantos.metadata.plugin.dbmanager.reverseengineer.vendor;

import com.jsantos.metadata.plugin.dbmanager.reverseengineer.ICatalogInfoQueryProvider;

public class H2CatalogInfoProvider  implements ICatalogInfoQueryProvider{

	@Override
	public String getTableListSql() {
		return "SELECT TABLE_SCHEMA || '.' || TABLE_NAME as fullTableName FROM INFORMATION_SCHEMA.tables WHERE table_schema<>'INFORMATION_SCHEMA'";
	}

	@Override
	public String getFieldListSql() {
		return "SELECT\n" + 
				"TABLE_SCHEMA || '.' || TABLE_NAME AS fullTableName,\n" + 
				"COLUMN_NAME AS columnName,\n" + 
				"TYPE_NAME AS dataTypeName,\n" + 
				"IS_NULLABLE AS isColumnNullable,\n" + 
				"character_maximum_length AS columnLength,\n" + 
				"numeric_scale AS columnScale\n" + 
				"FROM INFORMATION_SCHEMA.columns WHERE table_schema<>'INFORMATION_SCHEMA'";
	}

	@Override
	public String getPrimaryKeyListSql() {
		return "SELECT\n" + 
				"TABLE_SCHEMA || '.' || TABLE_NAME AS fullTableName,\n" + 
				"COLUMN_LIST AS columnName\n" + 
				"FROM INFORMATION_SCHEMA.CONSTRAINTS WHERE constraint_type='PRIMARY KEY' AND table_schema<>'INFORMATION_SCHEMA'\n";
	}

	@Override
	public String getForeignKeyListSql() {
		return "SELECT\n" + 
		"fktable_schema || '.' || fktable_name AS fromTableName,\n" + 
		"fkcolumn_name AS fromColumnName,\n" + 
		"pktable_schema || '.' || pktable_name AS toTableName\n" + 
		"FROM INFORMATION_SCHEMA.cross_references  WHERE table_schema<>'INFORMATION_SCHEMA'\n";
	}

	@Override
	public String getColumnDefaultListSql() {
		return "SELECT\n" + 
		"TABLE_SCHEMA || '.' || TABLE_NAME AS fullTableName,\n" + 
		"COLUMN_NAME AS columnName,\n" + 
		"COLUMN_DEFAULT AS defaultValue\n" + 
		"FROM INFORMATION_SCHEMA.columns WHERE table_schema<>'INFORMATION_SCHEMA'\n";
	}

	@Override
	public String getUniqueColumnListSql() {
		return "SELECT\n" + 
		"TABLE_SCHEMA || '.' || TABLE_NAME AS fullTableName,\n" + 
		"COLUMN_LIST AS columnName\n" + 
		"FROM INFORMATION_SCHEMA.CONSTRAINTS WHERE constraint_type='UNIQUE' AND table_schema<>'INFORMATION_SCHEMA'\n";
	}

	@Override
	public String getViewsDDLSql() {
		return "SELECT\n" + 
		"TABLE_SCHEMA || '.' || TABLE_NAME AS viewName,\n" + 
		"view_definition AS viewDDL\n" + 
		"FROM INFORMATION_SCHEMA.views WHERE table_schema<>'INFORMATION_SCHEMA'\n";
	}

}
