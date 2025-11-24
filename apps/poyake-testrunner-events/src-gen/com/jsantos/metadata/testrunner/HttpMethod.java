package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class HttpMethod extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int PUT = 2;
	public static final int DELETE = 4;
	public static final int POST = 3;
	public static final int GET = 1;

	static {
		values.put(2,"PUT");
		shortCodes.put("PUT",2);
		labels.put(2, new ArrayList<Label>());
		values.put(4,"DELETE");
		shortCodes.put("DELETE",4);
		labels.put(4, new ArrayList<Label>());
		values.put(3,"POST");
		shortCodes.put("POST",3);
		labels.put(3, new ArrayList<Label>());
		values.put(1,"GET");
		shortCodes.put("GET",1);
		labels.put(1, new ArrayList<Label>());
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