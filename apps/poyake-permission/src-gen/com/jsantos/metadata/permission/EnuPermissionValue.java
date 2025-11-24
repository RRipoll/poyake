package com.jsantos.metadata.permission;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuPermissionValue extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int ALL = 0;
	public static final int WRITE = 1;
	public static final int READ = 2;
	public static final int NO = 3;

	static {
		values.put(0,"All");
		shortCodes.put("ALL",0);
		labels.put(0, new ArrayList<Label>());
		values.put(1,"Write");
		shortCodes.put("WRITE",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"Read");
		shortCodes.put("READ",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"No");
		shortCodes.put("NO",3);
		labels.put(3, new ArrayList<Label>());

		labels.get(3).add( new Label("SHORTCODE","es_ES","No"));
		labels.get(2).add( new Label("SHORTCODE","es_ES","Lectura"));
		labels.get(1).add( new Label("SHORTCODE","es_ES","Escritura"));
		labels.get(0).add( new Label("SHORTCODE","es_ES","Todos"));
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