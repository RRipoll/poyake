package com.jsantos.custom.customfield;

import com.jsantos.gui.zkcomponent.MTCheckBox;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTDataType;

public class MTBitCheckBox extends MTCheckBox  implements IMTComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getValue() {
		return (boolean) super.getValue()?1:0;
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.EVENTSELECTED;
	}

	
	
	
}
