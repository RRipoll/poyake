package com.jsantos.custom.details;


import org.zkoss.zk.ui.Component;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.extendeddto.AppInfoExtDTO;
import com.jsantos.factory.DTOFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.gui.form.controller.MTDefaultDetailScreenController;
import com.jsantos.metadata.MTAuditData;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;


public class InputUserGroupDetails implements IDetailContainer{
	//Integer pk;
	Component parent;
	MTTable mTTable= MTAuditData.INPUTUSERGROUP;
	MTTable childrenMTTable= MTAuditData.VINPUTUSER;
	Component test_list;
	Component extra_list;
	Component header_list;
	EditMode mode=EditMode.AUTO;
	Component comp = null;
	private IDetachedRecord dr;
	MTDefaultDetailScreenController testController;
	
	public InputUserGroupDetails(int pk, Component parent) {
		
		dr= DTOFactory.get(mTTable).findByPk(pk);
		this.parent = parent;
	}
	
	public InputUserGroupDetails() {
		super();
		dr= DTOFactory.get(mTTable);
	}

	public IDetailContainer buildAndShowComponent(EditMode mode) {
		MTField inputUserGroupId=dr.findFieldByname(MTAuditData.APPINFO.INPUTUSERGROUPID.getName());
		if(null==dr.get(inputUserGroupId))
		dr.set(inputUserGroupId, DesktopHelper.getInputUserGroupId());
		buildComponent( mode);
		return showComponent();
		
		
	}
	
	public void reload() {
		comp.detach();
		buildAndShowComponent(mode);
	}
	
	public void setDetails(Component comp) {

	}
	
	

	
	@Override
	public MTTable getmTTable() {
		return mTTable;
	}

	public Component getParent() {
		return parent;
	}
	
	@Override
	public IDetailContainer setParent(Component parent) {
		this.parent = parent;
		return this;
	}

	@Override
	public IDetailContainer setmTTable(MTTable table) {
		mTTable=table;
		return this;
	}

	@Override
	public IDetailContainer setInitialParameters(MapValues<Object> initialParameter) {
		return this;
	}

	@Override
	public IDetailContainer setSearchName(String searchName) {
		return this;
	}

	
	@Override
	public IDetailContainer setDetachedRecord(IDetachedRecord dr) {this.dr=dr; return this;}

	@Override
	public IDetachedRecord getDetachedRecord() {
		return dr;
	}

	@Override
	public Component getFormComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDetailContainer buildComponent(EditMode mode) {

		 testController= new MTDefaultDetailScreenController(dr, parent,mode,null)
				.init();
		
		test_list=testController.getMtForm().getFormComponent().getFellowIfAny("FIELD_LIST");
		extra_list=testController.getMtForm().getFormComponent().getFellowIfAny("EXTRA_DIV");
		header_list=testController.getMtForm().getFormComponent().getFellowIfAny("BUTTON_DIV");
		
		try {
			new CrudScreen()
			.setFilterSection(" and inputuserGroupId=:inputuserGroupId")
			.setInitialParameters(new MapValues<Object>().add("inputuserGroupId", dr.getPk()))
			.init(childrenMTTable,extra_list)
			.setCollapsed(true)
			.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public IDetailContainer showComponent() {
		
			testController.doModal();
		
		
		return this;
	}

	@Override
	public boolean isCancelled() {
		
		return testController.isCancelled();
	}

	@Override
	public IDetailContainer setFormSerialize(IFormSerializer serializer) {
		return this;
	};
	
}
