package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class HPhoneNumberDTO extends AutoHistoryDetachedRecord{

	public HPhoneNumberDTO(){
		super(MTBase.getTable("HPHONENUMBER"));
	}

	public HPhoneNumberDTO(ResultSet rs){
		super(MTBase.getTable("HPHONENUMBER"), rs);
	}

	public HPhoneNumberDTO(Integer pk) {
		super(MTBase.getTable("HPHONENUMBER"), pk);
	}

	public HPhoneNumberDTO(String whereClause) {
		super(MTBase.getTable("HPHONENUMBER"), whereClause);
	}

	public HPhoneNumberDTO(Boolean isMainFk, Integer pk) {
		super(MTBase.getTable("HPHONENUMBER"),isMainFk, pk);
	}

	public java.lang.Integer getPhoneNumberId(){ 
		return (java.lang.Integer) get(MTTableHPHONENUMBER.PHONENUMBERID);
	}

	public void setPhoneNumberId(java.lang.Integer phoneNumberId){ 
		set(MTTableHPHONENUMBER.PHONENUMBERID, phoneNumberId);
	} 

	public java.lang.Integer getPhoneTypeId(){ 
		return (java.lang.Integer) get(MTTableHPHONENUMBER.PHONETYPEID);
	}

	public void setPhoneTypeId(java.lang.Integer phoneTypeId){ 
		set(MTTableHPHONENUMBER.PHONETYPEID, phoneTypeId);
	} 

	public java.lang.String getNumber(){ 
		return (java.lang.String) get(MTTableHPHONENUMBER.NUMBER);
	}

	public void setNumber(java.lang.String number){ 
		set(MTTableHPHONENUMBER.NUMBER, number);
	} 

	public java.lang.String getExtension(){ 
		return (java.lang.String) get(MTTableHPHONENUMBER.EXTENSION);
	}

	public void setExtension(java.lang.String extension){ 
		set(MTTableHPHONENUMBER.EXTENSION, extension);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableHPHONENUMBER.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableHPHONENUMBER.REVISIONID, revisionId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableHPHONENUMBER.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableHPHONENUMBER.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableHPHONENUMBER.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableHPHONENUMBER.ENDDATE, endDate);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableHPHONENUMBER.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableHPHONENUMBER.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableHPHONENUMBER.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableHPHONENUMBER.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public HPhoneNumberDTO insert() {
		return (HPhoneNumberDTO) super.insert();
	}

	public static HPhoneNumberDTO find(String whereExpression) {
		try {
			return new HPhoneNumberDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}