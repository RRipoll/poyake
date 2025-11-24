package com.jsantos.gui.objectselector.foldertree;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Treeitem;

import com.jsantos.common.util.ListValues;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.datagrid4.GridSelectorType;
import com.jsantos.gui.datagrid4.ISelectionMan;
import com.jsantos.search.AttributeConstants;

public class TreeSelectionMan extends Div implements ISelectionMan<Treeitem>{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ListValues<Treeitem> selectedSet = new ListValues<Treeitem>().setNotNull(true).setNotRepeted(true);
	ListValues<Checkbox> checkboxSelected= new ListValues<Checkbox>();
	
	@Override
	public ListValues<Treeitem> getSelectedSet() {
		return selectedSet;
	}
	@Override
	public void setSelectedSet(ListValues<Treeitem> selectedSet) {
		this.selectedSet = selectedSet;
	}

	GridSelectorType selectedtype;
	@Override
	public GridSelectorType getSelectedtype() {
		return selectedtype;
	}
	@Override
	public void setSelectedtype(GridSelectorType selectedtype) {
		this.selectedtype = selectedtype;
	}
	@Override
	public void set(Treeitem id, boolean checked) {
		if (checked) {
			if (selectedtype == GridSelectorType.RADIO)
				selectedSet.clear();
			if (!selectedSet.contains(id))
				selectedSet.add(id);
		} else
			remove(id);
		notifyListeners();
	}
	@Override
	public boolean add(Treeitem o) {
		 for (Treeitem item : (ListValues<Treeitem>)selectedSet.clone()) {
			if(o.equals(item)) {
				selectedSet.remove(item);
			}
		 }
		 selectedSet.add(o);
		 return true;
		
	}
	@Override
	 public boolean remove(Treeitem removedObject) {
		boolean retValue=false;
		for (Treeitem item : (ListValues<Treeitem>)selectedSet.clone()) {
				if(item.equals(removedObject)){
				selectedSet.remove(item);
				return true;
				}
			}
		 return retValue;
	 }
	
	@Override
	public void setSingleSelection(Treeitem id) {
		if (selectedtype != GridSelectorType.CHECKBOX)
			selectedSet.clear();
		selectedSet.add(id);
		notifyListeners();
	}
	
	public TreeSelectionMan(GridSelectorType selectorType) {
		super();
		this.selectedtype = selectorType;
	}
	@Override
	public ListValues<Treeitem> getChecked() {
		return selectedSet;
	}
	@Override
	public boolean isChecked(Treeitem id) {
		boolean retValue=false;
		if(selectedSet.contains(id) )retValue=true;
		else
		for (Treeitem item : selectedSet) {
			if(item.equals(id)) retValue=true;
		} 
		return retValue;
	}
	
	
	@Override
	public Treeitem getSingleSelectedKey() {
		if (1 != selectedSet.size())
			return null;
		return selectedSet.get(0);
	}
	@Override
	public int getSelectionCount() {
		return selectedSet.size();
	}
	@Override
	public void clear() {
		selectedSet.clear();
		checkboxSelected.stream().forEach(p-> p.setChecked(false));
		notifyListeners();
	}
	@Override
	public void notifyListeners() {
		Events.sendEvent(new Event(CustomEvents.ON_SELECTIONCHANGED, this, new Integer(getSelectionCount())));
	}
	@Override
	public Checkbox buildSelectorColumn(Component parent,Treeitem dr,EventListener<Event> eventlistener) {
		if(null==eventlistener) eventlistener=this::checked;
		if (GridSelectorType.CHECKBOX == getSelectedtype()) {
			Checkbox checkbox = new Checkbox();
			checkbox.setWidth("45px");
			checkbox.setParent(parent);
			checkbox.setAttribute(AttributeConstants.DETACHED_RECORD,dr);
			checkbox.setChecked(isChecked(dr));
			checkbox.addEventListener(Events.ON_CHECK, eventlistener);
			checkboxSelected.add(checkbox);
			return checkbox;
		}
		if (GridSelectorType.RADIO == getSelectedtype()) {
			Radio radio = new Radio();
			radio.setWidth("45px");
			radio.setParent(parent);
			radio.setAttribute(AttributeConstants.DETACHED_RECORD,dr);
			radio.addEventListener(Events.ON_CHECK, eventlistener);
			radio.setChecked(isChecked(dr));
			checkboxSelected.add(radio);
			return radio;
		}
		return null;
	}
	
	@Override
	public void checked(Event event) {
		Treeitem id = (Treeitem) event.getTarget().getAttribute(AttributeConstants.DETACHED_RECORD);
			
			if (null != id) {
				if(getSelectedtype().equals(GridSelectorType.RADIO))
					setSingleSelection(id);
				else 
					set( id,((CheckEvent) event).isChecked());
				Events.sendEvent(CustomEvents.ON_SELECTORCLICK, event.getTarget().getParent(), event.getTarget());
			}
	}
	
	
}