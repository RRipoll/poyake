package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class Operator extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int EQUAL = 1;
	public static final int NOT_EQUAL = 2;
	public static final int LT = 3;
	public static final int LE = 4;
	public static final int GE = 5;
	public static final int GT = 6;
	public static final int IN = 7;
	public static final int NOT_IN = 8;
	public static final int BETWEEN = 9;
	public static final int LIKE = 10;
	public static final int ILIKE = 11;
	public static final int _NULL = 12;
	public static final int NOT_NULL = 13;
	public static final int CHECK = 14;

	static {
		values.put(1,"EQUAL");
		shortCodes.put("EQUAL",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"NOT EQUAL");
		shortCodes.put("NOT_EQUAL",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"LOWER THAN");
		shortCodes.put("LT",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"LOWER OR EQUAL");
		shortCodes.put("LE",4);
		labels.put(4, new ArrayList<Label>());
		values.put(5,"GREATER OR EQUAL");
		shortCodes.put("GE",5);
		labels.put(5, new ArrayList<Label>());
		values.put(6,"GREATER THAN");
		shortCodes.put("GT",6);
		labels.put(6, new ArrayList<Label>());
		values.put(7,"IN");
		shortCodes.put("IN",7);
		labels.put(7, new ArrayList<Label>());
		values.put(8,"NOT IN");
		shortCodes.put("NOT_IN",8);
		labels.put(8, new ArrayList<Label>());
		values.put(9,"BETWEEN");
		shortCodes.put("BETWEEN",9);
		labels.put(9, new ArrayList<Label>());
		values.put(10,"LIKE");
		shortCodes.put("LIKE",10);
		labels.put(10, new ArrayList<Label>());
		values.put(11,"ILIKE");
		shortCodes.put("ILIKE",11);
		labels.put(11, new ArrayList<Label>());
		values.put(12,"NULL");
		shortCodes.put("_NULL",12);
		labels.put(12, new ArrayList<Label>());
		values.put(13,"NOT NULL");
		shortCodes.put("NOT_NULL",13);
		labels.put(13, new ArrayList<Label>());
		values.put(14,"CHECK");
		shortCodes.put("CHECK",14);
		labels.put(14, new ArrayList<Label>());
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