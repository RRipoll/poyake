package com.etantolling.testrunner.test.core.dblog.modules;

import com.etantolling.testrunner.test.core.dblog.AppLogSubModule;

public class LatitudeSync {
	static String moduleName = "LatitudeSync";
	
	public static AppLogSubModule exchangeProcess = new AppLogSubModule(moduleName, "Exchange Process");
	public static AppLogSubModule idc2LatitudeBillingAddressSync = new AppLogSubModule(moduleName, "IDC to Latitude Billing Address Sync");
	public static AppLogSubModule idc2LatitudeFinantialsSync = new AppLogSubModule(moduleName, "IDC to Latitude Finantials Sync");
	public static AppLogSubModule idc2LatitudePhoneNumberSync = new AppLogSubModule(moduleName, "IDC to Latitude Phone Number Sync");
	public static AppLogSubModule latitude2idcBillingAddressSync = new AppLogSubModule(moduleName, "Latitude to IDC Billing Address Sync");
	public static AppLogSubModule latitude2idcUserSync = new AppLogSubModule(moduleName, "Latitude to IDC User Sync");
}
