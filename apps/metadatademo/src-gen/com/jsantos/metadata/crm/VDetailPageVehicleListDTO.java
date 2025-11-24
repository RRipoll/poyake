package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VDetailPageVehicleListDTO extends DetachedRecord{

	public VDetailPageVehicleListDTO(){
		super(MTBase.getTable("VDETAILPAGEVEHICLELIST"));
	}

	public VDetailPageVehicleListDTO(ResultSet rs){
		super(MTBase.getTable("VDETAILPAGEVEHICLELIST"), rs);
	}

	public VDetailPageVehicleListDTO(Integer pk) {
		super(MTBase.getTable("VDETAILPAGEVEHICLELIST"), pk);
	}

	public VDetailPageVehicleListDTO(String whereClause) {
		super(MTBase.getTable("VDETAILPAGEVEHICLELIST"), whereClause);
	}

	public java.lang.Integer getVehicleId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGEVEHICLELIST.VEHICLEID);
	}

	public void setVehicleId(java.lang.Integer vehicleId){ 
		set(MTTableVDETAILPAGEVEHICLELIST.VEHICLEID, vehicleId);
	} 

	public java.lang.String getLpNumber(){ 
		return (java.lang.String) get(MTTableVDETAILPAGEVEHICLELIST.LPNUMBER);
	}

	public void setLpNumber(java.lang.String lpNumber){ 
		set(MTTableVDETAILPAGEVEHICLELIST.LPNUMBER, lpNumber);
	} 

	public java.lang.Integer getLicencePlateJurisdictionId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGEVEHICLELIST.LICENCEPLATEJURISDICTIONID);
	}

	public void setLicencePlateJurisdictionId(java.lang.Integer licencePlateJurisdictionId){ 
		set(MTTableVDETAILPAGEVEHICLELIST.LICENCEPLATEJURISDICTIONID, licencePlateJurisdictionId);
	} 

	public java.lang.Integer getLicensePlateTypeId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGEVEHICLELIST.LICENSEPLATETYPEID);
	}

	public void setLicensePlateTypeId(java.lang.Integer licensePlateTypeId){ 
		set(MTTableVDETAILPAGEVEHICLELIST.LICENSEPLATETYPEID, licensePlateTypeId);
	} 

	public java.lang.Integer getVehicleClassId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGEVEHICLELIST.VEHICLECLASSID);
	}

	public void setVehicleClassId(java.lang.Integer vehicleClassId){ 
		set(MTTableVDETAILPAGEVEHICLELIST.VEHICLECLASSID, vehicleClassId);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGEVEHICLELIST.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVDETAILPAGEVEHICLELIST.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public VDetailPageVehicleListDTO insert() {
		return (VDetailPageVehicleListDTO) super.insert();
	}

	public static VDetailPageVehicleListDTO find(String whereExpression) {
		try {
			return new VDetailPageVehicleListDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}