package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VCustomerSearchEditorDTO extends DetachedRecord{

	public VCustomerSearchEditorDTO(){
		super(MTBase.getTable("VCUSTOMERSEARCHEDITOR"));
	}

	public VCustomerSearchEditorDTO(ResultSet rs){
		super(MTBase.getTable("VCUSTOMERSEARCHEDITOR"), rs);
	}

	public VCustomerSearchEditorDTO(Integer pk) {
		super(MTBase.getTable("VCUSTOMERSEARCHEDITOR"), pk);
	}

	public VCustomerSearchEditorDTO(String whereClause) {
		super(MTBase.getTable("VCUSTOMERSEARCHEDITOR"), whereClause);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERSEARCHEDITOR.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVCUSTOMERSEARCHEDITOR.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getCustomerTypeId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERSEARCHEDITOR.CUSTOMERTYPEID);
	}

	public void setCustomerTypeId(java.lang.Integer customerTypeId){ 
		set(MTTableVCUSTOMERSEARCHEDITOR.CUSTOMERTYPEID, customerTypeId);
	} 

	public java.lang.String getFullName(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCHEDITOR.FULLNAME);
	}

	public void setFullName(java.lang.String fullName){ 
		set(MTTableVCUSTOMERSEARCHEDITOR.FULLNAME, fullName);
	} 

	public java.lang.String getMailingAddress(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCHEDITOR.MAILINGADDRESS);
	}

	public void setMailingAddress(java.lang.String mailingAddress){ 
		set(MTTableVCUSTOMERSEARCHEDITOR.MAILINGADDRESS, mailingAddress);
	} 

	public java.lang.String getPhonenumer(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCHEDITOR.PHONENUMER);
	}

	public void setPhonenumer(java.lang.String phonenumer){ 
		set(MTTableVCUSTOMERSEARCHEDITOR.PHONENUMER, phonenumer);
	} 

	public java.lang.String getEmail(){ 
		return (java.lang.String) get(MTTableVCUSTOMERSEARCHEDITOR.EMAIL);
	}

	public void setEmail(java.lang.String email){ 
		set(MTTableVCUSTOMERSEARCHEDITOR.EMAIL, email);
	} 

	public void update() {
		super.update();
	}

	public VCustomerSearchEditorDTO insert() {
		return (VCustomerSearchEditorDTO) super.insert();
	}

	public static VCustomerSearchEditorDTO find(String whereExpression) {
		try {
			return new VCustomerSearchEditorDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}