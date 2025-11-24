package com.jsantos.template;

import java.util.Map;

public class TemplateData {
	
	private Integer templateTypeId;
	private Map<String, Object> data;
	private String Name;
	
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public Integer getTemplateTypeId() {
		return templateTypeId;
	}
	public void setTemplateTypeId(Integer templateTypeId) {
		this.templateTypeId = templateTypeId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
