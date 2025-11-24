package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EventStatus extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int NEW = 1;
	public static final int WAITING = 2;
	public static final int PROCESSING = 3;
	public static final int ERROR = 4;
	public static final int DONE = 5;

	static {
		values.put(1,"None");
		shortCodes.put("NEW",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"Waiting");
		shortCodes.put("WAITING",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"Processing");
		shortCodes.put("PROCESSING",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"Error");
		shortCodes.put("ERROR",4);
		labels.put(4, new ArrayList<Label>());
		values.put(5,"Done");
		shortCodes.put("DONE",5);
		labels.put(5, new ArrayList<Label>());
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