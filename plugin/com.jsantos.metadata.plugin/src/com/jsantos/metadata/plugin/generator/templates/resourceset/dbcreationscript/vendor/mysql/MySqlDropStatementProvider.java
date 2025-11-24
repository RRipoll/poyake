package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsantos.metadata.plugin.dbmanager.IDBStatementProvider;

public class MySqlDropStatementProvider  implements IDBStatementProvider {
	Connection conn;
	
	@Override
	public List<String> buildStatements(){
		ArrayList<String> all = new ArrayList<>();
		try (Statement st = conn.createStatement()){
			String databaseName = getDatabaseName(st);
			all.add("DROP DATABASE " + databaseName);
			all.add("CREATE DATABASE " + databaseName);
			all.add("USE " + databaseName);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
		
	}
	
	String getDatabaseName(Statement st) throws SQLException {
		String databaseName=null;
		try(ResultSet rs = st.executeQuery("SELECT DATABASE()")){
			rs.next();
			databaseName = rs.getString(1);
		}
		return databaseName;
	}

	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	


}
