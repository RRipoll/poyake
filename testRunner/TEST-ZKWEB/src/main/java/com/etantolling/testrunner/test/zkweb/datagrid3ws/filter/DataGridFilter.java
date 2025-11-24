package com.etantolling.testrunner.test.zkweb.datagrid3ws.filter;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.*;
import org.zkoss.zul.impl.NumberInputElement;

import java.util.Hashtable;


public abstract class DataGridFilter extends Div implements EventListener<Event> {
	private static final long serialVersionUID = -2670281044719897388L;
	public static String cssClass = null;

	protected Component filterDetails = null;
	//protected Component toolbar = null;
	protected Vbox theVbox = null;
	
	private boolean textboxChanged = false;
	Hashtable <String,Object> parameters;
	
	public abstract String buildWhereClause();
	public abstract void reset();

	@SuppressWarnings("static-access")
	public DataGridFilter(String cssClass) {
		this.cssClass = cssClass;
		this.setWidth("100%");
		theVbox = new Vbox();
		theVbox.setParent(this);
		theVbox.setZclass("filter");
		if (null != cssClass)
			this.setZclass(cssClass);
		theVbox.setWidth("100%");
	}

	

	protected Hbox createBaseToolBar(int buttons) {
		Groupbox groupbox = new Groupbox();
		Hbox hbox = new Hbox();
		hbox.setParent(groupbox);
		hbox.setAlign("center");

		return hbox;
	}

	public void onOK() throws Exception {
		if (textboxChanged) { // we don't want to query the database until the onBlur or onOK events
			textboxChanged = false;
			Events.postEvent(new Event("onFilterChanged", this, null));
		}
	}

	public void refresh() {
		Events.postEvent(new Event("onFilterChanged", this, null));
	}

	public void onEvent(Event event) throws Exception {
		if (Events.ON_CHANGE.equals(event.getName())) {
			if (event.getTarget() instanceof Textbox || event.getTarget() instanceof NumberInputElement)
				textboxChanged = true;
			// we don't want to query the database until the onBlur or onOK events
			else
				Events.postEvent(new Event("onFilterChanged", this, null));
		} else if (Events.ON_BLUR.equals(event.getName())) {
			if (textboxChanged) { // we don't want to query the database until the onBlur or onOK events
				textboxChanged = false;
				Events.postEvent(new Event("onFilterChanged", this, null));
			}
		} else if (Events.ON_SELECT.equals(event.getName())) {
			Events.postEvent(new Event("onFilterChanged", this, null));
		} else
			Events.postEvent(new Event("onFilterChanged", this, null));

	}

	public Component getFilterDetails() {
		return filterDetails;
	}

	public Hashtable<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Hashtable<String, Object> parameters) {
		this.parameters = parameters;
	}
}
