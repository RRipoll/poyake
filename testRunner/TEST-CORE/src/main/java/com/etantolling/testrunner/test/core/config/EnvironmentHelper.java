package com.etantolling.testrunner.test.core.config;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.utils.DataFormatter;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class EnvironmentHelper {
	
	public static final String RUNTIME_TOMCAT = "RUNTIME_TOMCAT";
	public static final String RUNTIME_COMMAND_LINE = "RUNTIME_COMMAND_LINE";

	static String databaseId;

	static String tmpTomcatDir = null;

	static String address_From = null;
	//static String appBaseUrl = "http://localhost:8080";

	static String project=null;

	static String runtime = null;
	static String basePath = null;
	// static Vector<String> testAccount = new Vector<String>();
	static String nasshareFileSystemPath = null;
	static String nasshareEnvironmentPath = null;
	static int sessionId = Math.abs(new Random().nextInt());

	static Integer InputSourceCode=0;	
	static Integer InputUserId=0;
	
	
	
	public static String getProject() {
		return project;
	}

	public static void setProject(String project) {
		EnvironmentHelper.project = project;
	}

	public static Integer getInputSourceCode() {
		return InputSourceCode;
	}

	public static void setInputSourceCode(Integer inputSourceCode) {
		InputSourceCode = inputSourceCode;
	}

	public static Integer getInputUserId() {
		return InputUserId;
	}

	public static void setInputUserId(Integer inputUserId) {
		InputUserId = inputUserId;
	}

		
	
	
	public static String getAddress_From() {
		return address_From;
	}

	public static void setAddress_From(String address_From) {
		EnvironmentHelper.address_From = address_From;
	}

	
	/*
	 * static File logFilesFolder = null; static File inputFilesFolder = null; static File inputTransactionFilesFolder = null; static File
	 * inputPaymentFilesFolder = null; static File testFilesFolder = null; static File reportsFolder = null; static File outputFilesFolder = null;
	 * static File invoicesFolder = null; static File automaedTestFilesFolder = null; static File tempAreaFolder = null;
	 */

	static SubversionInfo subversionInfo = null;

	private static final Logger log = LoggerFactory.getLogger(EnvironmentHelper.class);

	// public static void addTestAccount(Integer accountId) {
	// testAccount.add(accountId + "");
	// }

	public static String getRuntime() {
		return runtime;
	}

	public static void setRuntime(String runtime) {
		log.info("Setting run time to: " + runtime);
		EnvironmentHelper.runtime = runtime;
	}

	public static String getBasePath() {
		return basePath;
	}

	public static void setBasePath(String realWebPath) {
		EnvironmentHelper.basePath = realWebPath;
		log.info("setting base path to: " + realWebPath);

	}
/*
	public static String getDatabaseRole() throws SQLException {
		return AppInfo.get(AppInfo.KEY_DATABASE_ROLE);
	}
*/
	
	public static String getDatabaseName() throws SQLException {
		return AppInfo.get(AppInfo.ENVIRONMENT_NAME);
	}
	
	public static String getNasshareFileSystemPath() {
		return nasshareFileSystemPath;
	}

	public static String getNasshareEnvironmentPath() {
		return nasshareEnvironmentPath;
	}

	public static void setNasshareFileSystemPath(String nasshareFileSystemPath) {
		if (StringUtils.isEmpty(nasshareFileSystemPath))
			throw new RuntimeException("Trying to set nasshareFileSystemPath to null");
		log.info("Setting nasshareFileSystemPath to: " + nasshareFileSystemPath);
		EnvironmentHelper.nasshareFileSystemPath = nasshareFileSystemPath;
	}

	public static void setNasshareEnvironmentPath(String nasshareEnvironmentPath) {
		if (StringUtils.isEmpty(nasshareEnvironmentPath))
			throw new RuntimeException("Trying to set nasshareEnvironmentPath to null");
		log.info("Setting nasshareEnvironmentPath to: " + nasshareEnvironmentPath);
		EnvironmentHelper.nasshareEnvironmentPath = nasshareEnvironmentPath;
	}

	public static String getAptInfoValue(String key) {
		try {
			return AppInfo.get(key);
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE: ", e);
			throw new RuntimeException(e);
		}
	}

	public static String getDatabaseId() {
		return databaseId;
	}

	public static SubversionInfo getSubversionInfo() {
		return subversionInfo;
	}

	public static void setSubversionInfo(SubversionInfo subversionInfo) {
		EnvironmentHelper.subversionInfo = subversionInfo;
	}

	public static void commonContextInitialization() {

		// Set system locale to US
		Locale.setDefault(new Locale("en", "US"));
		
		databaseId = getAptInfoValue(AppInfo.KEY_DATABASE_ID);
		if (null == databaseId) {
			log.info("DATABASE_ID not set in database!!!");
			throw new RuntimeException("DATABASE_ID not set in database!!!");
		}

		EnvironmentHelper.setRuntime(EnvironmentHelper.RUNTIME_TOMCAT);
		// EnvironmentHelper.setNasshareFileSystemPath(servletContextEvent.getServletContext().getRealPath("/nasshare/"));
		EnvironmentHelper.setNasshareFileSystemPath(AppInfo.ROOTFILE);
		
		try (Connection conn=MainDb.getConnection()){
			log.warn("*** DB getURL = {}", conn.getMetaData().getURL());
			//log.warn("*** DB getSchema = {}", conn.getSchema());
			log.warn("*** DB getUserName = {}", conn.getMetaData().getUserName());
			try(Statement st = conn.createStatement();ResultSet rs = st.executeQuery("select * from adm_app_info");){
				while(rs.next())
					log.warn("Key: " + rs.getString("skey") + "=" + rs.getString("svalue"));
			}
			EnvironmentHelper.setNasshareEnvironmentPath(AppInfo.ROOTFILE + AppInfo.get(AppInfo.KEY_DATABASE_ID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("ERROR STACKTRACE: ", e);
		}
		// log.info(EnvironmentHelper.getNasshareEnvironmentPath());
		// log.info(EnvironmentHelper.getNasshareFileSystemPath());

		/*
		 * if ("yes".equalsIgnoreCase(getAptInfoValue(AppInfo.CHECK_FOLDERS))){ for (NasFolder nasFolder:NasFolder.values()){
		 * checkFolder(nasFolder.getFolder()); } } logFilesFolder = new File(getNasshareFileSystemPath() + "/logs"); checkFolder(logFilesFolder);
		 * inputFilesFolder = new File(getNasshareFileSystemPath() + "/input"); checkFolder(inputFilesFolder); inputTransactionFilesFolder = new
		 * File(getNasshareFileSystemPath() + "/input/transactionfiles"); checkFolder(inputTransactionFilesFolder); inputPaymentFilesFolder = new
		 * File(getNasshareFileSystemPath() + "/input/paymentfiles"); checkFolder(inputPaymentFilesFolder); testFilesFolder = new
		 * File(getNasshareFileSystemPath() + "/test/manualtests"); checkFolder(testFilesFolder); automaedTestFilesFolder = new
		 * File(getNasshareFileSystemPath() + "/test/automatedtests"); checkFolder(automaedTestFilesFolder); reportsFolder = new
		 * File(getNasshareFileSystemPath() + "/output/reports"); checkFolder(reportsFolder); outputFilesFolder = new File(getNasshareFileSystemPath()
		 * + "/output"); checkFolder(outputFilesFolder); invoicesFolder = new File(getNasshareFileSystemPath() + "/output/invoices");
		 * checkFolder(invoicesFolder); tempAreaFolder = new File(getNasshareFileSystemPath() + "/tmp"); checkFolder(tempAreaFolder);
		 */

	}

	public static void checkFolder(File file) {
		if (!file.exists()) {
			log.info(file + " doesn't exist. creating...");
			file.mkdirs();
		}
		if (!file.exists()) {
			log.info(file + " doesn't exist, please create!!!");
			throw new RuntimeException(file + " doesn't exist, please create!!!");
		}
		if (!file.canWrite()) {
			log.info(file + " doesn't have write permissions for this user!!!");
			throw new RuntimeException(file + " doesn't have write permissions for this user!!!");
		}
		// log.info("Checking folder: " + file + " [ok, file exists and has write permissions]");
	}

	public static String getTmpTomcatDir() {
		return tmpTomcatDir;
	}

	public static void setTmpTomcatDir(String tmpTomcatDir) {
		log.info("*** tmpTomcatDir {}", tmpTomcatDir);
		EnvironmentHelper.tmpTomcatDir = tmpTomcatDir;
	}

	public static int getSessionId() {
		return sessionId;
	}
/*
	public static String getTestServerUrl(String context) throws Exception {
		String testLibraryUrl = AppInfo.get(AppInfo.TEST_LIBRARY_URL);
		if (testLibraryUrl == null) {
			throw new Exception("Did you forget to define TEST_LIBRARY_URL property in ADM_APP_INFO table?");
		} else {
			testLibraryUrl = testLibraryUrl.trim();
		}
		if (testLibraryUrl.endsWith("/")) {
			testLibraryUrl = testLibraryUrl.substring(0, testLibraryUrl.length() - 1);
		}
		if (context != null) {
			return testLibraryUrl + context;
		} else {
			return testLibraryUrl;
		}
	}

	// public static void setTestServerUrl(String testServerUrl) {
	// EnvironmentHelper.testServerUrl = testServerUrl;
	// }
	/*
	public static void setAppBaseUrl(String url) {
		log.info("Setting app URL to: " + url);
		EnvironmentHelper.appBaseUrl = url;
	}
	*/
	/**
	 * 
	 * @return Application URL pointing to localhost. e.g. http://localhost:8080/NHBOS/ intended to be used only by internal requests
	 */
	/*
	public static String getAppBaseUrl() {
		return appBaseUrl;
	}
	*/
	public static Integer getTomcatPort(){
		try {
			return Integer.parseInt(AppInfo.get(AppInfo.TOMCAT_PORT));
		} catch (NumberFormatException | SQLException e) {
			log.error("ERROR STACKTRACE: ", e);
			return null;
		}
	}
	
	/**
	 * Are we on production?ew
	 */
	/*
	public static boolean isProductionModeRealtime() throws SQLException {
		return getDatabaseId() != null && AppInfo.get(AppInfo.PRODUCTION_MODE_REALTIME) != null && AppInfo.getInt(AppInfo.PRODUCTION_MODE_REALTIME) == 1;
	}
*/
	public static String getVersionDate() {
		String versionDate="'"+DataFormatter.DFormatTimeStamp.format(new Date(new Date().getTime()+1000))+"'";
		System.out.println(versionDate);
		return versionDate;
			
	}
	
	public static Timestamp getVersionTimeStamp() {
		Timestamp versionDate=new Timestamp(new Date().getTime()+1000);
		System.out.println(versionDate);
		return versionDate;
			
	}
	
	
}