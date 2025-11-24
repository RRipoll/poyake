package com.jsantos.metadata.crm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuCountry extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int UNK = 0;
	public static final int US = 1;
	public static final int CA = 2;
	public static final int MX = 3;
	public static final int SP = 4;

	static {
		values.put(0,"Unknown");
		shortCodes.put("UNK",0);
		labels.put(0, new ArrayList<Label>());
		values.put(1,"USA");
		shortCodes.put("US",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"Canada");
		shortCodes.put("CA",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"Mexico");
		shortCodes.put("MX",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"Spain");
		shortCodes.put("SP",4);
		labels.put(4, new ArrayList<Label>());
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
	public LinkedHashMap<Integer, ArrayList<Label>> getLabels() {
		return labels;
	}
}