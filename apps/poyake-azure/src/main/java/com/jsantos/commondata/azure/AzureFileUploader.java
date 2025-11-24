package com.jsantos.commondata.azure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.UUID;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;




public class AzureFileUploader {

	public static void uploadBlob(CloudBlobContainer container, File source, String azureFileName) throws URISyntaxException, StorageException, FileNotFoundException, IOException{
		CloudBlockBlob blob = container.getBlockBlobReference(azureFileName);
		blob.upload(new FileInputStream(source), source.length());
	}

	
	public static void uploadBlob(CloudBlobContainer container, InputStream source, String azureFileName, long length) throws URISyntaxException, StorageException, FileNotFoundException, IOException{
		CloudBlockBlob blob = container.getBlockBlobReference(azureFileName);
		blob.upload(source, length);
	}
	
	public static boolean checkBlobExists(CloudBlobContainer container, String azureFileName) throws URISyntaxException, StorageException, FileNotFoundException, IOException{
		CloudBlockBlob blob = container.getBlockBlobReference(azureFileName);
		return blob.exists();
	}

	public static String storeInAzure(String formName,File file, Integer inputUserGroupId
			) throws InvalidKeyException, FileNotFoundException, URISyntaxException, StorageException, IOException, SQLException {
		LinkedHashMap<File, String>files=new LinkedHashMap<File, String>();
		files.put(file, formName);
		Hashtable<File, String> store= storeInAzure(formName, files,inputUserGroupId
				);
		return store.get(file);
		
	}
	
	
	public static Hashtable<File, String> storeInAzure(String formName,LinkedHashMap<File, String> files, Integer inputUserGroupId
			) throws InvalidKeyException, URISyntaxException, FileNotFoundException, StorageException, IOException, SQLException{
		Hashtable<File, String> azureFileNames = new Hashtable<File,String>();
		String uuid = UUID.randomUUID().toString();
		int nOrder = 0;
		for (File file:files.keySet()){
			
			String azureFileName = formName + "_"  + uuid + "_" + nOrder ;
			String ext=null;
			if(file.getName().lastIndexOf(".")!=-1){
			    ext=file.getName().substring(file.getName().lastIndexOf("."),file.getName().length());
			}else {
				String name=files.get(file);
				if(name.lastIndexOf(".")!=-1){
				    ext=name.substring(name.lastIndexOf("."),name.length());
				}
			}
			if(null!=ext && ext.length()>0) azureFileName+=ext;
			CloudBlobContainer container = AzureAccounts.getCloudBlobContainer(inputUserGroupId
					);
			
			AzureFileUploader.uploadBlob(container, file, azureFileName);
			azureFileNames.put(file, azureFileName);
			nOrder++;
		}
		return azureFileNames;
	}
	
}
