package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VTripSearchDTO extends DetachedRecord{

	public VTripSearchDTO(){
		super(MTBase.getTable("VTRIPSEARCH"));
	}

	public VTripSearchDTO(ResultSet rs){
		super(MTBase.getTable("VTRIPSEARCH"), rs);
	}

	public VTripSearchDTO(Integer pk) {
		super(MTBase.getTable("VTRIPSEARCH"), pk);
	}

	public VTripSearchDTO(String whereClause) {
		super(MTBase.getTable("VTRIPSEARCH"), whereClause);
	}

	public java.lang.Integer getTripId(){ 
		return (java.lang.Integer) get(MTTableVTRIPSEARCH.TRIPID);
	}

	public void setTripId(java.lang.Integer tripId){ 
		set(MTTableVTRIPSEARCH.TRIPID, tripId);
	} 

	public java.math.BigDecimal getFareAmount(){ 
		return (java.math.BigDecimal) get(MTTableVTRIPSEARCH.FAREAMOUNT);
	}

	public void setFareAmount(java.math.BigDecimal fareAmount){ 
		set(MTTableVTRIPSEARCH.FAREAMOUNT, fareAmount);
	} 

	public java.util.Date getLaneEntryDate(){ 
		return (java.util.Date) get(MTTableVTRIPSEARCH.LANEENTRYDATE);
	}

	public void setLaneEntryDate(java.util.Date laneEntryDate){ 
		set(MTTableVTRIPSEARCH.LANEENTRYDATE, laneEntryDate);
	} 

	public java.util.Date getLaneExitDate(){ 
		return (java.util.Date) get(MTTableVTRIPSEARCH.LANEEXITDATE);
	}

	public void setLaneExitDate(java.util.Date laneExitDate){ 
		set(MTTableVTRIPSEARCH.LANEEXITDATE, laneExitDate);
	} 

	public java.lang.Integer getLicencePlateJurisdictionId(){ 
		return (java.lang.Integer) get(MTTableVTRIPSEARCH.LICENCEPLATEJURISDICTIONID);
	}

	public void setLicencePlateJurisdictionId(java.lang.Integer licencePlateJurisdictionId){ 
		set(MTTableVTRIPSEARCH.LICENCEPLATEJURISDICTIONID, licencePlateJurisdictionId);
	} 

	public java.lang.String getLpnumber(){ 
		return (java.lang.String) get(MTTableVTRIPSEARCH.LPNUMBER);
	}

	public void setLpnumber(java.lang.String lpnumber){ 
		set(MTTableVTRIPSEARCH.LPNUMBER, lpnumber);
	} 

	public java.lang.Integer getLicensePlatetypeId(){ 
		return (java.lang.Integer) get(MTTableVTRIPSEARCH.LICENSEPLATETYPEID);
	}

	public void setLicensePlatetypeId(java.lang.Integer licensePlatetypeId){ 
		set(MTTableVTRIPSEARCH.LICENSEPLATETYPEID, licensePlatetypeId);
	} 

	public java.lang.Integer getPassId(){ 
		return (java.lang.Integer) get(MTTableVTRIPSEARCH.PASSID);
	}

	public void setPassId(java.lang.Integer passId){ 
		set(MTTableVTRIPSEARCH.PASSID, passId);
	} 

	public void update() {
		super.update();
	}

	public VTripSearchDTO insert() {
		return (VTripSearchDTO) super.insert();
	}

	public static VTripSearchDTO find(String whereExpression) {
		try {
			return new VTripSearchDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}