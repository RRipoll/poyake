package com.etantolling.testrunner.test.utils.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.commons.dbutils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.misc.RhinoEscaper;


//import oracle.sql.CLOB;

@SuppressWarnings("deprecation")
public class DBUtils {
	private static final Logger log = LoggerFactory.getLogger(DBUtils.class);

	public static int executeUpdate(String sql) throws SQLException {
		int nUpdated = 0;
		Connection conn = MainDb.getConnection();
		try {
			Statement st = conn.createStatement();
			nUpdated = st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
			throw new SQLException("Error: " + e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return nUpdated;
	}

	public static int executeUpdate(String sql, Connection conn) throws SQLException {
		int nUpdated = 0;
		Statement st = conn.createStatement();
		nUpdated = st.executeUpdate(sql);
		st.close();
		return nUpdated;
	}

	public static int[] executeBatch(String[] sqls) throws SQLException {
		Connection conn = null;
		Statement st = null;
		try {
			conn = MainDb.getConnection();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.clearBatch();
			for (int i = 0; i < sqls.length; i++) {
				String sql = sqls[i];
				log.info("Adding to batch :" + sql);
				st.addBatch(sql);
			}
			int[] retValue= st.executeBatch();
			 conn.commit();
			 return retValue;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw e;
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					log.error("ERROR STACKTRACE:",e);
				}
			}
			DbUtils.closeQuietly(st);
			DbUtils.closeQuietly(conn);
		}
	}

	public static String getSingleStringValue(String sql) throws SQLException {

		String retValue = null;
		Connection conn = MainDb.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next())
				retValue = rs.getString(1);
			st.close();
		} catch (SQLException e) {
			log.info("SQLException while running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return retValue;
	}
	
	public static String getSingleStringValue(Connection conn, String sql) throws SQLException {

		String retValue = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next())
				retValue = rs.getString(1);
		} catch (SQLException e) {
			log.info("SQLException while running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(st);
			DbUtils.closeQuietly(rs);
		}
		return retValue;
	}

	public static Integer getSingleIntegerValue(String sql) throws SQLException {

		Integer retValue = null;
		Connection conn = MainDb.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()){
				if(null==rs.getString(1))return null;
				retValue = rs.getInt(1);
			}
		} catch (SQLException e) {
			log.info("SQLException while running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(st);
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(conn);
		}
		return retValue;
	}
	
	public static Integer getSingleIntegerValue(Connection conn,String sql) throws SQLException {
		Integer retValue = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()){
				if(null==rs.getString(1))return null;
				retValue = rs.getInt(1);
			}
		} catch (SQLException e) {
			log.info("SQLException while running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(st);
		}
		return retValue;
	}

	public static BigDecimal getSingleBigDecimalValue(String sql) throws SQLException {

		BigDecimal retValue = null;
		Connection conn = MainDb.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next())
				retValue = rs.getBigDecimal(1);
			st.close();
		} catch (SQLException e) {
			log.info("SQLException while running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return retValue;
	}

	public static Boolean getSingleBooleanValue(String sql) throws SQLException {

		Boolean retValue = null;
		Connection conn = MainDb.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next())
				retValue = rs.getBoolean(1);
			st.close();
		} catch (SQLException e) {
			log.info("SQLException while running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return retValue;
	}

	public static Date getSingleDateValue(String sql) throws SQLException {
		Date retValue = null;
		Connection conn = MainDb.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next())
				retValue = rs.getDate(1);
			st.close();
		} catch (SQLException e) {
			log.info("SQLException while running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return retValue;
	}

	public static List<Object> getSingleValuesQueitly(String sql) throws SQLException {
		Connection conn = MainDb.getConnection();
		Statement st = null;
		ResultSet rs = null;
		final List<Object> list = new ArrayList<Object>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next())
				list.add(rs.getObject(1));
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(st);
			DbUtils.closeQuietly(conn);
		}
		return list;
	}

	public static List<Object> getRecordQueitly(String sql) throws SQLException {
		Connection conn = MainDb.getConnection();
		Statement st = null;
		ResultSet rs = null;
		final List<Object> list = new ArrayList<Object>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
					list.add(rs.getObject(i));
			}
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(st);
			DbUtils.closeQuietly(conn);
		}
		return list;
	}
	
	public static List<Object> getRecordQueitly(Connection conn, String sql) throws SQLException {
		Statement st = null;
		ResultSet rs = null;
		final List<Object> list = new ArrayList<Object>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
					list.add(rs.getObject(i));
			}
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(st);
		}
		return list;
	}

	public static List<List<Object>> getRecordsQueitly(String sql) throws SQLException {
		Connection conn = MainDb.getConnection();
		Statement st = null;
		ResultSet rs = null;
		final List<List<Object>> list = new Vector<List<Object>>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int count = rs.getMetaData().getColumnCount();
				final List<Object> internal = new ArrayList<Object>();
				for (int i = 1; i <= count; i++) {
					if (rs.getObject(i) instanceof Clob)
						try {
							internal.add(DBUtils.CLOBToString((Clob) rs.getObject(i)));
						} catch (Exception e) {
							log.error("ERROR STACKTRACE:",e);
						}
					else
						internal.add(rs.getObject(i));
				}
				list.add(internal);
			}
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(st);
			DbUtils.closeQuietly(conn);
		}
		return list;
	}

	public static List<List<Object>> getRecordsQueitly(Connection conn, String sql) throws SQLException {
 		Statement st = null;
		ResultSet rs = null;
		final List<List<Object>> list = new Vector<List<Object>>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int count = rs.getMetaData().getColumnCount();
				final List<Object> internal = new ArrayList<Object>();
				for (int i = 1; i <= count; i++) {
					if (rs.getObject(i) instanceof Clob)
						try {
							internal.add(DBUtils.CLOBToString((Clob) rs.getObject(i)));
						} catch (Exception e) {
							log.error("ERROR STACKTRACE:",e);
						}
					else
						internal.add(rs.getObject(i));
				}
				list.add(internal);
			}
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(st);
		}
		return list;
	}
	
	public static String prepStr(String s) {
		if (null == s)
			return s;
		else
			return "'" + RhinoEscaper.js_escape(s) + "'";
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException sqle) {
			log.info("error rolling back connection: " + sqle.toString());
		}
	}

	public static int executeInsert(String sql) throws SQLException {
		int nUpdated = 0;
		Connection conn = MainDb.getConnection();
		try {
			executeInsert(conn,sql);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return nUpdated;
	}
	
	public static int executeInsert(Connection conn,String sql) throws SQLException {
		int nUpdated = 0;
		try {
			Statement st = conn.createStatement();
			nUpdated = st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
			throw e;
		}
		return nUpdated;
	}

	public static int countQuery(String sql) throws SQLException {
		int nCount = 0;
		Connection conn = MainDb.getConnection();
		try{
			nCount=countQuery(conn,sql);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return nCount;
	}

	public static int countQuery(Connection conn,String sql) throws SQLException {
		int nCount = 0;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			nCount = rs.getInt(1);
			rs.close();
			st.close();
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
			throw e;
		}
		return nCount;
	}
	
	
	public static long queryLong(String sql) throws SQLException {
		long result = -1;
		Connection conn = MainDb.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next())
				result = rs.getLong(1);
			rs.close();
			st.close();
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return result;
	}

	public static int queryInt(String sql) throws SQLException {
		int result = -1;
		Connection conn = MainDb.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next())
				result = rs.getInt(1);
			rs.close();
			st.close();
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return result;
	}

	public static String queryString(String sql) throws SQLException {
		String result = "";
		Connection conn = MainDb.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next())
				result = rs.getString(1);
			rs.close();
			st.close();
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
			throw e;
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return result;
	}

	public static String CLOBToString(Clob data) {
		StringBuilder sb = new StringBuilder();
		try {
			if (data != null) {
				Reader reader = data.getCharacterStream();
				BufferedReader br = new BufferedReader(reader);
	
				String line;
				while (null != (line = br.readLine())) {
					sb.append(line);
				}
				br.close();
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
		return sb.toString();
	}

	
	
	public static String getStringUnion(Connection conn) throws SQLException{
		
		String dbTypeName=getTypeName(conn);
		if(dbTypeName.equals("PostgreSQL") || dbTypeName.contains("Microsoft") ) return " + ";
		else return " || ";

	}
	

	public static String getTypeName(Connection conn) throws SQLException{
		
		String name=conn.getMetaData().getDatabaseProductName();
		 return name;

	}

	
	public static boolean isOracle(Connection conn) throws SQLException{
		
		 return getTypeName(conn).equals("Oracle");

	}
	
	public static boolean isMSSqlServer(Connection conn) throws SQLException{
		
		 return getTypeName(conn).equals("Microsoft SQL Server");

	}
	
	public static boolean isH2(Connection conn) throws SQLException{
		
		return getTypeName(conn).equals("H2"); 

	}
	
	

	
	
	public static String getLikeString(String value) {
		return value == null? null: '%' + value + '%'; 
	}
}
