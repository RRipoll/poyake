package com.jsantos.custom.filter;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.model.SearchParameter.CompareType;
import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.util.ListValues;

public class DefaultFilterComponentBuilder   extends FilterComponent implements IFilterComponent{

	FilterComponent filtercomponent;
	
	@Override
	public Component buildFilterComponent() {
		return filtercomponent.buildFilterComponent();
	}

	@Override
	public void setInitialValues(ListValues<Object> initialValues) {
		filtercomponent.setInitialValues(initialValues);
	}

	

	@Override
	public ListValues<Object> getValues() {
		
		return filtercomponent.getValues();
	}

	@Override
	public FilterConfiguration getConfiguration() {
		
		return filtercomponent.getConfiguration();
	}

	@Override
	public void setConfiguration(FilterConfiguration conf) {
		
		if(CompareType.Range.equals(conf.getCompareType()))
		     filtercomponent= new RangeFilterEditorBuilder();
		else 
			filtercomponent= new DefaultFilterEditorBuilder();
	
		filtercomponent.setConfiguration(conf);
	}

	@Override
	public ListValues<Object> getInitialValues() {
	
		return filtercomponent.getInitialValues();
	}
}