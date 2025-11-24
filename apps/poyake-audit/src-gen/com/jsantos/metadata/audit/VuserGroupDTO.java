package com.jsantos.metadata.audit;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VuserGroupDTO extends DetachedRecord{

	public VuserGroupDTO(){
		super(MTBase.getTable("VUSERGROUP"));
	}

	public VuserGroupDTO(ResultSet rs){
		super(MTBase.getTable("VUSERGROUP"), rs);
	}

	public VuserGroupDTO(Integer pk) {
		super(MTBase.getTable("VUSERGROUP"), pk);
	}

	public VuserGroupDTO(String whereClause) {
		super(MTBase.getTable("VUSERGROUP"), whereClause);
	}

	public java.lang.Integer getUserGroupId(){ 
		return (java.lang.Integer) get(MTTableVUSERGROUP.USERGROUPID);
	}

	public void setUserGroupId(java.lang.Integer userGroupId){ 
		set(MTTableVUSERGROUP.USERGROUPID, userGroupId);
	} 

	public java.lang.Integer getInputUserGroupId(){ 
		return (java.lang.Integer) get(MTTableVUSERGROUP.INPUTUSERGROUPID);
	}

	public void setInputUserGroupId(java.lang.Integer inputUserGroupId){ 
		set(MTTableVUSERGROUP.INPUTUSERGROUPID, inputUserGroupId);
	} 

	public java.lang.Integer getUserId(){ 
		return (java.lang.Integer) get(MTTableVUSERGROUP.USERID);
	}

	public void setUserId(java.lang.Integer userId){ 
		set(MTTableVUSERGROUP.USERID, userId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableVUSERGROUP.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableVUSERGROUP.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableVUSERGROUP.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableVUSERGROUP.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableVUSERGROUP.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableVUSERGROUP.INPUTSOURCEID, inputSourceId);
	} 

	public java.lang.String getLoginName(){ 
		return (java.lang.String) get(MTTableVUSERGROUP.LOGINNAME);
	}

	public void setLoginName(java.lang.String loginName){ 
		set(MTTableVUSERGROUP.LOGINNAME, loginName);
	} 

	public java.lang.String getFullName(){ 
		return (java.lang.String) get(MTTableVUSERGROUP.FULLNAME);
	}

	public void setFullName(java.lang.String fullName){ 
		set(MTTableVUSERGROUP.FULLNAME, fullName);
	} 

	public java.lang.String getGroupName(){ 
		return (java.lang.String) get(MTTableVUSERGROUP.GROUPNAME);
	}

	public void setGroupName(java.lang.String groupName){ 
		set(MTTableVUSERGROUP.GROUPNAME, groupName);
	} 

	public java.lang.String getGroupDescription(){ 
		return (java.lang.String) get(MTTableVUSERGROUP.GROUPDESCRIPTION);
	}

	public void setGroupDescription(java.lang.String groupDescription){ 
		set(MTTableVUSERGROUP.GROUPDESCRIPTION, groupDescription);
	} 

	public void update() {
		super.update();
	}

	public VuserGroupDTO insert() {
		return (VuserGroupDTO) super.insert();
	}

	public static VuserGroupDTO find(String whereExpression) {
		try {
			return new VuserGroupDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}