package com.jsantos.gui.filegroup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;

import org.zkoss.zul.Filedownload;

import com.jsantos.common.util.ListValues;
import com.jsantos.custom.extendeddto.FileGroupExtDTO;
import com.jsantos.factory.file.FileFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.metadata.common.FileGroupDTO;
import com.jsantos.metadata.common.StorageFileDTO;

public class FileUIUtil {
	
	public static void ShowFile(File file) throws IOException{

		//FileInputStream inputStream;
		//inputStream = new FileInputStream(file);
		
		if(file.getPath().startsWith("http")) {
			String path=file.getPath();
			if(!file.getPath().contains("://"))path=path.replace(":/", "://");
			Filedownload.save(new URL(path), new MimetypesFileTypeMap().getContentType(file) );
		}else Filedownload.save(file, new MimetypesFileTypeMap().getContentType(file) );
		//inputStream.close();
	}
	
	public static FileGroupDTO insertFileGroup(LinkedHashMap<File, String> newFiles, String formName)
			throws Exception {
		
		
		Map<File, String> files = FileFactory.getProvider().storeFiles(formName, newFiles,DesktopHelper.getInputUserGroupId()
				);
		FileGroupExtDTO fileGroupDTO= new FileGroupExtDTO();
		
		for (File file : files.keySet()) {
			
			//String url = AzureAccounts.buildURL(azurefiles.get(file));
			//String url = file.getPath();
			String location=files.get(file);
			
			StorageFileDTO storageFile= new StorageFileDTO();
			storageFile.setFileGroupId(fileGroupDTO.getFileGroupId());
			storageFile.setFileName(file.getName());
			storageFile.setMimeType(new MimetypesFileTypeMap().getContentType(file));
			storageFile.setOriginalFileName(file.getName());
			storageFile.setLocation(location);
			if(null==fileGroupDTO.getStorageFiles())fileGroupDTO.setStorageFiles(new ListValues<StorageFileDTO>());
			fileGroupDTO.getStorageFiles().add(storageFile);
		}
		
		fileGroupDTO.insert();
		
		return fileGroupDTO;
	}
	
}
