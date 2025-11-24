package com.jsantos.demo.screen.cscase;

import org.zkoss.zk.ui.Component;

import com.jsantos.gui.form.controller.MTUpdateScreenController;
import com.jsantos.metadata.cs.CSCaseDTO;

public class CaseDetails {
	CSCaseDTO cscase;
	Component parent;
	Component comp = null;
	
	public CaseDetails(int pk, Component parent) {
		this.cscase = new CSCaseDTO(true, pk);
		MTUpdateScreenController editScreen = new MTUpdateScreenController(cscase, parent);
		if (editScreen.doModal())
			;//reload();
		//this.parent = parent;
	}
}
