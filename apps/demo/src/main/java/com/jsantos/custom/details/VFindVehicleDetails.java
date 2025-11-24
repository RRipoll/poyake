package com.jsantos.custom.details;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.gui.form.controller.MTInsertScreenController;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.MTAuditData;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;

public class VFindVehicleDetails implements IDetailContainer{
	
	Integer pk;
	Component parent;
	MTTable mTTable= MT.VFINDVEHICLE;
	MTTable childrenMTTable= MTAuditData.VINPUTUSER;
	Component test_list;
	Component extra_list;
	Component header_list;
	MapValues<Object> initialParameter;
	Component comp = null;
	String searchName;
	boolean isCancelled=false;
	
	

	@Override
	public IDetailContainer setmTTable(MTTable table) {
		mTTable=table;return this;
	}

	@Override
	public IDetailContainer buildAndShowComponent(EditMode mode) {

		MTInsertScreenController screen = new MTInsertScreenController(parent, MT.LICENSEPLATE, MT.VEHICLEINFO,MT.CUSTOMERVEHICLE);
		//CustomerVehicleDTO customerVehicle = new CustomerVehicleDTO();
		//customerVehicle.setCustomerId((Integer) initialParameter.get(MT.CUSTOMERVEHICLE.CUSTOMERID.toString()));
		//screen.getMtForm().addDetachedRecord(customerVehicle);
		screen.doModal();return this;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getFormComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDetailContainer buildComponent(EditMode mode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDetailContainer showComponent() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isCancelled() {
		
		return isCancelled;
	}

	@Override
	public IDetailContainer setDetachedRecord(IDetachedRecord dr) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IDetailContainer setFormSerialize(IFormSerializer serializer) {
		// TODO Auto-generated method stub
		return this;
	}
}
