package com.jsantos.custom.filter;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.util.ListValues;
import com.jsantos.custom.customfield.IMTComponent;

public class DefaultFilterEditorBuilder  extends FilterComponent implements IFilterComponent{

	IMTComponent comp;
	@Override
	public Component buildFilterComponent() {
		
		FilterEditor editor= new FilterEditor();
		comp = editor.geteditor(getConfiguration(), getDescription(),!getInitialValues().isEmpty()?getInitialValues().get(0):null);
		setEditorAtributes(comp,this);
		return editor;
	}

	@Override
	public ListValues<Object> getValues() {
		return new ListValues<Object>().addValue(comp.getValue());
	}
}
