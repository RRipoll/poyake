package com.jsantos.common.i18n;

import java.util.Locale;

import com.jsantos.orm.label.LabelSelector;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class MTLabels {

	public static String getLabel(MTField mtField, Locale locale){
		
		return LabelSelector.inst().getLabel(locale, mtField);
	}
	
	public static String getLabel(MTTable mtTable, Locale locale) {
		return LabelSelector.inst().getLabel(locale, null, mtTable);
	}
	
	public static String getLabel(MTEnumeration enu, Integer value, Locale locale) {
		return LabelSelector.inst().getLabel(enu, locale, value);
	}
		

}
