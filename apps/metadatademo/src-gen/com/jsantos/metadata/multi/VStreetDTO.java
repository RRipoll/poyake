package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VStreetDTO extends DetachedRecord{

	public VStreetDTO(){
		super(MTBase.getTable("VSTREET"));
	}

	public VStreetDTO(ResultSet rs){
		super(MTBase.getTable("VSTREET"), rs);
	}

	public VStreetDTO(Integer pk) {
		super(MTBase.getTable("VSTREET"), pk);
	}

	public VStreetDTO(String whereClause) {
		super(MTBase.getTable("VSTREET"), whereClause);
	}

	public java.lang.Integer getStreetId(){ 
		return (java.lang.Integer) get(MTTableVSTREET.STREETID);
	}

	public void setStreetId(java.lang.Integer streetId){ 
		set(MTTableVSTREET.STREETID, streetId);
	} 

	public java.lang.String getAddress(){ 
		return (java.lang.String) get(MTTableVSTREET.ADDRESS);
	}

	public void setAddress(java.lang.String address){ 
		set(MTTableVSTREET.ADDRESS, address);
	} 

	public java.lang.String getHomes(){ 
		return (java.lang.String) get(MTTableVSTREET.HOMES);
	}

	public void setHomes(java.lang.String homes){ 
		set(MTTableVSTREET.HOMES, homes);
	} 

	public void update() {
		super.update();
	}

	public VStreetDTO insert() {
		return (VStreetDTO) super.insert();
	}

	public static VStreetDTO find(String whereExpression) {
		try {
			return new VStreetDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}