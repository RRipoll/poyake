package com.etantolling.testrunner.test.zkweb;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.impl.InputElement;

import com.etantolling.testrunner.test.core.testing.Wildcards;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.github.underscore.lodash.U;

public class EditorElement extends Div implements EventListener<Event> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InputElement element;

	Textbox label;

	Radiogroup selection;

	Radio byValue;
	Radio byReference;
	
	Checkbox isOutput;
	Checkbox isInput;
	
	Button editJson;
	
	boolean deleted=false;

	public Checkbox getIsOutput() {
		return isOutput;
	}

	public void setIsOutput(Checkbox isOutput) {
		this.isOutput = isOutput;
	}

	public Checkbox getIsInput() {
		return isInput;
	}

	public void setIsInput(Checkbox isInput) {
		this.isInput = isInput;
	}

	public Radio getByValue() {
		return byValue;
	}

	public void setByValue(Radio byValue) {
		this.byValue = byValue;
	}

	public Radio getByReference() {
		return byReference;
	}

	public void setByReference(Radio byReference) {
		this.byReference = byReference;
	}

	public InputElement getElement() {
		return element;
	}

	public void setElement(InputElement element) {
		this.element = element;
	}

	public Textbox getLabel() {
		return label;
	}

	public void setLabel(Textbox label) {
		this.label = label;
	}

	public Radiogroup getSelection() {
		return selection;
	}

	public void setSelection(Radiogroup selection) {
		this.selection = selection;
	}

	public EditorElement(InputElement element, boolean isValue, boolean hideReference, boolean input, boolean output, String type) {

		Hbox h=new Hbox();
		h.setParent(this);
		
		
		Image img= new Image("../../img/trash.gif");
		img.setParent(h);
		img.addEventListener(Events.ON_CLICK, this);
		
		new Space().setParent(h);
		this.element = element;
		element.setParent(h);
		new Space().setParent(h);
		isInput = new Checkbox("Input");
		isInput.setChecked(input);
		isInput.setParent(h);
		isInput.setVisible(!hideReference);
		
		if(type.startsWith("Conditional")) {
			new Space().setParent(h);
			new Space().setParent(h);
			new Label(type).setParent(h);
			hideReference=true;
		}
		
		if(!hideReference)new Space().setParent(h);
		isOutput = new Checkbox("output");
		isOutput.setChecked(input);
		isOutput.setParent(h);
		isOutput.setVisible(!hideReference);

		if(!hideReference)new Space().setParent(h);

		selection = new Radiogroup();
		selection.setParent(h);
		byValue = new Radio("By Value");
		byValue.setChecked(isValue);
		byValue.setParent(selection);
		byValue.setVisible(!hideReference);
		byValue.addEventListener(Events.ON_CHECK, this);

		if(!hideReference)new Space().setParent(selection);
		byReference = new Radio("By Reference");
		byReference.setChecked(!isValue);
		byReference.setParent(selection);
		byReference.setVisible(!hideReference);
		byReference.addEventListener(Events.ON_CHECK, this);

		if(!hideReference)new Space().setParent(h);
		label = new Textbox();
		label.setVisible(!isValue);
		label.setParent(h);
		
		//new Space().setParent(this);
		if(type.equals("JSON")) {

			
			Vbox vbox=new Vbox();
			vbox.setParent(h);

			
			editJson= new Button("Edit");
				editJson.addEventListener(Events.ON_CLICK, this);
				editJson.setParent(vbox);

				
			Hbox hbox=new Hbox();
				hbox.setParent(vbox);

				
			Textbox tablename = new Textbox();
				tablename.setParent(hbox);
				tablename.setPlaceholder("Table Name");
				tablename.setWidth("100");
			Button getExample=new Button("get Example");
				getExample.setParent(hbox);
				getExample.addEventListener(Events.ON_CLICK, this::getExample);
				getExample.setAttribute("tableName", tablename);
				getExample.setAttribute("label", label);
		}
	}

	public EditorElement(String key, Object value) {

		if(null!=value) {
		InputElement element=getInputElement(value);
		this.element = element;
		element.setParent(this);
		new Space().setParent(this);
		label = new Textbox();
		label.setVisible(false);
		label.setParent(this);
		}
	}

	private InputElement getInputElement(Object value) {
		
		if(null== value || value instanceof InputElement) return (InputElement) value;
		InputElement object=null;
		if (value instanceof Integer) {
			object = new Intbox();
		} else if (value instanceof String) {
			object = new Textbox();
			object.setWidth("400px");
		} else if (value instanceof BigDecimal) {
			object= new Decimalbox();
		}else if (value instanceof Double) {
			object= new Decimalbox(new BigDecimal(((Double)value).toString()));
			return object;
		}
		else if (value instanceof Date) {
			object= new Datebox();
		}else if (value instanceof Boolean) {
			object= new Intbox();
		} 
		object.setRawValue(value);
		return object;
	}

	
	public void getExample(Event event) throws Exception {
		String tableName=((Textbox) event.getTarget().getAttribute("tableName")).getValue();
		if(null!=tableName) {
			String url=DesktopHelper.getAppBaseUrl()+"/api/mt/example/"+tableName;
			ResponseEntity<String> json = ClientWS.call(url, 
					HttpMethod.GET);
			element.setRawValue(U.formatJson(json.getBody()));
			
		}
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		if (event.getTarget().equals(byReference) && byReference.isChecked()) {
			label.setVisible(true);// element.setVisible(false);
		}else if (event.getTarget().equals(editJson)) {
			JsonEditor jsonEditor=new JsonEditor();
			jsonEditor.getPanel().setParent(this);
			((Textbox)jsonEditor.getPanel().getFellow("label")).setValue((String) element.getRawValue());
			((Textbox)jsonEditor.getPanel().getFellow("label")).addEventListener(Events.ON_CHANGE, this);
			
			Clients.evalJavaScript("editor.set("+Wildcards.addCommaToWildCard((String) element.getRawValue())+");editor.expandAll()");
			
			jsonEditor.getPanel().doModal();
		}
		else if (event.getTarget().equals(byValue) && byValue.isChecked()){
			label.setVisible(false);// element.setVisible(true);
		}
		else if (event.getName().equals(Events.ON_CHANGE)) {
			
			Object previousdata=((InputEvent)event).getPreviousValue();
			//Object data=((InputEvent)event).getValue();
			
			element.setRawValue(previousdata.toString());

		}else if (event.getTarget() instanceof Image) {
			deleted=true;
			Events.sendEvent("onDataDeleted", (Component) this, null);
		}
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}