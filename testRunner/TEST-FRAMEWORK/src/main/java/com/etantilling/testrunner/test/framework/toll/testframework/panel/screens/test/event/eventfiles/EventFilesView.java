package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event.eventfiles;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;

public class EventFilesView {
	public Div div;
	Button uploadButton;
	Div newFileListDiv;
	Div existingFileListDiv;
	
	public EventFilesView(){
		div = (Div) Executions.createComponents("/zul/panel/test/event/eventfiles/eventfiles.zul",null, null); 	
		uploadButton = (Button)div.getFellow("ADD_FILE_BUTTON");
		newFileListDiv = (Div)div.getFellow("EVENT_NEW_FILE_LIST");
		existingFileListDiv = (Div)div.getFellow("EVENT_EXISTING_FILE_LIST");
	}
}
