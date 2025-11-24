package com.jsantos.metadata.multi;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuRoomTypeDTO extends DetachedRecord{

	public EnuRoomTypeDTO(){
		super(MTBase.getTable("ENUROOMTYPE"));
	}

	public EnuRoomTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUROOMTYPE"), rs);
	}

	public EnuRoomTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUROOMTYPE"), pk);
	}

	public EnuRoomTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUROOMTYPE"), whereClause);
	}

	public java.lang.Integer getRoomTypeId(){ 
		return (java.lang.Integer) get(MTTableENUROOMTYPE.ROOMTYPEID);
	}

	public void setRoomTypeId(java.lang.Integer roomTypeId){ 
		set(MTTableENUROOMTYPE.ROOMTYPEID, roomTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUROOMTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUROOMTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUROOMTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUROOMTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuRoomTypeDTO insert() {
		return (EnuRoomTypeDTO) super.insert();
	}

	public static EnuRoomTypeDTO find(String whereExpression) {
		try {
			return new EnuRoomTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}