package com.etantolling.testrunner.test.core.cli.connectionpool;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.cli.JAXBHelper;
import com.etantolling.testrunner.test.core.cli.connectionpool.xmlbindings.GlobalNamingResources;
import com.etantolling.testrunner.test.core.cli.connectionpool.xmlbindings.Resource;

public class CliConnectionPoolLoader{

	private static final Logger log = LoggerFactory.getLogger(CliConnectionPoolLoader.class);
	
    public static DataSource initFromXml(String filePath, String dataSourceName) throws IOException, ClassNotFoundException{
		GlobalNamingResources globalNamingResources = new JAXBHelper<GlobalNamingResources>().loadXmlFile(filePath, GlobalNamingResources.class.getPackage().getName());

		for (Resource resource:globalNamingResources.getResource()){
			if (resource.getName().equals(dataSourceName)){
				log.info("loading pool configuration. Name: " + resource.getName() + " driver: " + resource.getDriverClassName());
        		return init(resource.getDriverClassName(), resource.getUrl(), resource.getUsername(), resource.getPassword(), resource.getName());
			}
        }
		throw new RuntimeException("Datasource: " + dataSourceName + " not found in file: " + filePath);
    }
    
    public static DataSource init(String driver, String url, String user, String pass, String name) throws ClassNotFoundException{
    	log.info("driver "+driver);
    	log.info("url "+url);
    	log.info("user "+user);
    	//log.info("pass "+pass);
    	log.info("name "+name);
    	
        DriverAdapterCPDS cpds = new DriverAdapterCPDS();
		cpds.setDriver(driver);
        cpds.setUrl(url);
        cpds.setUser(user);
        cpds.setPassword(pass);

        SharedPoolDataSource tds = new SharedPoolDataSource();
        tds.setConnectionPoolDataSource(cpds);

        return tds;
    }
    
    
}