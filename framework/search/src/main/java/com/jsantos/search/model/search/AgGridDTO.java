package com.jsantos.search.model.search;

import java.util.List;

import com.jsantos.common.util.MapValues;


/**
 * @author raul ripoll
 */


public class AgGridDTO {
	//@ApiModelProperty("Header details ")
	List<ColumnDTO>columnDef;
	//@ApiModelProperty("Array of Data")
	List<MapValues<Object>> rawData;
	//@ApiModelProperty("number total of results")
	Integer total;
	//@ApiModelProperty("number of the page shown")
	Integer page;
	//@ApiModelProperty("Size of the page shown")
	Integer size;
	public List<ColumnDTO> getColumnDef() {
		return columnDef;
	}
	public void setColumnDef(List<ColumnDTO> columnDef) {
		this.columnDef = columnDef;
	}
	public List<MapValues<Object>> getRawData() {
		return rawData;
	}
	public void setRawData(List<MapValues<Object>> list) {
		this.rawData = list;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
