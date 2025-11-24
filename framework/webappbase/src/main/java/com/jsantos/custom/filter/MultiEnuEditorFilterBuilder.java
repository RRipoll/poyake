package com.jsantos.custom.filter;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;

import com.jsantos.common.model.SearchParameter;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.customfield.MTMultiEnumContainer;
import com.jsantos.factory.DTOFactory;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTDataType;

public class MultiEnuEditorFilterBuilder  extends FilterComponent implements IFilterComponent{

	MTMultiEnumContainer enu;
	
	@Override
	public Component buildFilterComponent() {
		getConfiguration().setOperator(SearchParameter.Operator.IN);
		Div retValue = new Div();
		retValue.setSclass("form-group form-float");
		Div div2 = new Div();
		div2.setSclass("form-line");
		div2.setParent(retValue);

		enu= new MTMultiEnumContainer();
		enu.setMTField(getConfiguration().getMtField());
		enu.initialize().setParent(div2);
		
		enu.setDetachedRecord(DTOFactory.get(getConfiguration().getMtField().getTable()));
		setEditorAtributes(enu,this);
		
		enu.setLabel(getDescription());
		return retValue;
	}

	@Override
	public ListValues<Object> getValues() {
		return (ListValues<Object>) enu.getValue();
	}

	@Override
	public MTDataType forModelType() {
		
		return MTDataTypes.MULTIPLEENUM;
	}
	
}

