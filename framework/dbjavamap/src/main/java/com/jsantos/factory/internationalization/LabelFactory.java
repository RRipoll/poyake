package com.jsantos.factory.internationalization;

import com.jsantos.common.registry.AppClassRegistry;

public class LabelFactory {
	
	private static String GUI_PACKAGE = "com.jsantos.service";
	private static String className = "com.jsantos.factory.internationalization.ILabelProvider";
	private static  ILabelProvider labelProvider = null;
	
	
	public static void init()  {
		if(null==labelProvider){
			Class<?> iclass=AppClassRegistry.getClasses(GUI_PACKAGE, className);
			if(null!=iclass)
				try {
					labelProvider=(ILabelProvider) iclass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			else labelProvider=new LabelProviderDefault();
			labelProvider.inicialice();
			}
	}
	public static ILabelProvider getProvider() {
		if(null==labelProvider) init();
		return labelProvider;
	}
	
	
	
}
