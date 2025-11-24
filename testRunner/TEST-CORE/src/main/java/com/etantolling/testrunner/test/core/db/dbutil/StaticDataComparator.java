package com.etantolling.testrunner.test.core.db.dbutil;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.cli.CliContextInitializer;
import com.etantolling.testrunner.test.core.cli.configfolder.ConfigFolderHelper;
import com.etantolling.testrunner.test.core.cli.connectionpool.CliConnectionPoolLoader;
import com.etantolling.testrunner.test.core.metadata.MTBase;

public class StaticDataComparator {
	private static final Logger log = LoggerFactory.getLogger(StaticDataComparator.class);

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		CliContextInitializer.initialize();
		DataSource mdwDataSource = CliConnectionPoolLoader.initFromXml(ConfigFolderHelper.getConfigFile("connection_pool.xml").getCanonicalPath(),
				"jdbc/idc_mdw");
		DataSource mdtDataSource = CliConnectionPoolLoader.initFromXml(ConfigFolderHelper.getConfigFile("connection_pool.xml").getCanonicalPath(),
				"jdbc/preprod");

		compareTables(mdwDataSource.getConnection(), mdtDataSource.getConnection(), StaticDataExporter.tablesAndFilters);
	}

	public static void compareTables(Connection connMdw, Connection connMdt, String[][] tablesAndFilters) throws SQLException, IOException {
		Statement stMdw = connMdw.createStatement();
		Statement stMdt = connMdt.createStatement();

		for (String[] tableAndFilter : tablesAndFilters) {
			String tableName = tableAndFilter[0];
			String filter = tableAndFilter[1];
			log.info("-- TABLE: " + tableName);
			ResultSet rsMdw = getTableData(connMdw, stMdw, tableName, filter);
			ResultSet rsMdt = getTableData(connMdt, stMdt, tableName, filter);

			if (areTableEquals(rsMdw, rsMdt, tableName))
				log.info("--Data match");
		}
	}

	public static boolean areTableEquals(ResultSet rsMdw, ResultSet rsMdt, String tableName) throws SQLException, IOException {
		boolean bRetValue = true;
		while (rsMdw.next()) {
			if (rsMdt.next()) {
				if (!recordsEqual(rsMdw, rsMdt)) {
					log.info("--Different records for table: " + tableName);
					System.out.print("--MDW: ");
					dumpRecord(rsMdw);
					System.out.print("--MDT: ");
					dumpRecord(rsMdt);
					bRetValue = false;
				}
			} else {
				log.info("--Missing record in Mdt for record in mdw " + tableName);
				StringWriter writer = new StringWriter();

				if (tableHasIdentity(rsMdw))
					writer.write("SET IDENTITY_INSERT " + tableName + " ON" + " \r\n");
				TableDataExporter.exportRecordForInsert(rsMdw, tableName, writer);
				if (tableHasIdentity(rsMdw))
					writer.write("SET IDENTITY_INSERT " + tableName + " OFF" + " \r\n");

				log.info(writer.toString());
				bRetValue = false;
			}
		}
		return bRetValue;
	}

	public static boolean recordsEqual(ResultSet rsMdw, ResultSet rsMdt) throws SQLException {
		for (int nCol = 1; nCol <= rsMdw.getMetaData().getColumnCount(); nCol++) {
			if (!StringUtils.equals(rsMdw.getString(nCol), (rsMdt.getString(nCol))))
				return false;
		}
		return true;
	}

	public static ResultSet getTableData(Connection conn, Statement st, String tableName, String filter) throws SQLException {
		if (!SqlServerTableInfo.exists(conn, tableName)) {
			log.info("Table: " + tableName + " doesn't exist. Not exporting.");
			return null;
		}
		String sql = "select * from " + tableName + " " + filter;
		if (null != MTBase.getTable(tableName) && null != MTBase.getTable(tableName).getPrimaryKey())
			sql += " order by " + MTBase.getTable(tableName).getPrimaryKey();

		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	static void dumpRecord(ResultSet rs) throws SQLException {
		Hashtable<String, String> values = new Hashtable<String, String>();
		for (int nCol = 1; nCol <= rs.getMetaData().getColumnCount(); nCol++)
			values.put(rs.getMetaData().getColumnName(nCol), (null == rs.getString(nCol) ? "NULL" : rs.getString(nCol)));
		log.info(values.toString());
	}

	static boolean tableHasIdentity(ResultSet rs) throws SQLException {
		for (int nCol = 1; nCol <= rs.getMetaData().getColumnCount(); nCol++) {
			if (rs.getMetaData().getColumnTypeName(nCol).contains("int identity"))
				return true;
		}
		return false;
	}

}
