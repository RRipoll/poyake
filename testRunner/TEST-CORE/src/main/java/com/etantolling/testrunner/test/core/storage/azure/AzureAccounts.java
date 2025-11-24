package com.etantolling.testrunner.test.core.storage.azure;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.sql.SQLException;

import com.etantolling.testrunner.test.core.config.AppInfo;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPermissions;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

public class AzureAccounts {

	static String containerName="testrunner";
	
	
	public static String getAzureName() throws SQLException{
		return AppInfo.get(AppInfo.AZURENAME);
	}
	
	public static String getAzureKey() throws SQLException{
		return AppInfo.get(AppInfo.AZUREKEY);
	}
	
	public static String getBaseImageUrl() throws SQLException{
		String accountName = getAzureName();
		return "https://" + accountName + ".blob.core.windows.net/";
	}
	
	public static String buildURL(String blobReference) throws SQLException{
		String url = getBaseImageUrl();
		url += containerName + "/" + blobReference;
		return url;
	}
	
	
	

	public static CloudStorageAccount getCloudStorageAccount() throws InvalidKeyException, URISyntaxException, SQLException{
		String storageConnectionString = 
			    "DefaultEndpointsProtocol=https;" + 
			    "AccountName=" + getAzureName() + ";" + 
			    "AccountKey=" + getAzureKey() + ";EndpointSuffix=core.windows.net";
		return CloudStorageAccount.parse(storageConnectionString);
	}


	public static CloudBlobContainer getCloudBlobContainer() throws InvalidKeyException, URISyntaxException, SQLException, StorageException{
		CloudStorageAccount storageAccount = getCloudStorageAccount();
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
