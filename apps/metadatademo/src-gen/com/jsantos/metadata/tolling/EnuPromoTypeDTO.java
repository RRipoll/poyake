package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuPromoTypeDTO extends DetachedRecord{

	public EnuPromoTypeDTO(){
		super(MTBase.getTable("ENUPROMOTYPE"));
	}

	public EnuPromoTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUPROMOTYPE"), rs);
	}

	public EnuPromoTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUPROMOTYPE"), pk);
	}

	public EnuPromoTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUPROMOTYPE"), whereClause);
	}

	public java.lang.Integer getEnuPromoTypeId(){ 
		return (java.lang.Integer) get(MTTableENUPROMOTYPE.ENUPROMOTYPEID);
	}

	public void setEnuPromoTypeId(java.lang.Integer enuPromoTypeId){ 
		set(MTTableENUPROMOTYPE.ENUPROMOTYPEID, enuPromoTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUPROMOTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUPROMOTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUPROMOTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUPROMOTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuPromoTypeDTO insert() {
		return (EnuPromoTypeDTO) super.insert();
	}

	public static EnuPromoTypeDTO find(String whereExpression) {
		try {
			return new EnuPromoTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}