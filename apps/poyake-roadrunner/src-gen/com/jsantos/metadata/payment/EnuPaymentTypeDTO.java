package com.jsantos.metadata.payment;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuPaymentTypeDTO extends DetachedRecord{

	public EnuPaymentTypeDTO(){
		super(MTBase.getTable("ENUPAYMENTTYPE"));
	}

	public EnuPaymentTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUPAYMENTTYPE"), rs);
	}

	public EnuPaymentTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUPAYMENTTYPE"), pk);
	}

	public EnuPaymentTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUPAYMENTTYPE"), whereClause);
	}

	public java.lang.Integer getPaymentTypeId(){ 
		return (java.lang.Integer) get(MTTableENUPAYMENTTYPE.PAYMENTTYPEID);
	}

	public void setPaymentTypeId(java.lang.Integer paymentTypeId){ 
		set(MTTableENUPAYMENTTYPE.PAYMENTTYPEID, paymentTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUPAYMENTTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUPAYMENTTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUPAYMENTTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUPAYMENTTYPE.DESCRIPTION, description);
	} 

	public java.lang.Integer getPaymentTypeClassId(){ 
		return (java.lang.Integer) get(MTTableENUPAYMENTTYPE.PAYMENTTYPECLASSID);
	}

	public void setPaymentTypeClassId(java.lang.Integer paymentTypeClassId){ 
		set(MTTableENUPAYMENTTYPE.PAYMENTTYPECLASSID, paymentTypeClassId);
	} 

	public void update() {
		super.update();
	}

	public EnuPaymentTypeDTO insert() {
		return (EnuPaymentTypeDTO) super.insert();
	}

	public static EnuPaymentTypeDTO find(String whereExpression) {
		try {
			return new EnuPaymentTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}