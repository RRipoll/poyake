package com.jsantos.factory.file;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.jsantos.factory.appinfo.AppInfoFactory;
import com.jsantos.factory.appinfo.NasFolder;

public class FileProviderDefault implements IFileProvider {
		@Override
	public String storeFile(String formName, File file, Integer inputUserGroupId
			) throws Exception {
		
		return storeFile( formName,  file,0,  0);
	}

		public String storeFile(String formName, File file, int norder, Integer inputUserGroupId
				) throws Exception {
			
			File folder=FileUtil.getEnvironmentFolder(AppInfoFactory.getProvider().get(NasFolder.DOCEXAMPLE,inputUserGroupId
					).toString(),inputUserGroupId
					);
			UUID uuid = UUID.randomUUID();//.toString();
			
			String ext=null;
			String name=null==formName?file.getName():formName+"_"+uuid+"_"+norder;
			
			if(file.getName().lastIndexOf(".")!=-1){
			    ext=file.getName().substring(file.getName().lastIndexOf("."),file.getName().length());
			}
			if(null!=ext && ext.length()>0) name+=ext;
			
			File realFile=new File(folder.getAbsolutePath(),name);
			
			file.renameTo(realFile);
			return realFile.getAbsolutePath();
		}
		
	@Override
	public File getFile(String path) {
		return new File(path);
	}

	@Override
	public Map<File, String> storeFiles(String formName, LinkedHashMap<File, String> files, Integer inputUserGroupId
			) throws Exception {
		LinkedHashMap<File, String> retValue= new LinkedHashMap<File, String>();
		int i=0;
		for (File file : files.keySet()) {
			retValue.put(file, storeFile(files.get(file),file,i++));
		}
		return retValue;
	}

	@Override
	public String getURL(String location, Integer inputUserGroupId
			) throws Exception {
		//return new URL("http://localhost:8081/rest/api/file/" + location + "/download");
		return location;
	}

	@Override
	public String getProvider() {
		return this.getClass().getName();
	}
}
