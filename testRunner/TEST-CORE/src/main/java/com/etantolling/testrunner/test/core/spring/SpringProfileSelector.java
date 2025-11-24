package com.etantolling.testrunner.test.core.spring;

import java.io.IOException;

import com.etantolling.testrunner.test.utils.osenvironment.OSEnvironmentInfo;

public class SpringProfileSelector {
	
	public static String buildSpringProfileName() throws IOException{
		String springProfileName = "host_profile";
		if (null != OSEnvironmentInfo.getHostName())
			springProfileName += "_" + OSEnvironmentInfo.getHostName();
		else 
			springProfileName += "_unknown_host";
		if (null != OSEnvironmentInfo.getUserName())
			springProfileName += "_" + OSEnvironmentInfo.getUserName();
		else
			springProfileName += "_unknown_user";

		return springProfileName;
	}
}
