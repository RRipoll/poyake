package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class LicensePlateDTO extends DetachedRecord{

	public LicensePlateDTO(){
		super(MTBase.getTable("LICENSEPLATE"));
	}

	public LicensePlateDTO(ResultSet rs){
		super(MTBase.getTable("LICENSEPLATE"), rs);
	}

	public LicensePlateDTO(Integer pk) {
		super(MTBase.getTable("LICENSEPLATE"), pk);
	}

	public LicensePlateDTO(String whereClause) {
		super(MTBase.getTable("LICENSEPLATE"), whereClause);
	}

	public java.lang.Integer getLicensePlateId(){ 
		return (java.lang.Integer) get(MTTableLICENSEPLATE.LICENSEPLATEID);
	}

	public void setLicensePlateId(java.lang.Integer licensePlateId){ 
		set(MTTableLICENSEPLATE.LICENSEPLATEID, licensePlateId);
	} 

	public java.lang.Integer getLicencePlateJurisdictionId(){ 
		return (java.lang.Integer) get(MTTableLICENSEPLATE.LICENCEPLATEJURISDICTIONID);
	}

	public void setLicencePlateJurisdictionId(java.lang.Integer licencePlateJurisdictionId){ 
		set(MTTableLICENSEPLATE.LICENCEPLATEJURISDICTIONID, licencePlateJurisdictionId);
	} 

	public java.lang.String getLpnumber(){ 
		return (java.lang.String) get(MTTableLICENSEPLATE.LPNUMBER);
	}

	public void setLpnumber(java.lang.String lpnumber){ 
		set(MTTableLICENSEPLATE.LPNUMBER, lpnumber);
	} 

	public java.lang.Integer getLicensePlatetypeId(){ 
		return (java.lang.Integer) get(MTTableLICENSEPLATE.LICENSEPLATETYPEID);
	}

	public void setLicensePlatetypeId(java.lang.Integer licensePlatetypeId){ 
		set(MTTableLICENSEPLATE.LICENSEPLATETYPEID, licensePlatetypeId);
	} 

	public void update() {
		super.update();
	}

	public LicensePlateDTO insert() {
		return (LicensePlateDTO) super.insert();
	}

	public static LicensePlateDTO find(String whereExpression) {
		try {
			return new LicensePlateDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}