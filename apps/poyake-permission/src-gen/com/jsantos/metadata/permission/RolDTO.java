package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class RolDTO extends DetachedRecord{

	public RolDTO(){
		super(MTBase.getTable("ROL"));
	}

	public RolDTO(ResultSet rs){
		super(MTBase.getTable("ROL"), rs);
	}

	public RolDTO(Integer pk) {
		super(MTBase.getTable("ROL"), pk);
	}

	public RolDTO(String whereClause) {
		super(MTBase.getTable("ROL"), whereClause);
	}

	public java.lang.Integer getRolId(){ 
		return (java.lang.Integer) get(MTTableROL.ROLID);
	}

	public void setRolId(java.lang.Integer rolId){ 
		set(MTTableROL.ROLID, rolId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableROL.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableROL.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableROL.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableROL.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public RolDTO insert() {
		return (RolDTO) super.insert();
	}

	public static RolDTO find(String whereExpression) {
		try {
			return new RolDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}