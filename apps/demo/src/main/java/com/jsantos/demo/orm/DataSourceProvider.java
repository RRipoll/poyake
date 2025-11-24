package com.jsantos.demo.orm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class DataSourceProvider {
	public static BasicDataSource sqlServerDataSource() {
		 BasicDataSource ds = new BasicDataSource();
		 
		 ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 ds.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=jsantos");
		         
		 
		 //ds.setDriverClassName("org.h2.Driver");
         //ds.setUrl("jdbc:h2:~/testdbn;AUTO_SERVER=TRUE;");
         ds.setUsername("sa");
        // ds.setPassword("sa");
         ds.setPassword("IDeeSee!2017");
         ds.setMinIdle(5);
         ds.setMaxIdle(100);
         
        return ds;
	}

	public static DataSource tomcatPoolDatasource() {
		PoolProperties p = new PoolProperties();
		
		//p.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=jsantos");
		//p.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
		//p.setDriverClassName("org.h2.Driver");
        //p.setUrl("jdbc:h2:~/testdbn;AUTO_SERVER=TRUE;");
		
		p.setUrl("jdbc:postgresql://localhost:5432/jsantos");
		p.setDriverClassName("org.postgresql.Driver");
        p.setUsername("jsantos");
        p.setPassword("IDeeSee!2017");
       // p.setPassword("sa");
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
		File configDir = new File(System.getProperty("catalina.base"), "conf");
		File configFile = new File(configDir, "myconfig.properties");
		InputStream stream = new FileInputStream(configFile);
		Properties props = new Properties();
		props.load(stream);		
		System.out.println("Connection props from file: " + props);
		
		PoolProperties p = new PoolProperties();
		p.setUrl(props.getProperty("url"));
		p.setDriverClassName(props.getProperty("driver"));
        p.setUsername(props.getProperty("user"));
        p.setPassword(props.getProperty("password"));
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
