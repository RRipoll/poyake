package com.jsantos.metadata.acc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuLedgerType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int DEBIT = 1;
	public static final int CREDIT = 2;
	public static final int DC = 3;
	public static final int CC = 4;
	public static final int DR = 5;
	public static final int CR = 6;

	static {
		values.put(1,"Debit");
		shortCodes.put("DEBIT",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"Credit");
		shortCodes.put("CREDIT",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"Debit Cancellation");
		shortCodes.put("DC",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"Credit Cancellation");
		shortCodes.put("CC",4);
		labels.put(4, new ArrayList<Label>());
		values.put(5,"Debit Repost");
		shortCodes.put("DR",5);
		labels.put(5, new ArrayList<Label>());
		values.put(6,"Credit Repost");
		shortCodes.put("CR",6);
		labels.put(6, new ArrayList<Label>());
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