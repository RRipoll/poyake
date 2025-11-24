package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuLicensePlateJurisdictionDTO extends DetachedRecord{

	public EnuLicensePlateJurisdictionDTO(){
		super(MTBase.getTable("ENULICENSEPLATEJURISDICTION"));
	}

	public EnuLicensePlateJurisdictionDTO(ResultSet rs){
		super(MTBase.getTable("ENULICENSEPLATEJURISDICTION"), rs);
	}

	public EnuLicensePlateJurisdictionDTO(Integer pk) {
		super(MTBase.getTable("ENULICENSEPLATEJURISDICTION"), pk);
	}

	public EnuLicensePlateJurisdictionDTO(String whereClause) {
		super(MTBase.getTable("ENULICENSEPLATEJURISDICTION"), whereClause);
	}

	public java.lang.Integer getLicensePlateJurisdictionId(){ 
		return (java.lang.Integer) get(MTTableENULICENSEPLATEJURISDICTION.LICENSEPLATEJURISDICTIONID);
	}

	public void setLicensePlateJurisdictionId(java.lang.Integer licensePlateJurisdictionId){ 
		set(MTTableENULICENSEPLATEJURISDICTION.LICENSEPLATEJURISDICTIONID, licensePlateJurisdictionId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENULICENSEPLATEJURISDICTION.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENULICENSEPLATEJURISDICTION.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENULICENSEPLATEJURISDICTION.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENULICENSEPLATEJURISDICTION.DESCRIPTION, description);
	} 

	public java.lang.Integer getStateOrProviceId(){ 
		return (java.lang.Integer) get(MTTableENULICENSEPLATEJURISDICTION.STATEORPROVICEID);
	}

	public void setStateOrProviceId(java.lang.Integer stateOrProviceId){ 
		set(MTTableENULICENSEPLATEJURISDICTION.STATEORPROVICEID, stateOrProviceId);
	} 

	public java.lang.Integer getCountryId(){ 
		return (java.lang.Integer) get(MTTableENULICENSEPLATEJURISDICTION.COUNTRYID);
	}

	public void setCountryId(java.lang.Integer countryId){ 
		set(MTTableENULICENSEPLATEJURISDICTION.COUNTRYID, countryId);
	} 

	public void update() {
		super.update();
	}

	public EnuLicensePlateJurisdictionDTO insert() {
		return (EnuLicensePlateJurisdictionDTO) super.insert();
	}

	public static EnuLicensePlateJurisdictionDTO find(String whereExpression) {
		try {
			return new EnuLicensePlateJurisdictionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}