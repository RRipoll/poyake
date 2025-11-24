package com.etantolling.testrunner.test.core.dblog.modules;

import com.etantolling.testrunner.test.core.dblog.AppLogSubModule;

public class BackOffice {
	static String moduleName = "Back Office";
	
	public static AppLogSubModule main = new AppLogSubModule(moduleName, "Main");
	public static AppLogSubModule paymentProcessor = new AppLogSubModule(moduleName, "Payment processor");

}
