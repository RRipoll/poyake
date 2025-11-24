package com.jsantos.demo.screen.promo;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;

import com.jsantos.gui.datagrid4.EntityGrid;
import com.jsantos.metadata.MT;
import com.jsantos.orm.dbstatement.DetachedQueryResult;

public class PromoSearch {
	public void buildGrid(Component comp) throws Exception{
		comp.getChildren().clear();
		Component searchScreen = Executions.createComponents("/common/zul/standardlistscreen/standardlistscreen.zul", comp, null);
		comp.appendChild(searchScreen);
		
		//((Label)comp.getFellowIfAny("HEADER_LABEL")).setValue("Admin Promos");;
		Component gridDiv = searchScreen.getFellow("GRID");
		EntityGrid entityGrid = new EntityGrid(new DetachedQueryResult(MT.PROMO),null).init();
		gridDiv.getChildren().clear();
		gridDiv.appendChild(entityGrid.buildGrid());

	}

}
