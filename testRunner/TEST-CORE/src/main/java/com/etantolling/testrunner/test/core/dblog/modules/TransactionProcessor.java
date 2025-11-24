package com.etantolling.testrunner.test.core.dblog.modules;

import com.etantolling.testrunner.test.core.dblog.AppLogSubModule;

public class TransactionProcessor {
	static String moduleName = "Transaction Processor";
	
	public static AppLogSubModule main = new AppLogSubModule(moduleName, "Main");
	public static AppLogSubModule transactionFileValidator = new AppLogSubModule(moduleName, "Transaction File Validator");
	public static AppLogSubModule ftpTransactionDownloader = new AppLogSubModule(moduleName, "FTP Transaction Downloader");

}
