package com.jsantos.metadata.crm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuCustomerType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int SYSTEM = 0;
	public static final int CUSTOMER = 1;
	public static final int PROSPECT = 3;

	static {
		values.put(0,"System Internal Account");
		shortCodes.put("SYSTEM",0);
		labels.put(0, new ArrayList<Label>());
		values.put(1,"Customer");
		shortCodes.put("CUSTOMER",1);
		labels.put(1, new ArrayList<Label>());
		values.put(3,"Prospect");
		shortCodes.put("PROSPECT",3);
		labels.put(3, new ArrayList<Label>());

		labels.get(0).add( new Label("SHORTCODE","es_ES","Cuenta Interna"));
		labels.get(1).add( new Label("SHORTCODE","es_ES","Cuenta de Cliente"));
		labels.get(3).add( new Label("SHORTCODE","es_ES","Cliente Potencial"));
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