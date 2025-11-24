package com.jsantos.custom.cell;


import java.util.Locale;

import org.zkoss.zk.ui.Component;

import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;


/**
 * @author javier santos 
 * @author raul ripoll
 */


public interface IGridCellBuilder {
	
	
	public default   MTField forField() {return null;};
	public default   MTDataType forModelType() {return null;};
	
	public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord values, Locale locale);

}
