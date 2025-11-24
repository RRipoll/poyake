package com.jsantos.metadata.plugin.querymanager.jdbcresolver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCResolver {
	ArrayList<JDBCResolverColumn> columns = new ArrayList<>();
	
	public void executeQuery(String query, Connection conn) throws SQLException {
		try(Statement st=conn.createStatement(); ResultSet rs=st.executeQuery(query)){
			ResultSetMetaData md = rs.getMetaData();
			for (int nCol=1; nCol<=md.getColumnCount(); nCol++) {
				JDBCResolverColumn column = new JDBCResolverColumn();
				column.setName(md.getColumnLabel(nCol));
				column.setType(md.getColumnTypeName(nCol));
				column.setSize(md.getColumnDisplaySize(nCol));
				column.setPrecission(md.getPrecision(nCol));
				column.setScale(md.getScale(nCol));
				columns.add(column);
			}
		}
	}
	
	public List<JDBCResolverColumn> getColumns(){
		return columns;
	}
	
	public String logInfo() {
		String info = "JDBC Resolver Info: \r\n" ;
		for (JDBCResolverColumn column:columns) {
			info += "Column: " + column.getName() + "\r\n";
			info += "\t" + column.toString() + "\r\n";
		}
		return info;
	}
}
