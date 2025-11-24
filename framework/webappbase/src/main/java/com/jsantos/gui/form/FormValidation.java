package com.jsantos.gui.form;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Clients;

import com.jsantos.gui.zkutil.ComponentTreeTransverser;

public class FormValidation {
	public static void clearAllValidationMessages(Component formParent){
		Vector<Component> components = ComponentTreeTransverser.transverseTree(formParent);
		for (Component comp:components) Clients.clearWrongValue(comp);
	}
}
