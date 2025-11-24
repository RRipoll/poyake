package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class PassDTO extends DetachedRecord{

	public PassDTO(){
		super(MTBase.getTable("PASS"));
	}

	public PassDTO(ResultSet rs){
		super(MTBase.getTable("PASS"), rs);
	}

	public PassDTO(Integer pk) {
		super(MTBase.getTable("PASS"), pk);
	}

	public PassDTO(String whereClause) {
		super(MTBase.getTable("PASS"), whereClause);
	}

	public java.lang.Integer getPassId(){ 
		return (java.lang.Integer) get(MTTablePASS.PASSID);
	}

	public void setPassId(java.lang.Integer passId){ 
		set(MTTablePASS.PASSID, passId);
	} 

	public java.lang.String getFullPassNumber(){ 
		return (java.lang.String) get(MTTablePASS.FULLPASSNUMBER);
	}

	public void setFullPassNumber(java.lang.String fullPassNumber){ 
		set(MTTablePASS.FULLPASSNUMBER, fullPassNumber);
	} 

	public void update() {
		super.update();
	}

	public PassDTO insert() {
		return (PassDTO) super.insert();
	}

	public static PassDTO find(String whereExpression) {
		try {
			return new PassDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}