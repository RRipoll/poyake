package com.jsantos.metadata.config;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class AppInfoTreeDTO extends DetachedRecord{

	public AppInfoTreeDTO(){
		super(MTBase.getTable("APPINFOTREE"));
	}

	public AppInfoTreeDTO(ResultSet rs){
		super(MTBase.getTable("APPINFOTREE"), rs);
	}

	public AppInfoTreeDTO(Integer pk) {
		super(MTBase.getTable("APPINFOTREE"), pk);
	}

	public AppInfoTreeDTO(String whereClause) {
		super(MTBase.getTable("APPINFOTREE"), whereClause);
	}

	public java.lang.String getAppInfoTreeId(){ 
		return (java.lang.String) get(MTTableAPPINFOTREE.APPINFOTREEID);
	}

	public void setAppInfoTreeId(java.lang.String appInfoTreeId){ 
		set(MTTableAPPINFOTREE.APPINFOTREEID, appInfoTreeId);
	} 

	public java.lang.String getParentAppInfoTreeId(){ 
		return (java.lang.String) get(MTTableAPPINFOTREE.PARENTAPPINFOTREEID);
	}

	public void setParentAppInfoTreeId(java.lang.String parentAppInfoTreeId){ 
		set(MTTableAPPINFOTREE.PARENTAPPINFOTREEID, parentAppInfoTreeId);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableAPPINFOTREE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableAPPINFOTREE.DESCRIPTION, description);
	} 

	public java.lang.String getAppInfoId(){ 
		return (java.lang.String) get(MTTableAPPINFOTREE.APPINFOID);
	}

	public void setAppInfoId(java.lang.String appInfoId){ 
		set(MTTableAPPINFOTREE.APPINFOID, appInfoId);
	} 

	public void update() {
		super.update();
	}

	public AppInfoTreeDTO insert() {
		return (AppInfoTreeDTO) super.insert();
	}

	public static AppInfoTreeDTO find(String whereExpression) {
		try {
			return new AppInfoTreeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}