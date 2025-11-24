package com.jsantos.commondata.azure;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.sql.SQLException;

import com.jsantos.factory.appinfo.AppInfoFactory;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPermissions;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

public class AzureAccounts {

	static final String AZURENAME = "fastlanedevstorage"; 
	static final String AZUREKEY = "EzEiM2E6c+Q7RAIiDbK5+D36J4tXMid8OUqmNUQuggYwSG1FAFvff4hb6tvqreWaEyBDOF2vA4S1EkZ6NibZZQ=="; 
	
	static String containerName="docs";
	
	
	public static String getAzureName( Integer inputUserGroupId
			) throws SQLException{
		if(null!=AppInfoFactory.getProvider().get("AZURENAME", inputUserGroupId
				))
			return AppInfoFactory.getProvider().get("AZURENAME", inputUserGroupId
					).toString();
		return AZURENAME;
	}
	
	public static String getAzureKey( Integer inputUserGroupId
			) throws SQLException{
		if(null!=AppInfoFactory.getProvider().get("AZUREKEY", inputUserGroupId
				))
			return AppInfoFactory.getProvider().get("AZUREKEY", inputUserGroupId
					).toString();
		return AZUREKEY;
	}
	
	public static String getBaseImageUrl( Integer inputUserGroupId
			) throws SQLException{
		String accountName = getAzureName( inputUserGroupId
				);
		return "http://" + accountName + ".blob.core.windows.net/";
	}
	
	public static String buildURL(String blobReference, Integer inputUserGroupId
			) throws SQLException{
		String url = getBaseImageUrl(inputUserGroupId
				);
		url += containerName + "/" + blobReference;
		return url;
	}
	
	
	

	public static CloudStorageAccount getCloudStorageAccount( Integer inputUserGroupId
			) throws InvalidKeyException, URISyntaxException, SQLException{
		String storageConnectionString = 
			    "DefaultEndpointsProtocol=http;" + 
			    "AccountName=" + getAzureName(inputUserGroupId
			    		) + ";" + 
			    "AccountKey=" + getAzureKey(inputUserGroupId
			    		);		
		return CloudStorageAccount.parse(storageConnectionString);
	}


	public static CloudBlobContainer getCloudBlobContainer( Integer inputUserGroupId
			) throws InvalidKeyException, URISyntaxException, SQLException, StorageException{
		CloudStorageAccount storageAccount = getCloudStorageAccount(inputUserGroupId
				);
		CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
		CloudBlobContainer container = blobClient.getContainerReference(containerName);
		container.createIfNotExists();
		BlobContainerPermissions containerPermissions = new BlobContainerPermissions();
		containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);
		container.uploadPermissions(containerPermissions);		
		return container;
	}	
	
	public static boolean exists(CloudBlobContainer container, String blobReference) throws StorageException, URISyntaxException{
		return container.getBlockBlobReference(blobReference).exists();
	}
	
	
}


