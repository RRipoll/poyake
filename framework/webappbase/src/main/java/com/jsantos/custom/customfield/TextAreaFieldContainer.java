package com.jsantos.custom.customfield;

import org.zkoss.zk.ui.Component;

import com.jsantos.gui.zkcomponent.MTTextbox;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTDataType;

public class TextAreaFieldContainer extends DefaultMTCustomFieldContainer implements IMTComponent{

	@Override
	public MTDataType forModelType() {
		
		return MTDataTypes.TEXTAREA;
	}

	@Override
	public Component initialize() {
		MTTextbox editor=new MTTextbox();
		setCustomComponent(editor);
		editor.setMultiline(true);
		editor.setRows(2);
		return this;
		
	}

	
	
	
	
}
