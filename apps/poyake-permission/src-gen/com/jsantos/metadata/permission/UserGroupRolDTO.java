package com.jsantos.metadata.permission;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class UserGroupRolDTO extends DetachedRecord{

	public UserGroupRolDTO(){
		super(MTBase.getTable("USERGROUPROL"));
	}

	public UserGroupRolDTO(ResultSet rs){
		super(MTBase.getTable("USERGROUPROL"), rs);
	}

	public UserGroupRolDTO(Integer pk) {
		super(MTBase.getTable("USERGROUPROL"), pk);
	}

	public UserGroupRolDTO(String whereClause) {
		super(MTBase.getTable("USERGROUPROL"), whereClause);
	}

	public java.lang.Integer getUserGroupRolId(){ 
		return (java.lang.Integer) get(MTTableUSERGROUPROL.USERGROUPROLID);
	}

	public void setUserGroupRolId(java.lang.Integer userGroupRolId){ 
		set(MTTableUSERGROUPROL.USERGROUPROLID, userGroupRolId);
	} 

	public java.lang.Integer getRolId(){ 
		return (java.lang.Integer) get(MTTableUSERGROUPROL.ROLID);
	}

	public void setRolId(java.lang.Integer rolId){ 
		set(MTTableUSERGROUPROL.ROLID, rolId);
	} 

	public java.lang.Integer getInputUserGroupId(){ 
		return (java.lang.Integer) get(MTTableUSERGROUPROL.INPUTUSERGROUPID);
	}

	public void setInputUserGroupId(java.lang.Integer inputUserGroupId){ 
		set(MTTableUSERGROUPROL.INPUTUSERGROUPID, inputUserGroupId);
	} 

	public void update() {
		super.update();
	}

	public UserGroupRolDTO insert() {
		return (UserGroupRolDTO) super.insert();
	}

	public static UserGroupRolDTO find(String whereExpression) {
		try {
			return new UserGroupRolDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}