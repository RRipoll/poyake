package com.jsantos.metadata.payment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuPaymentTypeClass extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int CREDITCARD = 1;
	public static final int CASH = 2;
	public static final int DIRECTDEBIT = 3;
	public static final int CHECK = 4;

	static {
		values.put(1,"Credit Card");
		shortCodes.put("CREDITCARD",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"Cash");
		shortCodes.put("CASH",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"Direct Debit");
		shortCodes.put("DIRECTDEBIT",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"Check");
		shortCodes.put("CHECK",4);
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