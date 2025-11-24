package com.jsantos.gui.form;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.DetailConfiguration;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.zkcomponent.MTCustomFieldContainer;
import com.jsantos.gui.zkutil.ComponentTreeTransverser;
import com.jsantos.orm.mt.MTField;

/**
 * @author javier santos
 */

public class FormZulBuilder {
	String zulURI = "~./common/zul/standardeditscreen/standardeditscreen.zul";
	List<MTField> fieldsToBeAdded = null;
	EditMode mode;
	Component form;
	String fieldListName="FIELD_LIST";
	String searchName;
	
	public Component buildForm(Component parent) {
		form = Executions.createComponents(zulURI,parent, null);
		
		reloadFields();
		return form;
	}
	
	public void addFieldsToZul(List<MTField> fieldsToBeAdded, EditMode mode) {
		this.fieldsToBeAdded = fieldsToBeAdded;
		this.mode=mode;
	}
	
	public void reloadFields() {
		Component fieldListContainer=form.getFellowIfAny(fieldListName);
		if (null != fieldListContainer)
			fieldListContainer.getChildren().clear();
		ZulFieldTagEditorBuilder.buildFields(form);
		
		if (null != fieldsToBeAdded) { 
			fieldsToBeAdded=removeDuplecated(fieldsToBeAdded);
			addFields(form.getFellow(fieldListName),mode);
		}
	}
	
	private List<MTField> removeDuplecated(List<MTField> fieldsToBeAdded) {
		
		List<MTField> returnValue=new ArrayList<MTField>();
		for (MTField field:fieldsToBeAdded){
		     if (null == ComponentTreeTransverser.findFieldEditorFor(form, field)){
		    	 returnValue.add(field);
		     }
		}
		return returnValue;
	}
	public void setZulURI(String zulURI) {
		this.zulURI = zulURI;
	}

	private void addFields(Component comp,EditMode mode) {
			
		int columnCount=13;
		Div line = null;
		
		for (MTField field:fieldsToBeAdded){
			String asName=searchName;
			if(null==asName)  asName=field.getTable().getTableName();
			SettingDTO setting=DesktopHelper.getSetting(asName,  DesktopHelper.getInputUserGroupId(), LocaleFactory.getProvider().getLocale())				;
			DetailConfiguration detail=DataSettingFactory.getDetailConfiguration(
			    		setting, field, mode);
				if(columnCount>=12 || detail.isNewLine()) {
					line= new Div();
					line.setClass("row clearfix");
					line.setParent(comp);
					columnCount=0;
				}
			    if(null!=detail.getPreviousLabel() && !detail.getPreviousLabel().isEmpty()) {
			    	Div div= new Div();
			    	div.setClass("col-md-2");
			    	columnCount+=2;
			    	div.setParent(line);
			    	Label label= new Label(detail.getPreviousLabel());
			    	label.setSclass("font-bold");
			    	label.setParent(div);
			    }
			    Div div= new Div();
		    	div.setClass(detail.getsClass());
		    	columnCount+=4;
		    	div.setParent(line);
		    	MTCustomFieldContainer container= new MTCustomFieldContainer();
		    	container.setMode(mode);
				container.setParent(div);
				container.setMTField(field);
				container.addEventListener(CustomEvents.ON_CUSTOMFIELD_UPDATE, this::customFieldUpdate);
		}
	}

	public Component getForm() {
		return form;
	}

	public void setForm(Component form) {
		this.form = form;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	public void customFieldUpdate(Event event) {
		
		Events.sendEvent(
				new Event(CustomEvents.ON_CUSTOMFIELD_UPDATE, form,	event.getData())
						);
	}
}

