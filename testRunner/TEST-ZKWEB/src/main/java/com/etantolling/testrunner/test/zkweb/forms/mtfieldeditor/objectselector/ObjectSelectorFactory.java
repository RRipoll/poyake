package com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector;

import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Combobox;

import com.etantolling.testrunner.test.core.metadata.MTTable;

public class ObjectSelectorFactory {

	public static Component buildObjectSelector(MTTable table) throws SQLException{
		Combobox combobox = new Combobox();
		ObjectSelectorHelper.setTable(combobox, table);
		return combobox;
	}
}
