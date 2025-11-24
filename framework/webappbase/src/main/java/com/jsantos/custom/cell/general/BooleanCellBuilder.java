package com.jsantos.custom.cell.general;

import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTDataType;

public class BooleanCellBuilder extends BitCellBuilder{

	
	@Override
	public MTDataType forModelType() {
		return MTDataTypes.BOOLEAN;
	}
	
}
