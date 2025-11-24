package com.etantolling.testrunner.testrunner2.testrunnergui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class TestLogWindowController {
	Window view = new Window();
	Textbox textbox = new Textbox();
	
	public TestLogWindowController(Component parent){
		view.setParent(parent);
		view.setTitle("Test output log");
		view.setWidth("80%");
		view.setHeight("90%");
		view.setClosable(true);
		textbox.setParent(view);
		textbox.setMultiline(true);
		textbox.setWidth("100%");
		textbox.setHeight("100%");
		
	}
	
	public void setTitle(String title) {
		view.setTitle(title);
	}
	
	public void doModal(){
		view.doModal();
	}
	
}
