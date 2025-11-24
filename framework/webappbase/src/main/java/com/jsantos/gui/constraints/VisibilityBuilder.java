package com.jsantos.gui.constraints;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTField;

public class VisibilityBuilder implements IConstraintsBuilder{

	
	ListValues<Component> objetives;
	ListValues<Object> matchesValues;
	
	
	public VisibilityBuilder() {
		super();
	}
	
	public VisibilityBuilder( ListValues<Component> objetives, ListValues<Object> listValues) {
		super();
		this.objetives = objetives;
		this.matchesValues = listValues;
		
	}

	@Override
	public <T> ListValues<IValidationError> validate(MTField mtField, Object value, MTMapValues<T> values) {
		
		if(objetives.isEmpty())return null;
		//if(matchesValues.isEmpty())return null;
		for (Object matchesValue : matchesValues) {
			String checkValue="NULL";
			if(null!=matchesValue)
				checkValue=matchesValue.toString();
			
			if(checkValue.equals("NULL")) {
				if(null!=value) 
					objetives.stream().forEach(p -> p.setVisible(false));
				else 
					objetives.stream().forEach(p -> p.setVisible(true));
			}	
			
			else if(checkValue.equals("NOTNULL") || checkValue.equals("NOT NULL")) {
				if(null!=value && !value.toString().isEmpty()) 
					objetives.stream().forEach(p -> p.setVisible(true));
				else 
					objetives.stream().forEach(p -> p.setVisible(false));
			}	
			
			else if(!matchesValues.contains(value))
					objetives.stream().forEach(p -> p.setVisible(false));
				else 
					objetives.stream().forEach(p -> p.setVisible(true));
		}
		return null;
	}
}
