package com.jsantos.orm.dbstatement;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jsantos.common.util.FieldValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public interface IDetachedRecord {

	IDetachedRecord findByPk(Object pk);

	IDetachedRecord find(String whereExpression, MapValues<Object> params);

	IDetachedRecord find(MTTable table, MapValues<Object> params);

	IDetachedRecord find(MapValues<Object> params);

	IDetachedRecord insert();

	void update();

	Integer getInt(MTField field);

	boolean isUpdated();

	boolean isFieldUpdated(MTField field);

	IDetachedRecord set(ResultSet rs);

	void set(MTField field, Object value);

	Object get(MTField field);

	String getString(MTField field);

	Integer getInteger(MTField field);

	Long getLong(MTField field);

	java.sql.Date getDate(MTField field);

	BigDecimal getBigDecimal(MTField field);

	java.sql.Date getSqlDate(Object retValue);

	ArrayList<MTField> getFields();

	FieldValues getOriginalValues();

	FieldValues getUpdates();

	MTTable getTable();

	void clearModifiedFlags();

	IDetachedRecord load();

	Object getPk();

	void delete();

	String toString();

	MTField findFieldByname(String fieldName);

	void insertOrUpdate();

	MTMapValues<Object> getCopyValues();

	MTMapValues<Object> getCopyValuesToDB();

	IDetachedRecord setValues(MTMapValues<Object> values);

	String getWhereExpression();

	void setWhereExpression(String whereExpression);

	IDetachedRecord getExtendedDetachedRecord();

	void setExtendedDetachedRecord(IDetachedRecord extendedDetachedRecord);

	MapValues<Object> getParams();

	void setParams(MapValues<Object> params);

	boolean equals(Object obj);

}