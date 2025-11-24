package com.jsantos.metadata.audit;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VrolGroupDTO extends DetachedRecord{

	public VrolGroupDTO(){
		super(MTBase.getTable("VROLGROUP"));
	}

	public VrolGroupDTO(ResultSet rs){
		super(MTBase.getTable("VROLGROUP"), rs);
	}

	public VrolGroupDTO(Integer pk) {
		super(MTBase.getTable("VROLGROUP"), pk);
	}

	public VrolGroupDTO(String whereClause) {
		super(MTBase.getTable("VROLGROUP"), whereClause);
	}

	public java.lang.Integer getRolId(){ 
		return (java.lang.Integer) get(MTTableVROLGROUP.ROLID);
	}

	public void setRolId(java.lang.Integer rolId){ 
		set(MTTableVROLGROUP.ROLID, rolId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableVROLGROUP.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableVROLGROUP.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableVROLGROUP.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableVROLGROUP.DESCRIPTION, description);
	} 

	public java.lang.String getUserGroups(){ 
		return (java.lang.String) get(MTTableVROLGROUP.USERGROUPS);
	}

	public void setUserGroups(java.lang.String userGroups){ 
		set(MTTableVROLGROUP.USERGROUPS, userGroups);
	} 

	public void update() {
		super.update();
	}

	public VrolGroupDTO insert() {
		return (VrolGroupDTO) super.insert();
	}

	public static VrolGroupDTO find(String whereExpression) {
		try {
			return new VrolGroupDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}