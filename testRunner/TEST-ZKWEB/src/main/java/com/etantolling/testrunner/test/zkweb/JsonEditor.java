package com.etantolling.testrunner.test.zkweb;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Window;

public class JsonEditor  implements EventListener{
	protected Window panel;
	
	public JsonEditor(){
		  panel=(Window) Executions.createComponents("/zul/panel/jsoneditor.zul", panel, null);
	}

	@Override
	public void onEvent(Event event) throws Exception {
	}

	public Window getPanel() {
		return panel;
	}

	
}