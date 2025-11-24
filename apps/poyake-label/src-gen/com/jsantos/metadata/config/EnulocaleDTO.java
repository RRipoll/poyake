package com.jsantos.metadata.config;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnulocaleDTO extends DetachedRecord{

	public EnulocaleDTO(){
		super(MTBase.getTable("ENULOCALE"));
	}

	public EnulocaleDTO(ResultSet rs){
		super(MTBase.getTable("ENULOCALE"), rs);
	}

	public EnulocaleDTO(Integer pk) {
		super(MTBase.getTable("ENULOCALE"), pk);
	}

	public EnulocaleDTO(String whereClause) {
		super(MTBase.getTable("ENULOCALE"), whereClause);
	}

	public java.lang.Integer getEnuLocaleId(){ 
		return (java.lang.Integer) get(MTTableENULOCALE.ENULOCALEID);
	}

	public void setEnuLocaleId(java.lang.Integer enuLocaleId){ 
		set(MTTableENULOCALE.ENULOCALEID, enuLocaleId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENULOCALE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENULOCALE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENULOCALE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENULOCALE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnulocaleDTO insert() {
		return (EnulocaleDTO) super.insert();
	}

	public static EnulocaleDTO find(String whereExpression) {
		try {
			return new EnulocaleDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}