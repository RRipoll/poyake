package com.jsantos.metadata.plugin.dbmanager.reverseengineer.vendor;

import com.jsantos.metadata.plugin.dbmanager.reverseengineer.ICatalogInfoQueryProvider;

public class SqlServerCatalogInfoProvider implements ICatalogInfoQueryProvider{

	@Override
	public String getTableListSql() {
		return "select s.name + '.' + t.name as fullTableName from sys.tables t join sys.schemas s on t.schema_id =s.schema_id ";
	}

	@Override
	public String getFieldListSql() {
		return "select\n" + 
				"s.name + '.' + t.name as fullTableName\n" + 
				",c.name as columnName\n" + 
				",ty.name as dataTypeName\n" + 
				",c.is_nullable as isColumnNullable\n" + 
				"--,c.max_length\n" + 
				"--,ty.max_length as typeMaxLength\n" + 
				"--,c.precision\n" + 
				"--,ty.[precision] as typePrecission\n" + 
				"--,c.scale\n" + 
				"--,ty.[scale] as typeScale\n" + 
				",iif(ty.[scale] =0, null, c.[scale] ) as [columnScale]\n" + 
				",iif(ty.[precision] =0, c.max_length , c.[precision] ) as columnLength\n" + 
				"from\n" + 
				"sys.columns c\n" + 
				"join sys.tables t on c.object_id = t.object_id\n" + 
				"join sys.types ty on ty.system_type_id =c.system_type_id\n" + 
				"join sys.schemas s on t.schema_id =s.schema_id\n";
	}

	@Override
	public String getPrimaryKeyListSql() {
		return "select\n" + 
				"schema_name(tab.schema_id) + '.' + tab.[name] as fullTableName\n" + 
				",col.[name] as columnName\n" + 
				"from sys.tables tab\n" + 
				"inner join sys.indexes pk\n" + 
				"on tab.object_id = pk.object_id\n" + 
				"and pk.is_primary_key = 1\n" + 
				"inner join sys.index_columns ic\n" + 
				"on ic.object_id = pk.object_id\n" + 
				"and ic.index_id = pk.index_id\n" + 
				"inner join sys.columns col\n" + 
				"on pk.object_id = col.object_id\n" + 
				"and col.column_id = ic.column_id\n" + 
				"order by schema_name(tab.schema_id),\n" + 
				"pk.[name],\n" + 
				"ic.index_column_id\n";
	}

	@Override
	public String getForeignKeyListSql() {
		return "select\n" + 
				"schema_name(fromTable.schema_id) + '.' + fromTable.name fromTableName\n" + 
				",colFrom.name fromColumn\n" + 
				", schema_name(toTable.schema_id) + '.' + toTable.name toTableName\n" + 
				",colTo.name toColumn\n" + 
				"from\n" + 
				"sys.foreign_keys fk\n" + 
				"inner join sys.tables fromTable on fromTable.object_id = fk.parent_object_id\n" + 
				"inner join sys.tables toTable on toTable.object_id = fk.referenced_object_id\n" + 
				"inner join sys.foreign_key_columns fk_col on fk_col.constraint_object_id = fk.object_id\n" + 
				"inner join sys.columns colFrom on fk_col.parent_column_id=colFrom.column_id and colFrom.object_id=fromTable.object_id\n" + 
				"inner join sys.columns colTo on fk_col.referenced_column_id =colTo.column_id and colTo.object_id=toTable.object_id\n";
	}

	@Override
	public String getColumnDefaultListSql() {
		return "select\n" + 
				"schema_name(t.schema_id) + '.' + t.[name] as fullTableName\n" + 
				",col.[name] as columnName\n" + 
				",con.[definition] as defaultValue\n" + 
				"from\n" + 
				"sys.default_constraints con\n" + 
				"left outer join sys.objects t on con.parent_object_id = t.object_id\n" + 
				"left outer join sys.all_columns col on con.parent_column_id = col.column_id and con.parent_object_id = col.object_id\n";
	}

	@Override
	public String getUniqueColumnListSql() {
		return "select\n" + 
				"schema_name(t.schema_id) + '.' + t.[name] as fullTableName\n" + 
				",i.name as indexName\n" + 
				",x.colName as columnName\n" + 
				"from\n" + 
				"sys.objects t --tables\n" + 
				"join sys.indexes i on i.object_id =t.object_id and i.is_unique =1 and t.[type] ='U'\n" + 
				"join sys.key_constraints c on i.object_id = c.parent_object_id and i.index_id = c.unique_index_id and c.[type] ='UQ'\n" + 
				"join (\n" + 
				"select col.[name] as colName\n" + 
				",ic.index_id\n" + 
				",ic.object_id\n" + 
				",ic.column_id\n" + 
				"from sys.index_columns ic\n" + 
				"inner join sys.columns col\n" + 
				"on ic.object_id = col.object_id\n" + 
				"and ic.column_id = col.column_id\n" + 
				") X on X.index_id=i.index_id and x.object_id=t.object_id\n";
	}

	@Override
	public String getViewsDDLSql() {
		return " select schema_name(v.schema_id) + '.' + v.name as viewName, m.definition as viewDDL from sys.views v join sys.sql_modules m on m.object_id =v.object_id";
	}
}
