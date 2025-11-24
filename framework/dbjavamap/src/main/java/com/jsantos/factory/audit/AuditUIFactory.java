package com.jsantos.factory.audit;

import com.jsantos.common.registry.AppClassRegistry;

public class AuditUIFactory {
	
	private static String GUI_PACKAGE = "com.jsantos.service";
	private static String className = "com.jsantos.factory.audit.IAuditUIProvider";
	private static  IAuditUIProvider auditUIProvider = null;
	
	
	public static void init()  {
		if(null==auditUIProvider){
			Class<?> iclass=AppClassRegistry.getClasses(GUI_PACKAGE, className);
			if(null!=iclass)
				try {
					auditUIProvider=(IAuditUIProvider) iclass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			else auditUIProvider=new AuditUIProviderDefault();
			auditUIProvider.inicialice();
		}
	}
	public static IAuditUIProvider getProvider() {
		if(null==auditUIProvider) init();
		return auditUIProvider;
	}
	
}
