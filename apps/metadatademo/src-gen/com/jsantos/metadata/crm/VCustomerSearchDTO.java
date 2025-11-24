package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VCustomerSearchDTO extends DetachedRecord{

	public VCustomerSearchDTO(){
		super(MTBase.getTable("VCUSTOMERSEARCH"));
	}

	public VCustomerSearchDTO(ResultSet rs){
		super(MTBase.getTable("VCUSTOMERSEARCH"), rs);
	}

	public VCustomerSearchDTO(Integer pk) {
		super(MTBase.getTable("VCUSTOMERSEARCH"), pk);
	}

	public VCustomerSearchDTO(String whereClause) {
		super(MTBase.getTable("VCUSTOMERSEARCH"), whereClause);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERSEARCH.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVCUSTOMERSEARCH.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getCustomerTypeId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERSEARCH.CUSTOMERTYPEID);
	}

	public void setCustomerTypeId(java.lang.Integer customerTypeId){ 
		set(MTTableVCUSTOMERSEARCH.CUSTOMERTYPEID, customerTypeId);
	} 

	public java.lang.String getFullName(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCH.FULLNAME);
	}

	public void setFullName(java.lang.String fullName){ 
		set(MTTableVCUSTOMERSEARCH.FULLNAME, fullName);
	} 

	public java.lang.String getMailingAddress(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCH.MAILINGADDRESS);
	}

	public void setMailingAddress(java.lang.String mailingAddress){ 
		set(MTTableVCUSTOMERSEARCH.MAILINGADDRESS, mailingAddress);
	} 

	public java.lang.String getFirstName(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCH.FIRSTNAME);
	}

	public void setFirstName(java.lang.String firstName){ 
		set(MTTableVCUSTOMERSEARCH.FIRSTNAME, firstName);
	} 

	public java.lang.String getLastNameOrCompanyName(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCH.LASTNAMEORCOMPANYNAME);
	}

	public void setLastNameOrCompanyName(java.lang.String lastNameOrCompanyName){ 
		set(MTTableVCUSTOMERSEARCH.LASTNAMEORCOMPANYNAME, lastNameOrCompanyName);
	} 

	public java.lang.String getNumber(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCH.NUMBER);
	}

	public void setNumber(java.lang.String number){ 
		set(MTTableVCUSTOMERSEARCH.NUMBER, number);
	} 

	public java.lang.String getAddress(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCH.ADDRESS);
	}

	public void setAddress(java.lang.String address){ 
		set(MTTableVCUSTOMERSEARCH.ADDRESS, address);
	} 

	public java.lang.String getLastInvoice(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCH.LASTINVOICE);
	}

	public void setLastInvoice(java.lang.String lastInvoice){ 
		set(MTTableVCUSTOMERSEARCH.LASTINVOICE, lastInvoice);
	} 

	public java.lang.Integer getLastInvoiceId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERSEARCH.LASTINVOICEID);
	}

	public void setLastInvoiceId(java.lang.Integer lastInvoiceId){ 
		set(MTTableVCUSTOMERSEARCH.LASTINVOICEID, lastInvoiceId);
	} 

	public void update() {
		super.update();
	}

	public VCustomerSearchDTO insert() {
		return (VCustomerSearchDTO) super.insert();
	}

	public static VCustomerSearchDTO find(String whereExpression) {
		try {
			return new VCustomerSearchDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}