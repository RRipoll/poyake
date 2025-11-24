package com.jsantos.gui.filteredgrid;



import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Window;
/**
 * @author raul ripoll
 */
public class JsonEditor  {
	protected Window panel;
	
	public JsonEditor(){
		  panel=(Window) Executions.createComponents("~./common/zul/jsoneditor.zul", panel, null);
		 panel.getFellow("JSONEDITOR_CANCEL_BUTTON").addEventListener(Events.ON_CLICK, this::cancel);
	}

	void cancel(Event event) {
		panel.detach();
	}

	public Window getPanel() {
		return panel;
	}
	
	public Component getHeaderDiv() {
		
		return panel.getFellow("HEADER_DIV");
	}
}