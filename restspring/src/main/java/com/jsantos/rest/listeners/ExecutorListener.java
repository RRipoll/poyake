package com.jsantos.rest.listeners;

import java.sql.SQLException;

import javax.annotation.ManagedBean;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;

import com.jsantos.common.registry.AppClassRegistry;
import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.ORMClassRegistry;
import com.jsantos.metadata.MT;
import com.jsantos.orm.MainDb;
import com.jsantos.rest.config.DataSourceProvider;
import com.jsantos.search.registry.SearchClassRegistry;

@ManagedBean
public final class ExecutorListener  implements ServletContextInitializer {
   
    @Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		try {
			MainDb.setMainDataSource(DataSourceProvider.tomcatPoolDatasource());
		} catch (SQLException e) {
			throw new ServletException(e);
		}

		MT.init();
		//ORMClassRegistry.setTriggersPackage("com.jsantos.trigger");
		//ORMClassRegistry.setExtendedDTOPackage("com.jsantos.extendeddto");
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