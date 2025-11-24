package com.jsantos.gui.datagrid4;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Checkbox;

import com.jsantos.common.util.ListValues;


public interface ISelectionMan<T> {

	ListValues<T> getSelectedSet();

	void setSelectedSet(ListValues<T> selectedSet);

	GridSelectorType getSelectedtype();

	void setSelectedtype(GridSelectorType selectedtype);

	void set(T id, boolean checked);

	boolean add(T o);

	boolean remove(T removedObject);

	void setSingleSelection(T id);

	ListValues<T> getChecked();

	boolean isChecked(T id);

	T getSingleSelectedKey();

	int getSelectionCount();

	void clear();

	void checked(Event event);

	Checkbox buildSelectorColumn(Component row, T datarecord, EventListener<Event> object);

	void notifyListeners();

}