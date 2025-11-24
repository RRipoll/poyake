package com.jsantos.metadata.config;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class AppDataTypeDTO extends DetachedRecord{

	public AppDataTypeDTO(){
		super(MTBase.getTable("APPDATATYPE"));
	}

	public AppDataTypeDTO(ResultSet rs){
		super(MTBase.getTable("APPDATATYPE"), rs);
	}

	public AppDataTypeDTO(Integer pk) {
		super(MTBase.getTable("APPDATATYPE"), pk);
	}

	public AppDataTypeDTO(String whereClause) {
		super(MTBase.getTable("APPDATATYPE"), whereClause);
	}

	public java.lang.Integer getAppDataTypeId(){ 
		return (java.lang.Integer) get(MTTableAPPDATATYPE.APPDATATYPEID);
	}

	public void setAppDataTypeId(java.lang.Integer appDataTypeId){ 
		set(MTTableAPPDATATYPE.APPDATATYPEID, appDataTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableAPPDATATYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableAPPDATATYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableAPPDATATYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableAPPDATATYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public AppDataTypeDTO insert() {
		return (AppDataTypeDTO) super.insert();
	}

	public static AppDataTypeDTO find(String whereExpression) {
		try {
			return new AppDataTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}