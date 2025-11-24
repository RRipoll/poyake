package com.jsantos.metadata.recorder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuRecorderType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int INSERT = 1;
	public static final int UPDATE = 2;
	public static final int DELETED = 3;

	static {
		values.put(1,"INSERT");
		shortCodes.put("INSERT",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"UPDATE");
		shortCodes.put("UPDATE",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"DELETED");
		shortCodes.put("DELETED",3);
		labels.put(3, new ArrayList<Label>());
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