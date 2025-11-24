package com.jsantos.custom.detail;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;

/**
 * @author raul ripoll
 */

public interface IDetailContainer {

	public IDetailContainer setmTTable(MTTable table); 

	public IDetailContainer buildAndShowComponent(EditMode mode) ;
	
	public IDetailContainer setParent(Component parent);

	public MTTable getmTTable();
	
	public IDetailContainer setInitialParameters(MapValues<Object>initialParameter); 
	
	public IDetailContainer setSearchName(String searchName);
	
	public  IDetailContainer setFormSerialize(IFormSerializer serializer) ;
	
	public IDetailContainer setDetachedRecord(IDetachedRecord dr) ;
	
	public IDetachedRecord getDetachedRecord() ;
	
	public Component getFormComponent();
	
	public default Component init() {return getFormComponent();};
	
	public IDetailContainer buildComponent(EditMode mode) ;
	
	public IDetailContainer showComponent() ;
	
	public boolean isCancelled();

}
