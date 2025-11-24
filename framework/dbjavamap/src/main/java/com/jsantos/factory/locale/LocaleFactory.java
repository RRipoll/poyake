package com.jsantos.factory.locale;

import com.jsantos.common.registry.AppClassRegistry;

public class LocaleFactory {

	private static String GUI_PACKAGE = "com.jsantos.service";
	private static String className = "com.jsantos.factory.locale.ILocaleProvider";
	private static  ILocaleProvider localeProvider = null;
	
	
	public static void init()  {
		if(null==localeProvider){
			Class<?> iclass=AppClassRegistry.getClasses(GUI_PACKAGE, className);
			if(null!=iclass)
				try {
					localeProvider=(ILocaleProvider) iclass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			else localeProvider=new LocaleProviderDefault();
			localeProvider.inicialice();
			}
	}
	public static ILocaleProvider getProvider() {
		if(null==localeProvider) init();
		return localeProvider;
	}
	
		
	
}
