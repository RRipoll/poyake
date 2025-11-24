package com.etantolling.testrunner.test.zkweb.datagrid3.filter;

import java.util.Hashtable;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Html;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.impl.NumberInputElement;

import com.etantolling.testrunner.test.zkweb.datagrid3.PagingGoogle;


public abstract class DataGridFilter extends Div implements EventListener {
	private static final long serialVersionUID = -2670281044719897388L;
	public static String cssClass = null;
	public static final int NO_BUTTON = 0;
	public static final int BUTTON_FILTER = 1;
	public static final int BUTTON_NEW = 2;
	public static final int BUTTON_APPLY = 4;

	public Html countDisplay;
	public Paging pag = null;
	public Component buttonApply = null;
	public Button buttonNew = null;
	
	public PagingGoogle pagingGoogle;
	
	protected Button buttonClose = null;
	
	protected Component filterDetails = null;
	protected Component toolbar = null;
	protected Vbox theVbox = null;
	
	//private Button buttonToggleDetails = null;
	private boolean textboxChanged = false;
	
	Hashtable <String,Object> parameters;
	
	public Hashtable<String, Object> getParameters() {
		if (null != parameters) {
			return parameters;
		} else {
			return new Hashtable<String, Object>();
		}
	}

	public void setParameters(Hashtable<String, Object> parameters) {
		this.parameters = parameters;
	}
	
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

	@SuppressWarnings("static-access")
	public DataGridFilter(int buttons, String cssClass, boolean pagingVisible, PagingGoogle pagingGoogle) {
		this.pagingGoogle = pagingGoogle;
		this.cssClass = cssClass;
		this.setWidth("100%");
		theVbox = new Vbox();
		theVbox.setParent(this);
		theVbox.setZclass("filter");
		if (null != cssClass)
			this.setZclass(cssClass);
		theVbox.setWidth("100%");
		toolbar = createBaseToolBar(buttons);
		toolbar.setParent(theVbox);
		toolbar.setVisible(pagingVisible);
	}

	@SuppressWarnings("static-access")
	public DataGridFilter(int buttons, String cssClass, boolean pagingVisible) {
		this.cssClass = cssClass;
		this.setWidth("100%");
		theVbox = new Vbox();
		theVbox.setParent(this);
		theVbox.setZclass("filter");
		if (null != cssClass)
			this.setZclass(cssClass);
		theVbox.setWidth("100%");
		toolbar = createBaseToolBar(buttons);
		toolbar.setParent(theVbox);
		toolbar.setVisible(pagingVisible);
	}

	@SuppressWarnings("static-access")
	public DataGridFilter(int buttons, String cssClass, boolean pagingVisible, Div googlePaging) {
		this.cssClass = cssClass;
		this.setWidth("100%");
		theVbox = new Vbox();
		theVbox.setParent(this);
		theVbox.setZclass("filter");
		if (null != cssClass)
			this.setZclass(cssClass);
		theVbox.setWidth("100%");
		toolbar = createBaseToolBar(buttons);
		toolbar.setParent(theVbox);
		toolbar.setVisible(pagingVisible);
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

}
