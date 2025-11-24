package com.jsantos.custom.customfield;

import java.util.Map.Entry;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Listitem;

import com.jsantos.common.util.MapValues;
import com.jsantos.gui.zkcomponent.MTListbox;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.metadata.testrunner.EventTypeDTO;
import com.jsantos.orm.mt.MTField;
import com.jsantos.runningTest.TestEventTypeFactory;

public class EventTypeContainer  extends DefaultMTCustomFieldContainer implements IMTComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getValue() {
		MTListbox editor=((MTListbox)getCustomComponent());
		if(null!=editor.getSelectedItem())
		return editor.getSelectedItem().getValue();
		return null;
	}

	@Override
	public MTField forField() {
		return MTtestRunnerData.EVENTDEFINITION.EVENTTYPEID;
	}

	@Override
	public Component initialize() {
		MTListbox editor=new MTListbox();
		editor.setMold("select");
		setCustomComponent(editor);
		MapValues<EventTypeDTO> types=TestEventTypeFactory.getTypes();
		
		for (Entry<String, EventTypeDTO> item : types.entrySet()) {
			Listitem listItem= new Listitem(item.getValue().getDescription(), item.getValue().getEventTypeId());
			listItem.setParent(editor);
		}
		return this;
	}
}

