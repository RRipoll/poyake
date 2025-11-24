package com.jsantos.metadata.plugin.dbmanager.reverseengineer.vendor;

import com.jsantos.metadata.plugin.dbmanager.reverseengineer.ICatalogInfoQueryProvider;

public class PostgresCatalogProvider   implements ICatalogInfoQueryProvider{

	@Override
	public String getTableListSql() {
		return "SELECT \n" + 
				"	schemaname || '.' || tablename as fullTableName\n" + 
				"FROM pg_catalog.pg_tables\n" + 
				"WHERE schemaname != 'pg_catalog' AND \n" + 
				"    schemaname != 'information_schema';";
	}

	@Override
	public String getFieldListSql() {
		// TODO Auto-generated method stub
		return "SELECT\n" + 
				"	table_schema || '.' || table_name as fullTableName,\n" + 
				"	column_name as columnName,\n" + 
				"	data_type as dataTypeName,\n" + 
				"	is_nullable as isColumnNullable,\n" + 
				"	character_maximum_length AS columnLength,\n" + 
				"	numeric_scale AS columnScale\n" + 
				"FROM\n" + 
				"	informatihttp://marketplace.eclipse.org/marketplace-client-intro?mpc_install=5421785on_schema.columns\n" + 
				"WHERE table_schema != 'pg_catalog' AND \n" + 
				"    table_schema != 'information_schema';";
	}
	
	@Override
	public String getPrimaryKeyListSql() {
		return "select \n" + 
				"	kcu.table_schema || '.' || kcu.table_name as fullTableName,\n" + 
				"    kcu.column_name as columnName\n" + 
				"from information_schema.table_constraints tco\n" + 
				"join information_schema.key_column_usage kcu \n" + 
				"     on kcu.constraint_name = tco.constraint_name\n" + 
				"     and kcu.constraint_schema = tco.constraint_schema\n" + 
				"     and kcu.constraint_name = tco.constraint_name\n" + 
				"where tco.constraint_type = 'PRIMARY KEY'\n";
	}

	@Override
	public String getForeignKeyListSql() {
		return "select \n" + 
				"	kcu.table_schema || '.' ||kcu.table_name as toTableName,\n" + 
				"    string_agg(kcu.column_name, ', ') as fromColumn,\n" + 
				"    rel_tco.table_schema || '.' || rel_tco.table_name as fromTableName\n" + 
				"from information_schema.table_constraints tco\n" + 
				"join information_schema.key_column_usage kcu\n" + 
				"          on tco.constraint_schema = kcu.constraint_schema\n" + 
				"          and tco.constraint_name = kcu.constraint_name\n" + 
				"join information_schema.referential_constraints rco\n" + 
				"          on tco.constraint_schema = rco.constraint_schema\n" + 
				"          and tco.constraint_name = rco.constraint_name\n" + 
				"join information_schema.table_constraints rel_tco\n" + 
				"          on rco.unique_constraint_schema = rel_tco.constraint_schema\n" + 
				"          and rco.unique_constraint_name = rel_tco.constraint_name\n" + 
				"where tco.constraint_type = 'FOREIGN KEY'\n" + 
				"group by kcu.table_schema,\n" + 
				"         kcu.table_name,\n" + 
				"         rel_tco.table_name,\n" + 
				"         rel_tco.table_schema,\n" + 
				"         kcu.constraint_name\n" + 
				"";
	}

	@Override
	public String getColumnDefaultListSql() {
		return "SELECT\n" + 
				"	table_schema || '.' || table_name as fullTableName,\n" + 
				"	column_name as columnName,\n" + 
				"	column_default as defaultValue\n" + 
				"FROM\n" + 
				"	information_schema.columns\n" + 
				"WHERE table_schema != 'pg_catalog' AND \n" + 
				"    table_schema != 'information_schema';\n";
	}

	@Override
	public String getUniqueColumnListSql() {
		return "SELECT \n" + 
				"	kcu.table_schema || '.' || kcu.table_name as fullTableName,\n" + 
				"	kcu.column_name as columnName\n" + 
				"FROM \n" + 
				"	pg_catalog.pg_constraint pgc\n" + 
				"INNER JOIN pg_catalog.pg_class rel\n" + 
				"    ON rel.oid = pgc.conrelid\n" + 
				"INNER JOIN pg_catalog.pg_namespace nsp\n" + 
				"	ON nsp.oid = connamespace\n" + 
				"JOIN information_schema.key_column_usage kcu \n" + 
				"	ON kcu.constraint_name = pgc.conname\n" + 
				"WHERE \n" + 
				"	contype='u'\n" + 
				"	and nsp.nspname != 'information_schema'\n" + 
				"	and nsp.nspname != 'pg_catalog' \n" + 
				"";
	}

	@Override
	public String getViewsDDLSql() {
		return "select \n" + 
				"	schemaname || '.' || viewname as viewName,\n" + 
				"	definition as viewDDL\n" + 
				"from \n" + 
				"	pg_catalog.pg_views	\n" + 
				"where\n" + 
				"	schemaname != 'information_schema' and schemaname != 'pg_catalog'\n";
	}

}
