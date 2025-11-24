package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTEnumeration;

@SuppressWarnings("unused")
public class MTEnuENUAPPLOGCODE extends MTEnumeration{

	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<Integer, String>();

	public static final Integer Timeout_on_expected_file_1 = 1;
	public static final Integer NACK_2 = 2;
	public static final Integer Could_not_connect_to_service_3 = 3;
	public static final Integer Generic_Exception_4 = 4;
	public static final Integer File_invalid_5 = 5;

	static{
		values.put(1,"Timeout on expected file");
		values.put(2,"NACK");
		values.put(3,"Could not connect to service");
		values.put(4,"Generic Exception");
		values.put(5,"File invalid");
	}

	@Override
	public LinkedHashMap<Integer, String> getHashmap() {
		return values;
	}
}
