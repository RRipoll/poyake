package com.jsantos.custom.trigger;

import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jsantos.common.util.MapValues;
import com.jsantos.metadata.recorder.EnuRecorderType;
import com.jsantos.metadata.recorder.RecorderDataDTO;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.orm.mt.MTTrigger;

public class RecorderTrigger extends MTTrigger {

	@Override
	public void afterInsert(IDetachedRecord dr) {
		if (dr.getTable().isView())
			return;
		if (!dr.getTable().isRecorder())
			saveData(dr, EnuRecorderType.INSERT);
	}

	@Override
	public void afterUpdate(IDetachedRecord dr) {
		if (dr.getTable().isView())
			return;
		if (!dr.getTable().isRecorder())
			saveData(dr, EnuRecorderType.UPDATE);
	}

	@Override
	public void afterDelete(IDetachedRecord dr) {
		if (dr.getTable().isView())
			return;
		if (!dr.getTable().isRecorder())
			saveData(dr, EnuRecorderType.DELETED);
	}

	public void saveData(IDetachedRecord dr, Integer recorderTypeId) {
		try {
			
			RecorderDataDTO recorder = new RecorderDataDTO();
			recorder.setRecorderTypeId(recorderTypeId);
			recorder.setTableName(dr.getTable().getTableName());
			MapValues<Object> values = MTHelper.getValues(dr.getCopyValues());

			MapValues<Object> dBvalues = new MapValues<Object>();

			for (Entry<String, Object> entry : values.entrySet()) {
				dBvalues.add(entry.getKey(), DBValueMapper.unloadValue(dr.getTable().getField(entry.getKey()), dr));
			}
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
			String json = objectMapper.writeValueAsString(dBvalues);
			recorder.setData(json);
			recorder.insert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
