package com.jsantos.metadata.multi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuRoomType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int KICHEN = 1;
	public static final int DINER = 2;
	public static final int ROOM = 3;
	public static final int SERVICE = 4;

	static {
		values.put(1,"KICHEN");
		shortCodes.put("KICHEN",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"DINNER");
		shortCodes.put("DINER",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"ROOM");
		shortCodes.put("ROOM",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"SERVICE");
		shortCodes.put("SERVICE",4);
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