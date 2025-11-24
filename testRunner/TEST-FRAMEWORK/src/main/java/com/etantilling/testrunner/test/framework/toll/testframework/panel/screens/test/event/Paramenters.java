package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.zkweb.ParameterItem;

public class Paramenters {

	 public LinkedHashMap<String, ParameterItem> getParamenters() {
		return paramenters;
	}

	public void setParamenters(LinkedHashMap<String, ParameterItem> paramenters) {
		this.paramenters = paramenters;
	}

	LinkedHashMap<String, ParameterItem> paramenters = new LinkedHashMap<String, ParameterItem>(); 
	
}
