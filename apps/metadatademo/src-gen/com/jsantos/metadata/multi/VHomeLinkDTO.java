package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VHomeLinkDTO extends DetachedRecord{

	public VHomeLinkDTO(){
		super(MTBase.getTable("VHOMELINK"));
	}

	public VHomeLinkDTO(ResultSet rs){
		super(MTBase.getTable("VHOMELINK"), rs);
	}

	public VHomeLinkDTO(Integer pk) {
		super(MTBase.getTable("VHOMELINK"), pk);
	}

	public VHomeLinkDTO(String whereClause) {
		super(MTBase.getTable("VHOMELINK"), whereClause);
	}

	public java.lang.Integer getHomeLinkId(){ 
		return (java.lang.Integer) get(MTTableVHOMELINK.HOMELINKID);
	}

	public void setHomeLinkId(java.lang.Integer homeLinkId){ 
		set(MTTableVHOMELINK.HOMELINKID, homeLinkId);
	} 

	public java.lang.Integer getStreetId(){ 
		return (java.lang.Integer) get(MTTableVHOMELINK.STREETID);
	}

	public void setStreetId(java.lang.Integer streetId){ 
		set(MTTableVHOMELINK.STREETID, streetId);
	} 

	public java.lang.Integer getHomeId(){ 
		return (java.lang.Integer) get(MTTableVHOMELINK.HOMEID);
	}

	public void setHomeId(java.lang.Integer homeId){ 
		set(MTTableVHOMELINK.HOMEID, homeId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableVHOMELINK.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableVHOMELINK.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableVHOMELINK.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableVHOMELINK.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableVHOMELINK.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableVHOMELINK.INPUTSOURCEID, inputSourceId);
	} 

	public java.lang.String getName(){ 
		return (java.lang.String) get(MTTableVHOMELINK.NAME);
	}

	public void setName(java.lang.String name){ 
		set(MTTableVHOMELINK.NAME, name);
	} 

	public void update() {
		super.update();
	}

	public VHomeLinkDTO insert() {
		return (VHomeLinkDTO) super.insert();
	}

	public static VHomeLinkDTO find(String whereExpression) {
		try {
			return new VHomeLinkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}