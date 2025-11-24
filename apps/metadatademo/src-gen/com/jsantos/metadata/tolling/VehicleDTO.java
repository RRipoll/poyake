package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VehicleDTO extends DetachedRecord{

	public VehicleDTO(){
		super(MTBase.getTable("VEHICLE"));
	}

	public VehicleDTO(ResultSet rs){
		super(MTBase.getTable("VEHICLE"), rs);
	}

	public VehicleDTO(Integer pk) {
		super(MTBase.getTable("VEHICLE"), pk);
	}

	public VehicleDTO(String whereClause) {
		super(MTBase.getTable("VEHICLE"), whereClause);
	}

	public java.lang.Integer getVehicleId(){ 
		return (java.lang.Integer) get(MTTableVEHICLE.VEHICLEID);
	}

	public void setVehicleId(java.lang.Integer vehicleId){ 
		set(MTTableVEHICLE.VEHICLEID, vehicleId);
	} 

	public void update() {
		super.update();
	}

	public VehicleDTO insert() {
		return (VehicleDTO) super.insert();
	}

	public static VehicleDTO find(String whereExpression) {
		try {
			return new VehicleDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}