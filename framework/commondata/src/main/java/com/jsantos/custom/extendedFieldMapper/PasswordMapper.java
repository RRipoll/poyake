package com.jsantos.custom.extendedFieldMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.common.util.MD5;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class PasswordMapper implements IFieldMapper {

	
	
	@Override
	public boolean insertOrUpdate(MTField mtField, IDetachedRecord detachedRecord) {
		return IFieldMapper.super.insertOrUpdate( mtField,  detachedRecord);
	}

	@Override
	public Object loadRawValue(Object rawValue, MTField field)  {
		return IFieldMapper.super.loadRawValue( rawValue,  field);
	}

	@Override
	public Object unloadValue(MTField field, IDetachedRecord detachedRecord) {
		String passw=(String) detachedRecord.get(field);
		if(null==passw) return null;
		return MD5.digest(((String) detachedRecord.get(field)).trim());
	}

	@Override
	public MTDataType forModelType() {

		return MTDataTypes.PASSWORD;
	}
}
