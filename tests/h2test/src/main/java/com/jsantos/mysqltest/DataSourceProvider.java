package com.jsantos.mysqltest;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceProvider {
	public static BasicDataSource MySqlDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:~/testdbn6;AUTO_SERVER=TRUE;");
        ds.setUsername("sa");
        ds.setPassword("sa");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
        
        return ds;
	}

}
