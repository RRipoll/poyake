package com.jsantos.factory.permission;

import com.jsantos.common.registry.AppClassRegistry;

public class PermissionFactory {

	private static String GUI_PACKAGE = "com.jsantos.service";
	private static String className = "com.jsantos.factory.permission.IPermissionProvider";
	private static  IPermissionProvider permissionProvider = null;
	
	
	public static void init()  {
		if(null==permissionProvider){
			Class<?> iclass=AppClassRegistry.getClasses(GUI_PACKAGE, className);
			if(null!=iclass)
				try {
					permissionProvider=(IPermissionProvider) iclass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			else permissionProvider=new PermissionProviderDefault();
			permissionProvider.inicialice();
			}
	}
	public static IPermissionProvider getProvider() {
		if(null==permissionProvider) init();
		return permissionProvider;
	}
	
		
	
}
