package com.jsantos.demo;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.zkoss.zul.Messagebox;

import com.jsantos.common.registry.AppClassRegistry;
import com.jsantos.demo.orm.DataSourceProvider;
import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.ORMClassRegistry;
import com.jsantos.gui.registry.WebAppClassRegistry;
import com.jsantos.gui.zkcomponent.MTTextbox;
import com.jsantos.metadata.MT;
import com.jsantos.orm.MainDb;
import com.jsantos.search.registry.SearchClassRegistry;

//import lombok.extern.slf4j.Slf4j;
//@Slf4j



public class WebContextInitializer implements ServletContextListener {
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
			try {
				MainDb.setMainDataSource(DataSourceProvider.tomcatPoolDatasource());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		System.out.println("Database type: " + MainDb.getDatabaseProductName());
		
		MTTextbox m = new MTTextbox();
		MT.init();
		//ORMClassRegistry.addPath("com.jsantos.custom.trigger");
		//ORMClassRegistry.addPath("com.jsantos.custom.extendeddto");
		ORMClassRegistry.loadClasses();
		ORMClassRegistry.logTriggers();
		DTOFactory.logInfo();
		Messagebox.setTemplate("/common/zul/dialog/messagebox.zul");
		AppClassRegistry.loadClasses();
		SearchClassRegistry.loadClasses();
		WebAppClassRegistry.loadClasses();
		System.out.println("=============================================================");
		System.out.println("===== Context Initialization finished                   =====");
		System.out.println("=============================================================");
		
	}
}
