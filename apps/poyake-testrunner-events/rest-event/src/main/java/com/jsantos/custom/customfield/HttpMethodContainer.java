package com.jsantos.custom.customfield;

import org.zkoss.zk.ui.Component;

import com.jsantos.gui.zkcomponent.MTSelectbox;
import com.jsantos.orm.mt.MTField;

public class HttpMethodContainer extends DefaultMTCustomFieldContainer implements IMTComponent{

	@Override
	public Object getValue() {
		MTSelectbox editor=((MTSelectbox)getCustomComponent());
		return (editor).getListModel().get(editor.getSelectedIndex()).toString();
	}

	@Override
	public MTField forField() {
		return null;
		//return MTtestRunnerData.EVENTDEFINITION.HTTPMETHOD;
	}

	@Override
	public Component initialize() {
		MTSelectbox editor=new MTSelectbox();
		setCustomComponent(editor);
		return this;
	}

	
	
	
}
