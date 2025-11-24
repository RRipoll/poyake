package com.jsantos.metadata.audit;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class InputUserDTO extends DetachedRecord{

	public InputUserDTO(){
		super(MTBase.getTable("INPUTUSER"));
	}

	public InputUserDTO(ResultSet rs){
		super(MTBase.getTable("INPUTUSER"), rs);
	}

	public InputUserDTO(Integer pk) {
		super(MTBase.getTable("INPUTUSER"), pk);
	}

	public InputUserDTO(String whereClause) {
		super(MTBase.getTable("INPUTUSER"), whereClause);
	}

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableINPUTUSER.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableINPUTUSER.INPUTUSERID, inputUserId);
	} 

	public java.lang.String getLoginName(){ 
		return (java.lang.String) get(MTTableINPUTUSER.LOGINNAME);
	}

	public void setLoginName(java.lang.String loginName){ 
		set(MTTableINPUTUSER.LOGINNAME, loginName);
	} 

	public java.lang.String getPasswd(){ 
		return (java.lang.String) get(MTTableINPUTUSER.PASSWD);
	}

	public void setPasswd(java.lang.String passwd){ 
		set(MTTableINPUTUSER.PASSWD, passwd);
	} 

	public java.lang.String getFullName(){ 
		return (java.lang.String) get(MTTableINPUTUSER.FULLNAME);
	}

	public void setFullName(java.lang.String fullName){ 
		set(MTTableINPUTUSER.FULLNAME, fullName);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableINPUTUSER.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableINPUTUSER.CREATED, created);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableINPUTUSER.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableINPUTUSER.INPUTSOURCEID, inputSourceId);
	} 

	public java.lang.String getEmail(){ 
		return (java.lang.String) get(MTTableINPUTUSER.EMAIL);
	}

	public void setEmail(java.lang.String email){ 
		set(MTTableINPUTUSER.EMAIL, email);
	} 

	public void update() {
		super.update();
	}

	public InputUserDTO insert() {
		return (InputUserDTO) super.insert();
	}

	public static InputUserDTO find(String whereExpression) {
		try {
			return new InputUserDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}