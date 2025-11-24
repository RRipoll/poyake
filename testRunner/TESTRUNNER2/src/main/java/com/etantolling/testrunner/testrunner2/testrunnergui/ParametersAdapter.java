package com.etantolling.testrunner.testrunner2.testrunnergui;

import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Textbox;

public class ParametersAdapter implements RowRenderer<Map<String, String>> {

	@Override
	public void render(Row row, Map<String, String> data, int index) throws Exception {
		String key = data.keySet().stream().findFirst().get();
		String value = data.get(key);
		
		if(key != null && key.toUpperCase().equals("JSON")) {
			Div divJson = new Div();

			Textbox txtJson = new Textbox();
			txtJson.setValue(value);
			txtJson.setVisible(false);
			txtJson.setRows(4);
			txtJson.setHflex("1");
			
			A lnkJson = new A();
			lnkJson.setLabel("JSON");
			lnkJson.setStyle("text-decoration:none");
			lnkJson.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

				@Override
				public void onEvent(Event event) throws Exception {
					txtJson.setVisible(true);
				}
				
			});
			divJson.appendChild(lnkJson);
			divJson.appendChild(txtJson);
			row.appendChild(divJson);
		}
		else {
			Label lbl = new Label();
			lbl.setValue(key + ": " + value);			
			row.appendChild(lbl);
		}
		
		
		
		

	}
}