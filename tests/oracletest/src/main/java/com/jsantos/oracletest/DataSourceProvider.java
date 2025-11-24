package com.jsantos.oracletest;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceProvider {
	public static BasicDataSource oracleDataSource() {
		 BasicDataSource ds = new BasicDataSource();
         ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
         ds.setUrl("jdbc:oracle:thin:@//localhost:1521/XEPDB1");
         
         ds.setUsername("jsantos");
         ds.setPassword("LetPirilonIn");
         /*
         ds.setUsername("SYSTEM");
         ds.setPassword("9b4696a6225ace19");
         */


         ds.setMinIdle(5);
         ds.setMaxIdle(10);
         ds.setMaxOpenPreparedStatements(100);
         
        return ds;
	}

}
