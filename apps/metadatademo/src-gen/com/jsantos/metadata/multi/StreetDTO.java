package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class StreetDTO extends DetachedRecord{

	public StreetDTO(){
		super(MTBase.getTable("STREET"));
	}

	public StreetDTO(ResultSet rs){
		super(MTBase.getTable("STREET"), rs);
	}

	public StreetDTO(Integer pk) {
		super(MTBase.getTable("STREET"), pk);
	}

	public StreetDTO(String whereClause) {
		super(MTBase.getTable("STREET"), whereClause);
	}

	public java.lang.Integer getStreetId(){ 
		return (java.lang.Integer) get(MTTableSTREET.STREETID);
	}

	public void setStreetId(java.lang.Integer streetId){ 
		set(MTTableSTREET.STREETID, streetId);
	} 

	public java.lang.String getAddress(){ 
		return (java.lang.String) get(MTTableSTREET.ADDRESS);
	}

	public void setAddress(java.lang.String address){ 
		set(MTTableSTREET.ADDRESS, address);
	} 

	public void update() {
		super.update();
	}

	public StreetDTO insert() {
		return (StreetDTO) super.insert();
	}

	public static StreetDTO find(String whereExpression) {
		try {
			return new StreetDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}