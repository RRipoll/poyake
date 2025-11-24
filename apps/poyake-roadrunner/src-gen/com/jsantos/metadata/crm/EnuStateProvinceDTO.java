package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuStateProvinceDTO extends DetachedRecord{

	public EnuStateProvinceDTO(){
		super(MTBase.getTable("ENUSTATEPROVINCE"));
	}

	public EnuStateProvinceDTO(ResultSet rs){
		super(MTBase.getTable("ENUSTATEPROVINCE"), rs);
	}

	public EnuStateProvinceDTO(Integer pk) {
		super(MTBase.getTable("ENUSTATEPROVINCE"), pk);
	}

	public EnuStateProvinceDTO(String whereClause) {
		super(MTBase.getTable("ENUSTATEPROVINCE"), whereClause);
	}

	public java.lang.Integer getStateProvinceId(){ 
		return (java.lang.Integer) get(MTTableENUSTATEPROVINCE.STATEPROVINCEID);
	}

	public void setStateProvinceId(java.lang.Integer stateProvinceId){ 
		set(MTTableENUSTATEPROVINCE.STATEPROVINCEID, stateProvinceId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUSTATEPROVINCE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUSTATEPROVINCE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUSTATEPROVINCE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUSTATEPROVINCE.DESCRIPTION, description);
	} 

	public java.lang.String getAbbr(){ 
		return (java.lang.String) get(MTTableENUSTATEPROVINCE.ABBR);
	}

	public void setAbbr(java.lang.String abbr){ 
		set(MTTableENUSTATEPROVINCE.ABBR, abbr);
	} 

	public java.lang.Integer getCountryId(){ 
		return (java.lang.Integer) get(MTTableENUSTATEPROVINCE.COUNTRYID);
	}

	public void setCountryId(java.lang.Integer countryId){ 
		set(MTTableENUSTATEPROVINCE.COUNTRYID, countryId);
	} 

	public void update() {
		super.update();
	}

	public EnuStateProvinceDTO insert() {
		return (EnuStateProvinceDTO) super.insert();
	}

	public static EnuStateProvinceDTO find(String whereExpression) {
		try {
			return new EnuStateProvinceDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}