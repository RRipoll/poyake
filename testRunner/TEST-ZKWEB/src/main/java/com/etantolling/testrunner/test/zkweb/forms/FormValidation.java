package com.etantolling.testrunner.test.zkweb.forms;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Clients;

import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class FormValidation {
	public static void clearAllValidationMessages(Component formParent){
		Vector<Component> components = ComponentTreeTransverser.transverseTree(formParent);
		for (Component comp:components) Clients.clearWrongValue(comp);
	}
}
