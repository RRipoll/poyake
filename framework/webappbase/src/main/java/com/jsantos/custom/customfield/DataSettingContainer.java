package com.jsantos.custom.customfield;

import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTDataType;

public class DataSettingContainer extends JsonContainer{

	
	@Override
	public MTDataType forModelType() {
		return MTDataTypes.DATASETTING;
	}
	
}
