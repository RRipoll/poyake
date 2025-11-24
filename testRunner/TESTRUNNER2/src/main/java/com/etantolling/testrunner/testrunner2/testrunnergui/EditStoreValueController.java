package com.etantolling.testrunner.testrunner2.testrunnergui;

import java.util.LinkedHashMap;

import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.InputElement;

import com.etantolling.testrunner.test.zkweb.EditorElement;
import com.etantolling.testrunner.test.zkweb.ParameterItem;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.standardlistheader.StandardListHeader;

public class EditStoreValueController  implements EventListener<Event> {

	Window panel;
	LinkedHashMap<String, Object> storeValues;
	LinkedHashMap<String, ParameterItem> paramenters = new LinkedHashMap<String, ParameterItem>();
	
	Combobox newParameterType = null;
	Textbox newlabelname = null;
	Component addParamenter;
	Combobox eventType;
	Component saveButton;
	Component resetButton;
	
	public EditStoreValueController(LinkedHashMap<String, Object> storeValues) {
		this.storeValues=storeValues;
		if(null==storeValues)storeValues= new LinkedHashMap<String, Object>();
		panel=(Window) new StandardListHeader(this, "/zul/testgui2/standardstorevalue.zul").getComponent();
		init();
		panel.doModal();
	}

	private void init() {
		newParameterType = (Combobox) panel.getFellow("newType");
		newlabelname = (Textbox) panel.getFellow("newlabelname");
		addParamenter = panel.getFellow("ADD_PAREMETERS");
		addParamenter.addEventListener(Events.ON_CLICK, this);
		saveButton=panel.getFellow("SAVE_BUTTON");
		saveButton.addEventListener(Events.ON_CLICK, this);
		resetButton=panel.getFellow("RESET_BUTTON");
		resetButton.addEventListener(Events.ON_CLICK, this);
		
		createList();
		
		fillParameterType(newParameterType);
	}

	private void createList() {
		for (String key : storeValues.keySet()) {
            if(null==storeValues.get(key)) continue;
			EditorElement editorElement = new EditorElement(key,storeValues.get(key));
			paramenters.put(key, new ParameterItem(editorElement, false, false, false, null, storeValues.get(key), key));
			editorElement.getLabel().setText(key);
		}
		renderParamenters();
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if (event.getTarget().equals(addParamenter)) {

			String key = newlabelname.getValue();
			if (null == key || key.trim().length() == 0)
				throw new WrongValueException(newlabelname, "mandatory");
			key = key.trim();
			String type = newParameterType.getSelectedItem().getLabel();
			if (null == type || type.trim().length() == 0)
				throw new WrongValueException(newParameterType, "mandatory");

			if (null != key && null != type) {
				String label = key;
				EditorElement editorElement = new EditorElement(label, getObjectFromString(type));
				paramenters.put(key, new ParameterItem(editorElement, false, false, false, null, null, label));
				editorElement.getLabel().setText(key);
				renderParamenters();
				newlabelname.setValue(null);
				newParameterType.setValue(null);
			}
		} else if (event.getTarget().equals(saveButton)){
			
			storeValues.clear();
			
			for (String key : paramenters.keySet()) {
				ParameterItem item = paramenters.get(key);
				Object value= item.getEditElement().getElement().getRawValue();
				storeValues.put(key, value);
			}
			panel.detach();
		}else if (event.getTarget().equals(resetButton)){
			String AUTHORIZATION=(String) storeValues.get("AUTHORIZATION");
			storeValues.clear();
			storeValues.put("AUTHORIZATION", AUTHORIZATION);
			panel.detach();
		}
	}
	
	private void fillParameterType(Combobox newParameterType) {

		newParameterType.getChildren().clear();

		new Comboitem("Int").setParent(newParameterType);
		new Comboitem("Text").setParent(newParameterType);
		new Comboitem("BigDecimal").setParent(newParameterType);
		new Comboitem("Date").setParent(newParameterType);
	}
	
	public static InputElement getObjectFromString(String type) {

		if (type.equalsIgnoreCase("Int")) {
			Intbox object = new Intbox();
			return object;
		} else if (type.equalsIgnoreCase("Text")) {
			Textbox object = new Textbox();
			object.setWidth("400px");
			return object;
		} else if (type.equalsIgnoreCase("BigDecimal")) {
			return new Decimalbox();
		} else if (type.equalsIgnoreCase("Date")) {
			return new Datebox();
		} else
			return null;

	}
	
	private void renderParamenters() {

		Component eventParameterArea=	panel.getFellow("FIELD_LIST");
		eventParameterArea.getChildren().clear();
		
		for (String key : paramenters.keySet()) {
				Tr tr = new Tr();
				tr.setParent(eventParameterArea);
				Td box = new Td();
				box.setParent(tr);
				new Label(key).setParent(box);
				new Space().setParent(box);
				paramenters.get(key).editElement.setParent(box);
		}
	}
}