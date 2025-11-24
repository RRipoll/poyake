package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTEnumeration;

@SuppressWarnings("unused")
public class MTEnuEVENTTYPE extends MTEnumeration{

	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<Integer, String>();

	public static final Integer Rest_Event = 1;
	public static final Integer Job_Event = 2;
	public static final Integer File_Event = 3;
	public static final Integer Rest_Job_Event = 4;
	
	static{
		values.put(1,"Rest");
		values.put(2,"Job");
		values.put(3,"File");
		values.put(4,"Rest_Job");

	}

	@Override
	public LinkedHashMap<Integer, String> getHashmap() {
		return values;
	}
}
