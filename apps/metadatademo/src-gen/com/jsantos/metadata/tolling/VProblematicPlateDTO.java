package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VProblematicPlateDTO extends DetachedRecord{

	public VProblematicPlateDTO(){
		super(MTBase.getTable("VPROBLEMATICPLATE"));
	}

	public VProblematicPlateDTO(ResultSet rs){
		super(MTBase.getTable("VPROBLEMATICPLATE"), rs);
	}

	public VProblematicPlateDTO(Integer pk) {
		super(MTBase.getTable("VPROBLEMATICPLATE"), pk);
	}

	public VProblematicPlateDTO(String whereClause) {
		super(MTBase.getTable("VPROBLEMATICPLATE"), whereClause);
	}

	public java.lang.Integer getProblematicPlateId(){ 
		return (java.lang.Integer) get(MTTableVPROBLEMATICPLATE.PROBLEMATICPLATEID);
	}

	public void setProblematicPlateId(java.lang.Integer problematicPlateId){ 
		set(MTTableVPROBLEMATICPLATE.PROBLEMATICPLATEID, problematicPlateId);
	} 

	public java.lang.Integer getLicencePlateJurisdictionId(){ 
		return (java.lang.Integer) get(MTTableVPROBLEMATICPLATE.LICENCEPLATEJURISDICTIONID);
	}

	public void setLicencePlateJurisdictionId(java.lang.Integer licencePlateJurisdictionId){ 
		set(MTTableVPROBLEMATICPLATE.LICENCEPLATEJURISDICTIONID, licencePlateJurisdictionId);
	} 

	public java.lang.String getLpnumber(){ 
		return (java.lang.String) get(MTTableVPROBLEMATICPLATE.LPNUMBER);
	}

	public void setLpnumber(java.lang.String lpnumber){ 
		set(MTTableVPROBLEMATICPLATE.LPNUMBER, lpnumber);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVPROBLEMATICPLATE.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVPROBLEMATICPLATE.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getProblematicPlateReasonId(){ 
		return (java.lang.Integer) get(MTTableVPROBLEMATICPLATE.PROBLEMATICPLATEREASONID);
	}

	public void setProblematicPlateReasonId(java.lang.Integer problematicPlateReasonId){ 
		set(MTTableVPROBLEMATICPLATE.PROBLEMATICPLATEREASONID, problematicPlateReasonId);
	} 

	public java.lang.String getNotes(){ 
		return (java.lang.String) get(MTTableVPROBLEMATICPLATE.NOTES);
	}

	public void setNotes(java.lang.String notes){ 
		set(MTTableVPROBLEMATICPLATE.NOTES, notes);
	} 

	public void update() {
		super.update();
	}

	public VProblematicPlateDTO insert() {
		return (VProblematicPlateDTO) super.insert();
	}

	public static VProblematicPlateDTO find(String whereExpression) {
		try {
			return new VProblematicPlateDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}