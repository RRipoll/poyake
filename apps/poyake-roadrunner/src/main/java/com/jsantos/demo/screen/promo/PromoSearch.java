package com.jsantos.demo.screen.promo;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;

import com.jsantos.gui.datagrid4.EntityGrid;
import com.jsantos.metadata.MTroadRunnerData;
import com.jsantos.orm.dbstatement.DetachedQueryResult;

public class PromoSearch {
	public void buildGrid(Component comp) throws Exception{
		comp.getChildren().clear();
		Component searchScreen = Executions.createComponents("/common/zul/standardlistscreen/standardlistscreen.zul", comp, null);
		comp.appendChild(searchScreen);
		
		Component gridDiv = searchScreen.getFellow("GRID");
		EntityGrid entityGrid = new EntityGrid(new DetachedQueryResult(MTroadRunnerData.PROMO),null).init();
		gridDiv.getChildren().clear();
		gridDiv.appendChild(entityGrid.buildGrid());

	}

}
