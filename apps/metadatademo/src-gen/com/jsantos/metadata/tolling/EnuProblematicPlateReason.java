package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuProblematicPlateReason extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int OCRLOWSCORE = 1;
	public static final int LOWCONTRAST = 2;

	static {
		values.put(1,"OCR Low Score");
		shortCodes.put("OCRLOWSCORE",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"Low Contrast");
		shortCodes.put("LOWCONTRAST",2);
		labels.put(2, new ArrayList<Label>());
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