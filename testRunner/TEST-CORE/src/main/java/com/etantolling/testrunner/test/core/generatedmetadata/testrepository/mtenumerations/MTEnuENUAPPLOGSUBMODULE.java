package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTEnumeration;

@SuppressWarnings("unused")
public class MTEnuENUAPPLOGSUBMODULE extends MTEnumeration{

	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<Integer, String>();

	public static final Integer General_1 = 1;

	static{
		values.put(1,"General");
	}

	@Override
	public LinkedHashMap<Integer, String> getHashmap() {
		return values;
	}
}
