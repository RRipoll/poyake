package com.etantolling.testrunner.test.core.db.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlServerTableInfo {
	
	
	public static boolean exists(Connection conn, String tableName) throws SQLException{
		String sql = "IF EXISTS (SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='BASE TABLE' AND TABLE_NAME=?) SELECT 1 AS res ELSE SELECT 0 AS res";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, tableName);
		ResultSet rs = pst.executeQuery();
		rs.next();
		boolean retValue = (1 == rs.getInt(1));
		rs.close();
		pst.close();
		return retValue;
	}
}
