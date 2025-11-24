package com.jsantos.custom.extendedFieldMapper;

import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.orm.mt.MTField;

public class CheckParameterMapper extends TrParameterMapper implements IFieldMapper{

	@Override
	public MTField forField() {
		
		return MTtestRunnerData.CHECKPARAMEVENTDEFINITION.PARAMETERS;
	}
	
}
