package com.jsantos.metadata.audit;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class InputUserGroupDTO extends DetachedRecord{

	public InputUserGroupDTO(){
		super(MTBase.getTable("INPUTUSERGROUP"));
	}

	public InputUserGroupDTO(ResultSet rs){
		super(MTBase.getTable("INPUTUSERGROUP"), rs);
	}

	public InputUserGroupDTO(Integer pk) {
		super(MTBase.getTable("INPUTUSERGROUP"), pk);
	}

	public InputUserGroupDTO(String whereClause) {
		super(MTBase.getTable("INPUTUSERGROUP"), whereClause);
	}

	public java.lang.Integer getInputUserGroupId(){ 
		return (java.lang.Integer) get(MTTableINPUTUSERGROUP.INPUTUSERGROUPID);
	}

	public void setInputUserGroupId(java.lang.Integer inputUserGroupId){ 
		set(MTTableINPUTUSERGROUP.INPUTUSERGROUPID, inputUserGroupId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableINPUTUSERGROUP.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableINPUTUSERGROUP.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableINPUTUSERGROUP.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableINPUTUSERGROUP.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public InputUserGroupDTO insert() {
		return (InputUserGroupDTO) super.insert();
	}

	public static InputUserGroupDTO find(String whereExpression) {
		try {
			return new InputUserGroupDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}