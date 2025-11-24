package com.jsantos.custom.filter;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;

import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.gui.zkcomponent.MTCheckBox;
import com.jsantos.gui.zkcomponent.MTDatebox;
import com.jsantos.gui.zkcomponent.MTDecimalbox;
import com.jsantos.gui.zkcomponent.MTIntbox;
import com.jsantos.gui.zkcomponent.MTTextbox;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTDataType;

public class FilterEditor extends Div{
	
	private static final long serialVersionUID = -1710270721065491065L;

	public IMTComponent geteditor(FilterConfiguration conf,String description, Object value) {

		this.setSclass("form-group form-float");
		Div div2 = new Div();
		div2.setSclass("form-line");
		div2.setParent(this);

		MTDataType type=conf.getMtField().getDataType();
		IMTComponent comp=null;
		
		if(type.equals(MTDataTypes.DATE)) comp = new MTDatebox();
		else if(type.equals(MTDataTypes.DATETIME)) comp = new MTDatebox();
		else if(type.equals(MTDataTypes.DATETIME2)) comp = new MTDatebox();
		else if(type.equals(MTDataTypes.DECIMAL)) comp = new MTDecimalbox();
		else if(type.equals(MTDataTypes.MONEY)) comp = new MTDecimalbox();
		else if(type.equals(MTDataTypes.BIGINT)) comp = new MTIntbox();
		else if(type.equals(MTDataTypes.INT)) comp = new MTIntbox();
		else if(type.equals(MTDataTypes.FLOAT)) comp = new MTDecimalbox();
		else if(type.equals(MTDataTypes.BIT)) comp = new MTCheckBox();
		else if(type.equals(MTDataTypes.BOOLEAN)) comp = new MTCheckBox();
		else if(type.equals(MTDataTypes.PASSWORD)) comp = new MTTextbox();	
		else comp = new MTTextbox();	
		
		if (null != value)
			comp.setValue(value);
		((Component) comp).setParent(div2);
		
		comp.setLabel(description);
		
		return comp;
	}
	
	
	
}
