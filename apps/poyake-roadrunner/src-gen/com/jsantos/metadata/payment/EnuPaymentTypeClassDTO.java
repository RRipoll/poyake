package com.jsantos.metadata.payment;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuPaymentTypeClassDTO extends DetachedRecord{

	public EnuPaymentTypeClassDTO(){
		super(MTBase.getTable("ENUPAYMENTTYPECLASS"));
	}

	public EnuPaymentTypeClassDTO(ResultSet rs){
		super(MTBase.getTable("ENUPAYMENTTYPECLASS"), rs);
	}

	public EnuPaymentTypeClassDTO(Integer pk) {
		super(MTBase.getTable("ENUPAYMENTTYPECLASS"), pk);
	}

	public EnuPaymentTypeClassDTO(String whereClause) {
		super(MTBase.getTable("ENUPAYMENTTYPECLASS"), whereClause);
	}

	public java.lang.Integer getPaymentTypeClassId(){ 
		return (java.lang.Integer) get(MTTableENUPAYMENTTYPECLASS.PAYMENTTYPECLASSID);
	}

	public void setPaymentTypeClassId(java.lang.Integer paymentTypeClassId){ 
		set(MTTableENUPAYMENTTYPECLASS.PAYMENTTYPECLASSID, paymentTypeClassId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUPAYMENTTYPECLASS.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUPAYMENTTYPECLASS.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUPAYMENTTYPECLASS.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUPAYMENTTYPECLASS.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuPaymentTypeClassDTO insert() {
		return (EnuPaymentTypeClassDTO) super.insert();
	}

	public static EnuPaymentTypeClassDTO find(String whereExpression) {
		try {
			return new EnuPaymentTypeClassDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}