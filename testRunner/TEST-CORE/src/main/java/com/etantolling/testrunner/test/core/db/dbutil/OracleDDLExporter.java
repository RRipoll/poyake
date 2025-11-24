package com.etantolling.testrunner.test.core.db.dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class OracleDDLExporter {
	public static void main(String[] args) throws SQLException{
		Connection conn = MainDb.getConnection();
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("");
			while (rs.next()){
				rs.getString(1);
			}
		}
		finally{
			conn.close();
		}
	}
}
