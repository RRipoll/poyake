package com.etantolling.testrunner.test.core.dblog.modules;

import com.etantolling.testrunner.test.core.dblog.AppLogSubModule;

public class Mailer{
	static String moduleName = "Mailer";
	
	public static AppLogSubModule courtesyExtendedEmail = new AppLogSubModule(moduleName, "Courtesy Extended Email");
	public static AppLogSubModule backOfficeEmail = new AppLogSubModule(moduleName, "Back Office Email");
	public static AppLogSubModule invoiceEmailer = new AppLogSubModule(moduleName, "Invoice Emailer");
}
