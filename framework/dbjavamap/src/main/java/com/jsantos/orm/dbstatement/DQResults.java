package com.jsantos.orm.dbstatement;

import com.jsantos.common.util.ListValues;


public class DQResults<T> {

	Integer page;
	Integer size;
	Integer total;
	
	 ListValues<T> rawData;

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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public  ListValues<T> getRawData() {
		return rawData;
	}

	public  void setRawData(ListValues<T> results) {
		this.rawData =  results;
	}
}

