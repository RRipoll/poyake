package com.jsantos.custom.extendedFieldMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.factory.DTOFactory;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.runningTest.TestEventTypeFactory;

public class EventDefinitionMapper implements IFieldMapper{

	

	@Override
	public Object loadValue(ResultSet rs, MTField field) throws SQLException {
		String eventTypeId=rs.getString("eventTypeId");
		IDetachedRecord dr=  DTOFactory.get(TestEventTypeFactory.getProvider(eventTypeId).getMTTable());
		ListValues<IDetachedRecord> jdr=MultipleHelper.getDrsFromJson(TestEventTypeFactory.getProvider(eventTypeId).getMTTable(), rs.getString(field.getName()));
		if(null!=jdr && !jdr.isEmpty()) {
			dr.getOriginalValues().putAll(jdr.get(0).getCopyValues());
		}
		return dr;
	}

	@Override
	public Object unloadValue(MTField field, IDetachedRecord record)  {
		Object value=record.get(field);
		return MultipleHelper.getJsonFromDrs(field, new ListValues<IDetachedRecord>().addValue((IDetachedRecord) value));

	}

	/*
	@Override
	public Object loadValue(IDetachedRecord dr, MTField field) {
		Object value=dr.get(field);
		if(null==value || value instanceof ArrayList) {
			if(((List)value).size()>0 &&  ((List)value).get(0) instanceof DetachedRecord) {
				return value;
			}else { 
				return MultipleHelper.getDrsFromJson(field, dr.get(field));
			}
		}
		return  value;
	}
*/
	@Override
	public MTField forField() {
		
		return MTtestRunnerData.EVENTDEFINITION.EVENTDEFINITION;
	}
	
	
	
}
