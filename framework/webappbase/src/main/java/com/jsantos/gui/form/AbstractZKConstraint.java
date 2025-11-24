package com.jsantos.gui.form;

public class AbstractZKConstraint {
	
	private String fieldLabel;
	private String customErrorMessage;
	private Object dependentData;
	
	public AbstractZKConstraint(String fieldLabel, String customErrorMessage, Object dependentData){
		this.fieldLabel = fieldLabel;
		this.customErrorMessage = customErrorMessage;
		this.dependentData = dependentData;
	}
	
	public String getFieldLabel() {
		return fieldLabel;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public String getCustomErrorMessage() {
		return customErrorMessage;
	}

	public void setCustomErrorMessage(String customErrorMessage) {
		this.customErrorMessage = customErrorMessage;
	}

	public Object getDependentData() {
		return dependentData;
	}

	public void setDependentData(Object dependentData) {
		this.dependentData = dependentData;
	}

	
	
}
