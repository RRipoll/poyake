package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VPermissionRolDTO extends DetachedRecord{

	public VPermissionRolDTO(){
		super(MTBase.getTable("VPERMISSIONROL"));
	}

	public VPermissionRolDTO(ResultSet rs){
		super(MTBase.getTable("VPERMISSIONROL"), rs);
	}

	public VPermissionRolDTO(Integer pk) {
		super(MTBase.getTable("VPERMISSIONROL"), pk);
	}

	public VPermissionRolDTO(String whereClause) {
		super(MTBase.getTable("VPERMISSIONROL"), whereClause);
	}

	public java.lang.Integer getPermissionId(){ 
		return (java.lang.Integer) get(MTTableVPERMISSIONROL.PERMISSIONID);
	}

	public void setPermissionId(java.lang.Integer permissionId){ 
		set(MTTableVPERMISSIONROL.PERMISSIONID, permissionId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableVPERMISSIONROL.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableVPERMISSIONROL.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableVPERMISSIONROL.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableVPERMISSIONROL.DESCRIPTION, description);
	} 

	public java.lang.Integer getPermissionTypeId(){ 
		return (java.lang.Integer) get(MTTableVPERMISSIONROL.PERMISSIONTYPEID);
	}

	public void setPermissionTypeId(java.lang.Integer permissionTypeId){ 
		set(MTTableVPERMISSIONROL.PERMISSIONTYPEID, permissionTypeId);
	} 

	public java.lang.Integer getPermissionValueId(){ 
		return (java.lang.Integer) get(MTTableVPERMISSIONROL.PERMISSIONVALUEID);
	}

	public void setPermissionValueId(java.lang.Integer permissionValueId){ 
		set(MTTableVPERMISSIONROL.PERMISSIONVALUEID, permissionValueId);
	} 

	public java.lang.String getRols(){ 
		return (java.lang.String) get(MTTableVPERMISSIONROL.ROLS);
	}

	public void setRols(java.lang.String rols){ 
		set(MTTableVPERMISSIONROL.ROLS, rols);
	} 

	public void update() {
		super.update();
	}

	public VPermissionRolDTO insert() {
		return (VPermissionRolDTO) super.insert();
	}

	public static VPermissionRolDTO find(String whereExpression) {
		try {
			return new VPermissionRolDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}