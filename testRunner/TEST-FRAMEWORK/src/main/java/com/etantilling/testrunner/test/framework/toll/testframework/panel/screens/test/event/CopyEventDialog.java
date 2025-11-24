package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.TestDuplicator;

public class CopyEventDialog extends Window implements EventListener{
	Integer eventId;
	Intbox testIdTextbox = new Intbox();
	Button buttonOk = new Button("Ok");
	
	public CopyEventDialog(Integer eventId){
		this.eventId = eventId;
		Vbox vbox = new Vbox();
		new Label("Please enter the Test Id of the Test where the event will be copied").setParent(vbox);
		vbox.setParent(this);
		testIdTextbox.setParent(vbox);
		buttonOk.setParent(vbox);
		buttonOk.addEventListener(Events.ON_CLICK, this);
		this.setClosable(true);
		this.setTitle("Copy event to another test");
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if (buttonOk == event.getTarget()){
			if (null != testIdTextbox.getValue()){
				TestDuplicator.copyEvent(eventId, testIdTextbox.getValue());
				this.detach();
			}
		}
	}
}
