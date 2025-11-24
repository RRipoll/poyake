package com.jsantos.metadata.plugin.querymanager.jdbcresolver;

import com.jsantos.metadata.plugin.accessors.DataTypeHelper;
import com.jsantos.metadata.plugin.metaDsl.Configuration;
import com.jsantos.metadata.plugin.metaDsl.DataType;

public class JDBCResolverColumn {
	String name;
	String type;
	Integer size;
	Integer precission;
	Integer scale;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getPrecission() {
		return precission;
	}
	public void setPrecission(Integer precission) {
		this.precission = precission;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	
	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("Name: " + getName() + " type: " + getType() + " size: " + getSize() + " scale: " + getScale() + " precission: " + getPrecission());
		return out.toString();
	}
	
	public String renderType(Configuration configuration){
		String retValue = getType().toUpperCase();
		for (DataType dataType:configuration.getDataTypes()) {
			if (DataTypeHelper.getDbNativeType(dataType).equalsIgnoreCase(type)) {
				if (DataTypeHelper.getDetails(dataType).isWithLength()) 
					retValue += "(" + getSize() + ")";
				if (DataTypeHelper.getDetails(dataType).isWithPrecissionAndScale())
					retValue += "(" + getSize() + "," + getPrecission() + ")";
			}
		}
		return retValue;
	}
}
