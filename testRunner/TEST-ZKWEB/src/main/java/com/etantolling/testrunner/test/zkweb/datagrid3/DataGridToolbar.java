package com.etantolling.testrunner.test.zkweb.datagrid3;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Hbox;

@SuppressWarnings("serial")
public class DataGridToolbar extends Hbox{
	public static final int NO_BUTTON = 0;
	public static final int BUTTON_FILTER = 1;
	public static final int BUTTON_NEW = 2;
	public static final int BUTTON_APPLY = 4;

	
	private Button buttonToggleDetails = null;
	private Component buttonApply = null;
	private Button buttonNew = null;

	public DataGridToolbar(int buttons, EventListener<Event> eventListener) {
		buildButtons(buttons, eventListener);
	}
	
	void buildButtons(int buttons, EventListener<Event> eventListener){
		if (0 < (buttons & BUTTON_NEW)) {
			buttonNew = new Button();
			buttonNew.setImage("/common/img/dfToolbar/new.gif");
			buttonNew.setParent(this);
			buttonNew.setTooltiptext("New");
			buttonNew.addEventListener(Events.ON_CLICK, eventListener);
		}
		if (0 < (buttons & BUTTON_FILTER)) {
			buttonToggleDetails = new Button();
			buttonToggleDetails.setImage("/common/img/dfToolbar/find.gif");
			buttonToggleDetails.setParent(this);
			buttonToggleDetails.setTooltiptext("New");
			buttonToggleDetails.addEventListener(Events.ON_CLICK, eventListener);
			buttonToggleDetails.setTooltiptext("Filter");
		}
		if (0 < (buttons & BUTTON_APPLY)) {
			buttonApply = new Button();
			((Button) buttonApply).setImage("/common/img/dfToolbar/select.gif");
			buttonApply.setParent(this);
		}
	}
}
