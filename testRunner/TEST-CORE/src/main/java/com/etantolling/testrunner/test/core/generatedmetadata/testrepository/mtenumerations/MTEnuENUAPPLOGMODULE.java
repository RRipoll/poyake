package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.metadata.MTEnumeration;

@SuppressWarnings("unused")
public class MTEnuENUAPPLOGMODULE extends MTEnumeration{

	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<Integer, String>();

	public static final Integer IAG_1 = 1;
	public static final Integer Image_Review_2 = 2;
	public static final Integer DMV_3 = 3;
	public static final Integer Toll_Processor_4 = 4;
	public static final Integer File_Registry_5 = 5;
	public static final Integer Job_Control_6 = 6;
	public static final Integer GL_Processor_7 = 7;
	public static final Integer BOS_GUI_8 = 8;
	public static final Integer Invoice_Generator_9 = 9;
	public static final Integer Statement_Generator_10 = 10;
	public static final Integer Unspecified_11 = 11;

	static{
		values.put(1,"IAG");
		values.put(2,"Image Review");
		values.put(3,"DMV");
		values.put(4,"Toll Processor");
		values.put(5,"File Registry");
		values.put(6,"Job Control");
		values.put(7,"GL Processor");
		values.put(8,"BOS GUI");
		values.put(9,"Invoice Generator");
		values.put(10,"Statement Generator");
		values.put(11,"Unspecified");

	}

	@Override
	public LinkedHashMap<Integer, String> getHashmap() {
		return values;
	}
}
