package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuProblematicPlateReasonDTO extends DetachedRecord{

	public EnuProblematicPlateReasonDTO(){
		super(MTBase.getTable("ENUPROBLEMATICPLATEREASON"));
	}

	public EnuProblematicPlateReasonDTO(ResultSet rs){
		super(MTBase.getTable("ENUPROBLEMATICPLATEREASON"), rs);
	}

	public EnuProblematicPlateReasonDTO(Integer pk) {
		super(MTBase.getTable("ENUPROBLEMATICPLATEREASON"), pk);
	}

	public EnuProblematicPlateReasonDTO(String whereClause) {
		super(MTBase.getTable("ENUPROBLEMATICPLATEREASON"), whereClause);
	}

	public java.lang.Integer getProblematicPlateReason(){ 
		return (java.lang.Integer) get(MTTableENUPROBLEMATICPLATEREASON.PROBLEMATICPLATEREASON);
	}

	public void setProblematicPlateReason(java.lang.Integer problematicPlateReason){ 
		set(MTTableENUPROBLEMATICPLATEREASON.PROBLEMATICPLATEREASON, problematicPlateReason);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUPROBLEMATICPLATEREASON.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUPROBLEMATICPLATEREASON.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUPROBLEMATICPLATEREASON.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUPROBLEMATICPLATEREASON.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuProblematicPlateReasonDTO insert() {
		return (EnuProblematicPlateReasonDTO) super.insert();
	}

	public static EnuProblematicPlateReasonDTO find(String whereExpression) {
		try {
			return new EnuProblematicPlateReasonDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}