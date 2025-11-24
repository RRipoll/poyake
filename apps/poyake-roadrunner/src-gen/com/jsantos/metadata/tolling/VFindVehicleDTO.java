package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VFindVehicleDTO extends DetachedRecord{

	public VFindVehicleDTO(){
		super(MTBase.getTable("VFINDVEHICLE"));
	}

	public VFindVehicleDTO(ResultSet rs){
		super(MTBase.getTable("VFINDVEHICLE"), rs);
	}

	public VFindVehicleDTO(Integer pk) {
		super(MTBase.getTable("VFINDVEHICLE"), pk);
	}

	public VFindVehicleDTO(String whereClause) {
		super(MTBase.getTable("VFINDVEHICLE"), whereClause);
	}

	public java.lang.Integer getVehicleId(){ 
		return (java.lang.Integer) get(MTTableVFINDVEHICLE.VEHICLEID);
	}

	public void setVehicleId(java.lang.Integer vehicleId){ 
		set(MTTableVFINDVEHICLE.VEHICLEID, vehicleId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableVFINDVEHICLE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableVFINDVEHICLE.SHORTCODE, shortCode);
	} 

	public java.lang.String getLpnumber(){ 
		return (java.lang.String) get(MTTableVFINDVEHICLE.LPNUMBER);
	}

	public void setLpnumber(java.lang.String lpnumber){ 
		set(MTTableVFINDVEHICLE.LPNUMBER, lpnumber);
	} 

	public java.lang.String getMake(){ 
		return (java.lang.String) get(MTTableVFINDVEHICLE.MAKE);
	}

	public void setMake(java.lang.String make){ 
		set(MTTableVFINDVEHICLE.MAKE, make);
	} 

	public java.lang.String getModel(){ 
		return (java.lang.String) get(MTTableVFINDVEHICLE.MODEL);
	}

	public void setModel(java.lang.String model){ 
		set(MTTableVFINDVEHICLE.MODEL, model);
	} 

	public java.lang.Integer getModelYear(){ 
		return (java.lang.Integer) get(MTTableVFINDVEHICLE.MODELYEAR);
	}

	public void setModelYear(java.lang.Integer modelYear){ 
		set(MTTableVFINDVEHICLE.MODELYEAR, modelYear);
	} 

	public java.lang.String getColor(){ 
		return (java.lang.String) get(MTTableVFINDVEHICLE.COLOR);
	}

	public void setColor(java.lang.String color){ 
		set(MTTableVFINDVEHICLE.COLOR, color);
	} 

	public java.lang.Integer getAxles(){ 
		return (java.lang.Integer) get(MTTableVFINDVEHICLE.AXLES);
	}

	public void setAxles(java.lang.Integer axles){ 
		set(MTTableVFINDVEHICLE.AXLES, axles);
	} 

	public java.lang.Integer getVehicleClassId(){ 
		return (java.lang.Integer) get(MTTableVFINDVEHICLE.VEHICLECLASSID);
	}

	public void setVehicleClassId(java.lang.Integer vehicleClassId){ 
		set(MTTableVFINDVEHICLE.VEHICLECLASSID, vehicleClassId);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVFINDVEHICLE.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVFINDVEHICLE.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getLicensePlateId(){ 
		return (java.lang.Integer) get(MTTableVFINDVEHICLE.LICENSEPLATEID);
	}

	public void setLicensePlateId(java.lang.Integer licensePlateId){ 
		set(MTTableVFINDVEHICLE.LICENSEPLATEID, licensePlateId);
	} 

	public void update() {
		super.update();
	}

	public VFindVehicleDTO insert() {
		return (VFindVehicleDTO) super.insert();
	}

	public static VFindVehicleDTO find(String whereExpression) {
		try {
			return new VFindVehicleDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}