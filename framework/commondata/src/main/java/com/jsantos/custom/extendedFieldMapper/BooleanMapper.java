package com.jsantos.custom.extendedFieldMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class BooleanMapper implements IFieldMapper {
	@Override
	public  Object loadRawValue(Object rawValue, MTField field){
		Integer value= (Integer) rawValue;
		if(value==1)return true;
		if(value==0)return false;
		return null;
	}
	
	@Override
	public  Object unloadValue(MTField field,IDetachedRecord detachedRecord) {
		Object value= detachedRecord.get(field);
		if(null==value)return null;
		if(value instanceof Boolean)
			return ((Boolean)value)?1:0;
		return value;
		
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.BIT;
	}
	
	
	
}
