package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.standardlistheader.StandardListHeader;

public class EventListHeader extends StandardListHeader{

	public EventListHeader(EventListener<Event> eventListener) {
		super(eventListener, "/zul/panel/test/event/event_list_header.zul");
		//panel.getFellow("BUTTON_DELETE").addEventListener(Events.ON_CLICK, eventListener);
	}
}
