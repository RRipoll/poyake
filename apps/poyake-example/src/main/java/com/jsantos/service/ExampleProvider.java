package com.jsantos.service;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.jsantos.common.util.MapValues;
import com.jsantos.custom.menu.IMenuProvider;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.gui.objectselector.foldertree.TreeController;
import com.jsantos.metadata.MTExampleData;

/**
 * @author raul ripoll
 */
public class ExampleProvider implements IMenuProvider{

		Component mainArea;
		Component parent;
		String uri="~./zul/poyake-example/menu.zul";
		//TreeController eventTree;
		
		@Override
		public Component getMenu(Component parent,Component mainArea,MapValues<Object>data) {
			   this.parent=parent;
			   this.mainArea=mainArea;
			   
				Component mainScreen=Executions.createComponents(uri, parent, data);
				mainScreen.getFellow("BOOK").addEventListener(					Events.ON_CLICK, this::books);
				mainScreen.getFellow("AUTHOR").addEventListener(				Events.ON_CLICK, this::authors);
				
			return mainScreen;
		}
		
		@Override
		public boolean isImplemented() {
			return true;
		}
		void books(Event evt) throws Exception{
			mainArea.getChildren().clear();new CrudScreen().init(MTExampleData.VBOOK,mainArea).build();
			collapseMenu();
		}
		
		void authors(Event evt) throws Exception{
			mainArea.getChildren().clear();new CrudScreen().init(MTExampleData.AUTHOR,mainArea).build();
			collapseMenu();
		}
		private void collapseMenu() {
			Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
		}

		@Override
		public String getProviderName() {
			return "poyake-example";
		}
		
}
