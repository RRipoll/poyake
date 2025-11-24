package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuPermissionValueDTO extends DetachedRecord{

	public EnuPermissionValueDTO(){
		super(MTBase.getTable("ENUPERMISSIONVALUE"));
	}

	public EnuPermissionValueDTO(ResultSet rs){
		super(MTBase.getTable("ENUPERMISSIONVALUE"), rs);
	}

	public EnuPermissionValueDTO(Integer pk) {
		super(MTBase.getTable("ENUPERMISSIONVALUE"), pk);
	}

	public EnuPermissionValueDTO(String whereClause) {
		super(MTBase.getTable("ENUPERMISSIONVALUE"), whereClause);
	}

	public java.lang.Integer getPermissionValueId(){ 
		return (java.lang.Integer) get(MTTableENUPERMISSIONVALUE.PERMISSIONVALUEID);
	}

	public void setPermissionValueId(java.lang.Integer permissionValueId){ 
		set(MTTableENUPERMISSIONVALUE.PERMISSIONVALUEID, permissionValueId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUPERMISSIONVALUE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUPERMISSIONVALUE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUPERMISSIONVALUE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUPERMISSIONVALUE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuPermissionValueDTO insert() {
		return (EnuPermissionValueDTO) super.insert();
	}

	public static EnuPermissionValueDTO find(String whereExpression) {
		try {
			return new EnuPermissionValueDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}