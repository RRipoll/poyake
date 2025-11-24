package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuPermissionTypeDTO extends DetachedRecord{

	public EnuPermissionTypeDTO(){
		super(MTBase.getTable("ENUPERMISSIONTYPE"));
	}

	public EnuPermissionTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUPERMISSIONTYPE"), rs);
	}

	public EnuPermissionTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUPERMISSIONTYPE"), pk);
	}

	public EnuPermissionTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUPERMISSIONTYPE"), whereClause);
	}

	public java.lang.Integer getPermissionTypeId(){ 
		return (java.lang.Integer) get(MTTableENUPERMISSIONTYPE.PERMISSIONTYPEID);
	}

	public void setPermissionTypeId(java.lang.Integer permissionTypeId){ 
		set(MTTableENUPERMISSIONTYPE.PERMISSIONTYPEID, permissionTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUPERMISSIONTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUPERMISSIONTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUPERMISSIONTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUPERMISSIONTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuPermissionTypeDTO insert() {
		return (EnuPermissionTypeDTO) super.insert();
	}

	public static EnuPermissionTypeDTO find(String whereExpression) {
		try {
			return new EnuPermissionTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}