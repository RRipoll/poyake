package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class TripInfoDTO extends AutoHistoryDetachedRecord{

	public TripInfoDTO(){
		super(MTBase.getTable("TRIPINFO"));
	}

	public TripInfoDTO(ResultSet rs){
		super(MTBase.getTable("TRIPINFO"), rs);
	}

	public TripInfoDTO(Integer pk) {
		super(MTBase.getTable("TRIPINFO"), pk);
	}

	public TripInfoDTO(String whereClause) {
		super(MTBase.getTable("TRIPINFO"), whereClause);
	}

	public TripInfoDTO(Boolean isMainFk, Integer pk) {
		super(MTBase.getTable("TRIPINFO"),isMainFk, pk);
	}

	public java.lang.Integer getTripId(){ 
		return (java.lang.Integer) get(MTTableTRIPINFO.TRIPID);
	}

	public void setTripId(java.lang.Integer tripId){ 
		set(MTTableTRIPINFO.TRIPID, tripId);
	} 

	public java.math.BigDecimal getFareAmount(){ 
		return (java.math.BigDecimal) get(MTTableTRIPINFO.FAREAMOUNT);
	}

	public void setFareAmount(java.math.BigDecimal fareAmount){ 
		set(MTTableTRIPINFO.FAREAMOUNT, fareAmount);
	} 

	public java.util.Date getLaneExitDate(){ 
		return (java.util.Date) get(MTTableTRIPINFO.LANEEXITDATE);
	}

	public void setLaneExitDate(java.util.Date laneExitDate){ 
		set(MTTableTRIPINFO.LANEEXITDATE, laneExitDate);
	} 

	public java.lang.Integer getGantryId(){ 
		return (java.lang.Integer) get(MTTableTRIPINFO.GANTRYID);
	}

	public void setGantryId(java.lang.Integer gantryId){ 
		set(MTTableTRIPINFO.GANTRYID, gantryId);
	} 

	public java.util.Date getLaneEntryDate(){ 
		return (java.util.Date) get(MTTableTRIPINFO.LANEENTRYDATE);
	}

	public void setLaneEntryDate(java.util.Date laneEntryDate){ 
		set(MTTableTRIPINFO.LANEENTRYDATE, laneEntryDate);
	} 

	public java.lang.Integer getLicensePlateId(){ 
		return (java.lang.Integer) get(MTTableTRIPINFO.LICENSEPLATEID);
	}

	public void setLicensePlateId(java.lang.Integer licensePlateId){ 
		set(MTTableTRIPINFO.LICENSEPLATEID, licensePlateId);
	} 

	public java.lang.Integer getPassId(){ 
		return (java.lang.Integer) get(MTTableTRIPINFO.PASSID);
	}

	public void setPassId(java.lang.Integer passId){ 
		set(MTTableTRIPINFO.PASSID, passId);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableTRIPINFO.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableTRIPINFO.REVISIONID, revisionId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableTRIPINFO.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableTRIPINFO.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableTRIPINFO.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableTRIPINFO.ENDDATE, endDate);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableTRIPINFO.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableTRIPINFO.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableTRIPINFO.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableTRIPINFO.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public TripInfoDTO insert() {
		return (TripInfoDTO) super.insert();
	}

	public static TripInfoDTO find(String whereExpression) {
		try {
			return new TripInfoDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}