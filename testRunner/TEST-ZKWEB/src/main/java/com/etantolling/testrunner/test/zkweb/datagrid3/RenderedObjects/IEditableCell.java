package com.etantolling.testrunner.test.zkweb.datagrid3.RenderedObjects;


import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.impl.InputElement;


public interface IEditableCell {

	public InputElement getEditor();
	
	public default void addEventListener(EventListener eventListener){
		getEditor().addEventListener(Events.ON_CHANGE,  eventListener);
		getEditor().addEventListener(Events.ON_OK,  eventListener);
	};
	
	public default void setValue(Object value){
		getEditor().setRawValue(value);
	}
	
	public default Object getValue(){
		return getEditor().getRawValue();
	}
}
