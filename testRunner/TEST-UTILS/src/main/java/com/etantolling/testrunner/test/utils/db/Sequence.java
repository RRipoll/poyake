package com.etantolling.testrunner.test.utils.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sequence {
	public static Integer nextForTable(Connection conn, String tableName) throws SQLException{
		return next(conn, "seq_" + tableName);
	}
	
	public static Integer next(Connection conn, String name) throws SQLException{
		Integer retValue = null;
		//String sql = "select " + name + ".nextval from dual";
		String sql = "select NEXT VALUE FOR "+name;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		retValue = rs.getInt(1);
		rs.close();
		st.close();
		return retValue;
	}
}
