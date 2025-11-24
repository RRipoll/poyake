package com.jsantos.screen.systemadmin.users;

import org.zkoss.zk.ui.Component;

import com.jsantos.gui.form.controller.MTInsertScreenController;
import com.jsantos.metadata.MTAuditData;

public class CreateOrUpdateUser {
	public void buildEditorScreen(Component comp){
		try {
			comp.getChildren().clear();		
			MTInsertScreenController controler = new MTInsertScreenController(comp, MTAuditData.INPUTUSER);
			controler.getMtForm().getFormComponent().setParent(comp);
		}
		catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
}
