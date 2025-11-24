package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.sqlserver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsantos.metadata.plugin.dbmanager.DefaultDropStatementProvider;
import com.jsantos.metadata.plugin.util.Logger;

public class SqlServerDropStatementProvider extends DefaultDropStatementProvider {
	Connection conn;
	
	@Override
	public List<String> buildStatements(){
		ArrayList<String> all = new ArrayList<>();
		try(Statement st = conn.createStatement()){
			all.addAll(buildDropConstraintStatements(st));
			all.addAll(buildDropSequenceStatements(st));
			all.addAll(buildDropFunctionStatements(st));
			all.addAll(buildDropViewStatements(st));
			all.addAll(buildDropTableStatements(st));
			all.addAll(buildDropSchemaStatements(st));
		}
		catch(SQLException e) {
			Logger.error("SqlServerDropStatementProvider error", e);
		}
		return all;
	}

	@Override
	public String getAllConstraintsSQL() throws IOException {
		return "select table_view,\n" + 
				"object_type,\n" + 
				"constraint_type,\n" + 
				"constraint_name,\n" + 
				"details\n" + 
				"from (\n" + 
				"select schema_name(t.schema_id) + '.' + t.[name] as table_view,\n" + 
				"case when t.[type] = 'U' then 'Table'\n" + 
				"when t.[type] = 'V' then 'View'\n" + 
				"end as [object_type],\n" + 
				"case when c.[type] = 'PK' then 'Primary key'\n" + 
				"when c.[type] = 'UQ' then 'Unique constraint'\n" + 
				"when i.[type] = 1 then 'Unique clustered index'\n" + 
				"when i.type = 2 then 'Unique index'\n" + 
				"end as constraint_type,\n" + 
				"isnull(c.[name], i.[name]) as constraint_name,\n" + 
				"substring(column_names, 1, len(column_names)-1) as [details]\n" + 
				"from sys.objects t\n" + 
				"left outer join sys.indexes i\n" + 
				"on t.object_id = i.object_id\n" + 
				"left outer join sys.key_constraints c\n" + 
				"on i.object_id = c.parent_object_id\n" + 
				"and i.index_id = c.unique_index_id\n" + 
				"cross apply (select col.[name] + ', '\n" + 
				"from sys.index_columns ic\n" + 
				"inner join sys.columns col\n" + 
				"on ic.object_id = col.object_id\n" + 
				"and ic.column_id = col.column_id\n" + 
				"where ic.object_id = t.object_id\n" + 
				"and ic.index_id = i.index_id\n" + 
				"order by col.column_id\n" + 
				"for xml path ('') ) D (column_names)\n" + 
				"where is_unique = 1\n" + 
				"and t.is_ms_shipped <> 1\n" + 
				"union all\n" + 
				"select schema_name(fk_tab.schema_id) + '.' + fk_tab.name as foreign_table,\n" + 
				"'Table',\n" + 
				"'Foreign key',\n" + 
				"fk.name as fk_constraint_name,\n" + 
				"schema_name(pk_tab.schema_id) + '.' + pk_tab.name\n" + 
				"from sys.foreign_keys fk\n" + 
				"inner join sys.tables fk_tab\n" + 
				"on fk_tab.object_id = fk.parent_object_id\n" + 
				"inner join sys.tables pk_tab\n" + 
				"on pk_tab.object_id = fk.referenced_object_id\n" + 
				"inner join sys.foreign_key_columns fk_cols\n" + 
				"on fk_cols.constraint_object_id = fk.object_id\n" + 
				"union all\n" + 
				"select schema_name(t.schema_id) + '.' + t.[name],\n" + 
				"'Table',\n" + 
				"'Check constraint',\n" + 
				"con.[name] as constraint_name,\n" + 
				"con.[definition]\n" + 
				"from sys.check_constraints con\n" + 
				"left outer join sys.objects t\n" + 
				"on con.parent_object_id = t.object_id\n" + 
				"left outer join sys.all_columns col\n" + 
				"on con.parent_column_id = col.column_id\n" + 
				"and con.parent_object_id = col.object_id\n" + 
				"union all\n" + 
				"select schema_name(t.schema_id) + '.' + t.[name],\n" + 
				"'Table',\n" + 
				"'Default constraint',\n" + 
				"con.[name],\n" + 
				"col.[name] + ' = ' + con.[definition]\n" + 
				"from sys.default_constraints con\n" + 
				"left outer join sys.objects t\n" + 
				"on con.parent_object_id = t.object_id\n" + 
				"left outer join sys.all_columns col\n" + 
				"on con.parent_column_id = col.column_id\n" + 
				"and con.parent_object_id = col.object_id) a\n" + 
				"order by constraint_type, table_view, constraint_name\n";
	}

	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
}
