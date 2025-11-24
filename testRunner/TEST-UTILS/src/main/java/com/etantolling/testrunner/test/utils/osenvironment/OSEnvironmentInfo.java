package com.etantolling.testrunner.test.utils.osenvironment;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class OSEnvironmentInfo {

	public static String getHostName() throws IOException{
		return InetAddress.getLocalHost().getHostName();
	}
	public static String getUserName(){
		return System.getProperty("user.name");
	}
	public static String getCurrentCanonicalPath() throws IOException{
		return new File(".").getCanonicalPath();
	}
}
