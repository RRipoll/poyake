package com.etantolling.testrunner.test.core.dblog.modules;

import com.etantolling.testrunner.test.core.dblog.AppLogSubModule;

public class Invoices {
	static String moduleName = "Invoices";
	
	public static AppLogSubModule invoiceGenerator = new AppLogSubModule(moduleName, "Invoice Generator");
	public static AppLogSubModule invoiceFileUploader = new AppLogSubModule(moduleName, "Invoice File Uploader");
}
