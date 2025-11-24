package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.eventdefinition;

import java.sql.SQLException;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.MTListScreenControler;

public class EventDefinitionControler 	extends MTListScreenControler{
	
	private static final long serialVersionUID = -5882815688800094692L;

	public EventDefinitionControler() throws SQLException{
		super(MT.EVENTDEFINITION,false,null);
	}
	
}
