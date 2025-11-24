package com.jsantos.custom.filter;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

import com.jsantos.common.model.SearchParameter;
import com.jsantos.common.util.ListValues;
import com.jsantos.gui.objectselector.popup.ObjectSelectorPopup;
import com.jsantos.gui.zkcomponent.MTTextboxObjectDescription;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public class PKFilterEditorBuilder extends FilterComponent implements IFilterComponent{

	MTTextboxObjectDescription span;
	
	@Override
	public Component buildFilterComponent() {
		getConfiguration().setOperator(SearchParameter.Operator.IN);
		Div retValue = new Div();
		retValue.setSclass("form-group form-float");
		Div div2 = new Div();
		div2.setSclass("form-line");
		div2.setParent(retValue);

		span = new MTTextboxObjectDescription();
		span.setParent(div2);
		span.setLabel(getConfiguration().getMtField().getLabel());
		span.setMTField(getConfiguration().getMtField());
		span.addEventListener(Events.ON_CLICK, this::searchFolder);
		
		setEditorAtributes(span,this);
		span.setLabel(getDescription());
		return retValue;
	}
	void searchFolder(Event evt) {
		new ObjectSelectorPopup(getConfiguration().getMtField(),getConfiguration().getMtField().getForeignKey().getRealFKTOTable(), span).doModal();
	}
	
	@Override
	public ListValues<Object> getValues() {
		ListValues<Object> retValue= new ListValues<Object>();
		for (IDetachedRecord dr : span.getDrs()) {
			retValue.add(dr.getPk());
		}
		return retValue;
	}
	
}
