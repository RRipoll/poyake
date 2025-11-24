package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class ProblematicPlateDTO extends DetachedRecord{

	public ProblematicPlateDTO(){
		super(MTBase.getTable("PROBLEMATICPLATE"));
	}

	public ProblematicPlateDTO(ResultSet rs){
		super(MTBase.getTable("PROBLEMATICPLATE"), rs);
	}

	public ProblematicPlateDTO(Integer pk) {
		super(MTBase.getTable("PROBLEMATICPLATE"), pk);
	}

	public ProblematicPlateDTO(String whereClause) {
		super(MTBase.getTable("PROBLEMATICPLATE"), whereClause);
	}

	public java.lang.Integer getProblematicPlateId(){ 
		return (java.lang.Integer) get(MTTablePROBLEMATICPLATE.PROBLEMATICPLATEID);
	}

	public void setProblematicPlateId(java.lang.Integer problematicPlateId){ 
		set(MTTablePROBLEMATICPLATE.PROBLEMATICPLATEID, problematicPlateId);
	} 

	public java.lang.Integer getLicensePlateId(){ 
		return (java.lang.Integer) get(MTTablePROBLEMATICPLATE.LICENSEPLATEID);
	}

	public void setLicensePlateId(java.lang.Integer licensePlateId){ 
		set(MTTablePROBLEMATICPLATE.LICENSEPLATEID, licensePlateId);
	} 

	public java.lang.Integer getProblematicPlateReasonId(){ 
		return (java.lang.Integer) get(MTTablePROBLEMATICPLATE.PROBLEMATICPLATEREASONID);
	}

	public void setProblematicPlateReasonId(java.lang.Integer problematicPlateReasonId){ 
		set(MTTablePROBLEMATICPLATE.PROBLEMATICPLATEREASONID, problematicPlateReasonId);
	} 

	public java.lang.String getNotes(){ 
		return (java.lang.String) get(MTTablePROBLEMATICPLATE.NOTES);
	}

	public void setNotes(java.lang.String notes){ 
		set(MTTablePROBLEMATICPLATE.NOTES, notes);
	} 

	public void update() {
		super.update();
	}

	public ProblematicPlateDTO insert() {
		return (ProblematicPlateDTO) super.insert();
	}

	public static ProblematicPlateDTO find(String whereExpression) {
		try {
			return new ProblematicPlateDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}