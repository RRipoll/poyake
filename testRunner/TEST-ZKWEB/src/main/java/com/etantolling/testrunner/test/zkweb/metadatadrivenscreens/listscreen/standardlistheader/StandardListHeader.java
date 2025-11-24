package com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.standardlistheader;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

public class StandardListHeader{
	protected Component panel;
	protected EventListener<Event> eventListener;
	
	
	
	public StandardListHeader(EventListener<Event> eventListener, String zul){
		if (null == zul)
			panel = Executions.createComponents("/common/zul/standardlistscreen/standardlistheader/standard_list_header.zul", null, null);
		else
			panel = Executions.createComponents(zul, null, null);
	
		this.eventListener=eventListener;
		
		init();
	}
	
	public StandardListHeader(EventListener<Event> eventListener, Component panel){

		this.panel=panel;
		this.eventListener=eventListener;

		init();
	}

	
	public void init(){
		
		if (null !=panel.getFellowIfAny("BUTTON_CREATE")) 
			panel.getFellow("BUTTON_CREATE").addEventListener(Events.ON_CLICK, eventListener);
		if (null !=panel.getFellowIfAny("BUTTON_DELETE")) 
			panel.getFellow("BUTTON_DELETE").addEventListener(Events.ON_CLICK, eventListener);
		if (null !=panel.getFellowIfAny("BUTTON_COPY")) 
			panel.getFellow("BUTTON_COPY").addEventListener(Events.ON_CLICK, eventListener);
		if (null !=panel.getFellowIfAny("BUTTON_SWITCH")) 
			panel.getFellow("BUTTON_SWITCH").addEventListener(Events.ON_CLICK, eventListener);
		
	}
	
	
	public Component getComponent(){
		return panel;
	}

}
