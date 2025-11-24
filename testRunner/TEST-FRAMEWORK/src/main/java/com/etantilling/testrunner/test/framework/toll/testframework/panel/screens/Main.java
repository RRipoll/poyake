package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.ClientInfoEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.TestControler;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;


@SuppressWarnings("rawtypes")
public class Main extends GenericForwardComposer implements EventListener {

	private static final long serialVersionUID = 1L;

	public Component comp;

	public Component content;
	public Component filterContent;
	
	public Component tests;
	public Component eventdefinitions;
	public Component events;
	public Component files;
	public Component headeruser;
	public Label headerselection;
	public Component selectedView;
	Intbox headerBugId;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		DesktopHelper.setAttribute("BackOffice", this);
		Executions.getCurrent().getDesktop().setAttribute("INPUT_SOURCE_CODE", 0);
		this.comp=comp;
		
		content = comp.getFellow("content");
		filterContent = comp.getFellow("filterContent");
		
		selectedView = tests;
		comp.addEventListener(Events.ON_CLIENT_INFO, this);
		reload();
	}


	public void reload() throws WrongValueException, Exception {

		Executions.getCurrent().getDesktop().setAttribute("INPUT_SOURCE_CODE", 0);


				content.getChildren().clear();
				TestControler testControler = new TestControler(comp);
				testControler.setFilterComponent(filterContent);
				testControler.setContent(content);
				testControler.layout();
				testControler.getView().setParent(content);
			    //testControler.window=comp;
	}

	public void onEvent(Event event) throws Exception {
		if(Events.ON_CLIENT_INFO.equals(event.getName())){
			
			 int height = ((ClientInfoEvent) event).getDesktopHeight();
	         int width = ((ClientInfoEvent) event).getDesktopWidth();
			
			DesktopHelper.setAttribute("ClientHeight", height);
			DesktopHelper.setAttribute("ClientWidth", width);
		}
		else {selectedView = event.getTarget();
			reload();
	}}

	public void setHeaderSelection(String value) {

		headerselection.setValue(value);

	}

}
