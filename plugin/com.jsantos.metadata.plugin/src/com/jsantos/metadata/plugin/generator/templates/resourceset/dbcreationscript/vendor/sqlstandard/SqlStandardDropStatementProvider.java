package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.sqlstandard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsantos.metadata.plugin.dbmanager.DefaultDropStatementProvider;
import com.jsantos.metadata.plugin.util.EclipseFileUtil;

public class SqlStandardDropStatementProvider extends DefaultDropStatementProvider {
	Connection conn;
	
	@Override
	public List<String> buildStatements(){
		ArrayList<String> all = new ArrayList<>();
		try(Statement st = conn.createStatement()){
			all.addAll(buildDropConstraintStatements(st));
			all.addAll(buildDropSequenceStatements(st));
			all.addAll(buildDropViewStatements(st));
			all.addAll(buildDropTableStatements(st));
			all.addAll(buildDropSchemaStatements(st));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public String getAllConstraintsSQL() {
		try {
			return new EclipseFileUtil().readResourceFile("/src/com/jsantos/metadata/plugin/dbmanager/vendor/sqlserver/query_GetAllConstraints.sql");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
}
