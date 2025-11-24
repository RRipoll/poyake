package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class HomeLinkDTO extends DetachedRecord{

	public HomeLinkDTO(){
		super(MTBase.getTable("HOMELINK"));
	}

	public HomeLinkDTO(ResultSet rs){
		super(MTBase.getTable("HOMELINK"), rs);
	}

	public HomeLinkDTO(Integer pk) {
		super(MTBase.getTable("HOMELINK"), pk);
	}

	public HomeLinkDTO(String whereClause) {
		super(MTBase.getTable("HOMELINK"), whereClause);
	}

	public java.lang.Integer getHomeLinkId(){ 
		return (java.lang.Integer) get(MTTableHOMELINK.HOMELINKID);
	}

	public void setHomeLinkId(java.lang.Integer homeLinkId){ 
		set(MTTableHOMELINK.HOMELINKID, homeLinkId);
	} 

	public java.lang.Integer getStreetId(){ 
		return (java.lang.Integer) get(MTTableHOMELINK.STREETID);
	}

	public void setStreetId(java.lang.Integer streetId){ 
		set(MTTableHOMELINK.STREETID, streetId);
	} 

	public java.lang.Integer getHomeId(){ 
		return (java.lang.Integer) get(MTTableHOMELINK.HOMEID);
	}

	public void setHomeId(java.lang.Integer homeId){ 
		set(MTTableHOMELINK.HOMEID, homeId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableHOMELINK.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableHOMELINK.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableHOMELINK.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableHOMELINK.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableHOMELINK.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableHOMELINK.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public HomeLinkDTO insert() {
		return (HomeLinkDTO) super.insert();
	}

	public static HomeLinkDTO find(String whereExpression) {
		try {
			return new HomeLinkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}