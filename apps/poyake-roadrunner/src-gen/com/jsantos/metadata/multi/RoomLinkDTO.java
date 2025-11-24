package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class RoomLinkDTO extends DetachedRecord{

	public RoomLinkDTO(){
		super(MTBase.getTable("ROOMLINK"));
	}

	public RoomLinkDTO(ResultSet rs){
		super(MTBase.getTable("ROOMLINK"), rs);
	}

	public RoomLinkDTO(Integer pk) {
		super(MTBase.getTable("ROOMLINK"), pk);
	}

	public RoomLinkDTO(String whereClause) {
		super(MTBase.getTable("ROOMLINK"), whereClause);
	}

	public java.lang.Integer getRoomLinkId(){ 
		return (java.lang.Integer) get(MTTableROOMLINK.ROOMLINKID);
	}

	public void setRoomLinkId(java.lang.Integer roomLinkId){ 
		set(MTTableROOMLINK.ROOMLINKID, roomLinkId);
	} 

	public java.lang.Integer getRoomTypeId(){ 
		return (java.lang.Integer) get(MTTableROOMLINK.ROOMTYPEID);
	}

	public void setRoomTypeId(java.lang.Integer roomTypeId){ 
		set(MTTableROOMLINK.ROOMTYPEID, roomTypeId);
	} 

	public java.lang.Integer getHomeId(){ 
		return (java.lang.Integer) get(MTTableROOMLINK.HOMEID);
	}

	public void setHomeId(java.lang.Integer homeId){ 
		set(MTTableROOMLINK.HOMEID, homeId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableROOMLINK.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableROOMLINK.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableROOMLINK.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableROOMLINK.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableROOMLINK.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableROOMLINK.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public RoomLinkDTO insert() {
		return (RoomLinkDTO) super.insert();
	}

	public static RoomLinkDTO find(String whereExpression) {
		try {
			return new RoomLinkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}