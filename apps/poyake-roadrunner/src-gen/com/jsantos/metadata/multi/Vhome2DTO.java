package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class Vhome2DTO extends DetachedRecord{

	public Vhome2DTO(){
		super(MTBase.getTable("VHOME2"));
	}

	public Vhome2DTO(ResultSet rs){
		super(MTBase.getTable("VHOME2"), rs);
	}

	public Vhome2DTO(Integer pk) {
		super(MTBase.getTable("VHOME2"), pk);
	}

	public Vhome2DTO(String whereClause) {
		super(MTBase.getTable("VHOME2"), whereClause);
	}

	public java.lang.Integer getHomeId(){ 
		return (java.lang.Integer) get(MTTableVHOME2.HOMEID);
	}

	public void setHomeId(java.lang.Integer homeId){ 
		set(MTTableVHOME2.HOMEID, homeId);
	} 

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTableVHOME2.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTableVHOME2.POSTINGDATE, postingDate);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVHOME2.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVHOME2.CUSTOMERID, customerId);
	} 

	public java.lang.String getRoom2s(){ 
		return (java.lang.String) get(MTTableVHOME2.ROOM2S);
	}

	public void setRoom2s(java.lang.String room2s){ 
		set(MTTableVHOME2.ROOM2S, room2s);
	} 

	public void update() {
		super.update();
	}

	public Vhome2DTO insert() {
		return (Vhome2DTO) super.insert();
	}

	public static Vhome2DTO find(String whereExpression) {
		try {
			return new Vhome2DTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}