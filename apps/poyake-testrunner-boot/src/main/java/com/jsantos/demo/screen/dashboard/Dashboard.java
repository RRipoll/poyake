package com.jsantos.demo.screen.dashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;

/**
 * @author javier santos
 * @author raul ripoll
 */

public class Dashboard {

	public void buildScreen(Component comp){
		try {
			comp.getChildren().clear();		
			Component dashboardComponent = Executions.createComponents("~./screen/dashboard/dashboard.zul", comp, null);
			}
		catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	

	

}
