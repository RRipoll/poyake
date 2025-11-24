package com.jsantos.metadata.acc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuAnnotationType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int NEWDEBIT = 1;
	public static final int NEWCREDIT = 2;
	public static final int DEBITCANCEL = 3;
	public static final int CREDITCANCEL = 4;
	public static final int DEBITADJUST = 5;
	public static final int CREDITADJUST = 6;
	public static final int DEBITREALLOC = 7;
	public static final int CREDITREALLOC = 8;
	public static final int DEBITTYPECHANGE = 9;

	static {
		values.put(1,"New Debit");
		shortCodes.put("NEWDEBIT",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"New Credit");
		shortCodes.put("NEWCREDIT",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"Debit Cancellation");
		shortCodes.put("DEBITCANCEL",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"Credit Cancellation");
		shortCodes.put("CREDITCANCEL",4);
		labels.put(4, new ArrayList<Label>());
		values.put(5,"Debit Adjustment");
		shortCodes.put("DEBITADJUST",5);
		labels.put(5, new ArrayList<Label>());
		values.put(6,"Credit Adjustment");
		shortCodes.put("CREDITADJUST",6);
		labels.put(6, new ArrayList<Label>());
		values.put(7,"Debit Reallocation");
		shortCodes.put("DEBITREALLOC",7);
		labels.put(7, new ArrayList<Label>());
		values.put(8,"Credit Reallocation");
		shortCodes.put("CREDITREALLOC",8);
		labels.put(8, new ArrayList<Label>());
		values.put(9,"Debit Reclassification");
		shortCodes.put("DEBITTYPECHANGE",9);
		labels.put(9, new ArrayList<Label>());
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