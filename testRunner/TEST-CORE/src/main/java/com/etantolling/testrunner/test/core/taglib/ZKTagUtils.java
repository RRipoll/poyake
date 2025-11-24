package com.etantolling.testrunner.test.core.taglib;

import org.apache.commons.lang3.StringUtils;

public class ZKTagUtils {

	public static String formatMonthAndYear(String monthYear){
		String monthYearFormatted = null;
		if(!StringUtils.isBlank(monthYear)){
			monthYearFormatted = monthYear.substring(0,2) + "/" + monthYear.substring(2,4);
		}
		return monthYearFormatted;
	}
	
}
