package com.jsantos.demo;

import javax.annotation.ManagedBean;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
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

@ManagedBean
public final class ExecutorListener  implements ServletContextInitializer {
   
    @Override
	public void onStartup(ServletContext servletContext) throws ServletException {
/*
    	try {
			MainDb.setMainDataSource(DataSourceProvider.tomcatPoolDatasource("poyakeDB.properties"));
		}catch (Exception e) {
			System.out.println("Couldn't load datasource from Tomcat. Using default");
*/
			try {
				MainDb.setMainDataSource(DataSourceProvider.configFileDatasource("poyakeDB.properties"));
			}catch (Exception e1) {
				System.out.println("Couldn't load datasource from properties file. Using default");
				/*
				try {
					MainDb.setMainDataSource(DataSourceProvider.defaultDatasource());
				}catch (Exception e2) {
					throw new ServletException(e);
			
			}
			*/
		//}
    }
		MTTextbox m = new MTTextbox();
		MT.init();
		//ORMClassRegistry.addPath("com.jsantos.custom.trigger");
		//ORMClassRegistry.addPath("com.jsantos.custom.extendeddto");
		ORMClassRegistry.loadClasses();
		ORMClassRegistry.logTriggers();
		DTOFactory.logInfo();
		Messagebox.setTemplate("~./common/zul/dialog/messagebox.zul");
		AppClassRegistry.loadClasses();
		SearchClassRegistry.loadClasses();
		WebAppClassRegistry.loadClasses();
		System.out.println("=============================================================");
		System.out.println("===== Context Initialization finished                   =====");
		System.out.println("=============================================================");
		
	}
}