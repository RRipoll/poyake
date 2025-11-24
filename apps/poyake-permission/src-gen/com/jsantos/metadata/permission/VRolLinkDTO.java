package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VRolLinkDTO extends DetachedRecord{

	public VRolLinkDTO(){
		super(MTBase.getTable("VROLLINK"));
	}

	public VRolLinkDTO(ResultSet rs){
		super(MTBase.getTable("VROLLINK"), rs);
	}

	public VRolLinkDTO(Integer pk) {
		super(MTBase.getTable("VROLLINK"), pk);
	}

	public VRolLinkDTO(String whereClause) {
		super(MTBase.getTable("VROLLINK"), whereClause);
	}

	public java.lang.Integer getRolPermissionId(){ 
		return (java.lang.Integer) get(MTTableVROLLINK.ROLPERMISSIONID);
	}

	public void setRolPermissionId(java.lang.Integer rolPermissionId){ 
		set(MTTableVROLLINK.ROLPERMISSIONID, rolPermissionId);
	} 

	public java.lang.Integer getRolId(){ 
		return (java.lang.Integer) get(MTTableVROLLINK.ROLID);
	}

	public void setRolId(java.lang.Integer rolId){ 
		set(MTTableVROLLINK.ROLID, rolId);
	} 

	public java.lang.Integer getPermissionId(){ 
		return (java.lang.Integer) get(MTTableVROLLINK.PERMISSIONID);
	}

	public void setPermissionId(java.lang.Integer permissionId){ 
		set(MTTableVROLLINK.PERMISSIONID, permissionId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableVROLLINK.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableVROLLINK.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableVROLLINK.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableVROLLINK.DESCRIPTION, description);
	} 

	public java.lang.String getUserGroups(){ 
		return (java.lang.String) get(MTTableVROLLINK.USERGROUPS);
	}

	public void setUserGroups(java.lang.String userGroups){ 
		set(MTTableVROLLINK.USERGROUPS, userGroups);
	} 

	public void update() {
		super.update();
	}

	public VRolLinkDTO insert() {
		return (VRolLinkDTO) super.insert();
	}

	public static VRolLinkDTO find(String whereExpression) {
		try {
			return new VRolLinkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}