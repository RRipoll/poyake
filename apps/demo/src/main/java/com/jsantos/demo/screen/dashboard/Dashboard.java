package com.jsantos.demo.screen.dashboard;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Label;

import com.jsantos.metadata.MT;
import com.jsantos.orm.dbstatement.DetachedQueryResult;

public class Dashboard {

	public void buildScreen(Component comp){
		try {
			comp.getChildren().clear();		
			Component dashboardComponent = Executions.createComponents("/screen/dashboard/dashboard.zul", comp, null);
			((Label)dashboardComponent.getFellowIfAny("NUMBER_OF_ACCOUNTS")).setValue(findNumberOfAccounts());
			((Label)dashboardComponent.getFellowIfAny("NUMBER_OF_CASES")).setValue(findNumberOfCases());
			((Label)dashboardComponent.getFellowIfAny("NUMBER_OF_TRIPS")).setValue(findNumberOfTrips());
		}
		catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	String findNumberOfAccounts() {
		DetachedQueryResult dqr = new DetachedQueryResult(MT.CUSTOMERPK);
		if (null == dqr.getMaxResults())
			return "0";
		return Integer.toString(dqr.getMaxResults());
	}

	String findNumberOfCases() {
		DetachedQueryResult dqr = new DetachedQueryResult(MT.CSCASE);
		if (null == dqr.getMaxResults())
			return "0";
		return Integer.toString(dqr.getMaxResults());
	}

	String findNumberOfTrips() {
		DetachedQueryResult dqr = new DetachedQueryResult(MT.TRIP);
		if (null == dqr.getMaxResults())
			return "0";
		return Integer.toString(dqr.getMaxResults());
	}

}
