package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuVehicleClassDTO extends DetachedRecord{

	public EnuVehicleClassDTO(){
		super(MTBase.getTable("ENUVEHICLECLASS"));
	}

	public EnuVehicleClassDTO(ResultSet rs){
		super(MTBase.getTable("ENUVEHICLECLASS"), rs);
	}

	public EnuVehicleClassDTO(Integer pk) {
		super(MTBase.getTable("ENUVEHICLECLASS"), pk);
	}

	public EnuVehicleClassDTO(String whereClause) {
		super(MTBase.getTable("ENUVEHICLECLASS"), whereClause);
	}

	public java.lang.Integer getVehicleClassId(){ 
		return (java.lang.Integer) get(MTTableENUVEHICLECLASS.VEHICLECLASSID);
	}

	public void setVehicleClassId(java.lang.Integer vehicleClassId){ 
		set(MTTableENUVEHICLECLASS.VEHICLECLASSID, vehicleClassId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUVEHICLECLASS.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUVEHICLECLASS.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUVEHICLECLASS.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUVEHICLECLASS.DESCRIPTION, description);
	} 

	public java.lang.Integer getVehicleClassTypeId(){ 
		return (java.lang.Integer) get(MTTableENUVEHICLECLASS.VEHICLECLASSTYPEID);
	}

	public void setVehicleClassTypeId(java.lang.Integer vehicleClassTypeId){ 
		set(MTTableENUVEHICLECLASS.VEHICLECLASSTYPEID, vehicleClassTypeId);
	} 

	public java.lang.Integer getAigCode(){ 
		return (java.lang.Integer) get(MTTableENUVEHICLECLASS.AIGCODE);
	}

	public void setAigCode(java.lang.Integer aigCode){ 
		set(MTTableENUVEHICLECLASS.AIGCODE, aigCode);
	} 

	public void update() {
		super.update();
	}

	public EnuVehicleClassDTO insert() {
		return (EnuVehicleClassDTO) super.insert();
	}

	public static EnuVehicleClassDTO find(String whereExpression) {
		try {
			return new EnuVehicleClassDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}