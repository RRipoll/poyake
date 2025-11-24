package com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector;

import org.zkoss.zk.ui.Component;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

public interface IObjectSelector {
	void setPk(Integer pk);
	Integer getPk();
	void setTable(MTTable table);
	MTTable getTable();
	void setField(MTField field);
	MTField getField();
	Component getComponent();
}
