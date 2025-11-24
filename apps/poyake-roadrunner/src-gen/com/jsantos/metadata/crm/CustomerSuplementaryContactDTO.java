package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CustomerSuplementaryContactDTO extends DetachedRecord{

	public CustomerSuplementaryContactDTO(){
		super(MTBase.getTable("CUSTOMERSUPLEMENTARYCONTACT"));
	}

	public CustomerSuplementaryContactDTO(ResultSet rs){
		super(MTBase.getTable("CUSTOMERSUPLEMENTARYCONTACT"), rs);
	}

	public CustomerSuplementaryContactDTO(Integer pk) {
		super(MTBase.getTable("CUSTOMERSUPLEMENTARYCONTACT"), pk);
	}

	public CustomerSuplementaryContactDTO(String whereClause) {
		super(MTBase.getTable("CUSTOMERSUPLEMENTARYCONTACT"), whereClause);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERSUPLEMENTARYCONTACT.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableCUSTOMERSUPLEMENTARYCONTACT.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getPersonOrCompanyId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERSUPLEMENTARYCONTACT.PERSONORCOMPANYID);
	}

	public void setPersonOrCompanyId(java.lang.Integer personOrCompanyId){ 
		set(MTTableCUSTOMERSUPLEMENTARYCONTACT.PERSONORCOMPANYID, personOrCompanyId);
	} 

	public java.lang.Integer getContactTypeId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERSUPLEMENTARYCONTACT.CONTACTTYPEID);
	}

	public void setContactTypeId(java.lang.Integer contactTypeId){ 
		set(MTTableCUSTOMERSUPLEMENTARYCONTACT.CONTACTTYPEID, contactTypeId);
	} 

	public void update() {
		super.update();
	}

	public CustomerSuplementaryContactDTO insert() {
		return (CustomerSuplementaryContactDTO) super.insert();
	}

	public static CustomerSuplementaryContactDTO find(String whereExpression) {
		try {
			return new CustomerSuplementaryContactDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}