package com.etantolling.testrunner.test.core.dblog.modules;

import com.etantolling.testrunner.test.core.dblog.AppLogSubModule;

public class Controller {
	static String moduleName = "Controller";
	
	public static AppLogSubModule main = new AppLogSubModule(moduleName, "Main");
	public static AppLogSubModule runningJobs = new AppLogSubModule(moduleName, "Running Jobs");

}
