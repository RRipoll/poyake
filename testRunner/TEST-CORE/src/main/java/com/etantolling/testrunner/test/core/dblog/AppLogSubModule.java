package com.etantolling.testrunner.test.core.dblog;

public class AppLogSubModule {
	String moduleName;
	String subModuleName;
	
	public AppLogSubModule(String moduleName, String subModuleName){
		this.moduleName = moduleName;
		this.subModuleName = subModuleName;
	}
	
	public String getModule(){
		return moduleName;
	}
	
	public String getSubModule(){
		return subModuleName;
	}
}
