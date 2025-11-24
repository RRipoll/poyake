package com.jsantos.auditimmo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zul.Messagebox;

import com.jsantos.auditimmo.orm.DataSourceProvider;
import com.jsantos.gui.WebAppClassRegistry;
import com.jsantos.gui.zkcomponent.MTTextbox;
import com.jsantos.metadata.MT;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.util.DTOFactory;
import com.jsantos.orm.util.ORMClassRegistry;




public class WebContextInitializer implements ServletContextListener {
	
	private static final Logger log = LoggerFactory.getLogger(WebContextInitializer.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		MainDb.setMainDataSource(DataSourceProvider.sqlServerDataSource());
		MTTextbox m = new MTTextbox();
		MT.init();
		ORMClassRegistry.setTriggersPackage("com.jsantos.demo.orm.trigger");
		ORMClassRegistry.setExtendedDTOPackage("com.jsantos.demo.orm.extendeddto");
		ORMClassRegistry.loadClasses();
		ORMClassRegistry.logTriggers();
		DTOFactory.logInfo();
		Messagebox.setTemplate("/common/zul/dialog/messagebox.zul");
		
		WebAppClassRegistry.loadClasses();
		System.out.println("=============================================================");
		System.out.println("===== Context Initialization finished                   =====");
		System.out.println("=============================================================");
	}
}
