package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.TestDuplicator;

public class CopyEvents extends GenericForwardComposer implements EventListener {
	
	private static final Logger log = LoggerFactory.getLogger(CopyEvents.class);
	
	Component window = null;
	
	public void doAfterCompose(Component comp) throws Exception {
		this.window = comp;
		comp.getFellow("COPY").addEventListener(Events.ON_CLICK, this);
	}
	
	public void onEvent(Event event) throws Exception {
		Integer testId = Integer.parseInt(((Textbox)window.getFellow("TESTID")).getValue());
		String inputList = ((Textbox)window.getFellow("EVENT_LIST")).getValue();
		if (StringUtils.isEmpty(inputList))
			throw new RuntimeException("List is empty");
		String[] ids = inputList.split(",");
		Vector<Integer> events = new Vector<Integer>();
		for (String eventId:ids){
			events.add(Integer.parseInt(eventId));
		}
		LinkedHashMap<Integer, Integer> results = new LinkedHashMap<Integer,Integer>();
		try{
			for (Integer eventId:events){
				results.put(eventId, TestDuplicator.copyEvent(eventId, testId));
			}
		}
		catch (Exception e){
			log.error("ERROR STACKTRACE:",e);
			Messagebox.show(e.toString());
		}
		
		StringBuffer buff = new StringBuffer();
		for (Map.Entry<Integer,Integer> entry:results.entrySet())
			buff.append(entry.getKey() + " ->" + entry.getValue()).append("\r\n");
		
		((Textbox)window.getFellow("RESULTS")).setValue(buff.toString());
	}	
}
