package com.etantolling.testrunner.test.core.db;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;

public class SQLLoaderWeb {
	public static Hashtable<String, String> sqls = new Hashtable<String, String>();
	// static String BASE_FOLDER = "/home/raulito/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/latitudePanel/sql/";
	static String BASE_FOLDER = EnvironmentHelper.getBasePath();

	public static String get(String fileName, String dir) {
		if (!BASE_FOLDER.endsWith("/")) BASE_FOLDER = BASE_FOLDER + "/";
		String sql = sqls.get(fileName);
		if (null== sql) {
			try {
				sql = org.apache.commons.io.FileUtils.readFileToString(new File(BASE_FOLDER + dir + fileName));
			} catch (IOException e) {
				throw new RuntimeException("Can't find  file: " + fileName + " " + e.toString());
			}
		}
		return sql;
	}

	public static String get(String fileName, String dir, String label, String value) {
		if (!BASE_FOLDER.endsWith("/")) BASE_FOLDER = BASE_FOLDER + "/";
		StringBuffer sql = new StringBuffer();
		sql.append(get(fileName, dir));
		if (null != value)
			return sql.toString().replace(label, value);
		return sql.toString();

	}
}
