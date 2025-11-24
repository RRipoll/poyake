package com.etantolling.testrunner.test.core.db.dbutil;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;

public class TableDataExporter {
	static public SimpleDateFormat americanDate = new SimpleDateFormat("MM/dd/yyyy");
	static public SimpleDateFormat isoDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	public static void exportForInsert(Connection conn, String tableName, String filter, FileWriter writer) throws SQLException, IOException{
		if (!SqlServerTableInfo.exists(conn, tableName)){
			System.out.println("Table: " + tableName + " doesn't exist. Not exporting.");
			return;
		}
		if (null == filter) filter = "";
		String sql = "select * from " + tableName + " " + filter;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		writer.write(" \r\n");
		writer.write("-- " + tableName + " \r\n");
		writer.write("delete from " + tableName + " \r\n");
		
		boolean isIdentityTable = tableHasIdentity(rs);
		if (isIdentityTable) 
			writer.write("SET IDENTITY_INSERT " + tableName + " ON" + " \r\n");
		
		while (rs.next()){
			exportRecordForInsert(rs, tableName, writer);
		}
		if (isIdentityTable) 
		writer.write("SET IDENTITY_INSERT " + tableName + " OFF" + " \r\n");
		
	}
	
	public static void exportRecordForInsert(ResultSet rs, String tableName, Writer writer) throws SQLException, IOException{
		StringBuilder sb = new StringBuilder("insert into " + tableName + " (");

		// export column names
		for (int nCol=1; nCol<=rs.getMetaData().getColumnCount(); nCol++){
			//don't export if type is entrytime
			if (-2 == rs.getMetaData().getColumnType(nCol)) continue;
			
			if (nCol >1) sb.append(",");
			sb.append(rs.getMetaData().getColumnName(nCol));
		}
		
		sb.append(") values (");
		
		// export column fields
		for (int nCol=1; nCol<=rs.getMetaData().getColumnCount(); nCol++){
			
			//don't export if type is entrytime
			if (-2 == rs.getMetaData().getColumnType(nCol)) continue;

			if (nCol >1) sb.append(",");
			if (null == rs.getString(nCol)) {
				sb.append("NULL");
				continue;
			}
			
			switch (rs.getMetaData().getColumnType(nCol)){
			
			case Types.BIT:
			case Types.INTEGER:
			case Types.DECIMAL:
			case Types.BIGINT:
			case Types.SMALLINT:
			case Types.DOUBLE:
			case Types.FLOAT:
			case Types.NUMERIC:
			case Types.REAL:
			case Types.REF:
			case Types.ROWID:
			case Types.TINYINT:
				sb.append(rs.getString(nCol));
				break;
			
			case Types.CHAR:
			case Types.NCHAR:
			case Types.NVARCHAR:
			case Types.SQLXML:
			case Types.VARCHAR:
			case Types.CLOB:
				sb.append("'").append(rs.getString(nCol).replaceAll("'", "''")).append("'");
				break;
			case Types.DATE:
				sb.append("CONVERT(Date, '" + americanDate.format(rs.getDate(nCol)) + "', 101)");
				break;
			case Types.TIMESTAMP:
				sb.append("CONVERT(DateTime, '" + isoDateTime.format(rs.getDate(nCol)) + "', 126)");
				break;
			case Types.TIME:
				throw new RuntimeException("Time type not supported yet");
			default:
				throw new RuntimeException("The type of field (" +  rs.getMetaData().getColumnType(nCol) + ") is not supported yet. Column: " + tableName + "." + rs.getMetaData().getColumnName(nCol));
				
			}
		}
		sb.append(")");
		
		writer.write(sb.toString());
		writer.write("\r\n");
		
	}
	
	static boolean tableHasIdentity(ResultSet rs) throws SQLException{
		for (int nCol=1; nCol<=rs.getMetaData().getColumnCount(); nCol++){
			if (rs.getMetaData().getColumnTypeName(nCol).contains("int identity")) return true;
		}
		return false;
	}
}
