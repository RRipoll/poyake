package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CustomerPaymentMethodDTO extends DetachedRecord{

	public CustomerPaymentMethodDTO(){
		super(MTBase.getTable("CUSTOMERPAYMENTMETHOD"));
	}

	public CustomerPaymentMethodDTO(ResultSet rs){
		super(MTBase.getTable("CUSTOMERPAYMENTMETHOD"), rs);
	}

	public CustomerPaymentMethodDTO(Integer pk) {
		super(MTBase.getTable("CUSTOMERPAYMENTMETHOD"), pk);
	}

	public CustomerPaymentMethodDTO(String whereClause) {
		super(MTBase.getTable("CUSTOMERPAYMENTMETHOD"), whereClause);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERPAYMENTMETHOD.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableCUSTOMERPAYMENTMETHOD.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getPaymentMethodId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERPAYMENTMETHOD.PAYMENTMETHODID);
	}

	public void setPaymentMethodId(java.lang.Integer paymentMethodId){ 
		set(MTTableCUSTOMERPAYMENTMETHOD.PAYMENTMETHODID, paymentMethodId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableCUSTOMERPAYMENTMETHOD.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableCUSTOMERPAYMENTMETHOD.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableCUSTOMERPAYMENTMETHOD.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableCUSTOMERPAYMENTMETHOD.ENDDATE, endDate);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERPAYMENTMETHOD.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableCUSTOMERPAYMENTMETHOD.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERPAYMENTMETHOD.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableCUSTOMERPAYMENTMETHOD.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public CustomerPaymentMethodDTO insert() {
		return (CustomerPaymentMethodDTO) super.insert();
	}

	public static CustomerPaymentMethodDTO find(String whereExpression) {
		try {
			return new CustomerPaymentMethodDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}