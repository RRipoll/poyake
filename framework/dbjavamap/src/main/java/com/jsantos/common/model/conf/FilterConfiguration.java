package com.jsantos.common.model.conf;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsantos.common.model.SearchParameter.CompareType;
import com.jsantos.common.model.SearchParameter.Formatter;
import com.jsantos.common.model.SearchParameter.Operator;
import com.jsantos.common.util.ListValues;
import com.jsantos.orm.mt.MTField;

/**
 * @author raul ripoll
 */


public class FilterConfiguration implements IConfiguration {

	@JsonIgnore
	MTField mtField;

	String Name;

	private boolean Active = true;
	private boolean Available = true;
	private boolean hidden;
	private ListValues<Formatter> formatters;
	private ListValues<Object> values;// = Arrays.asList(1,2,3,4,5,6);
	private Operator operator;
	private boolean required;
	private CompareType compareType;

	public FilterConfiguration() {

	}

	public FilterConfiguration(String name) {
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

	public ListValues<Formatter> getFormatters() {
		return formatters;
	}

	public void setFormatters(ListValues<Formatter> formatters) {
		this.formatters = formatters;
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
	
	public static FilterConfiguration get(List<FilterConfiguration> list, String mtFieldName) {

		for (FilterConfiguration configuration : list) {
			if (configuration.getMtField().getName().equals(mtFieldName))
				return configuration;
		}

		return null;

	}

	public Operator getOperator() {
		if (null == operator)
			operator = Operator.EQUAL;
		return operator;
	}

	public void setOperator(Operator le) {
		this.operator = le;
	}

	
	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public CompareType getCompareType() {
		return compareType;
	}

	public void setCompareType(CompareType compareType) {
		this.compareType = compareType;
	}

	public ListValues<Object> getValues() {
		return values;
	}

	public void setValues(ListValues<Object> values) {
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
}
