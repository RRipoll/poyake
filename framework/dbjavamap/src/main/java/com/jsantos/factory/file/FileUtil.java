package com.jsantos.factory.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtil {

	public static File getEnvironmentFolder(String folder, Integer inputUserGroupId
			) {
		File retValue=null;
		try {
			File path= new File(folder);
			String fileDir=path.getAbsolutePath();
			//fileDir+=folder;
			retValue = new File(fileDir//,inputUserGroupId
					);
			if(!retValue.exists())
			
				FileUtils.forceMkdir(retValue);
		}
		catch (IOException  e) {
			e.printStackTrace();//log.error("ERROR STACKTRACE:",e);
		}
		return retValue;
	}
	
	
}
