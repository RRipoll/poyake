package com.jsantos.factory.file;

import java.io.File;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import com.jsantos.factory.appinfo.IProvider;

public interface IFileProvider  extends IProvider{

	String storeFile(String formName,File file, Integer inputUserGroupId
			) throws Exception;
	
	Map<File, String> storeFiles(String formName,LinkedHashMap<File, String> files, Integer inputUserGroupId
			) throws Exception;
	
	File getFile(String location);
	
	String getURL(String location,Integer inputUserGroupId) throws Exception;;
	
	String getProvider();
}
