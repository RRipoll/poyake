package com.jsantos.demo.screen.promo;

import org.zkoss.zk.ui.Component;

import com.jsantos.gui.form.controller.MTInsertScreenController;
import com.jsantos.metadata.MTroadRunnerData;

public class CreatePromo {
	
	public void buildEditorScreen(Component comp){
		try {
			comp.getChildren().clear();		
			MTInsertScreenController controler = new MTInsertScreenController(comp, MTroadRunnerData.PROMO);
			controler.getMtForm().getFormComponent().setParent(comp);
		}
		catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
}
