package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event;

import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.impl.InputElement;

import com.etantolling.testrunner.test.zkweb.EditorElement;
import com.etantolling.testrunner.test.zkweb.ParameterItem;

public class AddParameter implements EventListener<Event>{

	LinkedHashMap<String, ParameterItem> parameters;
	Combobox newParameterType = null;
	Textbox newlabelname = null;

	Component addParamenter;
	Component resetParamenters;
	Combobox eventType;
	Component window;
	EditScreenControler screen;
	Checkbox isInputParameter;
	Checkbox isOutputParameter;

	public AddParameter(Component parent,LinkedHashMap<String, ParameterItem> parameters,EditScreenControler screen)
			throws WrongValueException, SQLException {
		
		window = parent;
		this.parameters=parameters;
		this.screen=screen;
		newParameterType = (Combobox) window.getFellow("newType");
		newlabelname = (Textbox) window.getFellow("newlabelname");
		//eventParameterArea =  window.getFellow("EVENT_PARAMENTER_AREA");
		addParamenter = window.getFellow("ADD_PAREMETERS");
		addParamenter.addEventListener(Events.ON_CLICK, this);

		isInputParameter = (Checkbox) window.getFellow("ISINPUTPARAMETER");
		isOutputParameter = (Checkbox) window.getFellow("ISOUTPUTPARAMETER");

		//eventType.addEventListener(Events.ON_CHANGE, this);
		fillParameterType(newParameterType);
		
	}

	private void fillParameterType(Combobox newParameterType) {

		newParameterType.getChildren().clear();

		new Comboitem("Int").setParent(newParameterType);
		new Comboitem("Text").setParent(newParameterType);
		new Comboitem("BigDecimal").setParent(newParameterType);
		new Comboitem("Date").setParent(newParameterType);
		new Comboitem("JSON").setParent(newParameterType);
		new Comboitem("Conditional-Null").setParent(newParameterType);
		new Comboitem("Conditional-Not-Null").setParent(newParameterType);
		new Comboitem("Conditional-Equal").setParent(newParameterType);

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

			boolean bIsInput = isInputParameter.isChecked();
			boolean bIsOutput = isOutputParameter.isChecked();
			if (!(bIsInput || bIsOutput))
				throw new WrongValueException(isInputParameter, "Input or Output must be checked");

			if (null != key && null != type) {
				String label = key;
				EditorElement editorElement = new EditorElement(getObjectFromString(type), true, false, bIsInput,
						bIsOutput,type);
				parameters.put(key, new ParameterItem(editorElement, false, bIsInput, bIsOutput, type, null, label));
				editorElement.getLabel().setText(key);
			//	renderParamenters();
				newlabelname.setValue(null);
				newParameterType.setValue(null);
				isInputParameter.setChecked(false);
				isInputParameter.setChecked(false);
			}
			screen.render();
		}

		if (event.getTarget().equals(resetParamenters)) {

			parameters.clear();
			screen.render();
		}
	
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
		} else if (type.equalsIgnoreCase("JSON")) {
			Textbox tb = new Textbox("");
			tb.setWidth("400px");
			tb.setCols(10);
			tb.setHeight("200px");
			tb.setMultiline(true);
			return tb;
		} else if (type.equalsIgnoreCase("Conditional-Null") || type.equalsIgnoreCase("Conditional-Not-Null") || type.equalsIgnoreCase("Conditional-Equal")) {
			Textbox object = new Textbox();
			object.setWidth("400px");
			return object;
		} else
			return null;

	}
}