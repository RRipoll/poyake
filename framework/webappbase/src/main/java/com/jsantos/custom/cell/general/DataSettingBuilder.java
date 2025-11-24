package com.jsantos.custom.cell.general;

import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTDataType;

public class DataSettingBuilder extends JsonBuilder{

	
	@Override
	public MTDataType forModelType() {

		return MTDataTypes.DATASETTING;
	}
	
}
