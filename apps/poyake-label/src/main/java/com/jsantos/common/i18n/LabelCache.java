package com.jsantos.common.i18n;

import java.util.LinkedHashMap;
import java.util.Locale;

public class LabelCache {
	static LinkedHashMap<Locale, LinkedHashMap<String, String>> cache = new LinkedHashMap<>();
	
	public static String get(Locale locale, String shortCode) {
		if (null != cache.get(locale))
			return cache.get(locale).get(shortCode);
		return null;
	}
	
	public static void set(Locale locale, String shortCode, String label) {
		if(null==cache.get(locale))cache.put(locale, new LinkedHashMap<>());
		cache.get(locale).put(shortCode, label);
	}
}
