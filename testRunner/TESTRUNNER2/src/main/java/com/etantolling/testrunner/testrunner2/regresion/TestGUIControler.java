package com.etantolling.testrunner.testrunner2.regresion;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;


public class TestGUIControler extends GenericForwardComposer implements EventListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Component comp;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		this.comp=comp;
		
		//CliContextInitializer.initialize();
		comp.getFellow("see").addEventListener(Events.ON_CLICK, this);
		comp.getFellow("create").addEventListener(Events.ON_CLICK, this);

		new CreationControler(comp);
		
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		if(event.getTarget().equals(comp.getFellow("see"))){
			new HistoryControler(comp);
		
		}else if(event.getTarget().equals(comp.getFellow("create"))){
			new CreationControler(comp);
		
		} 
	}
	
}