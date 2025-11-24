package com.jsantos.common.model.conf;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsantos.orm.mt.MTField;

/**
 * @author raul ripoll
 */


public class DetailConfiguration implements IConfiguration {

	@JsonIgnore
	MTField mtField;

	String Name;

	private boolean Active = true;
	private boolean Available = true;
	private boolean hidden;
	private List<Object> values;// = Arrays.asList(1,2,3,4,5,6);
	private boolean newLine = false;
	private String sClass = "col-md-4";
	private boolean required;
	private String previousLabel;
	private List<String> Constraints;
	private List<ActionConstraints> actions;

	public DetailConfiguration() {

	}

	public DetailConfiguration(String name) {
		this.Name = name;
		
	}

	

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public boolean isAvailable() {
		return Available;
	}

	public void setAvailable(boolean available) {
		Available = available;
	}

	
	

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public static FilterConfiguration get(List<FilterConfiguration> list, MTField mtField) {

		for (FilterConfiguration configuration : list) {
			if (configuration.getMtField().equals(mtField))
				return configuration;
		}

		return null;

	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public List<Object> getValues() {
		return values;
	}

	public void setValues(List<Object> values) {
		this.values = values;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@JsonIgnore
	public MTField getMtField() {
		return mtField;
	}

	public void setMtField(MTField mtField) {
		this.mtField = mtField;
	}

	public boolean isNewLine() {
		return newLine;
	}

	public void setNewLine(boolean newLine) {
		this.newLine = newLine;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}



	public List<String> getConstraints() {
		return Constraints;
	}

	public void setConstraints(List<String> constraints) {
		Constraints = constraints;
	}

	public List<ActionConstraints> getActions() {
		return actions;
	}

	public void setActions(List<ActionConstraints> actions) {
		this.actions = actions;
	}

	public String getPreviousLabel() {
		return previousLabel;
	}

	public void setPreviousLabel(String previousLabel) {
		this.previousLabel = previousLabel;
	}

}
