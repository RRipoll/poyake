package com.jsantos.metadata.audit;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VUserMultiGroupDTO extends DetachedRecord{

	public VUserMultiGroupDTO(){
		super(MTBase.getTable("VUSERMULTIGROUP"));
	}

	public VUserMultiGroupDTO(ResultSet rs){
		super(MTBase.getTable("VUSERMULTIGROUP"), rs);
	}

	public VUserMultiGroupDTO(Integer pk) {
		super(MTBase.getTable("VUSERMULTIGROUP"), pk);
	}

	public VUserMultiGroupDTO(String whereClause) {
		super(MTBase.getTable("VUSERMULTIGROUP"), whereClause);
	}

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableVUSERMULTIGROUP.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableVUSERMULTIGROUP.INPUTUSERID, inputUserId);
	} 

	public java.lang.String getLoginName(){ 
		return (java.lang.String) get(MTTableVUSERMULTIGROUP.LOGINNAME);
	}

	public void setLoginName(java.lang.String loginName){ 
		set(MTTableVUSERMULTIGROUP.LOGINNAME, loginName);
	} 

	public java.lang.String getPasswd(){ 
		return (java.lang.String) get(MTTableVUSERMULTIGROUP.PASSWD);
	}

	public void setPasswd(java.lang.String passwd){ 
		set(MTTableVUSERMULTIGROUP.PASSWD, passwd);
	} 

	public java.lang.String getFullName(){ 
		return (java.lang.String) get(MTTableVUSERMULTIGROUP.FULLNAME);
	}

	public void setFullName(java.lang.String fullName){ 
		set(MTTableVUSERMULTIGROUP.FULLNAME, fullName);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableVUSERMULTIGROUP.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableVUSERMULTIGROUP.CREATED, created);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableVUSERMULTIGROUP.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableVUSERMULTIGROUP.INPUTSOURCEID, inputSourceId);
	} 

	public java.lang.String getUserGroups(){ 
		return (java.lang.String) get(MTTableVUSERMULTIGROUP.USERGROUPS);
	}

	public void setUserGroups(java.lang.String userGroups){ 
		set(MTTableVUSERMULTIGROUP.USERGROUPS, userGroups);
	} 

	public void update() {
		super.update();
	}

	public VUserMultiGroupDTO insert() {
		return (VUserMultiGroupDTO) super.insert();
	}

	public static VUserMultiGroupDTO find(String whereExpression) {
		try {
			return new VUserMultiGroupDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}