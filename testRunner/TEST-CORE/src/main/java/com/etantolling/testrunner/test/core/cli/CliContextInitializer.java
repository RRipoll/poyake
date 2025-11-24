package com.etantolling.testrunner.test.core.cli;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.cli.configfolder.ConfigFolderHelper;
import com.etantolling.testrunner.test.core.cli.connectionpool.CliConnectionPoolLoader;
import com.etantolling.testrunner.test.core.config.AppInfo;
import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class CliContextInitializer {
private static final Logger log = LoggerFactory.getLogger(CliContextInitializer.class);
	
	public static void initialize() throws ClassNotFoundException, IOException, SQLException {
		initializeWithConfigFolderMapFile(null);
	}
	
	public static void initializeWithConfigFolderMapFile(String configFolderMapFile) throws ClassNotFoundException, IOException, SQLException {
		log.info("======================================================================");
		log.info("============== START OF CONTEXT INITIALIZATION: " + new Date() + " =======================");
		ConfigFolderHelper.init(configFolderMapFile);
		EnvironmentHelper.setRuntime(EnvironmentHelper.RUNTIME_COMMAND_LINE);
		MainDb.setMainDataSource(CliConnectionPoolLoader.initFromXml(ConfigFolderHelper.getConfigFile("connection_pool.xml").getCanonicalPath(), "jdbc/maindb"));
		MainDb.setReportsDataSource(CliConnectionPoolLoader.initFromXml(ConfigFolderHelper.getConfigFile("connection_pool.xml").getCanonicalPath(), "jdbc/reportsdb"));
		EnvironmentHelper.setNasshareFileSystemPath(AppInfo.ROOTFILE);
		EnvironmentHelper.setNasshareEnvironmentPath(AppInfo.ROOTFILE + AppInfo.get(AppInfo.KEY_DATABASE_ID));
		EnvironmentHelper.setBasePath(new File(".").getCanonicalPath());
		EnvironmentHelper.commonContextInitialization();
		EnvironmentHelper.setAddress_From("no-reply@idc.com");
		log.info("AppInfo Database ID: " + AppInfo.get(AppInfo.KEY_DATABASE_ID));
		//log.info("AppInfo Database Role: " + AppInfo.get(AppInfo.KEY_DATABASE_ROLE));
		//log.info("AppInfo Database Description: " + AppInfo.get(AppInfo.KEY_DATABASE_DESCRIPTION));
		log.info("============== END OF CONTEXT INITIALIZATION =========================");
		log.info("======================================================================");
	}
}