package com.jsantos.custom.cell.general;

import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.filteredgrid.JsonEditor;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
/**
 * @author raul ripoll
 */
public class JsonBuilder extends Div implements IGridCellBuilder {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3406396881713156671L;
	Object value;
	IDetachedRecord detachedRecord;
	Locale locale;
	JsonEditor jsonEditor;
	MTField mTField;
	ListValues<Component> extraButton= new ListValues<>();
	private boolean isUpdated;
	
	public ListValues<Component> getExtraButton() {
		return extraButton;
	}

	public void setExtraButton(ListValues<Component> extraButton) {
		this.extraButton = extraButton;
	}
	
	public JsonBuilder() {

	}

	@Override
	public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord detachedRecord, Locale locale) {
		this.mTField = mtField;
		this.value = value;
		this.detachedRecord = detachedRecord;
		this.locale = locale;
		
		this.setSclass("btn btn-link");
		this.setStyle("color:blue");
		Label label = new Label("Edit Json");
		label.setStyle("cursor:pointer");
		label.setParent(this);
		
		this.addEventListener(Events.ON_CLICK, this::jsonEditor);
		return this;

	}

	public void jsonEditor(Event event) throws JsonProcessingException {

		jsonEditor = new JsonEditor();
		jsonEditor.getPanel().setParent(this.getParent());
		detachedRecord.set(mTField,value);
		String data= (String) DBValueMapper.unloadValue(mTField, detachedRecord);
//				.setData((SettingDTO) value);
		//if(null==value)value="{}";
		((Textbox) jsonEditor.getPanel().getFellow("label")).setValue(data);
		((Textbox) jsonEditor.getPanel().getFellow("label")).addEventListener(Events.ON_CHANGE, this::jsonOnChange);

		for (Component component : extraButton) {
			new Space().setParent(getHeaderDiv());
			component.setParent(getHeaderDiv());
		}
		
		Clients.evalJavaScript("editor.set(" + data + ");editor.expandAll()");

		jsonEditor.getPanel().doModal();
	}
	
	public void jsonOnChange(Event event) throws Exception {
		Object previousdata = ((InputEvent) event).getPreviousValue();

		String data = previousdata.toString();

		try {
			detachedRecord.set(mTField,data);
			value=DBValueMapper.loadValue(detachedRecord, mTField);
			detachedRecord.set(mTField,value);
			jsonEditor.getPanel().detach();
            setUpdated(true);
			//Events.sendEvent(CustomEvents.ON_CHANGINGCONF, this.getParent(), null);
		} catch (Exception e) {
			throw new ApiException(ApiError.DB_BAD_SQL, "Wrong Data in Db");
		}
	}

	@Override
	public MTDataType forModelType() {

		return MTDataTypes.JSON;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
		if(null!=jsonEditor) {
			Clients.evalJavaScript("editor.set(" + value + ");editor.expandAll()");
		}
	}

	public IDetachedRecord getValues() {
		return detachedRecord;
	}

	public void setDetachedRecord(IDetachedRecord values) {
		this.detachedRecord = values;
	}

	public Component getHeaderDiv() {
		return jsonEditor.getHeaderDiv();
	}

	
	public boolean isUpdated() {
		return isUpdated;
	}

	
	public void setUpdated(boolean isUpdated) {
		this.isUpdated=isUpdated;
		if(isUpdated)
			Events.sendEvent(CustomEvents.ON_ISUPDATED, this, getValue());
	}
	
	public void setUpdated(Event isUpdated) {
		setUpdated(true);
	}
}
