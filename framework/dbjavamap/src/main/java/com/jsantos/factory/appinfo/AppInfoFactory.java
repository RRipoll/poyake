package com.jsantos.factory.appinfo;

import com.jsantos.common.registry.AppClassRegistry;

public class AppInfoFactory {

	private static String GUI_PACKAGE = "com.jsantos.service";
	private static String className = "com.jsantos.factory.appinfo.IAppInfoProvider";
	private static  IAppInfoProvider appInfoProvider = null;
	
	public static void init()  {
		if(null==appInfoProvider){
			Class<?> iclass=AppClassRegistry.getClasses(GUI_PACKAGE, className);
			if(null!=iclass)
				try {
					appInfoProvider=(IAppInfoProvider) iclass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			else appInfoProvider=new AppInfoProviderDefault();
			appInfoProvider.inicialice();
			}
	}
	public static IAppInfoProvider getProvider() {
		if(null==appInfoProvider) init();
		return appInfoProvider;
	}
}
