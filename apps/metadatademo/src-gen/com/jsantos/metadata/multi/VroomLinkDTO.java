package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VroomLinkDTO extends DetachedRecord{

	public VroomLinkDTO(){
		super(MTBase.getTable("VROOMLINK"));
	}

	public VroomLinkDTO(ResultSet rs){
		super(MTBase.getTable("VROOMLINK"), rs);
	}

	public VroomLinkDTO(Integer pk) {
		super(MTBase.getTable("VROOMLINK"), pk);
	}

	public VroomLinkDTO(String whereClause) {
		super(MTBase.getTable("VROOMLINK"), whereClause);
	}

	public java.lang.Integer getRoomLinkId(){ 
		return (java.lang.Integer) get(MTTableVROOMLINK.ROOMLINKID);
	}

	public void setRoomLinkId(java.lang.Integer roomLinkId){ 
		set(MTTableVROOMLINK.ROOMLINKID, roomLinkId);
	} 

	public java.lang.Integer getRoomTypeId(){ 
		return (java.lang.Integer) get(MTTableVROOMLINK.ROOMTYPEID);
	}

	public void setRoomTypeId(java.lang.Integer roomTypeId){ 
		set(MTTableVROOMLINK.ROOMTYPEID, roomTypeId);
	} 

	public java.lang.Integer getHomeId(){ 
		return (java.lang.Integer) get(MTTableVROOMLINK.HOMEID);
	}

	public void setHomeId(java.lang.Integer homeId){ 
		set(MTTableVROOMLINK.HOMEID, homeId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableVROOMLINK.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableVROOMLINK.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableVROOMLINK.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableVROOMLINK.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableVROOMLINK.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableVROOMLINK.INPUTSOURCEID, inputSourceId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableVROOMLINK.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableVROOMLINK.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableVROOMLINK.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableVROOMLINK.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public VroomLinkDTO insert() {
		return (VroomLinkDTO) super.insert();
	}

	public static VroomLinkDTO find(String whereExpression) {
		try {
			return new VroomLinkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}