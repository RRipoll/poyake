package com.jsantos.metadata.eva;

import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;

public class EnuSubSectionstatus extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<String, LinkedHashMap<Integer, String>> labels = new LinkedHashMap<>();

	public static final int O = 1;
	public static final int Em = 2;
	public static final int Ev = 3;
	public static final int NA = 4;

	static {
		values.put(1,"The Element has not been assessed");
		shortCodes.put("O",1);
		values.put(2,"The Element has been assessed but one or more mandatory fields are missing");
		shortCodes.put("Em",2);
		values.put(3,"The Element has been assessed and all mandatory fields have been entered");
		shortCodes.put("Ev",3);
		values.put(4,"The Element has been marked N/A");
		shortCodes.put("NA",4);
	}

	@Override
	public LinkedHashMap<Integer, String> getHashmap() {
		return values;
	}

	@Override
	public LinkedHashMap<String, Integer> getShortCodes() {
		return shortCodes;
	}
	@Override
	public LinkedHashMap<String, LinkedHashMap<Integer, String>> getLabels() {
		return labels;
	}
}