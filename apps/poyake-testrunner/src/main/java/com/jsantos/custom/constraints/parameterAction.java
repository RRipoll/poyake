package com.jsantos.custom.constraints;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Textbox;

import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.constraint.UIConstraints;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.custom.customfield.DefaultMTCustomFieldContainer;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTField;


public class parameterAction implements IConstraintsBuilder,UIConstraints	{

	@Override
	public <T> ListValues<IValidationError> validate(MTField mtField, Object value, MTMapValues<T> values) {
		
		if(null!=value) {
			
			String placeholder="";
			switch (value.toString()) {
			case "1":
				placeholder="aBc1$.";break;
			case "2":
				placeholder="1234567890";break;
			case "3":
				placeholder="true/false";break;
			case "4":
				placeholder="2015-03-25T12:00:00Z";break;
			case "5":
				placeholder="1234567.90";break;
			}
			
			DefaultMTCustomFieldContainer component=(DefaultMTCustomFieldContainer)values.get(MTtestRunnerData.TRPARAMETER.VALUE);
			Textbox textBox=(Textbox)component.getCustomComponent();
			Events.sendEvent(Events.ON_FOCUS,(Component)component.getCustomComponent(),null);
			(textBox).setPlaceholder(placeholder);
			(textBox).setTooltiptext(placeholder);
		}
        return null;
	}
	@Override
	public MTField forField() {
		return MTtestRunnerData.TRPARAMETER.TRPARAMETERTYPEID;
	}
}
