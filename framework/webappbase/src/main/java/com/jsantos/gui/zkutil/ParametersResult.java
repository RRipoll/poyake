package com.jsantos.gui.zkutil;

import com.jsantos.common.util.ListValues;
import com.jsantos.orm.dbstatement.DQResults;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedResult;
import com.jsantos.orm.mt.MTTable;

public class ParametersResult implements IDetachedResult{

	MTTable mTTable;
	ListValues<IDetachedRecord> values;
	Integer pageSize;
	
	@Override
	public MTTable getmTTable() {
		return mTTable;
	}

	@Override
	public DQResults<IDetachedRecord> getPage(Integer pageNumber) {
		DQResults<IDetachedRecord> result= new DQResults<IDetachedRecord>();
		result.setPage(pageNumber);
		if(null==pageNumber || null==pageSize)
			result.setRawData(values);
		else  result.setRawData(new ListValues().addAllValues(
				values.subList(pageSize*pageNumber>values.size()?values.size():pageSize*pageNumber, pageSize*(pageNumber+1)>values.size()?values.size():pageSize*(pageNumber+1))
				));
		return result;
	}

	public ParametersResult(MTTable mTTable, ListValues<IDetachedRecord> values, Integer pageSize) {
		super();
		this.mTTable = mTTable;
		this.values = values;
		this.pageSize = pageSize;
	}

	@Override
	public Integer getMaxResults() {
		if(null==values)return null;
		return values.size();
	}

	@Override
	public Integer getPageSize() {
		
		return this.pageSize;
	}

	@Override
	public void setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		
	}

}
