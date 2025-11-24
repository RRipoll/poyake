package com.jsantos.custom.customfield;

import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.Component;

import com.jsantos.common.util.ListValues;
import com.jsantos.gui.zkcomponent.MTCustomFieldContainer;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public class TrParameterItem {

	IDetachedRecord dr;
	MTCustomFieldContainer container;
	
    ListValues<MTCustomFieldContainer> customFieldList= new ListValues<>();
    
	public IDetachedRecord getDr() {
		for (MTCustomFieldContainer entry : customFieldList) {
			dr.set(entry.getMTField(), entry.getValue());
		}
		return dr;
	}

	public void setDr(IDetachedRecord dr) {
		this.dr = dr;
	}
	
	public Component init(){
		Div parent= new Div();
		
		parent.setSclass("row");
		for (MTField mTField : dr.getFields()) {
			Div div= new Div();
			div.setParent(parent);
			div.setSclass("col");
			container= new MTCustomFieldContainer();
			container.setParent(div);
			container.setMTField(mTField);
			container.setDetachedRecord(dr);
			container.initialize();
			customFieldList.add(container);
		}
		return parent;
	}
	
	public void setReadonly(boolean readOnly) {
		for (MTCustomFieldContainer customField : customFieldList) {
			customField.setReadonly(readOnly);
		}
	}
}
