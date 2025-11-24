package com.jsantos.orm.dbstatement;

import com.jsantos.orm.mt.MTTable;

public interface IDetachedResult {

	public MTTable getmTTable();

	public DQResults<IDetachedRecord> getPage(Integer pageNumber);
	
	public Integer getMaxResults();

	public Integer getPageSize();

	public void setPageSize(Integer pageSize) ;

	

}
