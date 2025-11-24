package com.etantolling.testrunner.test.core.facade.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationLogDAO {
	public List<String>list(final Connection conn, Integer maxLogLevel) throws SQLException{
		List<String> logs = new ArrayList<String>();
		/*
		try(final PreparedStatement pst = conn.prepareStatement("select message from applicationLog where apploglevelid<=" + maxLogLevel + " order by created asc")){
			try(final ResultSet rs = pst.executeQuery()){
				while(rs.next()){	
					logs.add(rs.getString(1));
				}
			}
		}
		*/
		return logs;
	}
}
