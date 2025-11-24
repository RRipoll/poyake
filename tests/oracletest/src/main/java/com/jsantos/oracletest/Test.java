package com.jsantos.oracletest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jsantos.orm.MainDb;

public class Test {
	public static void main(String[] args) throws SQLException {
		new Test().doIt();
	}
	
	void doIt() throws SQLException {
		MainDb.setMainDataSource(DataSourceProvider.oracleDataSource());
		
		String sql = "SELECT object_name, object_type\n" + 
				"FROM user_objects\n" + 
				"WHERE object_type IN\n" + 
				"('TABLE',\n" + 
				"'VIEW',\n" + 
				"'PACKAGE',\n" + 
				"'PROCEDURE',\n" + 
				"'FUNCTION',\n" + 
				"'SEQUENCE',\n" + 
				"'SYNONYM'\n" + 
				")\n";
		try (Connection conn =MainDb.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
		
	}
}
