package com.jsantos.commondata.util;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jsantos.orm.MainDb;

public class DropDB {

	public static boolean run(){
		
		String dataBaseProductName= MainDb.getDatabaseProductName().toUpperCase();
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
		   
		switch (dataBaseProductName) {
		case "POSTGRESQL":
			
			String db="jjsantos";
		    
		    String connections=" SELECT * FROM pg_stat_activity WHERE datname = '"+db+"'";

		    String connections2="SELECT	pg_terminate_backend (pid) FROM	pg_stat_activity WHERE	pg_stat_activity.datname = '\"+db+\"'";
		    
		    String connections3="DROP DATABASE "+db;
			
			break;
		case "H2":
			 jdbcTemplate.getJdbcOperations().execute("DROP ALL OBJECTS DELETE FILES");
			break;
		case "SQLSERVER":
			 jdbcTemplate.getJdbcOperations().execute("exec dbo.reset_db_sp");
			break;	
		default:
			break;
		}
		
		
		return false;
	}
}
