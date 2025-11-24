package com.etantolling.testrunner.test.core.dblog.modules;

import com.etantolling.testrunner.test.core.dblog.AppLogSubModule;

public class PaymentProcessor {
	static String moduleName = "Payment Processor";
	
	public static AppLogSubModule lockBoxFileProcessor = new AppLogSubModule(moduleName, "Lock box file processor");
	public static AppLogSubModule auditFailedPayments = new AppLogSubModule(moduleName, "Audit Failed Payments");
	public static AppLogSubModule ivrPaymentsProcessor = new AppLogSubModule(moduleName, "IVR Payments Processor");
	public static AppLogSubModule moneygramPaymentsProcessor = new AppLogSubModule(moduleName, "Moneygram Payments Processor");
}
