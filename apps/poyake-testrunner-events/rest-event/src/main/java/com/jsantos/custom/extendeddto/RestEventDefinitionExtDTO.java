package com.jsantos.custom.extendeddto;

import com.jsantos.metadata.testrunner.MTTableRESTEVENTDEFINITION;
import com.jsantos.metadata.testrunner.RestEventDefinitionDTO;

public class RestEventDefinitionExtDTO extends RestEventDefinitionDTO{
	
	@Override
	public void update() {
		System.out.println();;
	}

	@Override
	public RestEventDefinitionExtDTO insert() {
		return this;
	}

	@Override
	public void insertOrUpdate() {
		System.out.println();;;
	}
	
	public java.lang.Integer getSelected(){ 
		Object value=get(MTTableRESTEVENTDEFINITION.SELECTED);
		if(null==value)return null;
		if(value instanceof Boolean)
			return (boolean) value?1:0;
		return (java.lang.Integer) get(MTTableRESTEVENTDEFINITION.SELECTED);
	}
}
