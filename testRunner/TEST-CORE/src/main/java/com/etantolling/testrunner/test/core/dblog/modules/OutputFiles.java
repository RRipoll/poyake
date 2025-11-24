package com.etantolling.testrunner.test.core.dblog.modules;

import com.etantolling.testrunner.test.core.dblog.AppLogSubModule;

public class OutputFiles {
	static String moduleName = "Output Files";
	
	public static AppLogSubModule returnedRegistrationHold = new AppLogSubModule(moduleName, "Returned Registration Hold");
	public static AppLogSubModule registrationHold = new AppLogSubModule(moduleName, "Registration Hold");
	public static AppLogSubModule registrationHoldReport = new AppLogSubModule(moduleName, "Registration Hold Report");
	public static AppLogSubModule ringClear = new AppLogSubModule(moduleName, "Ring clear");
	public static AppLogSubModule ringClearStopFile = new AppLogSubModule(moduleName, "Ring clear Stop File");
	public static AppLogSubModule disputedPlates = new AppLogSubModule(moduleName, "Disputed Plates");
	public static AppLogSubModule nsfPaymentLetters = new AppLogSubModule(moduleName, "NSF Payment Letters");
	public static AppLogSubModule ivrInvoiceFile = new AppLogSubModule(moduleName, "IVR Invoice File");
	public static AppLogSubModule wellsFargoStopFile = new AppLogSubModule(moduleName, "Wells Fargo Stop File");
	public static AppLogSubModule chart = new AppLogSubModule(moduleName, "Chart Script");
	public static AppLogSubModule blacklist = new AppLogSubModule(moduleName, "Black List File");
	public static AppLogSubModule etech = new AppLogSubModule(moduleName, "E-Tech");	
}
