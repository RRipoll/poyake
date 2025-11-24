package com.etantolling.testrunner.test.zkweb;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;


public interface IPanel {

	
	static final Logger log = LoggerFactory.getLogger(IPanel.class);
	public Component getPanel();
	public void layout() throws SQLException;
	public void setId(Object Id);
	
	public default void attachZulAndController() throws SQLException{
		getPanel().setAttribute("controller", this);
	}

	public default void refresh() throws SQLException {
		layout();
	}

	
}
