package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class PromoDTO extends DetachedRecord{

	public PromoDTO(){
		super(MTBase.getTable("PROMO"));
	}

	public PromoDTO(ResultSet rs){
		super(MTBase.getTable("PROMO"), rs);
	}

	public PromoDTO(Integer pk) {
		super(MTBase.getTable("PROMO"), pk);
	}

	public PromoDTO(String whereClause) {
		super(MTBase.getTable("PROMO"), whereClause);
	}

	public java.lang.Integer getPromoId(){ 
		return (java.lang.Integer) get(MTTablePROMO.PROMOID);
	}

	public void setPromoId(java.lang.Integer promoId){ 
		set(MTTablePROMO.PROMOID, promoId);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTablePROMO.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTablePROMO.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getPromoTypeId(){ 
		return (java.lang.Integer) get(MTTablePROMO.PROMOTYPEID);
	}

	public void setPromoTypeId(java.lang.Integer promoTypeId){ 
		set(MTTablePROMO.PROMOTYPEID, promoTypeId);
	} 

	public void update() {
		super.update();
	}

	public PromoDTO insert() {
		return (PromoDTO) super.insert();
	}

	public static PromoDTO find(String whereExpression) {
		try {
			return new PromoDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}