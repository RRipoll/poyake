package com.jsantos.test;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceProvider {
	public static BasicDataSource sqlServerDataSource() {
		 BasicDataSource ds = new BasicDataSource();
         ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         ds.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=jsantos");
         ds.setUsername("sa");
         ds.setPassword("IDeeSee!2017");


         ds.setMinIdle(5);
         ds.setMaxIdle(10);
         ds.setMaxOpenPreparedStatements(100);
         
        return ds;
	}

}
