package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class HEmailAddressDTO extends AutoHistoryDetachedRecord{

	public HEmailAddressDTO(){
		super(MTBase.getTable("HEMAILADDRESS"));
	}

	public HEmailAddressDTO(ResultSet rs){
		super(MTBase.getTable("HEMAILADDRESS"), rs);
	}

	public HEmailAddressDTO(Integer pk) {
		super(MTBase.getTable("HEMAILADDRESS"), pk);
	}

	public HEmailAddressDTO(String whereClause) {
		super(MTBase.getTable("HEMAILADDRESS"), whereClause);
	}

	public HEmailAddressDTO(Boolean isMainFk, Integer pk) {
		super(MTBase.getTable("HEMAILADDRESS"),isMainFk, pk);
	}

	public java.lang.Integer getEmailAddressId(){ 
		return (java.lang.Integer) get(MTTableHEMAILADDRESS.EMAILADDRESSID);
	}

	public void setEmailAddressId(java.lang.Integer emailAddressId){ 
		set(MTTableHEMAILADDRESS.EMAILADDRESSID, emailAddressId);
	} 

	public java.lang.String getAddress(){ 
		return (java.lang.String) get(MTTableHEMAILADDRESS.ADDRESS);
	}

	public void setAddress(java.lang.String address){ 
		set(MTTableHEMAILADDRESS.ADDRESS, address);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableHEMAILADDRESS.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableHEMAILADDRESS.REVISIONID, revisionId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableHEMAILADDRESS.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableHEMAILADDRESS.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableHEMAILADDRESS.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableHEMAILADDRESS.ENDDATE, endDate);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableHEMAILADDRESS.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableHEMAILADDRESS.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableHEMAILADDRESS.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableHEMAILADDRESS.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public HEmailAddressDTO insert() {
		return (HEmailAddressDTO) super.insert();
	}

	public static HEmailAddressDTO find(String whereExpression) {
		try {
			return new HEmailAddressDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}