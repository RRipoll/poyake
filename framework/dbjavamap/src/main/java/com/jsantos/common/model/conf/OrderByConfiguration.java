package com.jsantos.common.model.conf;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsantos.orm.DBUtil.OrderByItem;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.mt.MTField;

/**
 * @author raul ripoll
 */

public class OrderByConfiguration extends OrderByItem implements IConfiguration {

	@JsonIgnore
	MTField mtField;

	public boolean active = false;
	public boolean hidden = false;
	String label;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public OrderByConfiguration(String name, String label, Boolean asc, boolean active) {
		super(name, asc);
		this.active = active;
		this.label = label;
	}

	public OrderByConfiguration() {
		super();

	}

	public OrderByConfiguration(String name, String stringAsc, String stringDesc, Boolean asc) {
		super(name, stringAsc, stringDesc, asc);
		this.asc = asc;
	}

	@JsonIgnore
	public String getOrder() {

		if (asc && null != stringAsc)
			return stringAsc;
		if (!asc && null != stringDesc)
			return stringDesc;
		return name + " " + (asc ? " asc " : " desc ");
	}

	

	public static OrderByConfiguration get(List<OrderByConfiguration> list, MTField mtField) {
		for (OrderByConfiguration configuration : list) {
			if(null==configuration.getMtField()) {
				System.out.println(ApiError.DATA_ERROR+ "DataGrid Configuration is obsolete");
				return null;
			}if (configuration.getMtField().equals(mtField))
				return configuration;
		}

		return null;

	}

	/*
		
	*/
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@JsonIgnore
	public MTField getMtField() {
		return mtField;
	}

	public void setMtField(MTField mtField) {
		this.mtField = mtField;
	}

	@Override
	public boolean isHidden() {
		return hidden;
	}

	@Override
	public void setHidden(boolean hidden) {
		this.hidden=hidden;
		
	}

}
