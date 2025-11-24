package com.jsantos.custom.customfield;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;

import com.jsantos.common.util.MapValues;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.filteredgrid.Jsoncheckeditor;
import com.jsantos.gui.zkutil.ButtonCssClass;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.metadata.testrunner.StoreValuesEventDTO;
import com.jsantos.orm.mt.MTField;

public class StoreValuesContainer  extends  ParameterContainer{

	@Override
	public MTField forField() {
		
		return MTtestRunnerData.STOREVALUESTEST.STOREVALUESEVENTS;
	}

	@Override
	public Component initialize() {
		 super.initialize();
		 addHeaderButton(headerDiv, Zklabel.getLabel("check"), ButtonCssClass.COLOR_SECONDARY)
			.addEventListener(Events.ON_CLICK, this::checkItem);
		
		return this;
	}

	
	void checkItem(Event evt) {
		if (list.getSelectionMan().getSelectionCount() > 0) {
			for (Object item : list.getSelectionMan().getSelectedSet()) {
				try {
					Jsoncheckeditor jsoncheckeditor=  new Jsoncheckeditor(((StoreValuesEventDTO)item).getData(),this);
					if(jsoncheckeditor.isUpdated()) {
						Events.sendEvent(new Event(CustomEvents.ON_CUSTOMFIELD_UPDATE, this,
								new MapValues<Object>()
									.add("expresion",jsoncheckeditor.getExpresion())
									.add("result",jsoncheckeditor.getResult())
									.add("MTField",getMTField())
									.add("item",item)
													)
										);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			
			list.getSelectionMan().clear();
			list.buildGrid();
		} else
			Clients.showNotification("Nothing selected", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
	}
	
}
