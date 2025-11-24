package com.jsantos.custom.extendeddto.extendedfieldMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.metadata.MTDataGridSettingData;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTField;

public class SettingMapper implements IFieldMapper {

	
	
	@Override
	public Object loadValue(IDetachedRecord dr, MTField field) {
		Object value=dr.get(field);
		if(value instanceof SettingDTO)
			return value;
		ObjectMapper mapper = new ObjectMapper();
		try {
			SettingDTO settingDTO = mapper.readValue(value.toString(), SettingDTO.class);
			return settingDTO;
		} catch (Exception e) {
			throw new ApiException(ApiError.DATA_ERROR, "Wrong Data in Db");
		}
	}

	@Override
	public boolean insertOrUpdate(MTField mtField, IDetachedRecord detachedRecord) {
		return IFieldMapper.super.insertOrUpdate( mtField,  detachedRecord);
	}

	@Override
	public Object loadRawValue(Object rawValue, MTField field) {
		
		String data = (String) rawValue;
		ObjectMapper mapper = new ObjectMapper();
		try {
			SettingDTO settingDTO = mapper.readValue(data, SettingDTO.class);
			return settingDTO;
		} catch (Exception e) {
			throw new ApiException(ApiError.DB_BAD_SQL, "Wrong Data in Db");
		}
		
	}

	public Object load(Object data) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			SettingDTO settingDTO = mapper.readValue(data.toString(), SettingDTO.class);
			return settingDTO;
		} catch (Exception e) {
			throw new ApiException(ApiError.DB_BAD_SQL, "Wrong Data in Db");
		}
	}
	
	
	@Override
	public Object unloadValue(MTField field, IDetachedRecord detachedRecord) {
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			String data = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(detachedRecord.get(MTDataGridSettingData.DATAGRIDSETTING.DATA)));
			
			return data;
			
		} catch (JsonProcessingException e) {
			throw new ApiException(ApiError.DB_BAD_METADATA, "Wrong Data");
		}
		
		
		
		
	}

	@Override
	public MTField forField() {

		return MTDataGridSettingData.DATAGRIDSETTING.DATA;
	}
}
