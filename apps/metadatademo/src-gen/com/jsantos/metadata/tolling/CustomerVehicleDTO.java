package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CustomerVehicleDTO extends DetachedRecord{

	public CustomerVehicleDTO(){
		super(MTBase.getTable("CUSTOMERVEHICLE"));
	}

	public CustomerVehicleDTO(ResultSet rs){
		super(MTBase.getTable("CUSTOMERVEHICLE"), rs);
	}

	public CustomerVehicleDTO(Integer pk) {
		super(MTBase.getTable("CUSTOMERVEHICLE"), pk);
	}

	public CustomerVehicleDTO(String whereClause) {
		super(MTBase.getTable("CUSTOMERVEHICLE"), whereClause);
	}

	public java.lang.Integer getCustomerVehicleId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERVEHICLE.CUSTOMERVEHICLEID);
	}

	public void setCustomerVehicleId(java.lang.Integer customerVehicleId){ 
		set(MTTableCUSTOMERVEHICLE.CUSTOMERVEHICLEID, customerVehicleId);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERVEHICLE.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableCUSTOMERVEHICLE.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getVehicleId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERVEHICLE.VEHICLEID);
	}

	public void setVehicleId(java.lang.Integer vehicleId){ 
		set(MTTableCUSTOMERVEHICLE.VEHICLEID, vehicleId);
	} 

	public java.util.Date getEffectiveStartDate(){ 
		return (java.util.Date) get(MTTableCUSTOMERVEHICLE.EFFECTIVESTARTDATE);
	}

	public void setEffectiveStartDate(java.util.Date effectiveStartDate){ 
		set(MTTableCUSTOMERVEHICLE.EFFECTIVESTARTDATE, effectiveStartDate);
	} 

	public java.util.Date getEffectiveEndDate(){ 
		return (java.util.Date) get(MTTableCUSTOMERVEHICLE.EFFECTIVEENDDATE);
	}

	public void setEffectiveEndDate(java.util.Date effectiveEndDate){ 
		set(MTTableCUSTOMERVEHICLE.EFFECTIVEENDDATE, effectiveEndDate);
	} 

	public void update() {
		super.update();
	}

	public CustomerVehicleDTO insert() {
		return (CustomerVehicleDTO) super.insert();
	}

	public static CustomerVehicleDTO find(String whereExpression) {
		try {
			return new CustomerVehicleDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}