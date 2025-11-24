package com.etantolling.testrunner.test.core.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class AppInfo {
	public static final String ROOTFILE = "/nasshare/";
	public static final String ENVIRONMENT_NAME = "ENVIRONMENT_NAME";
	public static final String KEY_DATABASE_ID = "DATABASE_ID"; 
	public static final String AZURENAME = "AZURENAME"; 
	public static final String AZUREKEY = "AZUREKEY"; 
	public static final String NASSHARE_FOLDER = "NASSHARE_FOLDER";
	public static final String TEST_LIBRARY_URL = "TEST_LIBRARY_URL";
	public static final String TOMCAT_PORT = "TOMCAT_PORT";
	public static final String INCOMING_DOCUMENTS_SUPPORTED_LOCATIONS = "INCOMING_DOCUMENTS_SUPPORTED_LOCATIONS";
	public static final String TEST_RUNNER_DISABLED = "TEST_RUNNER_DISABLED";
	public static final String CUSTOMER_CREDENTIALS_ENCRYPTED = "CUSTOMER_CREDENTIALS_ENCRYPTED";
	public static final String INPUT_USER_CREDENTIALS_ENCRYPTED = "INPUT_USER_CREDENTIALS_ENCRYPTED";
	public static final String SWAGGER_API_KEY = "SWAGGER_API_KEY";
	
	public static final String BASE_URL_FOR_PD4ML = "BASE_URL_FOR_PD4ML";
	
	static final Hashtable<String, String> cacheValues = new Hashtable<String, String>();
	static final Hashtable<String, Date> cacheDates = new Hashtable<String, Date>();
	static Boolean cacheEnabled = null;
	static final long CACHE_TIMEOUT_MS = 10000; 
	private static final Logger log = LoggerFactory.getLogger(AppInfo.class);
	
	public static String get(String key) throws SQLException{
		if (isCacheEnabled()){
			if (null != cacheDates.get(key) && CACHE_TIMEOUT_MS > new Date().getTime() - cacheDates.get(key).getTime())
				if (null != cacheValues.get(key))
					return cacheValues.get(key);
		}
		
		String retValue = getFromDB(key);
		
		if (isCacheEnabled() && !StringUtils.isBlank(retValue)){
			if ("NHDEV_P2".equals(retValue))
				Thread.currentThread().dumpStack();
			cacheValues.put(key, retValue);
			cacheDates.put(key, new Date());
		}
		return retValue;
	}
	
	public static Integer getInt(String key) throws SQLException{
		if (null == get(key)) 
			return null;
		return Integer.parseInt(get(key));
	}

	static String getFromDB(String key) throws SQLException{
		String retValue = null;
		
		try(Connection conn = MainDb.getConnection()){
			Statement st = conn.createStatement();
			String sql="select * from adm_app_info where skey='" + key + "'";
			
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) 
				retValue = rs.getString("svalue");
			rs.close();
			st.close();
		}
		return retValue;
	}
	
	static public boolean isCacheEnabled() throws SQLException{
		return true;
	}
	
	public static Hashtable<String,String> getLike(String key) {
		Hashtable<String,String> htParams = new Hashtable<String,String>();
		try(Connection conn = MainDb.getConnection()){
			Statement st = conn.createStatement();
			String sql="SELECT SKEY,SVALUE FROM ADM_APP_INFO WHERE SKEY LIKE '" + key + "%'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) 
				htParams.put(rs.getString("SKEY"), rs.getString("SVALUE"));
			rs.close();
			st.close();
		} catch(SQLException ex) {
			log.error("ERROR STACKTRACE: ", ex);;
		}
		return htParams;
	}
	
	public static int set(String key, String svalue) throws SQLException{
		try(Connection conn = MainDb.getConnection(); Statement st = conn.createStatement()){
			String sql="update adm_app_info set svalue = '" + svalue + "' where skey='" + key + "'";
			return st.executeUpdate(sql);
		}
	}
}