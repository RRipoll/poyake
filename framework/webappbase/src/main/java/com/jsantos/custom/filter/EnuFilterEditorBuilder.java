package com.jsantos.custom.filter;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;

import com.jsantos.common.model.SearchParameter.CompareType;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.custom.customfield.MTMultiEnumContainer;
import com.jsantos.factory.DTOFactory;
import com.jsantos.gui.zkcomponent.MTSelectbox;
import com.jsantos.orm.mt.MTTable;

public class EnuFilterEditorBuilder  extends FilterComponent implements IFilterComponent{

	IMTComponent comp;
	
	@Override
	public Component buildFilterComponent() {
		Div retValue=null; 
		

		MTTable foreignkey = getConfiguration().getMtField().getForeignKey();
		
		if (null!=getConfiguration().getCompareType()) {
			
			if (getConfiguration().getCompareType().equals(CompareType.MultiSelect)) {
				MTMultiEnumContainer enumFilter = new MTMultiEnumContainer();
				enumFilter.setMTField(getConfiguration().getMtField());
				retValue=(Div) enumFilter.initialize();
				enumFilter.setDetachedRecord(DTOFactory.get(getConfiguration().getMtField().getTable()));
				enumFilter.setLabel(getConfiguration().getMtField().getName());
				comp= enumFilter;

			}else if (getConfiguration().getCompareType().equals(CompareType.MultiCheck)) {
				;
			}else if (getConfiguration().getCompareType().equals(CompareType.Radio)) {
				;
			}
		}
		
			if(null==comp) {
				retValue= new Div();
				retValue.setSclass("form-group form-float");
				Div div2 = new Div();
				div2.setSclass("form-line");
				div2.setParent(retValue);
				comp = new MTSelectbox();
				comp.setMTField(getConfiguration().getMtField());
				((MTSelectbox)comp).buildObjectList(foreignkey,getInitialValues());
				((Component)comp).setParent(div2);
		}
		
		
			setEditorAtributes(((Component)comp),this);
		comp.setLabel(getDescription());
		
		return retValue;
	}

	@Override
	public ListValues<Object> getValues() {
		return new ListValues<Object>().addValue(comp.getValue());
	}

	
}
