package com.jsantos.factory.file;

import com.jsantos.common.registry.AppClassRegistry;

public class FileFactory {

	private static String GUI_PACKAGE = "com.jsantos.service";
	private static String className = "com.jsantos.factory.file.IFileProvider";
	private static  IFileProvider fileProvider = null;
	
	
	public static void init()  {
		if(null==fileProvider){
			Class<?> iclass=AppClassRegistry.getClasses(GUI_PACKAGE, className);
			if(null!=iclass)
				try {
					fileProvider=(IFileProvider) iclass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			else fileProvider=new FileProviderDefault();
			fileProvider.inicialice();
			}
	}
	public static IFileProvider getProvider() {
		if(null==fileProvider) init();
		return fileProvider;
	}
	
	
	
}
