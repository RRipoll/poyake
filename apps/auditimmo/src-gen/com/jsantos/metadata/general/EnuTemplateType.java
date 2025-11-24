package com.jsantos.metadata.general;

import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;

public class EnuTemplateType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<String, LinkedHashMap<Integer, String>> labels = new LinkedHashMap<>();


	static {
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
	public LinkedHashMap<String, LinkedHashMap<Integer, String>> getLabels() {
		return labels;
	}
}