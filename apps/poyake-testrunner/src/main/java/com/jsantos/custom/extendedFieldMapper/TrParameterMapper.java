package com.jsantos.custom.extendedFieldMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class TrParameterMapper implements IFieldMapper{

	@Override
	public MTDataType forModelType() {
		
		return MTDataTypes.PARAMETER;
	}

	@Override
	public Object loadRawValue(Object rawValue, MTField field){
		
		return MultipleHelper.getDrsFromJson(field.getMultiRefTo(), rawValue);

	}

	@Override
	public Object unloadValue(MTField field, IDetachedRecord record)  {
		
		return MultipleHelper.getJsonFromDrs(field, (ListValues<IDetachedRecord>) record.get(field));

	}

	
	@Override
	public Object loadValue(IDetachedRecord dr, MTField field) {
		Object value=dr.get(field);
		if(null==value || value instanceof ArrayList) {
			if(((List)value).size()>0 &&  ((List)value).get(0) instanceof DetachedRecord) {
				return value;
			}else { 
				return MultipleHelper.getDrsFromJson(field.getMultiRefTo(), dr.get(field));
			}
		}
		return  value;
	}
	
	
	
}
