package com.jsantos.custom.filter;

import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.util.ListValues;

public abstract class FilterComponent  implements IFilterComponent{
	
	ListValues<Object> initialValues= new ListValues<Object>();
	FilterConfiguration configuration;
	@Override
	public void setInitialValues(ListValues<Object> initialValues) {
		this.initialValues.addAllValues(initialValues);
	}
	
	@Override
	public void setConfiguration(FilterConfiguration conf) {
		this.configuration=conf;
	}
	
	@Override
	public ListValues<Object> getInitialValues() {
		return initialValues;
	}
	
	@Override
	public FilterConfiguration getConfiguration() {
		return configuration;
	}
}
