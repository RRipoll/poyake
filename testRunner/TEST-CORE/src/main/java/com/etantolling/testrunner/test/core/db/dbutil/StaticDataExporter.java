package com.etantolling.testrunner.test.core.db.dbutil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.etantolling.testrunner.test.core.cli.CliContextInitializer;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class StaticDataExporter {
	public static String[][] tablesAndFilters = {
			{"ENUM_Bug_Platform",""},
			{"ENUM_Bug_Platform",""},
			{"ENUM_Bug_Priority",""},
			{"ENUM_Bug_Status",""},
			{"ENUM_Task_Status",""},
			{"AppUser",""},
			{"Client",""},
			{"Project",""},
			{"Module",""},			
		};
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
		
		CliContextInitializer.initialize();
		
		// Use hardcoded idc_mdw connection so we always dump data from the master database
		Connection conn = MainDb.getConnection();
		File file = new File("WebContent/sql/database_scripts/static_data.sql");
		if (!file.getParentFile().exists()){
			System.out.println("file " + file.getParentFile().getCanonicalPath() + " doesn't exist. Creating...");
			file.getParentFile().mkdirs();
		}
			
		FileWriter fileWriter = new FileWriter("WebContent/sql/database_scripts/static_data.sql");
		try{
			for (String[] tableAndFilter:tablesAndFilters){
				System.out.println("Export : " + tableAndFilter[0] + " [" + tableAndFilter[1] + "]");
				TableDataExporter.exportForInsert(conn, tableAndFilter[0], tableAndFilter[1], fileWriter);
			}
			fileWriter.flush();
			fileWriter.close();
		}
		finally{
			conn.close();
		}
		
		System.out.println("Finished [ok]");
	}
}
