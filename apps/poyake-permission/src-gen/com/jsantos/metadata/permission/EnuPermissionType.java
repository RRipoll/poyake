package com.jsantos.metadata.permission;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuPermissionType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int MENU = 1;
	public static final int MTTABLE = 3;

	static {
		values.put(1,"Menu");
		shortCodes.put("MENU",1);
		labels.put(1, new ArrayList<Label>());
		values.put(3,"Table");
		shortCodes.put("MTTABLE",3);
		labels.put(3, new ArrayList<Label>());

		labels.get(1).add( new Label("SHORTCODE","es_ES","Menu"));
		labels.get(3).add( new Label("SHORTCODE","es_ES","Pantalla"));
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