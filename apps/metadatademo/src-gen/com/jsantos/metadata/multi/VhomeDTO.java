package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VhomeDTO extends DetachedRecord{

	public VhomeDTO(){
		super(MTBase.getTable("VHOME"));
	}

	public VhomeDTO(ResultSet rs){
		super(MTBase.getTable("VHOME"), rs);
	}

	public VhomeDTO(Integer pk) {
		super(MTBase.getTable("VHOME"), pk);
	}

	public VhomeDTO(String whereClause) {
		super(MTBase.getTable("VHOME"), whereClause);
	}

	public java.lang.Integer getHomeId(){ 
		return (java.lang.Integer) get(MTTableVHOME.HOMEID);
	}

	public void setHomeId(java.lang.Integer homeId){ 
		set(MTTableVHOME.HOMEID, homeId);
	} 

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTableVHOME.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTableVHOME.POSTINGDATE, postingDate);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVHOME.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVHOME.CUSTOMERID, customerId);
	} 

	public java.lang.String getRooms(){ 
		return (java.lang.String) get(MTTableVHOME.ROOMS);
	}

	public void setRooms(java.lang.String rooms){ 
		set(MTTableVHOME.ROOMS, rooms);
	} 

	public void update() {
		super.update();
	}

	public VhomeDTO insert() {
		return (VhomeDTO) super.insert();
	}

	public static VhomeDTO find(String whereExpression) {
		try {
			return new VhomeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}