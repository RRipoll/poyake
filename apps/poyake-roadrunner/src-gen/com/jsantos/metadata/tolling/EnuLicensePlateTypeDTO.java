package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuLicensePlateTypeDTO extends DetachedRecord{

	public EnuLicensePlateTypeDTO(){
		super(MTBase.getTable("ENULICENSEPLATETYPE"));
	}

	public EnuLicensePlateTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENULICENSEPLATETYPE"), rs);
	}

	public EnuLicensePlateTypeDTO(Integer pk) {
		super(MTBase.getTable("ENULICENSEPLATETYPE"), pk);
	}

	public EnuLicensePlateTypeDTO(String whereClause) {
		super(MTBase.getTable("ENULICENSEPLATETYPE"), whereClause);
	}

	public java.lang.Integer getLicensePlateType(){ 
		return (java.lang.Integer) get(MTTableENULICENSEPLATETYPE.LICENSEPLATETYPE);
	}

	public void setLicensePlateType(java.lang.Integer licensePlateType){ 
		set(MTTableENULICENSEPLATETYPE.LICENSEPLATETYPE, licensePlateType);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENULICENSEPLATETYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENULICENSEPLATETYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENULICENSEPLATETYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENULICENSEPLATETYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuLicensePlateTypeDTO insert() {
		return (EnuLicensePlateTypeDTO) super.insert();
	}

	public static EnuLicensePlateTypeDTO find(String whereExpression) {
		try {
			return new EnuLicensePlateTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}