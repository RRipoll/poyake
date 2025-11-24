package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VgroupRolDTO extends DetachedRecord{

	public VgroupRolDTO(){
		super(MTBase.getTable("VGROUPROL"));
	}

	public VgroupRolDTO(ResultSet rs){
		super(MTBase.getTable("VGROUPROL"), rs);
	}

	public VgroupRolDTO(Integer pk) {
		super(MTBase.getTable("VGROUPROL"), pk);
	}

	public VgroupRolDTO(String whereClause) {
		super(MTBase.getTable("VGROUPROL"), whereClause);
	}

	public java.lang.Integer getInputUserGroupId(){ 
		return (java.lang.Integer) get(MTTableVGROUPROL.INPUTUSERGROUPID);
	}

	public void setInputUserGroupId(java.lang.Integer inputUserGroupId){ 
		set(MTTableVGROUPROL.INPUTUSERGROUPID, inputUserGroupId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableVGROUPROL.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableVGROUPROL.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableVGROUPROL.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableVGROUPROL.DESCRIPTION, description);
	} 

	public java.lang.String getRols(){ 
		return (java.lang.String) get(MTTableVGROUPROL.ROLS);
	}

	public void setRols(java.lang.String rols){ 
		set(MTTableVGROUPROL.ROLS, rols);
	} 

	public void update() {
		super.update();
	}

	public VgroupRolDTO insert() {
		return (VgroupRolDTO) super.insert();
	}

	public static VgroupRolDTO find(String whereExpression) {
		try {
			return new VgroupRolDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}