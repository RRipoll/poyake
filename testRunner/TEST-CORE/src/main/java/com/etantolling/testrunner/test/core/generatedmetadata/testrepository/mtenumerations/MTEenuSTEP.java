package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTEnumeration;

public class MTEenuSTEP extends MTEnumeration{

	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<Integer, String>();

	public static final Integer CORE_1 = 1;

	public static final Integer SANDAG_2 = 2;

	public static final Integer WASDOT_3 = 3;

	static{

		values.put(1,"CORE");
		values.put(2,"SANDAG");
		values.put(3,"WSDOT");
	}

	@Override

	public LinkedHashMap<Integer, String> getHashmap() {
		return values;
	}
}