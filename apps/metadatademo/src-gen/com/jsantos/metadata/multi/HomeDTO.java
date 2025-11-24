package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class HomeDTO extends DetachedRecord{

	public HomeDTO(){
		super(MTBase.getTable("HOME"));
	}

	public HomeDTO(ResultSet rs){
		super(MTBase.getTable("HOME"), rs);
	}

	public HomeDTO(Integer pk) {
		super(MTBase.getTable("HOME"), pk);
	}

	public HomeDTO(String whereClause) {
		super(MTBase.getTable("HOME"), whereClause);
	}

	public java.lang.Integer getHomeId(){ 
		return (java.lang.Integer) get(MTTableHOME.HOMEID);
	}

	public void setHomeId(java.lang.Integer homeId){ 
		set(MTTableHOME.HOMEID, homeId);
	} 

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTableHOME.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTableHOME.POSTINGDATE, postingDate);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableHOME.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableHOME.CUSTOMERID, customerId);
	} 

	public java.lang.String getName(){ 
		return (java.lang.String) get(MTTableHOME.NAME);
	}

	public void setName(java.lang.String name){ 
		set(MTTableHOME.NAME, name);
	} 

	public void update() {
		super.update();
	}

	public HomeDTO insert() {
		return (HomeDTO) super.insert();
	}

	public static HomeDTO find(String whereExpression) {
		try {
			return new HomeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}