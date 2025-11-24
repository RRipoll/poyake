package com.jsantos.metadata.plugin.dbmanager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DefaultDropStatementProvider implements IDBStatementProvider{

	public abstract String getAllConstraintsSQL() throws IOException;


	public List<String> buildDropConstraintStatements(Statement st) throws SQLException {

		ArrayList<String> dropStatements = new ArrayList<>();
		try {
			String sql = getAllConstraintsSQL();
			try(ResultSet rs = st.executeQuery(sql)){
				while (rs.next()) {
					String statement = "ALTER " + rs.getString("object_type") + " " + rs.getString("table_view") + " DROP CONSTRAINT " + rs.getString("constraint_name");
					dropStatements.add(statement);
				}
			}
		}
		catch (IOException e) {
			throw new SQLException(e.getMessage(), e);
		}
		return dropStatements;
	}

	public List<String> buildDropFunctionStatements(Statement st) throws SQLException {
		ArrayList<String> dropStatements = new ArrayList<>();
		String sql = "select 'drop function [' + schema_name(schema_id) + '].[' + name + ']' as statement from sys.objects where type in ( 'FN', 'IF', 'TF' )"; 
		try(ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				dropStatements.add(rs.getString(1));
			}
		}
		return dropStatements;

	}

	public List<String> buildDropSequenceStatements(Statement st) throws SQLException {

		ArrayList<String> dropStatements = new ArrayList<>();
		String sql = "select sch.name + '.' + seq.name as sequenceFullName from sys.sequences seq join sys.schemas sch on seq.schema_id =sch.schema_id";
		try(ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				String statement = "DROP SEQUENCE " + rs.getString("sequenceFullName");
				dropStatements.add(statement);
			}
		}
		return dropStatements;
	}

	public List<String> buildDropSchemaStatements(Statement st) throws SQLException {

		ArrayList<String> dropStatements = new ArrayList<>();
		String sql = "select name from sys.schemas where principal_id=1 and name <>'dbo'";
		try(ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				String statement = "DROP SCHEMA " + rs.getString("name");
				dropStatements.add(statement);
			}
		}
		return dropStatements;
	}

	public List<String> buildDropViewStatements(Statement st) throws SQLException {

		ArrayList<String> dropStatements = new ArrayList<>();
		String sql = "select table_schema + '.' + table_name as fullViewName from information_schema.views";
		try(ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				String statement = "DROP VIEW " + rs.getString("fullViewName");
				dropStatements.add(statement);
			}
		}
		return dropStatements;
	}

	public List<String> buildDropTableStatements(Statement st) throws SQLException {

		ArrayList<String> dropStatements = new ArrayList<>();
		String sql = "SELECT table_schema + '.' + table_name as fullViewName  FROM information_schema.tables WHERE table_type = 'base table'";
		try(ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				String statement = "DROP TABLE " + rs.getString("fullViewName");
				dropStatements.add(statement);
			}
		}
		return dropStatements;
	}
}
