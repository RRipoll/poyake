package com.jsantos.metadata.payment;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class PaymentMethodDTO extends DetachedRecord{

	public PaymentMethodDTO(){
		super(MTBase.getTable("PAYMENTMETHOD"));
	}

	public PaymentMethodDTO(ResultSet rs){
		super(MTBase.getTable("PAYMENTMETHOD"), rs);
	}

	public PaymentMethodDTO(Integer pk) {
		super(MTBase.getTable("PAYMENTMETHOD"), pk);
	}

	public PaymentMethodDTO(String whereClause) {
		super(MTBase.getTable("PAYMENTMETHOD"), whereClause);
	}

	public java.lang.Integer getPaymentMethodId(){ 
		return (java.lang.Integer) get(MTTablePAYMENTMETHOD.PAYMENTMETHODID);
	}

	public void setPaymentMethodId(java.lang.Integer paymentMethodId){ 
		set(MTTablePAYMENTMETHOD.PAYMENTMETHODID, paymentMethodId);
	} 

	public java.lang.Integer getPaymentTypeId(){ 
		return (java.lang.Integer) get(MTTablePAYMENTMETHOD.PAYMENTTYPEID);
	}

	public void setPaymentTypeId(java.lang.Integer paymentTypeId){ 
		set(MTTablePAYMENTMETHOD.PAYMENTTYPEID, paymentTypeId);
	} 

	public java.lang.String getCcNumber(){ 
		return (java.lang.String) get(MTTablePAYMENTMETHOD.CCNUMBER);
	}

	public void setCcNumber(java.lang.String ccNumber){ 
		set(MTTablePAYMENTMETHOD.CCNUMBER, ccNumber);
	} 

	public java.lang.String getAccountNumber(){ 
		return (java.lang.String) get(MTTablePAYMENTMETHOD.ACCOUNTNUMBER);
	}

	public void setAccountNumber(java.lang.String accountNumber){ 
		set(MTTablePAYMENTMETHOD.ACCOUNTNUMBER, accountNumber);
	} 

	public java.lang.String getCheckNumber(){ 
		return (java.lang.String) get(MTTablePAYMENTMETHOD.CHECKNUMBER);
	}

	public void setCheckNumber(java.lang.String checkNumber){ 
		set(MTTablePAYMENTMETHOD.CHECKNUMBER, checkNumber);
	} 

	public void update() {
		super.update();
	}

	public PaymentMethodDTO insert() {
		return (PaymentMethodDTO) super.insert();
	}

	public static PaymentMethodDTO find(String whereExpression) {
		try {
			return new PaymentMethodDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}