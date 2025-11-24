package com.jsantos.metadata.audit;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class UserGroupDTO extends DetachedRecord{

	public UserGroupDTO(){
		super(MTBase.getTable("USERGROUP"));
	}

	public UserGroupDTO(ResultSet rs){
		super(MTBase.getTable("USERGROUP"), rs);
	}

	public UserGroupDTO(Integer pk) {
		super(MTBase.getTable("USERGROUP"), pk);
	}

	public UserGroupDTO(String whereClause) {
		super(MTBase.getTable("USERGROUP"), whereClause);
	}

	public java.lang.Integer getUserGroupId(){ 
		return (java.lang.Integer) get(MTTableUSERGROUP.USERGROUPID);
	}

	public void setUserGroupId(java.lang.Integer userGroupId){ 
		set(MTTableUSERGROUP.USERGROUPID, userGroupId);
	} 

	public java.lang.Integer getInputUserGroupId(){ 
		return (java.lang.Integer) get(MTTableUSERGROUP.INPUTUSERGROUPID);
	}

	public void setInputUserGroupId(java.lang.Integer inputUserGroupId){ 
		set(MTTableUSERGROUP.INPUTUSERGROUPID, inputUserGroupId);
	} 

	public java.lang.Integer getUserId(){ 
		return (java.lang.Integer) get(MTTableUSERGROUP.USERID);
	}

	public void setUserId(java.lang.Integer userId){ 
		set(MTTableUSERGROUP.USERID, userId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableUSERGROUP.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableUSERGROUP.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableUSERGROUP.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableUSERGROUP.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableUSERGROUP.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableUSERGROUP.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public UserGroupDTO insert() {
		return (UserGroupDTO) super.insert();
	}

	public static UserGroupDTO find(String whereExpression) {
		try {
			return new UserGroupDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}