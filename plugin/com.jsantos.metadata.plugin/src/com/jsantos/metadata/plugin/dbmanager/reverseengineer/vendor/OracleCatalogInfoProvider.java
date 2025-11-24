package com.jsantos.metadata.plugin.dbmanager.reverseengineer.vendor;

import com.jsantos.metadata.plugin.dbmanager.reverseengineer.ICatalogInfoQueryProvider;

public class OracleCatalogInfoProvider implements ICatalogInfoQueryProvider{

	@Override
	public String getTableListSql() {
		return "SELECT table_name AS fullTableName FROM all_tab_cols WHERE owner=USER";
	}

	@Override
	public String getFieldListSql() {
		return "SELECT\n" + 
		"table_name AS fullTableName\n" + 
		",lower(column_name) AS columnName\n" + 
		",data_type AS dataTypeName\n" + 
		",nullable AS isColumnNullable\n" + 
		",COALESCE(data_precision, data_length) AS columnLength\n" + 
		",COALESCE(data_scale,0) AS columnScale\n" + 
		"FROM all_tab_cols WHERE owner=USER  order by column_id\n";
	}

	@Override
	public String getPrimaryKeyListSql() {
		return "SELECT\n" + 
				"tc.TABLE_NAME AS fullTableName\n" + 
				",col.COLUMN_NAME AS columnName\n" + 
				"FROM\n" + 
				"ALL_CONSTRAINTS c\n" + 
				"JOIN ALL_CONS_COLUMNS col ON c.CONSTRAINT_NAME =col.constraint_name AND c.OWNER=USER AND col.OWNER =USER\n" + 
				"JOIN all_tab_cols tc ON tc.TABLE_NAME =col.TABLE_NAME AND c.OWNER = USER  AND c.CONSTRAINT_TYPE ='P'\n";
	}

	@Override
	public String getForeignKeyListSql() {
		return "SELECT\n" + 
				"a.table_name AS fromTableName\n" + 
				", a.column_name AS fromColumn\n" + 
				", c_pk.table_name AS toTableName\n" + 
				"FROM all_cons_columns a\n" + 
				"JOIN all_constraints c ON a.owner = c.owner\n" + 
				"AND a.constraint_name = c.constraint_name\n" + 
				"JOIN all_constraints c_pk ON c.r_owner = c_pk.owner\n" + 
				"AND c.r_constraint_name = c_pk.constraint_name\n" + 
				"WHERE\n" + 
				"c.constraint_type = 'R'\n" + 
				"AND c.OWNER = USER\n";
	}

	@Override
	public String getColumnDefaultListSql() {
		return "SELECT\n" + 
				"table_name AS fullTableName\n" + 
				",column_name AS columnName\n" + 
				",DATA_DEFAULT  AS defaultValue\n" + 
				"FROM all_tab_cols WHERE owner=USER and data_default IS NOT null\n";
	}

	@Override
	public String getUniqueColumnListSql() {
		return "select\n" + 
				"c.TABLE_NAME AS fullTableName\n" + 
				",c.COLUMN_NAME AS columnName\n" + 
				"from\n" + 
				"USER_INDEXES i, USER_IND_COLUMNS c\n" + 
				"where\n" + 
				"i.UNIQUENESS = 'UNIQUE'\n" + 
				"and i.TABLE_NAME = c.TABLE_NAME\n" + 
				"and i.INDEX_NAME = c.INDEX_NAME\n" + 
				"union\n" + 
				"select\n" + 
				"cc.TABLE_NAME AS fullTableName\n" + 
				",cc.COLUMN_NAME AS fullColumnName\n" + 
				"from\n" + 
				"USER_CONSTRAINTS con, USER_CONS_COLUMNS cc, all_tab_cols tc\n" + 
				"where\n" + 
				"con.CONSTRAINT_TYPE in ( 'U', 'P' )\n" + 
				"and con.TABLE_NAME = cc.TABLE_NAME\n" + 
				"and con.CONSTRAINT_NAME = cc.CONSTRAINT_NAME\n" + 
				"AND cc.COLUMN_NAME =tc.COLUMN_NAME  AND cc.TABLE_NAME =tc.TABLE_NAME\n";
	}

	@Override
	public String getViewsDDLSql() {
		return "SELECT DISTINCT NULL AS schemaName, table_name AS tableName FROM all_tab_cols WHERE 1=0";
	}

}
