package com.etantolling.testrunner.test.core.testing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//this is used to trigger a bit of code with a button in the bos home.

public class ProgrammersOnlyEntryPoint {
	private static final Logger log = LoggerFactory.getLogger(ProgrammersOnlyEntryPoint.class);

	public void runSomeCode(){
		log.info("runSomeCode called");
		try{
			//new InvoiceFileGenerator().generateDailyFile();
		}
		catch (Exception e){
			log.error("ERROR STACKTRACE:",e);
		}
	}
}
