package com.etantolling.testrunner.test.core.metadata;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class MTTable {
	public abstract LinkedHashMap<String, MTField> getFields();
	protected String tableName;
	protected List<MTField> primaryKeys = new ArrayList<MTField>();
	protected Boolean isEnumeration = false;
	protected MTEnumeration enumeration = null;
	protected String idField = null;
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String toString(){
		return tableName;
	}
	
	public List<MTField> getPrimaryKeys(){
		if (null != primaryKeys) 
			return primaryKeys;
		
		for (MTField field:getFields().values()) { 
			if (field.isPrimaryKey()) { 
				primaryKeys.add(field);
			}
		}

		return primaryKeys;
	}
	
	public MTField getPrimaryKey() {
		for (MTField field: getPrimaryKeys()) {
			if (! field.getName().equalsIgnoreCase("REV")) {
				return field;
			}
		}
		return null;
	}
	
	public MTField getField(String fieldName){
		return getFields().get(fieldName.toUpperCase());
	}
	
	public MTField getIdField(){
		//for now we will just guess. There will be a way to register the id field in the META_fields table in the database
		return guessDefaultIdField();
	}
	
	public MTField guessDefaultIdField(){
		if (null != idField) return getField(idField);
		if (null != getField("Name")) return getField("Name");
		else if (null != getField(getTableName() + "Name")) return getField(getTableName() + "Name");
		if (null != getField("Description")) return getField("Description");
		if (getTableName().startsWith("EN_")){
			String tableName = getTableName().substring(3, getTableName().length());
			if (null != getField(tableName + "Name")) return getField(tableName + "Name");
		}
		for (MTField field:getFields().values()){
			if (field.getName().toUpperCase().contains("NAME"))
				return field;
		}
		
		return null;
	}

	public Boolean getIsEnumeration() {
		return isEnumeration;
	}

	public void setIsEnumeration(Boolean isEnumeration) {
		this.isEnumeration = isEnumeration;
	}
	
	public String getEnumerationValue(Integer key){
		return enumeration.getValue(key);
	}

	public MTEnumeration getEnumeration(){
		return enumeration;
	}

	@Override
	public boolean equals(Object obj) {
		return obj.toString().equals(this.toString());
	}

}
