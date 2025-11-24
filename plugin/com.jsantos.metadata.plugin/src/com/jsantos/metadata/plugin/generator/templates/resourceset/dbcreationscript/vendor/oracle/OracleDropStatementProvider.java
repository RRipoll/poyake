package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsantos.metadata.plugin.dbmanager.IDBStatementProvider;
import com.jsantos.metadata.plugin.util.Logger;

public class OracleDropStatementProvider implements IDBStatementProvider{

	Connection conn;
	
	@Override
	public List<String> buildStatements() {
		ArrayList<String> statements = new ArrayList<String>();
		
		String sql = "SELECT 'drop ' || object_type || ' ' || OBJECT_name || ' CASCADE CONSTRAINTS PURGE' AS dropStatement, object_name, object_type\n" + 
				"FROM user_objects\n" + 
				"WHERE object_type IN\n" + 
				"('TABLE','VIEW')"; 
				
		try(Statement st = conn.createStatement(); ResultSet rs=st.executeQuery(sql)){
			while(rs.next())
				statements.add(rs.getString("dropStatement"));
		}
		catch(SQLException e) {
			Logger.error("SqlServerDropStatementProvider error", e);
		}

		sql = "SELECT 'drop ' || object_type || ' ' || OBJECT_name AS dropStatement, object_name, object_type\n" + 
				"FROM user_objects\n" + 
				"WHERE object_type IN\n" + 
				"(" + 
				"'PACKAGE',\n" + 
				"'PROCEDURE',\n" + 
				"'FUNCTION',\n" + 
				"'SEQUENCE',\n" + 
				"'SYNONYM'\n" + 
				")\n"; 
				
		try(Statement st = conn.createStatement(); ResultSet rs=st.executeQuery(sql)){
			while(rs.next())
				statements.add(rs.getString("dropStatement"));
		}
		catch(SQLException e) {
			Logger.error("SqlServerDropStatementProvider error", e);
		}
		
		return statements;
	}

	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}


}
