package com.etantolling.testrunner.test.core.db;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashMap;

import org.apache.commons.lang3.ObjectUtils;


public class DetachedRow {
	
	//private static final Logger log = LoggerFactory.getLogger(DetachedRow.class);
	
	private LinkedHashMap<String, Object> originalValues = new LinkedHashMap<String, Object>();
	private LinkedHashMap<String, Object> updates = new LinkedHashMap<String, Object>();
	LinkedHashMap<String, Object> row;
	
	public DetachedRow(){
	}

	public DetachedRow(LinkedHashMap<String, Object> row){
		this.row=row;
		originalValues=(LinkedHashMap<String, Object>) row.clone();
	}
	
	public boolean isUpdated(){
		return updates.size()>0;
	}
	
	public boolean isColumnUpdated(String columnName){
		return updates.containsKey(columnName);
	}
	
	public void set(String columnName, Object value){
		if (!row.containsKey(columnName))
			throw new RuntimeException("columnName: " + columnName + " not found in DetachedRow.set() ");
		if(null == value && (null == originalValues.get(columnName) || null==originalValues.get(columnName)) ) return ;
		if (null == value && null != originalValues.get(columnName) && !(null==originalValues.get(columnName)) ){ 
			updates.put(columnName, ObjectUtils.NULL);
		}else if(null != value && (null == originalValues.get(columnName) || originalValues.get(columnName) instanceof ObjectUtils.Null)){
			updates.put(columnName, value);
		}else if(value instanceof Integer){
			if (!originalValues.get(columnName).toString().equals(value.toString())) 
				updates.put(columnName, value);
		}else if(value instanceof Date){
			if (getSqlDate(originalValues.get(columnName)).getTime()!=getSqlDate(value).getTime()) 
				updates.put(columnName, value);
		}else if ( !originalValues.get(columnName).equals(value)){ 
			updates.put(columnName, value);
			}
	}
	
	public Object get(String columnName){
		Object retValue = internalGet(columnName);
		 return retValue;
	}
	
	public Integer getInteger(String columnName){
		Object retValue = internalGet(columnName);
		if (null==retValue) return null;
		else if (retValue instanceof Integer) return (Integer)retValue;
		else Integer.parseInt(retValue.toString());
		throw new RuntimeException("Can't map field " + columnName + " into an integer");
	}

	public Long getLong(String columnName){
		Object retValue = internalGet(columnName);
		if (null==retValue) return null;
		else if (retValue instanceof Long) return (Long)retValue;
		else if (retValue instanceof BigDecimal) return ((BigDecimal)retValue).longValueExact();
		throw new RuntimeException("Can't map field " + columnName + " into an long");
	}
	
	public java.sql.Date getDate(String columnName){
		Object retValue = null;
		try {
			retValue=internalGet(columnName);
			return getSqlDate(retValue);
		} catch (Exception e) {
			throw new RuntimeException("Can't map field " + columnName + " into an date. Class is: " + retValue.getClass());
		}
		
	}
	
	public java.sql.Date getSqlDate(Object retValue){
		if (null==retValue) 
			return null;
		if (retValue instanceof Timestamp)
			return new java.sql.Date(((Timestamp)retValue).getTime());
		
		else if (retValue instanceof java.sql.Date)
			return (java.sql.Date)retValue;
		else if (retValue instanceof java.util.Date)
			return (new java.sql.Date(((java.util.Date)retValue).getTime()));
		else
			throw new RuntimeException("Can't map field  into an date. Class is: " + retValue.getClass());
	}
	
	
	private Object internalGet(String columnName){
		if (updates.containsKey(columnName)) return updates.get(columnName); 
		if (originalValues.containsKey(columnName)) return originalValues.get(columnName);
		else
			throw new RuntimeException("Field: " + columnName + " not found in DetachedRow ");
	}


	public LinkedHashMap<String, Object> getOriginalValues() {
		return originalValues;
	}

	public LinkedHashMap<String, Object> getUpdates() {
		return updates;
	}
	
	
	public LinkedHashMap<String, Object> getValues() {
		LinkedHashMap<String, Object> retValue= new LinkedHashMap<String, Object>(); 
		for (String field: row.keySet()) {
			if(updates.containsKey(field))
				retValue.put(field, updates.get(field));
			else retValue.put(field,originalValues.get(field));
		}
	return retValue;
	}

	
	public void reset(){
		 updates = new LinkedHashMap<String, Object>();
	}
}