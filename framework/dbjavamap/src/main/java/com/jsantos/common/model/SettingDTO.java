package com.jsantos.common.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsantos.common.model.conf.DetailConfiguration;
import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.model.conf.IConfiguration;
import com.jsantos.common.model.conf.OrderByConfiguration;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

/**
 * @author raul ripoll
 */

public class SettingDTO {
	
	String dataTableName;
	
	@JsonIgnore
	MTTable mtTable;
	
	String aSName;
	
	List<GridColumnConfiguration> columnConfigurations;
	List<OrderByConfiguration> orderByConfigurations;
	List<FilterConfiguration> filterConfigurations;
	List<DetailConfiguration> detailScreenConfigurations;
	List<DetailConfiguration> editConfigurations;
	
	public String getaSName() {
		return aSName;
	}
	public void setaSName(String aSName) {
		this.aSName = aSName;
	}
	
	public String getDataTableName() {
		return dataTableName;
	}
	public void setDataTableName(String dataTableName) {
		this.dataTableName = dataTableName;
	}
	
	public List<GridColumnConfiguration> getColumnConfigurations() {
		return columnConfigurations;
	}
	public void setColumnConfigurations(List<GridColumnConfiguration> columnConfigurations) {
		this.columnConfigurations = columnConfigurations;
	}
	public List<OrderByConfiguration> getOrderByConfigurations() {
		return orderByConfigurations;
	}
	public void setOrderByConfigurations(List<OrderByConfiguration> orderByConfigurations) {
		this.orderByConfigurations = orderByConfigurations;
	}
	public List<FilterConfiguration> getFilterConfigurations() {
		return filterConfigurations;
	}
	public void setFilterConfigurations(List<FilterConfiguration> filterConfigurations) {
		this.filterConfigurations = filterConfigurations;
	}
	public MTField getMTField(IConfiguration config) {
		return MTBase.getTable(getDataTableName()).getField(config.getName());
	}
	@JsonIgnore
	public MTTable getMtTable() {
		return mtTable;
	}
	public void setMtTable(MTTable mtTable) {
		this.mtTable = mtTable;
	}
	public List<DetailConfiguration> getDetailScreenConfigurations() {
		return detailScreenConfigurations;
	}
	public void setDetailScreenConfigurations(List<DetailConfiguration> detailScreenConfigurations) {
		this.detailScreenConfigurations = detailScreenConfigurations;
	}
	public List<DetailConfiguration> getEditConfigurations() {
		return editConfigurations;
	}
	public void setEditConfigurations(List<DetailConfiguration> editConfigurations) {
		this.editConfigurations = editConfigurations;
	}
}
