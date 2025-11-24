package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class HCustomerDTO extends AutoHistoryDetachedRecord{

	public HCustomerDTO(){
		super(MTBase.getTable("HCUSTOMER"));
	}

	public HCustomerDTO(ResultSet rs){
		super(MTBase.getTable("HCUSTOMER"), rs);
	}

	public HCustomerDTO(Integer pk) {
		super(MTBase.getTable("HCUSTOMER"), pk);
	}

	public HCustomerDTO(String whereClause) {
		super(MTBase.getTable("HCUSTOMER"), whereClause);
	}

	public HCustomerDTO(Boolean isMainFk, Integer pk) {
		super(MTBase.getTable("HCUSTOMER"),isMainFk, pk);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableHCUSTOMER.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableHCUSTOMER.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getMainContactPersonOrCompanyId(){ 
		return (java.lang.Integer) get(MTTableHCUSTOMER.MAINCONTACTPERSONORCOMPANYID);
	}

	public void setMainContactPersonOrCompanyId(java.lang.Integer mainContactPersonOrCompanyId){ 
		set(MTTableHCUSTOMER.MAINCONTACTPERSONORCOMPANYID, mainContactPersonOrCompanyId);
	} 

	public java.lang.Integer getMailingPostalAddressId(){ 
		return (java.lang.Integer) get(MTTableHCUSTOMER.MAILINGPOSTALADDRESSID);
	}

	public void setMailingPostalAddressId(java.lang.Integer mailingPostalAddressId){ 
		set(MTTableHCUSTOMER.MAILINGPOSTALADDRESSID, mailingPostalAddressId);
	} 

	public java.lang.Integer getShippingPostalAddressId(){ 
		return (java.lang.Integer) get(MTTableHCUSTOMER.SHIPPINGPOSTALADDRESSID);
	}

	public void setShippingPostalAddressId(java.lang.Integer shippingPostalAddressId){ 
		set(MTTableHCUSTOMER.SHIPPINGPOSTALADDRESSID, shippingPostalAddressId);
	} 

	public java.lang.Integer getCustomerTypeId(){ 
		return (java.lang.Integer) get(MTTableHCUSTOMER.CUSTOMERTYPEID);
	}

	public void setCustomerTypeId(java.lang.Integer customerTypeId){ 
		set(MTTableHCUSTOMER.CUSTOMERTYPEID, customerTypeId);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableHCUSTOMER.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableHCUSTOMER.REVISIONID, revisionId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableHCUSTOMER.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableHCUSTOMER.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableHCUSTOMER.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableHCUSTOMER.ENDDATE, endDate);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableHCUSTOMER.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableHCUSTOMER.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableHCUSTOMER.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableHCUSTOMER.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public HCustomerDTO insert() {
		return (HCustomerDTO) super.insert();
	}

	public static HCustomerDTO find(String whereExpression) {
		try {
			return new HCustomerDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}