package com.etantolling.testrunner.test.zkweb.datagrid3;

import java.util.Vector;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

@SuppressWarnings("serial")
public class SelectionMan extends Div { // we extend Div so we can generate events

	public Vector<Object> selectedSet = new Vector<Object>();
	int selectedtype;

	public void set(Object id, boolean checked) {
		if (checked) {
			if (selectedtype == 2)
				selectedSet.clear();
			if (!selectedSet.contains(id))
				selectedSet.add(id);
		} else
			selectedSet.remove(id);
		notifyListeners();
	}

	public void setSingleSelection(Object id) {
		//System.out.println("Setting checked: " + id);
		if (selectedtype == 2)
			selectedSet.clear();
		selectedSet.add(id);
		notifyListeners();
	}

	public SelectionMan(int selectedtype) {
		super();
		this.selectedtype = selectedtype;
	}

	public Vector<Object> getChecked() {
		return selectedSet;
	}

	public String getExceptionKeysSelector() {
		return KeySetUtils.getExceptionKeysSelector(selectedSet);
	}

	public boolean isChecked(Object id) {
		return selectedSet.contains(id);
	}
	
	
	@SuppressWarnings("unchecked")
	public SelectionMan clone() {
		SelectionMan theClone = new SelectionMan(selectedtype);
		theClone.selectedSet = (Vector<Object>) this.selectedSet.clone();
		return theClone;
	}

	public Object getSingleSelectedKey() {
		if (1 != selectedSet.size())
			return null;
		return selectedSet.get(0);
	}

	public int getSelectionCount() {
		return selectedSet.size();
	}

	public void clear() {
		selectedSet.clear();
		notifyListeners();
	}

	void notifyListeners() {
		Events.sendEvent(new Event("onSelectionChanged", this, new Integer(getSelectionCount())));
	}

}
