package com.jsantos.metadata.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class Enulocale extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int es_ES = 3082;
	public static final int en_US = 1033;
	public static final int fr_FR = 1036;

	static {
		values.put(3082,"Spanish (International)");
		shortCodes.put("es_ES",3082);
		labels.put(3082, new ArrayList<Label>());
		values.put(1033,"English (USA)");
		shortCodes.put("en_US",1033);
		labels.put(1033, new ArrayList<Label>());
		values.put(1036,"France (International)");
		shortCodes.put("fr_FR",1036);
		labels.put(1036, new ArrayList<Label>());
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