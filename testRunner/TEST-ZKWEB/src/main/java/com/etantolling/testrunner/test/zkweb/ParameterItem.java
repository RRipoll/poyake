package com.etantolling.testrunner.test.zkweb;

public class ParameterItem {

	public EditorElement editElement;
	boolean isVariable=false;
	boolean isInput=true;
	boolean isOutput=false;
	String label;
	String type;
	Object value;
	
	public String getLabel() {
		return label.trim();
	}
	public void setLabel(String label) {
		this.label = label.trim();
	}
	public boolean isOutput() {
		return isOutput;
	}
	public void setOutput(boolean isOutput) {
		this.isOutput = isOutput;
	}
	
	
	
	
	public ParameterItem(EditorElement editElement , boolean isVariable, boolean isInput,  boolean isOutput, String type,Object value,String label) {
		super();
		this.editElement = editElement;
		this.isVariable = isVariable;
		this.isInput = isInput;
		this.isOutput = isOutput;
		this.type = type;
		this.value=value;
		if(null!=editElement) {
			if(null!=value) editElement.getElement().setRawValue(value);
			if(null!=label) editElement.getLabel().setRawValue(label.trim());
			if(isVariable) editElement.getByReference().setChecked(isVariable);
			else if (null!= editElement.getByValue())editElement.getByValue().setChecked(!isVariable);
			if (null!= editElement.getIsInput())editElement.getIsInput().setChecked(isInput);
			if (null!= editElement.getIsOutput())editElement.getIsOutput().setChecked(isOutput);
		}
	}
	
	public EditorElement getEditElement() {
		return editElement;
	}
	public void setEditElement(EditorElement editElement) {
		this.editElement = editElement;
	}
	public boolean isVariable() {
		return isVariable;
	}
	public void setVariable(boolean isVariable) {
		this.isVariable = isVariable;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public boolean isInput() {
		return isInput;
	}
	public void setInput(boolean isInput) {
		this.isInput = isInput;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
