package com.jsantos.metadata.audit;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VinputUserDTO extends DetachedRecord{

	public VinputUserDTO(){
		super(MTBase.getTable("VINPUTUSER"));
	}

	public VinputUserDTO(ResultSet rs){
		super(MTBase.getTable("VINPUTUSER"), rs);
	}

	public VinputUserDTO(Integer pk) {
		super(MTBase.getTable("VINPUTUSER"), pk);
	}

	public VinputUserDTO(String whereClause) {
		super(MTBase.getTable("VINPUTUSER"), whereClause);
	}

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableVINPUTUSER.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableVINPUTUSER.INPUTUSERID, inputUserId);
	} 

	public java.lang.String getLoginName(){ 
		return (java.lang.String) get(MTTableVINPUTUSER.LOGINNAME);
	}

	public void setLoginName(java.lang.String loginName){ 
		set(MTTableVINPUTUSER.LOGINNAME, loginName);
	} 

	public java.lang.String getPasswd(){ 
		return (java.lang.String) get(MTTableVINPUTUSER.PASSWD);
	}

	public void setPasswd(java.lang.String passwd){ 
		set(MTTableVINPUTUSER.PASSWD, passwd);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableVINPUTUSER.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableVINPUTUSER.CREATED, created);
	} 

	public java.lang.String getFullName(){ 
		return (java.lang.String) get(MTTableVINPUTUSER.FULLNAME);
	}

	public void setFullName(java.lang.String fullName){ 
		set(MTTableVINPUTUSER.FULLNAME, fullName);
	} 

	public java.lang.Integer getInputUserGroupId(){ 
		return (java.lang.Integer) get(MTTableVINPUTUSER.INPUTUSERGROUPID);
	}

	public void setInputUserGroupId(java.lang.Integer inputUserGroupId){ 
		set(MTTableVINPUTUSER.INPUTUSERGROUPID, inputUserGroupId);
	} 

	public void update() {
		super.update();
	}

	public VinputUserDTO insert() {
		return (VinputUserDTO) super.insert();
	}

	public static VinputUserDTO find(String whereExpression) {
		try {
			return new VinputUserDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}