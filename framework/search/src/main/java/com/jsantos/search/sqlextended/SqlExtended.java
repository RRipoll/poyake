package com.jsantos.search.sqlextended;

import com.jsantos.custom.sqlextended.ISqlExtended;

public  class SqlExtended implements ISqlExtended{

	public SqlExtended() {
		super();
	}
	private String whereClause;
	private String selectClause;
	
	@Override
	public String getWhereClause() {
		return whereClause;
	}
	@Override
	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}
	@Override
	public String getSelectClause() {
		return selectClause;
	}
	@Override
	public void setSelectClause(String selectClause) {
		this.selectClause = selectClause;
	}
}
