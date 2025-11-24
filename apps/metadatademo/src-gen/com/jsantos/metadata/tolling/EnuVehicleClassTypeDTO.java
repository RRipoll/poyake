package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuVehicleClassTypeDTO extends DetachedRecord{

	public EnuVehicleClassTypeDTO(){
		super(MTBase.getTable("ENUVEHICLECLASSTYPE"));
	}

	public EnuVehicleClassTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUVEHICLECLASSTYPE"), rs);
	}

	public EnuVehicleClassTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUVEHICLECLASSTYPE"), pk);
	}

	public EnuVehicleClassTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUVEHICLECLASSTYPE"), whereClause);
	}

	public java.lang.Integer getVehicleClassTypeId(){ 
		return (java.lang.Integer) get(MTTableENUVEHICLECLASSTYPE.VEHICLECLASSTYPEID);
	}

	public void setVehicleClassTypeId(java.lang.Integer vehicleClassTypeId){ 
		set(MTTableENUVEHICLECLASSTYPE.VEHICLECLASSTYPEID, vehicleClassTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUVEHICLECLASSTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUVEHICLECLASSTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUVEHICLECLASSTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUVEHICLECLASSTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuVehicleClassTypeDTO insert() {
		return (EnuVehicleClassTypeDTO) super.insert();
	}

	public static EnuVehicleClassTypeDTO find(String whereExpression) {
		try {
			return new EnuVehicleClassTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}