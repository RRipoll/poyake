package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuCountryDTO extends DetachedRecord{

	public EnuCountryDTO(){
		super(MTBase.getTable("ENUCOUNTRY"));
	}

	public EnuCountryDTO(ResultSet rs){
		super(MTBase.getTable("ENUCOUNTRY"), rs);
	}

	public EnuCountryDTO(Integer pk) {
		super(MTBase.getTable("ENUCOUNTRY"), pk);
	}

	public EnuCountryDTO(String whereClause) {
		super(MTBase.getTable("ENUCOUNTRY"), whereClause);
	}

	public java.lang.Integer getCountryId(){ 
		return (java.lang.Integer) get(MTTableENUCOUNTRY.COUNTRYID);
	}

	public void setCountryId(java.lang.Integer countryId){ 
		set(MTTableENUCOUNTRY.COUNTRYID, countryId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUCOUNTRY.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUCOUNTRY.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUCOUNTRY.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUCOUNTRY.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuCountryDTO insert() {
		return (EnuCountryDTO) super.insert();
	}

	public static EnuCountryDTO find(String whereExpression) {
		try {
			return new EnuCountryDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}