package com.jsantos.metadata.plugin.util;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.FrameworkUtil;


public class Logger {
	static final boolean debug = true;
	public static final ILog logger = Platform.getLog(FrameworkUtil.getBundle(Logger.class));
	
	public static void error(String message) {
		logger.error(message);
	}
	
	public static void error(String message, Throwable e) {
		logger.error(message, e);
	}
	
	public static void info(String message) {
		logger.info(message);;
	}
}
