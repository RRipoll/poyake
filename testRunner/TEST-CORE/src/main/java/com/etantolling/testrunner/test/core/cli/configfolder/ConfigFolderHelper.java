package com.etantolling.testrunner.test.core.cli.configfolder;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.cli.JAXBHelper;
import com.etantolling.testrunner.test.core.cli.configfolder.xmlbindings.Host;
import com.etantolling.testrunner.test.core.cli.configfolder.xmlbindings.Hosts;

public class ConfigFolderHelper {
	
	private static final String DEFAULT_CONFIG_FOLDER_MAP_FILE = "confs/ConfigFolderMap.xml";
	
	public static String hostname = null;
	public static Hosts hosts = null;
	public static String configFolderBaseDir;
	
	private static final Logger log = LoggerFactory.getLogger(ConfigFolderHelper.class);
	
	public static void init(String configFolderMapFile) throws IOException {
		
		// Determine base directory for config folder map files
		File mapFile;
		if (StringUtils.isBlank(configFolderMapFile))
			mapFile = new File(DEFAULT_CONFIG_FOLDER_MAP_FILE);
		else
			mapFile = new File(configFolderMapFile);
		configFolderBaseDir = mapFile.getParentFile().getCanonicalPath();
		
		getHostName();
		log.info("Host Name: " + hostname);
		log.info("User Name: " + System.getProperty("user.name"));
		hosts = new JAXBHelper<Hosts>().loadXmlFile(mapFile.getPath(), Hosts.class.getPackage().getName());
		if (null == hosts) {
			log.info("ConfigFolderMap.xml exiting...");
			System.exit(0);
		}
	}

	public static String getHostName() throws IOException{
		if (null == hostname){
			hostname = System.getenv("CONFIG_FOLDER");
		}
		if (null == hostname){
			hostname = InetAddress.getLocalHost().getHostName();
		}
		return hostname;
	}
	
	public static String getCurrentCanonicalPath() throws IOException{
		return new File(".").getCanonicalPath();
	}
	
	public static File getConfigFolderByHostName(boolean isDefault) throws IOException{
		return getConfigFolderByHostName(getHostName(), isDefault);
	}
	
	public static File getConfigFolderByHostName(String hostname, boolean isDefault) throws IOException{
		for (Host host:hosts.getHost()){
			if (hostname.equalsIgnoreCase(host.getName())){
				
				String configFileDir = configFolderBaseDir + "/" + (isDefault ? host.getDefaultsConfigFolder() : host.getConfigFolder());
				File folder = new File(configFileDir);
				if (folder.exists()) {
					log.info("Using configurations in folder: " + folder.getCanonicalPath());
					return folder;
				}
			}
		}
		return null;
	}

	public static File getConfigFolder(boolean isDefault) throws IOException{
		
		String hostName = getHostName();
		String userName = System.getProperty("user.name");
		String environmentVariable = System.getenv("CONFIGFOLDER");
		
		for (Host host:hosts.getHost()){
			 if (!StringUtils.isEmpty(host.getName()) && !hostName.equalsIgnoreCase(host.getName())) continue;
			 if (!StringUtils.isEmpty(host.getUsername()) && !userName.equalsIgnoreCase(host.getUsername())) continue;
			 if (!StringUtils.isEmpty(host.getEnvironmentvariable()) && !StringUtils.isEmpty(environmentVariable) && !environmentVariable.equalsIgnoreCase(host.getEnvironmentvariable())) continue;

			 String configFileDir = configFolderBaseDir + "/" + (isDefault ? host.getDefaultsConfigFolder() : host.getConfigFolder());
			 File folder = new File(configFileDir);
			 if (folder.exists()) {
				log.info("Using configurations in folder: " + folder.getCanonicalPath());
				return folder;
			 }			
		}
		return null;
	}
	
	public static File getConfigFile(String fileName) throws IOException{
		File configFolder = getConfigFolder(false);
		 
		if (null !=configFolder){
			
			File file = new File(configFolder.getCanonicalPath() + "/" + fileName);
			if (file.exists()) return file;
		}

		configFolder = getConfigFolder(true);
		log.info(" configFolder1 " + configFolder);
		if (null !=configFolder){
			File file = new File(configFolder.getCanonicalPath() + "/" + fileName);
			if (file.exists()) return file;
		}
		
		configFolder = getConfigFolderByHostName("default", false);
		if (null !=configFolder){
			File file = new File(configFolder.getCanonicalPath() + "/" + fileName);
			if (file.exists()) return file;
		}
		else log.info("default config folder not found!!!");
		
		log.info("File: " + fileName + " not found !!!");
		return null;
	}
}