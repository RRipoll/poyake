package com.jsantos.rest.config;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.util.ResourceUtils;
/**
 * @author javier santos
 * @author raul ripoll
 */
public class DataSourceProvider {
	

	
	public static DataSource configFileDatasource(String fileName) throws IOException {
		
		
		File file = ResourceUtils.getFile("classpath:"+fileName);
		InputStream stream = new FileInputStream(file);
		Properties props = new Properties();
		props.load(stream);		
		
		System.out.println("Connection props from file: " + props);
		
		PoolProperties p = new PoolProperties();
		String driverClassName=props.getProperty("driverClassName");
		p.setDriverClassName(driverClassName);
        String url=props.getProperty("url");;
		p.setUrl(url);
        String username=props.getProperty("username");
		p.setUsername(username);
        String password=props.getProperty("password");
		p.setPassword(password);
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
          "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
          "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);
        
        return datasource;
		
	}
public static DataSource configFileDatasource() throws IOException {
		
		
		File file = ResourceUtils.getFile("classpath:dataSource.properties");
		InputStream stream = new FileInputStream(file);
		Properties props = new Properties();
		props.load(stream);		
		
		System.out.println("Connection props from file: " + props);
		
		PoolProperties p = new PoolProperties();
		String driverClassName=props.getProperty("driverClassName");
		p.setDriverClassName(driverClassName);
        String url=props.getProperty("url");;
		p.setUrl(url);
        String username=props.getProperty("username");
		p.setUsername(username);
        String password=props.getProperty("password");
		p.setPassword(password);
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
          "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
          "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);
        
        return datasource;
		
	}
}
