package com.jsantos.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.LinkedHashMap;

import com.jsantos.commondata.azure.AzureAccounts;
import com.jsantos.commondata.azure.AzureFileUploader;
import com.jsantos.factory.file.IFileProvider;
import com.microsoft.azure.storage.StorageException;


public class AzureProvider implements IFileProvider{
	//private static final Logger log = LoggerFactory.getLogger(AzureProvider.class);
	@Override
	public String storeFile(String formName, File file, Integer inputUserGroupId
			) throws Exception  {
		try {
			return AzureFileUploader.storeInAzure(formName, file,inputUserGroupId
					);
		} catch (InvalidKeyException | URISyntaxException | StorageException | IOException | SQLException e) {
			throw new Exception(e);
		}
	}

	@Override
	public File getFile(String path) {
		return new File(path);
	}

	@Override
	public Hashtable<File, String> storeFiles(String formName, LinkedHashMap<File, String> files, Integer inputUserGroupId
			) throws Exception {
		try {
			return AzureFileUploader.storeInAzure(formName, files,inputUserGroupId
					);
		} catch (InvalidKeyException | URISyntaxException | StorageException | IOException | SQLException e) {
			throw new Exception(e);
		}
	}

	@Override
	public String getURL(String location, Integer inputUserGroupId
			) throws Exception {
		return AzureAccounts.buildURL(location,inputUserGroupId
				);
	}

	@Override
	public String getProvider() {
		return this.getClass().getName();
	}

	

	

}
