package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class HPersonOrCompanyDTO extends AutoHistoryDetachedRecord{

	public HPersonOrCompanyDTO(){
		super(MTBase.getTable("HPERSONORCOMPANY"));
	}

	public HPersonOrCompanyDTO(ResultSet rs){
		super(MTBase.getTable("HPERSONORCOMPANY"), rs);
	}

	public HPersonOrCompanyDTO(Integer pk) {
		super(MTBase.getTable("HPERSONORCOMPANY"), pk);
	}

	public HPersonOrCompanyDTO(String whereClause) {
		super(MTBase.getTable("HPERSONORCOMPANY"), whereClause);
	}

	public HPersonOrCompanyDTO(Boolean isMainFk, Integer pk) {
		super(MTBase.getTable("HPERSONORCOMPANY"),isMainFk, pk);
	}

	public java.lang.Integer getPersonOrCompanyId(){ 
		return (java.lang.Integer) get(MTTableHPERSONORCOMPANY.PERSONORCOMPANYID);
	}

	public void setPersonOrCompanyId(java.lang.Integer personOrCompanyId){ 
		set(MTTableHPERSONORCOMPANY.PERSONORCOMPANYID, personOrCompanyId);
	} 

	public java.lang.Integer getIsCompany(){ 
		return (java.lang.Integer) get(MTTableHPERSONORCOMPANY.ISCOMPANY);
	}

	public void setIsCompany(java.lang.Integer isCompany){ 
		set(MTTableHPERSONORCOMPANY.ISCOMPANY, isCompany);
	} 

	public java.lang.String getSalutation(){ 
		return (java.lang.String) get(MTTableHPERSONORCOMPANY.SALUTATION);
	}

	public void setSalutation(java.lang.String salutation){ 
		set(MTTableHPERSONORCOMPANY.SALUTATION, salutation);
	} 

	public java.lang.String getFirstName(){ 
		return (java.lang.String) get(MTTableHPERSONORCOMPANY.FIRSTNAME);
	}

	public void setFirstName(java.lang.String firstName){ 
		set(MTTableHPERSONORCOMPANY.FIRSTNAME, firstName);
	} 

	public java.lang.String getMiddleName(){ 
		return (java.lang.String) get(MTTableHPERSONORCOMPANY.MIDDLENAME);
	}

	public void setMiddleName(java.lang.String middleName){ 
		set(MTTableHPERSONORCOMPANY.MIDDLENAME, middleName);
	} 

	public java.lang.String getLastNameOrCompanyName(){ 
		return (java.lang.String) get(MTTableHPERSONORCOMPANY.LASTNAMEORCOMPANYNAME);
	}

	public void setLastNameOrCompanyName(java.lang.String lastNameOrCompanyName){ 
		set(MTTableHPERSONORCOMPANY.LASTNAMEORCOMPANYNAME, lastNameOrCompanyName);
	} 

	public java.lang.String getSuffix(){ 
		return (java.lang.String) get(MTTableHPERSONORCOMPANY.SUFFIX);
	}

	public void setSuffix(java.lang.String suffix){ 
		set(MTTableHPERSONORCOMPANY.SUFFIX, suffix);
	} 

	public java.lang.String getDesignation(){ 
		return (java.lang.String) get(MTTableHPERSONORCOMPANY.DESIGNATION);
	}

	public void setDesignation(java.lang.String designation){ 
		set(MTTableHPERSONORCOMPANY.DESIGNATION, designation);
	} 

	public java.lang.String getDoingBusinessAs(){ 
		return (java.lang.String) get(MTTableHPERSONORCOMPANY.DOINGBUSINESSAS);
	}

	public void setDoingBusinessAs(java.lang.String doingBusinessAs){ 
		set(MTTableHPERSONORCOMPANY.DOINGBUSINESSAS, doingBusinessAs);
	} 

	public java.lang.Integer getPhoneNumberId(){ 
		return (java.lang.Integer) get(MTTableHPERSONORCOMPANY.PHONENUMBERID);
	}

	public void setPhoneNumberId(java.lang.Integer phoneNumberId){ 
		set(MTTableHPERSONORCOMPANY.PHONENUMBERID, phoneNumberId);
	} 

	public java.lang.Integer getEmailAddressId(){ 
		return (java.lang.Integer) get(MTTableHPERSONORCOMPANY.EMAILADDRESSID);
	}

	public void setEmailAddressId(java.lang.Integer emailAddressId){ 
		set(MTTableHPERSONORCOMPANY.EMAILADDRESSID, emailAddressId);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableHPERSONORCOMPANY.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableHPERSONORCOMPANY.REVISIONID, revisionId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableHPERSONORCOMPANY.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableHPERSONORCOMPANY.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableHPERSONORCOMPANY.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableHPERSONORCOMPANY.ENDDATE, endDate);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableHPERSONORCOMPANY.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableHPERSONORCOMPANY.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableHPERSONORCOMPANY.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableHPERSONORCOMPANY.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public HPersonOrCompanyDTO insert() {
		return (HPersonOrCompanyDTO) super.insert();
	}

	public static HPersonOrCompanyDTO find(String whereExpression) {
		try {
			return new HPersonOrCompanyDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}