package com.jsantos.gui.filteredgrid;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.jayway.jsonpath.JsonPath;
import com.jsantos.gui.CustomEvents;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
/**
 * @author raul ripoll
 */
public class Jsoncheckeditor {
	protected Window panel;
	String value;
	Object result;
	String expresion;
	Component parent;
	boolean isUpdated=false;

	public Jsoncheckeditor(String value, Component parent) {
		this.value = (String) value;
        this.parent=parent;
		panel = (Window) Executions.createComponents("~./common/zul/jsonCheck.zul", panel, null);
		panel.getFellow("CheckJSONEDITOR_CANCEL_BUTTON").addEventListener(Events.ON_CLICK, this::cancel);
		panel.getFellow("getExp").addEventListener(Events.ON_CLICK, this::updateEpression);
		panel.setParent(parent);
		((Textbox) panel.getFellow("Checklabel")).setValue(this.value);
		((Textbox) panel.getFellow("Checklabel")).addEventListener(Events.ON_CHANGE, this::jsonOnChange);
		((Textbox) panel.getFellow("Checklabelresult")).addEventListener(Events.ON_CHANGE, this::jsonResultOnChange);
		Textbox checkexpression=(Textbox) panel.getFellow("Checkexpression");
		checkexpression.setValue("$..");
		checkexpression.addEventListener(Events.ON_CHANGING, this::selected);
		Clients.evalJavaScript("editor.set(" + value + ");editor.expandAll()");
		panel.doModal();
	}

	void cancel(Event event) {
		panel.detach();
	}
	
	void updateEpression(Event event) {
		isUpdated=true;
		panel.detach();
	}
	
	public Window getPanel() {
		return panel;
	}

	public Component getHeaderDiv() {
		return panel.getFellow("CheckHEADER_DIV");
	}

	void selected(Event event) {
		expresion=((InputEvent)event).getValue();
		//expresion = ((Textbox) event.getTarget()).getValue();
		System.out.println(((Textbox) event.getTarget()).getValue());
		Object resultCheck;
		try {
			result =JsonPath.read(value, expresion);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
			resultCheck="";
		}
		if(null!=result && !result.toString().startsWith("["))
			resultCheck="[\""+result+"\"]";
		else resultCheck=result;
		Clients.evalJavaScript("editorresult.set("+resultCheck+");editorresult.expandAll()");
	}

	public void jsonOnChange(Event event) throws Exception {
		Object previousdata = ((InputEvent) event).getPreviousValue();

		String data = previousdata.toString();

		try {
			panel.detach();

			Events.sendEvent(CustomEvents.ON_CHANGINGCONF, parent, null);
		} catch (Exception e) {
			throw new ApiException(ApiError.DB_BAD_SQL, "Wrong Data in Db");
		}
	}

	public void jsonResultOnChange(Event event) throws Exception {
		Object previousdata = ((InputEvent) event).getPreviousValue();

		String data = previousdata.toString();

		try {
			panel.detach();

			Events.sendEvent(CustomEvents.ON_CHANGINGCONF, parent, null);
		} catch (Exception e) {
			throw new ApiException(ApiError.DB_BAD_SQL, "Wrong Data in Db");
		}
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getExpresion() {
		return expresion;
	}

	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}

	public boolean isUpdated() {
		return isUpdated;
	}

	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

}
