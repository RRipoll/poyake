package com.jsantos.common.fieldMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public interface IFieldMapper {

	public default   MTField forField() {return null;};
	public default   MTDataType forModelType() {return null;};
	
	public default boolean insertOrUpdate(MTField mtField,IDetachedRecord detachedRecord) {
		return false;
	}
	public default Object loadRawValue(Object rawValue, MTField field)  {
		return rawValue;
	}
	
	public default Object loadValue(ResultSet rs, MTField field) throws SQLException {
		return loadRawValue(rs.getObject(field.getName()),field);
	}
	public default Object loadValue(IDetachedRecord dr, MTField field) {
		return dr.get(field);
	}
	
	public default Object unloadValue(MTField field,IDetachedRecord detachedRecord) {
		return detachedRecord.get(field);
	}
}
