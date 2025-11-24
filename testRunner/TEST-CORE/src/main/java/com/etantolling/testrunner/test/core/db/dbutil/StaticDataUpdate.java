package com.etantolling.testrunner.test.core.db.dbutil;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Hashtable;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import com.etantolling.testrunner.test.core.cli.CliContextInitializer;
import com.etantolling.testrunner.test.core.cli.configfolder.ConfigFolderHelper;
import com.etantolling.testrunner.test.core.cli.connectionpool.CliConnectionPoolLoader;
import com.etantolling.testrunner.test.core.metadata.MTBase;

public class StaticDataUpdate {
	
	public static String[][] tablesAndFilters = {
		{"BO_LetterTemplateKeys",""},
		{"BO_LetterTemplate",""},
		{"StaticTemplates",""},
	};
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
		CliContextInitializer.initialize();
		DataSource mdwDataSource = CliConnectionPoolLoader.initFromXml(ConfigFolderHelper.getConfigFile("connection_pool.xml").getCanonicalPath(), "jdbc/idc_mdw");
		DataSource mdtDataSource = CliConnectionPoolLoader.initFromXml(ConfigFolderHelper.getConfigFile("connection_pool.xml").getCanonicalPath(), "jdbc/preprod");
		
		updateTables(mdwDataSource.getConnection(), mdtDataSource.getConnection(), StaticDataUpdate.tablesAndFilters);
	}	
	
	public static void updateTables(Connection connMdw, Connection connMdt, String[][] tablesAndFilters) throws SQLException, IOException{
		Statement stMdw = connMdw.createStatement();
		Statement stMdt = connMdt.createStatement();
		
		for (String[] tableAndFilter:tablesAndFilters){
			String tableName = tableAndFilter[0];
			String filter = tableAndFilter[1];
			System.out.println("-- TABLE: " + tableName );
			ResultSet rsMdw = getTableData(connMdw, stMdw, tableName, filter);
			ResultSet rsMdt = getTableData(connMdt, stMdt, tableName, filter);
			if (areTableEquals(rsMdw, rsMdt, tableName))
				System.out.println("--Data match");
		}		
	}
	
	public static boolean areTableEquals(ResultSet rsMdw, ResultSet rsMdt, String tableName) throws SQLException, IOException{
		boolean bRetValue = true;
		while (rsMdw.next()){
			if (rsMdt.next()){
				if (!recordsEqual(rsMdw, rsMdt)){
					StringWriter writer = new StringWriter();
					
					System.out.println("--Different records for table: " + tableName);
					if (tableHasIdentity(rsMdw)) 
						writer.write("SET IDENTITY_INSERT " + tableName + " ON" + " \r\n");
					exportRecordForUpdate(rsMdw, tableName, writer);
					if (tableHasIdentity(rsMdw)) 
						writer.write("SET IDENTITY_INSERT " + tableName + " OFF" + " \r\n");
					bRetValue = false;
					System.out.println(writer.toString());

				}
			}
			else {
				StringWriter writer = new StringWriter();

				System.out.println("--Missing record in Mdt for record in mdw " + tableName);
				
				if (tableHasIdentity(rsMdw)) 
					writer.write("SET IDENTITY_INSERT " + tableName + " ON" + " \r\n");
				TableDataExporter.exportRecordForInsert(rsMdw, tableName, writer);
				if (tableHasIdentity(rsMdw)) 
					writer.write("SET IDENTITY_INSERT " + tableName + " OFF" + " \r\n");
				System.out.println(writer.toString());
				
				bRetValue = false;
			}
		}
		return bRetValue;
	}
	
	
	public static boolean recordsEqual(ResultSet rsMdw, ResultSet rsMdt) throws SQLException{
		for (int nCol=1; nCol<= rsMdw.getMetaData().getColumnCount(); nCol++){
			if (!StringUtils.equals(rsMdw.getString(nCol),(rsMdt.getString(nCol))))
				return false;
		}
		return true;
	}
	
	public static ResultSet getTableData(Connection conn, Statement st, String tableName, String filter) throws SQLException{
		if (!SqlServerTableInfo.exists(conn, tableName)){
			System.out.println("Table: " + tableName + " doesn't exist. Not exporting.");
			return null;
		}
		String sql = "select * from " + tableName + " " + filter;
		if (null != MTBase.getTable(tableName) && null != MTBase.getTable(tableName).getPrimaryKey())
			sql += " order by " + MTBase.getTable(tableName).getPrimaryKey();
			
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	static void dumpRecord(ResultSet rs) throws SQLException{
		Hashtable<String, String> values = new Hashtable<String, String>();
		for (int nCol=1; nCol<= rs.getMetaData().getColumnCount(); nCol++)
			values.put(rs.getMetaData().getColumnName(nCol), (null==rs.getString(nCol)?"NULL":rs.getString(nCol)));
		System.out.println(values);
	}
	
	static boolean tableHasIdentity(ResultSet rs) throws SQLException{
		for (int nCol=1; nCol<=rs.getMetaData().getColumnCount(); nCol++){
			if (rs.getMetaData().getColumnTypeName(nCol).contains("int identity")) return true;
		}
		return false;
	}
	
	public static void exportRecordForUpdate(ResultSet rs, String tableName, Writer writer) throws SQLException, IOException{
		StringBuilder sb = new StringBuilder("update " + tableName + " set ");

		String where=" where ";
		
		
		// export column names
		for (int nCol=1; nCol<=rs.getMetaData().getColumnCount(); nCol++){
			//don't export if type is entrytime
			if (-2 == rs.getMetaData().getColumnType(nCol)) continue;
			if( rs.getMetaData().getColumnName(nCol).equalsIgnoreCase(MTBase.getTable(tableName).getPrimaryKey().getName())){
				where+= MTBase.getTable(tableName).getPrimaryKey()+" = "+rs.getInt(nCol);
				continue;
			}
			if (nCol >2) sb.append(",");
			sb.append(rs.getMetaData().getColumnName(nCol));
			sb.append("=");
		
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
				sb.append("CONVERT(Date, '" + TableDataExporter.americanDate.format(rs.getDate(nCol)) + "', 101)");
				break;
			case Types.TIMESTAMP:
				sb.append("CONVERT(DateTime, '" + TableDataExporter.isoDateTime.format(rs.getDate(nCol)) + "', 126)");
				break;
			case Types.TIME:
				throw new RuntimeException("Time type not supported yet");
			default:
				throw new RuntimeException("The type of field (" +  rs.getMetaData().getColumnType(nCol) + ") is not supported yet. Column: " + tableName + "." + rs.getMetaData().getColumnName(nCol));
				
			}

			
			
		}
		sb.append(where);
		writer.write(sb.toString());
		writer.write("\r\n");
		
	}
}
