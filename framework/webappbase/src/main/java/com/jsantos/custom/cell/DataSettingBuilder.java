package com.jsantos.custom.cell;

import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.filteredgrid.JsonEditor;

import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
/**
 * @author raul ripoll
 */
public class DataSettingBuilder  implements IGridCellBuilder{

	Object value;
	IDetachedRecord values;
	Locale locale;
	JsonEditor jsonEditor;
	Component comp;
	
	public DataSettingBuilder() {
		
	}

	@Override
	public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord values,Locale locale) {
		this.value=value;
		this.values=values;
		this.locale=locale;
		
		comp=new Div();
		
		((Div) comp).setSclass("btn btn-link");
		((Div) comp).setStyle("color:blue");
		Label label= new Label("Show Json");
		label.setStyle("cursor:pointer");
		label.setParent(comp);
		
		comp.addEventListener(Events.ON_CLICK, this::jsonEditor);
		return comp;
	}
	
	public void jsonEditor(Event event) throws JsonProcessingException {

		jsonEditor = new JsonEditor();
		jsonEditor.getPanel().setParent(DesktopHelper.getRootComponent());
		String data= DataSettingFactory.setData((SettingDTO) value);
		
		((Textbox) jsonEditor.getPanel().getFellow("label")).setValue(data);
		((Textbox) jsonEditor.getPanel().getFellow("label")).addEventListener(Events.ON_CHANGE, this::jsonOnChange);

		Clients.evalJavaScript("editor.set(" + data + ");editor.expandAll()");

		jsonEditor.getPanel().doModal();
	}

	public void jsonOnChange(Event event) throws Exception {
		Object previousdata = ((InputEvent) event).getPreviousValue();

		String data = previousdata.toString();

		try {
			 values.set(MTBase.getMTField("DATAGRIDSETTING.DATA"),DataSettingFactory.setData(data));
				
			 values.set(MTBase.getMTField("DATAGRIDSETTING.INPUTUSERID"),DesktopHelper.getInputUserId());
			
			 DesktopHelper.putSetting(values.get(MTBase.getMTField("DATAGRIDSETTING.SEARCHNAME")).toString(),
					 (DetachedRecord) values);
			 
			values.update();
			
			jsonEditor.getPanel().detach();
			Events.sendEvent(CustomEvents.ON_CHANGINGCONF, comp.getParent(), null);
		} catch (Exception e) {
			throw new ApiException(ApiError.DB_BAD_SQL, "Wrong Data in Db");
		}
	}

	@Override
	public MTField forField() {
		try {
			return MTBase.getMTField("DATAGRIDSETTING.DATA");
		} catch (Exception e) {
			System.out.println("Table DATAGRIDSETTING doesn't exist!!");
		}
		return null;
	}
}
