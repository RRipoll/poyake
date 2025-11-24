package com.etantolling.testrunner.test.core.utils;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

import com.etantolling.testrunner.test.core.metadata.MTEnumeration;
import com.etantolling.testrunner.test.core.metadata.MTField;

public class MultiEnumHelper {

	public static String getCommaSeparatedDescriptionForValue(MTField mtField, int valueToMap) throws SQLException{
		String retValue = "";
		for (Integer key:mtField.getTableNameOfEnumerationValues().getEnumeration().getKeys()){
			if (0< ((int)Math.pow(2, ((Integer)key)-1) & valueToMap)){
				if (!StringUtils.isEmpty(retValue)) retValue += ",";
				retValue += mtField.getTableNameOfEnumerationValues().getEnumeration().getValue(key);
			}
		}
		return retValue;
	}
	
	public static String getCommaSeparatedDescriptionForValue(MTEnumeration mtEnu, int valueToMap) throws SQLException{
		String retValue = "";
		for (Integer key:mtEnu.getKeys()){
			if (0< ((int)Math.pow(2, ((Integer)key)-1) & valueToMap)){
				if (!StringUtils.isEmpty(retValue)) retValue += ",";
				retValue += mtEnu.getValue(key);
			}
		}
		return retValue;
	}
	
	
}
