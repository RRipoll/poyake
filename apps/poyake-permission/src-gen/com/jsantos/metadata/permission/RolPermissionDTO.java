package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class RolPermissionDTO extends DetachedRecord{

	public RolPermissionDTO(){
		super(MTBase.getTable("ROLPERMISSION"));
	}

	public RolPermissionDTO(ResultSet rs){
		super(MTBase.getTable("ROLPERMISSION"), rs);
	}

	public RolPermissionDTO(Integer pk) {
		super(MTBase.getTable("ROLPERMISSION"), pk);
	}

	public RolPermissionDTO(String whereClause) {
		super(MTBase.getTable("ROLPERMISSION"), whereClause);
	}

	public java.lang.Integer getRolPermissionId(){ 
		return (java.lang.Integer) get(MTTableROLPERMISSION.ROLPERMISSIONID);
	}

	public void setRolPermissionId(java.lang.Integer rolPermissionId){ 
		set(MTTableROLPERMISSION.ROLPERMISSIONID, rolPermissionId);
	} 

	public java.lang.Integer getRolId(){ 
		return (java.lang.Integer) get(MTTableROLPERMISSION.ROLID);
	}

	public void setRolId(java.lang.Integer rolId){ 
		set(MTTableROLPERMISSION.ROLID, rolId);
	} 

	public java.lang.Integer getPermissionId(){ 
		return (java.lang.Integer) get(MTTableROLPERMISSION.PERMISSIONID);
	}

	public void setPermissionId(java.lang.Integer permissionId){ 
		set(MTTableROLPERMISSION.PERMISSIONID, permissionId);
	} 

	public void update() {
		super.update();
	}

	public RolPermissionDTO insert() {
		return (RolPermissionDTO) super.insert();
	}

	public static RolPermissionDTO find(String whereExpression) {
		try {
			return new RolPermissionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}