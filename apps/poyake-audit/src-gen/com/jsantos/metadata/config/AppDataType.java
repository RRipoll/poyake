package com.jsantos.metadata.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class AppDataType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int TEXT = 1;
	public static final int INTEGER = 2;
	public static final int BOOLEAN = 3;
	public static final int DATE = 4;
	public static final int DECIMAL = 5;

	static {
		values.put(1,"Text");
		shortCodes.put("TEXT",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"Integer");
		shortCodes.put("INTEGER",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"Boolean");
		shortCodes.put("BOOLEAN",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"Date");
		shortCodes.put("DATE",4);
		labels.put(4, new ArrayList<Label>());
		values.put(5,"Decimal");
		shortCodes.put("DECIMAL",5);
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