package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTEnumeration;

@SuppressWarnings("unused")
public class MTEnuENUAPPLOGLEVEL extends MTEnumeration{

	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<Integer, String>();

	public static final Integer Disaster_1 = 1;
	public static final Integer High_2 = 2;
	public static final Integer Average_3 = 3;
	public static final Integer Warning_4 = 4;
	public static final Integer Info_5 = 5;

	static{
		values.put(1,"Disaster");
		values.put(2,"High");
		values.put(3,"Average");
		values.put(4,"Warning");
		values.put(5,"Info");
	}

	@Override
	public LinkedHashMap<Integer, String> getHashmap() {
		return values;
	}
}
