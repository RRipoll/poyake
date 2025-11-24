package com.etantolling.testrunner.test.zkweb;

import java.util.Hashtable;
import java.util.UUID;
import java.util.Vector;

import org.zkoss.zk.ui.Executions;

import com.etantolling.testrunner.test.core.db.DetachedRecord;

public class DesktopHelper {

	private static final String INPUT_SOURCE_CODE = "INPUT_SOURCE_CODE";
	public static final String INPUT_SOURCE_CODE_NAME = "INPUT_SOURCE_CODE_NAME";
	public static final String USER_ID = "USER_ID";
	public static final String INPUTUSER = "INPUTUSER";
	public static final String APP_BASE_URL = "APP_BASE_URL";
	public static final String APP_JOB_URL = "APP_JOB_URL";
	
	public static final String TEST_BASE_URS = "TEST_BASE_URS";
	public static final String DEFAULT_TOKEN="DEFAULT_TOKEN";
	public static final String TENNANT_NAME="TENNANT_NAME";
	public static final String RECORDER_UUID="RECORDER_UUID";
	
	public  static String getAppBaseUrl() {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() || null == Executions.getCurrent().getDesktop().getAttribute(APP_BASE_URL))
			return null;
		return (String) Executions.getCurrent().getDesktop().getAttribute(APP_BASE_URL);
	}

	public  static void setAppBaseUrl(String appBaseUrl) {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() )
			return;
		Executions.getCurrent().getDesktop().setAttribute(APP_BASE_URL, appBaseUrl);
	}

	public  static String getAppJobUrl() {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() || null == Executions.getCurrent().getDesktop().getAttribute(APP_JOB_URL))
			return null;
		return (String) Executions.getCurrent().getDesktop().getAttribute(APP_JOB_URL);
	}

	public  static void setAppJobUrl(String appJobUrl) {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() )
			return;
		Executions.getCurrent().getDesktop().setAttribute(APP_JOB_URL, appJobUrl);
	}
	
	
	public  static String getDefaultTokken() {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() || null == Executions.getCurrent().getDesktop().getAttribute(APP_BASE_URL))
			return null;
		return (String) Executions.getCurrent().getDesktop().getAttribute(DEFAULT_TOKEN);
	}

	public  static void setDefaultTokken(String tokken) {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() )
			return;
		Executions.getCurrent().getDesktop().setAttribute(DEFAULT_TOKEN, tokken);
	}

	public  static String getTestLibraryURL() {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() || null == Executions.getCurrent().getDesktop().getAttribute(TEST_BASE_URS))
			return null;
		return (String) Executions.getCurrent().getDesktop().getAttribute(TEST_BASE_URS);
	}

	public  static void setTestLibraryURL(String appTestLibraryURL) {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() )
			return;
		Executions.getCurrent().getDesktop().setAttribute(TEST_BASE_URS, appTestLibraryURL);
	}
	
	
	public static Integer getInputSourceCode() {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() || null == Executions.getCurrent().getDesktop().getAttribute(INPUT_SOURCE_CODE))
			return 0;
		return (Integer) Executions.getCurrent().getDesktop().getAttribute(INPUT_SOURCE_CODE);
	}

	public static void setInputSourceCode(Integer inputSourceCode) {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() )
			return;
		Executions.getCurrent().getDesktop().setAttribute(INPUT_SOURCE_CODE, inputSourceCode);
	}


	public static boolean isUserLogged() {
		if (null == Executions.getCurrent().getDesktop().getAttribute(USER_ID))
			return false;
		return true;
	}

	public static Integer getInputUserId() {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() || null == Executions.getCurrent().getDesktop().getAttribute(USER_ID))
			return 1;
		return (Integer) Executions.getCurrent().getDesktop().getAttribute(USER_ID);
	}

	public static void setInputUserId(Integer inputUserId) {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() )
			return;
		Executions.getCurrent().getDesktop().setAttribute(USER_ID, inputUserId);

	}

	public static DetachedRecord getInputUser() {
		if (null == Executions.getCurrent().getDesktop().getAttribute(INPUTUSER))
			return null;
		return (DetachedRecord) Executions.getCurrent().getDesktop().getAttribute(INPUTUSER);
	}

	public static void setInputUser(DetachedRecord inputUser) {
		Executions.getCurrent().getDesktop().setAttribute(INPUTUSER, inputUser);

	}

	public static Object getAttribute(String name) {
		return Executions.getCurrent().getDesktop().getAttribute(name);
	}

	public static void setAttribute(String name, Object value) {
		Executions.getCurrent().getDesktop().setAttribute(name, value);
	}

	public static Integer getClientHeightByN(Double n) {
		Integer retValue = null;
		if (null != n && null != DesktopHelper.getAttribute("ClientHeight")) {
			float height = (Integer) DesktopHelper.getAttribute("ClientHeight");
			retValue = (int) (height * n);
		}
		return retValue;
	}

	public static void setMetaDataSql(String tableName, Hashtable<String, Object> data) {
		if (null != tableName)
			Executions.getCurrent().getDesktop().setAttribute(tableName, data);
	}

	@SuppressWarnings("unchecked")
	public static Hashtable<String, Object> getMetaDataSql(String tableName) {
		if (null == tableName)
			return null;
		return (Hashtable<String, Object>) Executions.getCurrent().getDesktop().getAttribute(tableName);
	}

	@SuppressWarnings("unchecked")
	public static void setTelephoneValidation(Integer customerId) {
		Vector<String> telephoneValidationPermission;
		if (null == Executions.getCurrent().getDesktop().getAttribute("telephoneValidationPermission"))
			telephoneValidationPermission = new Vector<String>();
		else
			telephoneValidationPermission = (Vector<String>) Executions.getCurrent().getDesktop().getAttribute("telephoneValidationPermission");

		telephoneValidationPermission.add(customerId.toString());
		Executions.getCurrent().getDesktop().setAttribute("telephoneValidationPermission", telephoneValidationPermission);
	}

	@SuppressWarnings("unchecked")
	public static boolean isCustomerTelephoneValidated(Integer customerId) {

		Vector<String> telephoneValidationPermission = (Vector<String>) Executions.getCurrent().getDesktop().getAttribute("telephoneValidationPermission");
		if (null != telephoneValidationPermission && telephoneValidationPermission.contains(customerId.toString()))
			return true;
		return false;
	}
	
	public static  String getTestServerUrl(String context) throws Exception {
		String testLibraryUrl = getTestLibraryURL();
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

	public  static String getTennantName() {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() || null == Executions.getCurrent().getDesktop().getAttribute(TEST_BASE_URS))
			return null;
		return (String) Executions.getCurrent().getDesktop().getAttribute(TENNANT_NAME);
	}

	public static void setTennantName(String tennantName) {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() )
			return;
		Executions.getCurrent().getDesktop().setAttribute(TENNANT_NAME, tennantName);
	}

	
	public  static Integer getRecorderUuid() {
		return (Integer) Executions.getCurrent().getDesktop().getAttribute(RECORDER_UUID);
	}

	public static void setRecorderUuid(Integer uuid) {
		Executions.getCurrent().getDesktop().setAttribute(RECORDER_UUID, uuid);
	}
	
	public static void deleteRecorderUuid() {
		Executions.getCurrent().getDesktop().removeAttribute(RECORDER_UUID);
	}
}