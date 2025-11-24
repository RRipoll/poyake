package com.etantolling.testrunner.test.core.config;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubversionInfo {
	private boolean isInfoAvailable = false;
	private String revisionLine = null;
	private String lastCommitDateLine = null;
	
	private static final Logger log = LoggerFactory.getLogger(SubversionInfo.class);
	
	@SuppressWarnings("unchecked")
	public SubversionInfo(File subversionInfoFile){
		try{
			if (subversionInfoFile.exists()){
				List<String> lines = FileUtils.readLines(subversionInfoFile);
				for (String line:lines){
					if (line.startsWith("Revision:")) revisionLine = line;
					if (line.startsWith("Last Changed Date:")) lastCommitDateLine = line;
				}
			}
			if (!StringUtils.isEmpty(revisionLine)) {
				log.info("Subversion Info: ");
				log.info(revisionLine);
				log.info(lastCommitDateLine);
				
				isInfoAvailable=true;
			}
		}
		catch(Exception e){
			log.error("ERROR STACKTRACE: ", e);
		}
	}

	public String getRevisionLine() {
		return revisionLine;
	}

	public String getLastCommitDateLine() {
		return lastCommitDateLine;
	}

	public boolean isInfoAvailable() {
		return isInfoAvailable;
	}
}