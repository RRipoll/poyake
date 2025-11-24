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

public class CheckParameterAction implements IConstraintsBuilder,UIConstraints	{

	@Override
	public <T> ListValues<IValidationError> validate(MTField mtField, Object value, MTMapValues<T> values) {
		
		if(null!=value) {
			
			String placeholder="";
			String operator=MTtestRunnerData.OPERATOR.getEnumeration().getShortCode((Integer) value);
			
			switch (operator) {
				case "EQUAL":
				case "NOT_EQUAL":
				case "LT":
				case "LE":
				case "GE":
				case "GT":
					placeholder="1234567.90";break;
				case "IN":
				case "NOT_IN":
					placeholder="a,b,c,d.....";break;
				case "BETWEEN":
					placeholder="a,b";break;
				case "LIKE":
				case "ILIKE":
					placeholder="*abcde";break;
				case "_NULL":
				case "NOT_NULL":
					break;
			}
			
			DefaultMTCustomFieldContainer component=(DefaultMTCustomFieldContainer)values.get(MTtestRunnerData.CHECKPARAMETERITEM.CHECKVALUE);
			Textbox textBox=(Textbox)component.getCustomComponent();
			DefaultMTCustomFieldContainer type=(DefaultMTCustomFieldContainer)values.get(MTtestRunnerData.CHECKPARAMETERITEM.CHECKVALUETYPEID);
			
			if(operator.equals("_NULL") || operator.equals("NOT_NULL")) {
				textBox.setVisible(false);
				type.setVisible(false);

			}else {
				type.setVisible(true);
				textBox.setVisible(true);
				Events.sendEvent(Events.ON_FOCUS,(Component)component.getCustomComponent(),null);
				(textBox).setPlaceholder(placeholder);
				(textBox).setTooltiptext(placeholder);
			}
			
		}
        return null;
	}
	@Override
	public MTField forField() {
		return MTtestRunnerData.CHECKPARAMETERITEM.OPERATOR;
	}
}
