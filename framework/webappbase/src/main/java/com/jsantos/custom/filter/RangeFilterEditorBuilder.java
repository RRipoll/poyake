package com.jsantos.custom.filter;


import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;

import com.jsantos.common.model.SearchParameter;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.gui.zkutil.Zklabel;


public class RangeFilterEditorBuilder extends FilterComponent implements IFilterComponent{
	Div retValue;
	IMTComponent fromComp;
	IMTComponent toComp;

	@Override
	public Component buildFilterComponent() {
		retValue = new Div();

		getConfiguration().setOperator(SearchParameter.Operator.BETWEEN);

		Object value0=!getInitialValues().isEmpty() ? getInitialValues().get(0) : null;
		FilterEditor editor= new FilterEditor();
		fromComp = editor.geteditor(
						getConfiguration(),
						getDescription() + " " + Zklabel.getLabel("from") + ":",
				        value0);
		editor.setParent(retValue);
		Object value1=!getInitialValues().isEmpty()?(null != getInitialValues().get(1)?getInitialValues().get(1):null):null;
		editor= new FilterEditor();
		toComp = editor.geteditor(
						getConfiguration(),
						getDescription() + " " + Zklabel.getLabel("to") + ":",
						value1);
		editor.setParent(retValue);
		setEditorAtributes(retValue,this);
		return retValue;
	}
	
	@Override
	public ListValues<Object> getValues() {
		return new ListValues<Object>().addValue(fromComp.getValue()).addValue(toComp.getValue());
	}
}
