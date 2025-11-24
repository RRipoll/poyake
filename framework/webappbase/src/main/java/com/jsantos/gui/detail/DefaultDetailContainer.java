package com.jsantos.gui.detail;

import java.util.Map.Entry;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.factory.DTOFactory;
import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.gui.form.controller.MTDefaultDetailScreenController;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;

/**
 * @author raul ripoll
 */

public class DefaultDetailContainer implements IDetailContainer {

	//private Object PK;
	private MTTable mTTable;
	private Component parent;
	private MapValues<Object> initialParameter;
	private String searchName;
	private IFormSerializer serializer;
	private IDetachedRecord dr;
	MTDefaultDetailScreenController editScreen;
	
	

	@Override
	public IDetailContainer buildAndShowComponent(EditMode mode) {
		buildComponent( mode);
		return showComponent();
	}
	
	@Override
	public IDetailContainer buildComponent(EditMode mode) {
		if(null==dr)dr = DTOFactory.get(mTTable);
		if(null!=initialParameter && null==dr.getPk())
			for (Entry<String, Object> element : initialParameter.entrySet()) {
				if(null!=dr.getTable().getField(element.getKey()))
						dr.set(dr.getTable().getField(element.getKey()), element.getValue());
			}
		editScreen = new MTDefaultDetailScreenController(dr, parent,mode,searchName).init();
		if(null!= serializer)editScreen.getMtForm().setSerializer(serializer);
		return this;
	}
	
	
	@Override
	public IDetailContainer showComponent() {
		editScreen.doModal();
		return this;
	}
	

	@Override
	public MTTable getmTTable() {
		return mTTable;
	}

	@Override
	public IDetailContainer setParent(Component parent) {
		this.parent = parent;return this;
	}

	@Override
	public IDetailContainer setmTTable(MTTable table) {
		mTTable=table;return this;
	}

	@Override
	public IDetailContainer setInitialParameters(MapValues<Object> initialParameter) {
		this.initialParameter=initialParameter;return this;
	}

	public String getSearchName() {
		return searchName;
	}

	public IDetailContainer setSearchName(String searchName) {
		this.searchName = searchName;return this;
	}

	@Override
	public IDetailContainer setFormSerialize(IFormSerializer serializer) {
		this.serializer=serializer;return this;
	}

	
	@Override
	public IDetailContainer setDetachedRecord(IDetachedRecord dr) {
		this.dr = dr;return this;
	}

	@Override
	public IDetachedRecord getDetachedRecord() {
		ZulDataWirer.readFormFieldValues(dr, editScreen.getMtForm().getFormComponent());
		return dr;
	}

	public MTDefaultDetailScreenController getEditScreen() {
		return editScreen;
	}

	@Override
	public Component getFormComponent() {
		return editScreen.getMtForm().getFormComponent();
	}

	@Override
	public boolean isCancelled() {
		return editScreen.isCancelled();
	}
}

