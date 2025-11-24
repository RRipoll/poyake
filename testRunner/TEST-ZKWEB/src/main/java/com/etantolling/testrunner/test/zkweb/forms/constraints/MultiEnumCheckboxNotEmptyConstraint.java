package com.etantolling.testrunner.test.zkweb.forms.constraints;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Checkbox;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class MultiEnumCheckboxNotEmptyConstraint {

	public static void check(Component parent, MTField mtField, MTTable mtTable) {
		Vector<Component> components = ComponentTreeTransverser.transverseTree(parent);
		boolean atLeastOneIsChecked = false;
		for (Component comp:components){
			if (null != comp.getAttribute("field")){
				if (comp instanceof Checkbox){
					if (mtField.getName().equalsIgnoreCase((String)comp.getAttribute("field"))){
						String tableName = (String)comp.getAttribute("table");
						if (null == tableName || tableName.equalsIgnoreCase(mtTable.toString())){
							if (((Checkbox)comp).isChecked()) 
								atLeastOneIsChecked = true;
						}
					}
				}
			}
		}
		if (!atLeastOneIsChecked){
			for (Component comp:components){
				if (null != comp.getAttribute("validation_error_anchor_for_field")){
					if (mtField.getName().equalsIgnoreCase((String)comp.getAttribute("validation_error_anchor_for_field"))){
						String tableName = (String)comp.getAttribute("table");
						if (null == tableName || tableName.equalsIgnoreCase(mtTable.toString())){
							parent = comp;
						}
					}
				}
			}			
			throw new WrongValueException(parent, "At least one call subject must be checked");
		}
	}
}
