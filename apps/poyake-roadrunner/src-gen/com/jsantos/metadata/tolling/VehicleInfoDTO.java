package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class VehicleInfoDTO extends AutoHistoryDetachedRecord{

	public VehicleInfoDTO(){
		super(MTBase.getTable("VEHICLEINFO"));
	}

	public VehicleInfoDTO(ResultSet rs){
		super(MTBase.getTable("VEHICLEINFO"), rs);
	}

	public VehicleInfoDTO(Integer pk) {
		super(MTBase.getTable("VEHICLEINFO"), pk);
	}

	public VehicleInfoDTO(String whereClause) {
		super(MTBase.getTable("VEHICLEINFO"), whereClause);
	}

	public VehicleInfoDTO(Boolean isMainFk, Integer pk) {
		super(MTBase.getTable("VEHICLEINFO"),isMainFk, pk);
	}

	public java.lang.Integer getVehicleId(){ 
		return (java.lang.Integer) get(MTTableVEHICLEINFO.VEHICLEID);
	}

	public void setVehicleId(java.lang.Integer vehicleId){ 
		set(MTTableVEHICLEINFO.VEHICLEID, vehicleId);
	} 

	public java.lang.Integer getLicensePlateId(){ 
		return (java.lang.Integer) get(MTTableVEHICLEINFO.LICENSEPLATEID);
	}

	public void setLicensePlateId(java.lang.Integer licensePlateId){ 
		set(MTTableVEHICLEINFO.LICENSEPLATEID, licensePlateId);
	} 

	public java.lang.String getColor(){ 
		return (java.lang.String) get(MTTableVEHICLEINFO.COLOR);
	}

	public void setColor(java.lang.String color){ 
		set(MTTableVEHICLEINFO.COLOR, color);
	} 

	public java.lang.String getMake(){ 
		return (java.lang.String) get(MTTableVEHICLEINFO.MAKE);
	}

	public void setMake(java.lang.String make){ 
		set(MTTableVEHICLEINFO.MAKE, make);
	} 

	public java.lang.String getModel(){ 
		return (java.lang.String) get(MTTableVEHICLEINFO.MODEL);
	}

	public void setModel(java.lang.String model){ 
		set(MTTableVEHICLEINFO.MODEL, model);
	} 

	public java.lang.Integer getVehicleClassId(){ 
		return (java.lang.Integer) get(MTTableVEHICLEINFO.VEHICLECLASSID);
	}

	public void setVehicleClassId(java.lang.Integer vehicleClassId){ 
		set(MTTableVEHICLEINFO.VEHICLECLASSID, vehicleClassId);
	} 

	public java.lang.String getStyle(){ 
		return (java.lang.String) get(MTTableVEHICLEINFO.STYLE);
	}

	public void setStyle(java.lang.String style){ 
		set(MTTableVEHICLEINFO.STYLE, style);
	} 

	public java.lang.Integer getAxles(){ 
		return (java.lang.Integer) get(MTTableVEHICLEINFO.AXLES);
	}

	public void setAxles(java.lang.Integer axles){ 
		set(MTTableVEHICLEINFO.AXLES, axles);
	} 

	public java.lang.Integer getModelYear(){ 
		return (java.lang.Integer) get(MTTableVEHICLEINFO.MODELYEAR);
	}

	public void setModelYear(java.lang.Integer modelYear){ 
		set(MTTableVEHICLEINFO.MODELYEAR, modelYear);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableVEHICLEINFO.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableVEHICLEINFO.REVISIONID, revisionId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableVEHICLEINFO.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableVEHICLEINFO.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableVEHICLEINFO.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableVEHICLEINFO.ENDDATE, endDate);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableVEHICLEINFO.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableVEHICLEINFO.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableVEHICLEINFO.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableVEHICLEINFO.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public VehicleInfoDTO insert() {
		return (VehicleInfoDTO) super.insert();
	}

	public static VehicleInfoDTO find(String whereExpression) {
		try {
			return new VehicleInfoDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}