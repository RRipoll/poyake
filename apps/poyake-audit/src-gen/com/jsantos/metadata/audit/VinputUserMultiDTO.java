package com.jsantos.metadata.audit;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VinputUserMultiDTO extends DetachedRecord{

	public VinputUserMultiDTO(){
		super(MTBase.getTable("VINPUTUSERMULTI"));
	}

	public VinputUserMultiDTO(ResultSet rs){
		super(MTBase.getTable("VINPUTUSERMULTI"), rs);
	}

	public VinputUserMultiDTO(Integer pk) {
		super(MTBase.getTable("VINPUTUSERMULTI"), pk);
	}

	public VinputUserMultiDTO(String whereClause) {
		super(MTBase.getTable("VINPUTUSERMULTI"), whereClause);
	}

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableVINPUTUSERMULTI.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableVINPUTUSERMULTI.INPUTUSERID, inputUserId);
	} 

	public java.lang.String getLoginName(){ 
		return (java.lang.String) get(MTTableVINPUTUSERMULTI.LOGINNAME);
	}

	public void setLoginName(java.lang.String loginName){ 
		set(MTTableVINPUTUSERMULTI.LOGINNAME, loginName);
	} 

	public java.lang.String getPasswd(){ 
		return (java.lang.String) get(MTTableVINPUTUSERMULTI.PASSWD);
	}

	public void setPasswd(java.lang.String passwd){ 
		set(MTTableVINPUTUSERMULTI.PASSWD, passwd);
	} 

	public java.lang.String getFullName(){ 
		return (java.lang.String) get(MTTableVINPUTUSERMULTI.FULLNAME);
	}

	public void setFullName(java.lang.String fullName){ 
		set(MTTableVINPUTUSERMULTI.FULLNAME, fullName);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableVINPUTUSERMULTI.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableVINPUTUSERMULTI.CREATED, created);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableVINPUTUSERMULTI.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableVINPUTUSERMULTI.INPUTSOURCEID, inputSourceId);
	} 

	public java.lang.String getUsergroups(){ 
		return (java.lang.String) get(MTTableVINPUTUSERMULTI.USERGROUPS);
	}

	public void setUsergroups(java.lang.String usergroups){ 
		set(MTTableVINPUTUSERMULTI.USERGROUPS, usergroups);
	} 

	public void update() {
		super.update();
	}

	public VinputUserMultiDTO insert() {
		return (VinputUserMultiDTO) super.insert();
	}

	public static VinputUserMultiDTO find(String whereExpression) {
		try {
			return new VinputUserMultiDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}