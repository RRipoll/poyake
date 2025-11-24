package com.jsantos.custom.details;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Window;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.gui.datagrid4.EntityGrid;
import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.metadata.MTroadRunnerData;
import com.jsantos.metadata.tolling.TripInfoDTO;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;

public class TripDetails  implements IDetailContainer {
	
	
	Window window;
	//Integer pk;
	Component parent;
	MTTable mTTable= MTroadRunnerData.TRIP;
	MapValues<Object> initialParameter;
	String searchName;
	 boolean isCancelled=false;
	 IDetachedRecord detachedRecord;
	
	 
	 /*
	public void buildScreen(Integer tripId, Component parent) throws  Exception {
		pk=tripId;
		this.parent=parent;
		buildAndShowComponent(null);
		
	}
	*/	
	@Override
	public IDetailContainer buildAndShowComponent(EditMode mode) {
       Integer pk=(Integer) getDetachedRecord().getPk();
	
		window = (Window)Executions.createComponents("~./zul/poyake-roadrunner/screen/trip/trip_details.zul", parent, null);
		window.getFellowIfAny("DETAILS_BUTTON_CLOSE").addEventListener(Events.ON_CLICK, this::cancelWindow);
		ZulDataWirer.initializeFieldValues(new TripInfoDTO(pk), window);

		EntityGrid paymentsGrid = new EntityGrid(new DetachedQueryResult(MTroadRunnerData.VTRIPPAYMENT, " and tripId=" + pk),null).init();
		paymentsGrid.setPageSize(10);
		paymentsGrid.setShowPageSizeSelector(false);
		paymentsGrid.buildGrid().setParent(window.getFellow("PAYMENTS_GRID"));


		window.doModal();return this;
	}

	public void closeWindow(Event evt) {
		window.detach();
	}
	void cancelWindow(Event event) {
		isCancelled=true;
		closeWindow(event);;
	}
	
	@Override
	public IDetailContainer setmTTable(MTTable table) {
		mTTable=table;return this;
	}
	@Override
	public IDetailContainer setParent(Component parent) {
		this.parent = parent;return this;
	}

	@Override
	public MTTable getmTTable() {
		return mTTable;
	}
	@Override
	public IDetailContainer setInitialParameters(MapValues<Object> initialParameter) {
		this.initialParameter=initialParameter;return this;
	}

	@Override
	public IDetailContainer setSearchName(String searchName) {
		this.searchName=searchName;return this;
	}

	

	@Override
	public IDetachedRecord getDetachedRecord() {
		
		return detachedRecord;
	}

	@Override
	public Component getFormComponent() {
		
		return window;
	}

	@Override
	public IDetailContainer buildComponent(EditMode mode) {
		
		return null;
	}

	@Override
	public IDetailContainer showComponent() {
		
		return this;
	}
	@Override
	public boolean isCancelled() {
		
		return isCancelled;
	}

	@Override
	public IDetailContainer setDetachedRecord(IDetachedRecord dr) {
		this.detachedRecord=dr;
		return this;
	}

	@Override
	public IDetailContainer setFormSerialize(IFormSerializer serializer) {
		// TODO Auto-generated method stub
		return this;
	}
}
