package com.jsantos.metadata.crm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuPhoneNumberType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int HOME = 1;
	public static final int WORK = 2;
	public static final int MOBILE = 3;

	static {
		values.put(1,"Home");
		shortCodes.put("HOME",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"Work");
		shortCodes.put("WORK",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"Mobile");
		shortCodes.put("MOBILE",3);
		labels.put(3, new ArrayList<Label>());

		labels.get(1).add( new Label("SHORTCODE","es_ES","Domicilio"));
		labels.get(2).add( new Label("SHORTCODE","es_ES","Trabajo"));
		labels.get(3).add( new Label("SHORTCODE","es_ES","M??vil"));
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