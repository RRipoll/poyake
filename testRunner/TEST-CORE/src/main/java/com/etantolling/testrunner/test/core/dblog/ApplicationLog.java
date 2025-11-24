package com.etantolling.testrunner.test.core.dblog;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

import org.apache.log4j.Logger;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTEnuENUAPPLOGCODE;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTEnuENUAPPLOGLEVEL;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTEnuENUAPPLOGMODULE;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTEnuENUAPPLOGSUBMODULE;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;

public class ApplicationLog {
	private static final Logger log = Logger.getLogger(ApplicationLog.class);

	private static final int LOG_MESSAGE_LIMIT = 4000;

	public static void reportException(Integer appLogModuleId, Integer appLogSubModuleId, Integer appLogLevelId, Exception e){
		StringWriter stackTrace = new StringWriter();
		e.printStackTrace(new PrintWriter(stackTrace));
		String message = stackTrace.toString();
		log.error("Exception reported into ApplicationLog", e);

		if (null == appLogLevelId) appLogLevelId= MTEnuENUAPPLOGLEVEL.Warning_4;
		insert(appLogModuleId, appLogSubModuleId, appLogLevelId, MTEnuENUAPPLOGCODE.Generic_Exception_4, message);
	}


	public static void logCritical(Integer appLogModuleId, Integer appLogSubModuleId, Integer appLogLevelId, Integer appLogCodeId, String message){
		insert(appLogModuleId, appLogSubModuleId, MTEnuENUAPPLOGLEVEL.Disaster_1, appLogCodeId, message);
	}

	public static void logError(Integer appLogModuleId, Integer appLogSubModuleId, Integer appLogLevelId, Integer appLogCodeId, String message){
		insert(appLogModuleId, appLogSubModuleId, MTEnuENUAPPLOGLEVEL.High_2, appLogCodeId, message);
	}

	public static void logWarning(Integer appLogModuleId, Integer appLogSubModuleId, Integer appLogLevelId, Integer appLogCodeId, String message){
		insert(appLogModuleId, appLogSubModuleId, MTEnuENUAPPLOGLEVEL.Warning_4, appLogCodeId, message);
	}

	public static void logInfo(Integer appLogModuleId, Integer appLogSubModuleId, Integer appLogLevelId, Integer appLogCodeId, String message){
		insert(appLogModuleId, appLogSubModuleId, MTEnuENUAPPLOGLEVEL.Info_5, appLogCodeId, message);
	}

	private static void insert(Integer appLogModuleId, Integer appLogSubModuleId, Integer appLogLevelId, Integer appLogCodeId, String message){
		try{

			// Truncate message to fit to the MESSAGE column (4000 byte) of
			// APPLICATIONLOG table
			if (message.length() > LOG_MESSAGE_LIMIT)
				message = message.substring(0, LOG_MESSAGE_LIMIT);

			try(Connection conn = MainDb.getConnection()){
				String sql = "insert  /*+ APPEND */ into ApplicationLog (applicationLogId, created, appLogModuleId, appLogSubModuleId, appLogLevelId, appLogCodeId, message) values (Seq_ApplicationLog.nextVal, getPostingDateTime(), :appLogModuleId, :appLogSubModuleId, :appLogLevelId, :appLogCodeId, :message)";
				NamedParameterStatement nps = new NamedParameterStatement(conn, sql);

				if (null == appLogModuleId) appLogModuleId = MTEnuENUAPPLOGMODULE.Unspecified_11;
				nps.setInt("appLogModuleId", appLogModuleId);

				if (null == appLogSubModuleId) appLogSubModuleId = MTEnuENUAPPLOGSUBMODULE.General_1;
				nps.setInt("appLogSubModuleId", appLogSubModuleId);

				if (null == appLogLevelId) appLogLevelId = MTEnuENUAPPLOGLEVEL.Info_5;
				nps.setInt("appLogLevelId", appLogLevelId);

				nps.setInt("appLogCodeId", appLogCodeId);
				nps.setString("message", message);
				nps.executeUpdate();
				nps.close();
			}
		}
		catch (Exception e){
			log.error("ERROR STACKTRACE: ", e);
		}
	}
}
