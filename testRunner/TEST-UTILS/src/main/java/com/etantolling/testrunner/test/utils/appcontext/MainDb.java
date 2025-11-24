package com.etantolling.testrunner.test.utils.appcontext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainDb {
	private static DataSource mainDataSource = null;
	private static DataSource latitudeDataSource = null;
	private static DataSource reportsDataSource = null;
	private static DataSource testDataSource = null;
	private static final Logger log = LoggerFactory.getLogger(MainDb.class);

	public static Connection getConnection() throws SQLException {
		return mainDataSource.getConnection();
	}

	public static DataSource getMainDataSource() throws SQLException {
		return mainDataSource;
	}

	public static void setMainDataSource(DataSource dataSource) {
		Connection conn;
		try {
			conn = dataSource.getConnection();
			log.warn("*** Registering dataSource. Connection url = {} for user {}", conn.getMetaData().getURL(), conn.getMetaData().getUserName());
			String sql = "select * from adm_app_info where skey='DATABASE_ID'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next())
				log.info("Checking DATABASE_ID: " + rs.getString("svalue"));
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE: ", e);
		}
		mainDataSource = dataSource;
		
	};

	public static Connection getLatitudeConnection() throws SQLException {
		return latitudeDataSource.getConnection();
	}

	public static void setLatitudeDataSource(DataSource dataSource) {
		latitudeDataSource = dataSource;
	}

	public static Connection getReportsConnection() throws SQLException {
		return reportsDataSource.getConnection();
	}

	public static void setReportsDataSource(DataSource reportsDataSource) {
		MainDb.reportsDataSource = reportsDataSource;
	}

	public static Connection getTestConnection() throws SQLException {
		return testDataSource.getConnection();
	}

	public static void setTestDataSource(DataSource dataSource) {
		testDataSource = dataSource;
	}
}