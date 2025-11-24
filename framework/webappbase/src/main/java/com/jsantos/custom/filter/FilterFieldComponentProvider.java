package com.jsantos.custom.filter;

import java.util.LinkedHashMap;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.util.ListValues;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class FilterFieldComponentProvider {
	static final LinkedHashMap<String, IFilterComponent> byMTField = new LinkedHashMap<>();
	static final LinkedHashMap<String, IFilterComponent> byModelDataType = new LinkedHashMap<>();
	
	public static IFilterComponent getFilterComponent(FilterConfiguration conf, ListValues<Object> values){
		try {
			IFilterComponent compRenderer=null;
			MTField mTField=conf.getMtField();
			if (null != byMTField.get(mTField.getFullyQualifiedName())) {
				compRenderer=byMTField.get(mTField.getFullyQualifiedName()).getClass().newInstance();
			}else if (null != byModelDataType.get(mTField.getDataType().getName())) {
				compRenderer=byModelDataType.get(mTField.getDataType().getName()).getClass().newInstance();
			}else {
				compRenderer= new DefaultFilterComponentBuilder().getClass().newInstance();
			}
			compRenderer.setConfiguration(conf);
			compRenderer.setInitialValues(values);
			return compRenderer;
		}
		catch (InstantiationException| IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static Component buildAndInitializeFilterComponent(FilterConfiguration conf, ListValues<Object> values
			){
			IFilterComponent compRenderer=getFilterComponent(conf,values);
			return compRenderer.buildFilterComponent();
		}
	
	

	public static void logBindings() {
		for (String modelDataType:byModelDataType.keySet())
			System.out.println("Filter Component Provider: " + modelDataType + " -> " + byModelDataType.get(modelDataType).getClass().getSimpleName());
		for (String field:byMTField.keySet())
			System.out.println("Filter Component Provider: " + field + " -> " + byMTField.get(field).getClass().getSimpleName());
	}

	public static void putBymtfield(MTField field, IFilterComponent fieldComponent) {
		byMTField.put(field.getFullyQualifiedName(), fieldComponent);
		
	}

	public static void putByModelDataType(MTDataType forModelType, IFilterComponent fieldComponent) {
		byModelDataType.put(forModelType.getName(), fieldComponent);
		
	}
}
