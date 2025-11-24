package com.jsantos.metadata.plugin.querymanager.resolver;

import com.jsantos.metadata.plugin.metaDsl.Attribute;

public class ResolverColumn {
	String attributeName;
	Attribute sameAsAttribute;
	ResolverColumnStatus status = ResolverColumnStatus.ATTRIBUTE_NOT_FOUND;
	String dataTypeFromJDBC;
	
	public ResolverColumn(String attributeName) {
		this.attributeName = attributeName;
	}
	
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public Attribute getSameAsAttribute() {
		return sameAsAttribute;
	}
	public void setSameAsAttribute(Attribute sameAsAttribute) {
		this.sameAsAttribute = sameAsAttribute;
	}
	public ResolverColumnStatus getStatus() {
		return status;
	}
	public void setStatus(ResolverColumnStatus status) {
		this.status = status;
	}

	public String getDataTypeFromJDBC() {
		return dataTypeFromJDBC;
	}

	public void setDataTypeFromJDBC(String dataTypeFromJDBC) {
		this.dataTypeFromJDBC = dataTypeFromJDBC;
	}
	
	
}
