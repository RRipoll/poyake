package com.jsantos.metadata.config;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.ResultSet;

public class AppInfoDTO extends DetachedRecord{

	public AppInfoDTO(){
		super(MT.APPINFO);
	}

	public AppInfoDTO(ResultSet rs){
		super(MT.APPINFO, rs);
	}

	public AppInfoDTO(Integer pk) {
		super(MT.APPINFO,pk);
	}

	public AppInfoDTO(String whereClause) {
		super(MT.APPINFO,whereClause);
	}

	public java.lang.Integer getAppInfoId(){ 
		return (java.lang.Integer) get(MTTableAPPINFO.APPINFOID);
	}

	public void setAppInfoId(java.lang.Integer appInfoId){ 
		set(MTTableAPPINFO.APPINFOID, appInfoId);
	} 

	public java.lang.String getSKey(){ 
		return (java.lang.String) get(MTTableAPPINFO.SKEY);
	}

	public void setSKey(java.lang.String sKey){ 
		set(MTTableAPPINFO.SKEY, sKey);
	} 

	public java.lang.String getSValue(){ 
		return (java.lang.String) get(MTTableAPPINFO.SVALUE);
	}

	public void setSValue(java.lang.String sValue){ 
		set(MTTableAPPINFO.SVALUE, sValue);
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