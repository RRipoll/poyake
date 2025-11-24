package com.jsantos.factory.audit;

import com.jsantos.common.registry.AppClassRegistry;

public class AuditFactory {

	private static String GUI_PACKAGE = "com.jsantos.service";
	private static String className = "com.jsantos.factory.audit.IAuditProvider";
	private static  IAuditProvider auditProvider = null;
	
	
	public static void init()  {
		if(null==auditProvider){
			Class<?> iclass=AppClassRegistry.getClasses(GUI_PACKAGE, className);
			if(null!=iclass)
				try {
					auditProvider=(IAuditProvider) iclass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			else auditProvider=new AuditProviderDefault();
			}
	}
	public static IAuditProvider getProvider() {
		if(null==auditProvider) init();
		return auditProvider;
	}
	
	
		
	
}
