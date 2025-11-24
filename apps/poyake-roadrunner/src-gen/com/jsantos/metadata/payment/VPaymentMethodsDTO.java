package com.jsantos.metadata.payment;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VPaymentMethodsDTO extends DetachedRecord{

	public VPaymentMethodsDTO(){
		super(MTBase.getTable("VPAYMENTMETHODS"));
	}

	public VPaymentMethodsDTO(ResultSet rs){
		super(MTBase.getTable("VPAYMENTMETHODS"), rs);
	}

	public VPaymentMethodsDTO(Integer pk) {
		super(MTBase.getTable("VPAYMENTMETHODS"), pk);
	}

	public VPaymentMethodsDTO(String whereClause) {
		super(MTBase.getTable("VPAYMENTMETHODS"), whereClause);
	}

	public java.lang.Integer getPaymentMethodId(){ 
		return (java.lang.Integer) get(MTTableVPAYMENTMETHODS.PAYMENTMETHODID);
	}

	public void setPaymentMethodId(java.lang.Integer paymentMethodId){ 
		set(MTTableVPAYMENTMETHODS.PAYMENTMETHODID, paymentMethodId);
	} 

	public java.lang.Integer getPaymentTypeClassId(){ 
		return (java.lang.Integer) get(MTTableVPAYMENTMETHODS.PAYMENTTYPECLASSID);
	}

	public void setPaymentTypeClassId(java.lang.Integer paymentTypeClassId){ 
		set(MTTableVPAYMENTMETHODS.PAYMENTTYPECLASSID, paymentTypeClassId);
	} 

	public java.lang.Integer getPaymentTypeId(){ 
		return (java.lang.Integer) get(MTTableVPAYMENTMETHODS.PAYMENTTYPEID);
	}

	public void setPaymentTypeId(java.lang.Integer paymentTypeId){ 
		set(MTTableVPAYMENTMETHODS.PAYMENTTYPEID, paymentTypeId);
	} 

	public java.lang.String getNumber(){ 
		return (java.lang.String) get(MTTableVPAYMENTMETHODS.NUMBER);
	}

	public void setNumber(java.lang.String number){ 
		set(MTTableVPAYMENTMETHODS.NUMBER, number);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVPAYMENTMETHODS.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVPAYMENTMETHODS.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public VPaymentMethodsDTO insert() {
		return (VPaymentMethodsDTO) super.insert();
	}

	public static VPaymentMethodsDTO find(String whereExpression) {
		try {
			return new VPaymentMethodsDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}