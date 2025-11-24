package com.etantolling.testrunner.test.zkweb.datagrid3.filter.items;

import java.util.Hashtable;

public interface IFilter {
	public String buildWhereClause(String componentId,Hashtable <String,Object> parameters);
	public void setSelectedValue(Object selectedValue);
	
	
}
