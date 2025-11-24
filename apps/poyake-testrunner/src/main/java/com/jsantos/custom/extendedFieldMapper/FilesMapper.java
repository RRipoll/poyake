package com.jsantos.custom.extendedFieldMapper;

import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public class FilesMapper implements IFieldMapper{

	@Override
	public MTField forField() {
		
		return null;//MTtestRunnerData.TESTEVENT.FILES;
	}

	@Override
	public Object loadValue(IDetachedRecord dr, MTField field) {
		// TODO Auto-generated method stub
		return IFieldMapper.super.loadValue(dr, field);
	}

	@Override
	public Object unloadValue(MTField field, IDetachedRecord detachedRecord) {
		// TODO Auto-generated method stub
		return IFieldMapper.super.unloadValue(field, detachedRecord);
	}

}
