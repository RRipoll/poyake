package com.etantolling.testrunner.test.core.appcontext;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;

public enum NasFolder {
	LOG("/logs"),
	INPUT("/input"),
	TRANSACTIONFILES("/input/transactionfiles"),
	PAYMENTFILES("/input/paymentfiles"),
	INVOICE_PDF_FILES("/input/InvoiceImages"),
	MANUALTESTS("/test/manualtests"),
	AUTOMATEDTESTS("/test/automatedtests"),
	REPORTS("/output/reports"),
	OUTPUT("/output"),
	INVOICES("/output/invoices"),
	EXCHANGE("/output/exchange"),
	COLLECTIONS("/output/collections"),
	IVR_INVOICE_FILES("/output/ivr_invoice_files"),
	TMP("/tmp"),
	DISPUTED_PLATES("/output/Misreads"),
	REG_HOLD("/output/RegHold"),
	REG_HOLD_ARCHIVE("/output/RegHold/Archive"), 
	NSF_LETTER("/output/nsfFile"), 
	RINGCLEAR("/output/ringClear/"),
	BLACKLIST("/output/blacklist"),
	WELLS_FARGO_STOP_FILE("/output/wells_fargo_stop_file"),
	STATEMENT_ZIP_FOLDER("/output/statement");////
	
	private final String path;
	private static final Logger log = LoggerFactory.getLogger(NasFolder.class);

	NasFolder(String path){
		this.path=path;
	}
	
	/*
	public String getPath(){
		return path;
	}
	*/
	
	public String toString(){
		try {
			return getFolder().getCanonicalPath();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public File getFolder(){
		if (StringUtils.isEmpty(EnvironmentHelper.getNasshareFileSystemPath()))
			throw new RuntimeException("Environment helper doesn't seem to be initialized. NasshareFileSystemPath is empty. Did you call CliContextInitializer.initialize()?");
		
		File folder = new File(EnvironmentHelper.getNasshareFileSystemPath(), path);
		if(!folder.exists())
			try {
				FileUtils.forceMkdir(folder);
			}
			catch (IOException e) {
				log.error("ERROR STACKTRACE: ", e);
			}
		
		return folder;
	}
	
	public File getEnvironmentFolder(){
		if (StringUtils.isEmpty(EnvironmentHelper.getNasshareEnvironmentPath()))
			throw new RuntimeException("Environment helper doesn't seem to be initialized. getNasshareEnvironmentPath is empty. Did you call CliContextInitializer.initialize()?");
		
		File folder = new File(EnvironmentHelper.getNasshareEnvironmentPath(), path);
		if(!folder.exists())
			try {
				FileUtils.forceMkdir(folder);
			}
			catch (IOException e) {
				log.error("ERROR STACKTRACE: ", e);
			}
		
		return folder;
	}
}
