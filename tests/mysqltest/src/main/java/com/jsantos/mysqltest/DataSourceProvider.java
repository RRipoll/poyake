package com.jsantos.mysqltest;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceProvider {
	public static BasicDataSource MySqlDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setUrl("jdbc:mariadb://localhost:3306/mysqltest");
        ds.setUsername("root");
        ds.setPassword("");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
        
        return ds;
	}

}
