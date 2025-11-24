package com.testrunner.test.framework.toll.testframework.panel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.lang.Library;

import com.etantolling.testrunner.test.zkweb.experimental.ClassRegistry;
import com.jsantos.core.EnvironmentHelper;
import com.jsantos.metadata.MT;
import com.jsantos.orm.MainDb;
//import com.etantolling.testrunner.test.core.db.MainDb;



public class WebContextInitializer implements ServletContextListener {
	
	private static final Logger log = LoggerFactory.getLogger(WebContextInitializer.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("=============================================================");
		System.out.println("===== Context initialization starts                    ======");
		System.out.println("=============================================================");
		
		//System.getProperties().setProperty("oracle.jdbc.J2EE13Compliant", "true") ; 
		System.setProperty("java.net.preferIPv6Addresses", "true");  
//		System.setProperty("javax.xml.bind.JAXBContext", "com.sun.xml.internal.bind.v2.ContextFactory"); /nasshare
		System.out.println("Themes available: " + Library.getProperty("org.zkoss.theme.names"));

		System.out.println("Setting main database");
		try{
			String realPath = this.getClass().getResource("/").getPath().substring(0, this.getClass().getResource("/").getPath().lastIndexOf("WEB-INF/classes/"));
			EnvironmentHelper.setBasePath(realPath);
			MainDb.setMainDataSource(getDataSource("jdbc/maindb"));
			//MainDb.setMainDataSource(DataSourceProvider.sqlServerDataSource());
			String versionInfo = getVersionInformation();
			if (StringUtils.isEmpty(versionInfo))
				versionInfo = "Debug build";
			servletContextEvent.getServletContext().setAttribute("VERSION_INFO", versionInfo);
			
		}
		catch (Exception e){
			log.error("ERROR STACKTRACE:",e);
			throw new RuntimeException(e);
		}
		
		System.out.println("Initializing Class Registry");
		System.out.println(MT.ADM_APP_INFO);
		ClassRegistry.loadClasses();
		
		/*
		try {
			if (!EnvironmentHelper.getNasshareFileSystemPath().equals(AppInfo.get(AppInfo.NASSHARE_FOLDER))){
				System.out.println("Error: Nassshare file systempath is different in tomcat's context.xml from what is set in adm_app_info !!!");
				System.out.println("Nassshare file systempath in tomcat's context xml: " + EnvironmentHelper.getNasshareFileSystemPath());
				System.out.println("NASSHARE_FOLDER in apt_info: " + AppInfo.get(AppInfo.NASSHARE_FOLDER));
				throw new RuntimeException("Error: Nassshare file systempath is different in tomcat's web.xml from what is set in adm_app_info !!!");
			}
		} catch (Exception e) {
			System.out.println("Error getting NASSHARE_FOLDER FROM adm_apt_info");
			throw new RuntimeException("Error getting NASSHARE_FOLDER FROM adm_apt_info" + e.toString());
		}		
*/
		EnvironmentHelper.commonContextInitialization();
		
		File subversinInfoFile = new File(EnvironmentHelper.getBasePath() + "/WEB-INF/svn_info.txt");
		//EnvironmentHelper.setSubversionInfo(new SubversionInfo(subversinInfoFile));

		/*
		try {
			System.out.println("KEY_DATABASE_DESCRIPTION: " + AppInfo.get(AppInfo.KEY_DATABASE_DESCRIPTION));
			System.out.println("KEY_DATABASE_ID: " + AppInfo.get(AppInfo.KEY_DATABASE_ROLE));
			System.out.println("KEY_DATABASE_ROLE: " + AppInfo.get(AppInfo.KEY_DATABASE_ROLE));
		} catch (SQLException e) {
			log.error("ERROR STACKTRACE:",e);
		}
		*/
		
		
		System.out.println("=============================================================");
		System.out.println("===== Context Initialization finished                   =====");
		System.out.println("=============================================================");
	}
	
	public static DataSource getDataSource(String dataSourceName) throws NamingException {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup(dataSourceName); 
		return ds;
	}
	
	
	public static String getVersionInformation() throws IOException{
		File manifestFile = new File(EnvironmentHelper.getBasePath() + "/META-INF/MANIFEST.MF");
		Manifest manifest = new Manifest(new FileInputStream(manifestFile));
		Attributes attributes = manifest.getMainAttributes();
		return " SVN:" + attributes.getValue("Implementation-Build") + " Built: " + attributes.getValue("Build-Timestamp") + "UTC";
	}
}
