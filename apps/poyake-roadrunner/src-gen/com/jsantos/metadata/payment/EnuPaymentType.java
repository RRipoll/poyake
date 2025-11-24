package com.jsantos.metadata.payment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuPaymentType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int VISA = 1;
	public static final int MCARD = 2;
	public static final int AMEX = 3;
	public static final int DISC = 4;
	public static final int CASH = 5;
	public static final int DIRECTDEBIT = 6;
	public static final int CHECK = 7;

	static {
		values.put(1,"Visa");
		shortCodes.put("VISA",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"MasterCard");
		shortCodes.put("MCARD",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"American Express");
		shortCodes.put("AMEX",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"Discovery");
		shortCodes.put("DISC",4);
		labels.put(4, new ArrayList<Label>());
		values.put(5,"Cash");
		shortCodes.put("CASH",5);
		labels.put(5, new ArrayList<Label>());
		values.put(6,"Direct Debit");
		shortCodes.put("DIRECTDEBIT",6);
		labels.put(6, new ArrayList<Label>());
		values.put(7,"Check");
		shortCodes.put("CHECK",7);
		labels.put(7, new ArrayList<Label>());
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