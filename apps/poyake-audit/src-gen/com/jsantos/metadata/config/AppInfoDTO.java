package com.jsantos.metadata.config;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class AppInfoDTO extends DetachedRecord{

	public AppInfoDTO(){
		super(MTBase.getTable("APPINFO"));
	}

	public AppInfoDTO(ResultSet rs){
		super(MTBase.getTable("APPINFO"), rs);
	}

	public AppInfoDTO(Integer pk) {
		super(MTBase.getTable("APPINFO"), pk);
	}

	public AppInfoDTO(String whereClause) {
		super(MTBase.getTable("APPINFO"), whereClause);
	}

	public java.lang.String getAppInfoId(){ 
		return (java.lang.String) get(MTTableAPPINFO.APPINFOID);
	}

	public void setAppInfoId(java.lang.String appInfoId){ 
		set(MTTableAPPINFO.APPINFOID, appInfoId);
	} 

	public java.lang.String getSKey(){ 
		return (java.lang.String) get(MTTableAPPINFO.SKEY);
	}

	public void setSKey(java.lang.String sKey){ 
		set(MTTableAPPINFO.SKEY, sKey);
	} 

	public java.lang.Integer getType(){ 
		return (java.lang.Integer) get(MTTableAPPINFO.TYPE);
	}

	public void setType(java.lang.Integer type){ 
		set(MTTableAPPINFO.TYPE, type);
	} 

	public java.lang.String getSValue(){ 
		return (java.lang.String) get(MTTableAPPINFO.SVALUE);
	}

	public void setSValue(java.lang.String sValue){ 
		set(MTTableAPPINFO.SVALUE, sValue);
	} 

	public java.lang.Integer getInputUserGroupId(){ 
		return (java.lang.Integer) get(MTTableAPPINFO.INPUTUSERGROUPID);
	}

	public void setInputUserGroupId(java.lang.Integer inputUserGroupId){ 
		set(MTTableAPPINFO.INPUTUSERGROUPID, inputUserGroupId);
	} 

	public void update() {
		super.update();
	}

	public AppInfoDTO insert() {
		return (AppInfoDTO) super.insert();
	}

	public static AppInfoDTO find(String whereExpression) {
		try {
			return new AppInfoDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}