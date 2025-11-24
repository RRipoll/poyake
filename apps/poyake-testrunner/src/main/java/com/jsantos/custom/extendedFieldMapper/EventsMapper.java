package com.jsantos.custom.extendedFieldMapper;

import java.util.Collection;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.factory.DTOFactory;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.runningTest.TestEventTypeFactory;
import com.jsantos.service.ITestEventRunner;

public class EventsMapper implements IFieldMapper{

	@Override
	public MTField forField() {
		
		return  MTtestRunnerData.TEST.EVENTS;
	}
	@Override
	public Object loadRawValue(Object rawValue, MTField field){
		
		Object value=rawValue;
		ListValues<LinkedHashMap<String, Object>> valueParsed;
		ObjectMapper mapper = new ObjectMapper();
		if(value instanceof String) {
			try {
				valueParsed = mapper.readValue(value.toString(),
					(new ListValues<LinkedHashMap<String, Object>>()).getClass());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new ApiException(ApiError.PARSING_ERROR, "Wrong Data in Db");
			}
		}else valueParsed=new ListValues<LinkedHashMap<String, Object>>().addAllValues((Collection<? extends LinkedHashMap<String, Object>>) value);
		
		ListValues<IDetachedRecord> drs = new ListValues<IDetachedRecord>();
		for (LinkedHashMap<String, Object> pdRecord : valueParsed) {
			
			String eventTypeId=(String) pdRecord.get("eventTypeId");
			IDetachedRecord dr=  DTOFactory.get(TestEventTypeFactory.getProvider(eventTypeId).getMTTable());
			dr.getOriginalValues().putAll(MTHelper.getValues(new MapValues<Object>().add(pdRecord), dr.getTable().getTableName()));
			drs.add(dr);

		}
		return drs;
	}

	@Override
	public Object unloadValue(MTField field, IDetachedRecord record)  {
		Object value=record.get(field);
		ListValues<IDetachedRecord> values=new ListValues<IDetachedRecord>();
		if(value instanceof IDetachedRecord) {
			String eventType=(String) ((IDetachedRecord)value).get(((IDetachedRecord)value).findFieldByname("eventTypeId"));
			ITestEventRunner testEvenrunner = TestEventTypeFactory.getProvider(eventType);
			values.add((IDetachedRecord)testEvenrunner.mapper(record));
		}else {
			if(null!=value)
				for(IDetachedRecord pdRecord : (ListValues<IDetachedRecord>) value) {
					String eventType=(String) pdRecord.get(pdRecord.findFieldByname("eventTypeId"));
					ITestEventRunner testEvenrunner = TestEventTypeFactory.getProvider(eventType);
					values.add((IDetachedRecord)testEvenrunner.mapper(pdRecord));
				}		
		}
		return MultipleHelper.getJsonFromDrs(field, values);
	}
}
