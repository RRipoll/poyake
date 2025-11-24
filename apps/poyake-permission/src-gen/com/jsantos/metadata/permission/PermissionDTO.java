package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class PermissionDTO extends DetachedRecord{

	public PermissionDTO(){
		super(MTBase.getTable("PERMISSION"));
	}

	public PermissionDTO(ResultSet rs){
		super(MTBase.getTable("PERMISSION"), rs);
	}

	public PermissionDTO(Integer pk) {
		super(MTBase.getTable("PERMISSION"), pk);
	}

	public PermissionDTO(String whereClause) {
		super(MTBase.getTable("PERMISSION"), whereClause);
	}

	public java.lang.Integer getPermissionId(){ 
		return (java.lang.Integer) get(MTTablePERMISSION.PERMISSIONID);
	}

	public void setPermissionId(java.lang.Integer permissionId){ 
		set(MTTablePERMISSION.PERMISSIONID, permissionId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTablePERMISSION.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTablePERMISSION.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTablePERMISSION.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTablePERMISSION.DESCRIPTION, description);
	} 

	public java.lang.Integer getPermissionTypeId(){ 
		return (java.lang.Integer) get(MTTablePERMISSION.PERMISSIONTYPEID);
	}

	public void setPermissionTypeId(java.lang.Integer permissionTypeId){ 
		set(MTTablePERMISSION.PERMISSIONTYPEID, permissionTypeId);
	} 

	public java.lang.Integer getPermissionValueId(){ 
		return (java.lang.Integer) get(MTTablePERMISSION.PERMISSIONVALUEID);
	}

	public void setPermissionValueId(java.lang.Integer permissionValueId){ 
		set(MTTablePERMISSION.PERMISSIONVALUEID, permissionValueId);
	} 

	public void update() {
		super.update();
	}

	public PermissionDTO insert() {
		return (PermissionDTO) super.insert();
	}

	public static PermissionDTO find(String whereExpression) {
		try {
			return new PermissionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}