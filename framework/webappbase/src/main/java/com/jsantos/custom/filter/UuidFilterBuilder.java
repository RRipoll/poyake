package com.jsantos.custom.filter;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.util.ListValues;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTDataType;

public class UuidFilterBuilder extends FilterComponent{

	IFilterComponent filtercomponent;
	
	@Override
	public MTDataType forModelType() {
		return MTDataTypes.UUID;
	}
	
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
		if (null != conf.getMtField().getForeignKey() && !conf.getMtField().isPrimaryKey()) 
				filtercomponent = new PKFilterEditorBuilder();
		else filtercomponent = new DefaultFilterEditorBuilder();
		filtercomponent.setConfiguration(conf);
	}

	@Override
	public ListValues<Object> getInitialValues() {
		return filtercomponent.getInitialValues();
	}
	
}
