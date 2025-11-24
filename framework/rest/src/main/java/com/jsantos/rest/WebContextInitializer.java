package com.jsantos.rest;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jsantos.common.registry.AppClassRegistry;
import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.ORMClassRegistry;
import com.jsantos.metadata.MT;
import com.jsantos.orm.MainDb;
import com.jsantos.rest.orm.DataSourceProvider;
import com.jsantos.search.registry.SearchClassRegistry;




public class WebContextInitializer implements ServletContextListener {
	
	private static final Logger log = LoggerFactory.getLogger(WebContextInitializer.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			MainDb.setMainDataSource(DataSourceProvider.tomcatPoolDatasource());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MT.init();
		//ORMClassRegistry.setTriggersPackage("com.jsantos.demo.orm.trigger");
		//ORMClassRegistry.setExtendedDTOPackage("com.jsantos.demo.orm.extendeddto");
		ORMClassRegistry.loadClasses();
		ORMClassRegistry.logTriggers();
		DTOFactory.logInfo();
		AppClassRegistry.loadClasses();
		SearchClassRegistry.loadClasses();
		System.out.println("=============================================================");
		System.out.println("===== Context Initialization finished                   =====");
		System.out.println("=============================================================");
	}
}
