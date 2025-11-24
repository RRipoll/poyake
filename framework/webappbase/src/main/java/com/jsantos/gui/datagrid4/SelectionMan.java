package com.jsantos.gui.datagrid4;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Radio;

import com.jsantos.common.util.ListValues;
import com.jsantos.gui.CustomEvents;

import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.search.AttributeConstants;

public class SelectionMan extends Div implements ISelectionMan<IDetachedRecord> { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ListValues<IDetachedRecord> selectedSet = new ListValues<IDetachedRecord>().setNotNull(true).setNotRepeted(true);
	@Override
	public ListValues<IDetachedRecord> getSelectedSet() {
		return selectedSet;
	}

	@Override
	public void setSelectedSet(ListValues<IDetachedRecord> selectedSet) {
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
	public void set(IDetachedRecord id, boolean checked) {
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
	public boolean add(IDetachedRecord o) {
		 for (IDetachedRecord detachedRecord : (ListValues<IDetachedRecord>)selectedSet.clone()) {
			if(o.getPk()==detachedRecord.getPk()) {
				selectedSet.remove(detachedRecord);
			}
		 }
		 selectedSet.add(o);
		 return true;
		
	}
	
	 @Override
	public boolean remove(IDetachedRecord removedObject) {
		boolean retValue=false;
		for (IDetachedRecord detachedRecord : (ListValues<IDetachedRecord>)selectedSet.clone()) {
			if(null!=detachedRecord.getPk() && removedObject.getPk().toString().equals(detachedRecord.getPk().toString())) {
				selectedSet.remove(detachedRecord);
				retValue=true;
		}}
		 return retValue;
	 }
	
	
	@Override
	public void setSingleSelection(IDetachedRecord id) {
		if (selectedtype != GridSelectorType.CHECKBOX)
			selectedSet.clear();
		selectedSet.add(id);
		notifyListeners();
	}

	public SelectionMan(GridSelectorType selectorType) {
		super();
		this.selectedtype = selectorType;
	}

	@Override
	public ListValues<IDetachedRecord> getChecked() {
		return selectedSet;
	}

	@Override
	public boolean isChecked(IDetachedRecord id) {
		if(null==id)return false;
		boolean retValue=false;
		try {
			if( selectedSet.contains(id) )retValue=true;
			else
			for (IDetachedRecord detachedRecord : selectedSet) {
				if(detachedRecord.equals(id)) retValue=true;
			} 
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return retValue;
	}
	
	

	@Override
	public IDetachedRecord getSingleSelectedKey() {
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
		notifyListeners();
	}
	@Override
	public void notifyListeners() {
		Events.sendEvent(new Event(CustomEvents.ON_SELECTIONCHANGED, this, new Integer(getSelectionCount())));
	}
	@Override
	public Checkbox buildSelectorColumn(Component parent,IDetachedRecord dr,EventListener<Event> eventlistener) {
		if(null==eventlistener) eventlistener=this::checked;
		if (GridSelectorType.CHECKBOX == getSelectedtype()) {
			Checkbox checkbox = new Checkbox();
			checkbox.setWidth("45px");
			checkbox.setParent(parent);
			checkbox.setAttribute(AttributeConstants.DETACHED_RECORD,dr);
			checkbox.setChecked(isChecked(dr));
			checkbox.addEventListener(Events.ON_CHECK, eventlistener);
			return checkbox;
		}else if (GridSelectorType.RADIO == getSelectedtype()) {
			Radio radio = new Radio();
			radio.setWidth("45px");
			radio.setParent(parent);
			radio.setAttribute(AttributeConstants.DETACHED_RECORD,dr);
			radio.addEventListener(Events.ON_CHECK, eventlistener);
			radio.setChecked(isChecked(dr));
			return radio;
		}
		return null;
	}
	
	
	@Override
	public void checked(Event event) {
		IDetachedRecord id = (IDetachedRecord) event.getTarget().getAttribute(AttributeConstants.DETACHED_RECORD);
			
			if (null != id) {
				if(getSelectedtype().equals(GridSelectorType.RADIO))
					setSingleSelection(id);
				else 
					set( id,((CheckEvent) event).isChecked());
				Events.sendEvent(CustomEvents.ON_SELECTORCLICK, event.getTarget().getParent(), event.getTarget());
			}
	}

	
		
	
	
	
}
