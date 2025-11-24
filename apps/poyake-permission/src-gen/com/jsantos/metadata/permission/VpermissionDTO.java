package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VpermissionDTO extends DetachedRecord{

	public VpermissionDTO(){
		super(MTBase.getTable("VPERMISSION"));
	}

	public VpermissionDTO(ResultSet rs){
		super(MTBase.getTable("VPERMISSION"), rs);
	}

	public VpermissionDTO(Integer pk) {
		super(MTBase.getTable("VPERMISSION"), pk);
	}

	public VpermissionDTO(String whereClause) {
		super(MTBase.getTable("VPERMISSION"), whereClause);
	}

	public java.lang.Integer getInputuserId(){ 
		return (java.lang.Integer) get(MTTableVPERMISSION.INPUTUSERID);
	}

	public void setInputuserId(java.lang.Integer inputuserId){ 
		set(MTTableVPERMISSION.INPUTUSERID, inputuserId);
	} 

	public java.lang.Integer getInputUserGroupId(){ 
		return (java.lang.Integer) get(MTTableVPERMISSION.INPUTUSERGROUPID);
	}

	public void setInputUserGroupId(java.lang.Integer inputUserGroupId){ 
		set(MTTableVPERMISSION.INPUTUSERGROUPID, inputUserGroupId);
	} 

	public java.lang.Integer getRolId(){ 
		return (java.lang.Integer) get(MTTableVPERMISSION.ROLID);
	}

	public void setRolId(java.lang.Integer rolId){ 
		set(MTTableVPERMISSION.ROLID, rolId);
	} 

	public java.lang.Integer getPermissionTypeId(){ 
		return (java.lang.Integer) get(MTTableVPERMISSION.PERMISSIONTYPEID);
	}

	public void setPermissionTypeId(java.lang.Integer permissionTypeId){ 
		set(MTTableVPERMISSION.PERMISSIONTYPEID, permissionTypeId);
	} 

	public java.lang.Integer getPermissionValueId(){ 
		return (java.lang.Integer) get(MTTableVPERMISSION.PERMISSIONVALUEID);
	}

	public void setPermissionValueId(java.lang.Integer permissionValueId){ 
		set(MTTableVPERMISSION.PERMISSIONVALUEID, permissionValueId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableVPERMISSION.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableVPERMISSION.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableVPERMISSION.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableVPERMISSION.DESCRIPTION, description);
	} 

	public java.lang.Integer getPermissionId(){ 
		return (java.lang.Integer) get(MTTableVPERMISSION.PERMISSIONID);
	}

	public void setPermissionId(java.lang.Integer permissionId){ 
		set(MTTableVPERMISSION.PERMISSIONID, permissionId);
	} 

	public void update() {
		super.update();
	}

	public VpermissionDTO insert() {
		return (VpermissionDTO) super.insert();
	}

	public static VpermissionDTO find(String whereExpression) {
		try {
			return new VpermissionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}