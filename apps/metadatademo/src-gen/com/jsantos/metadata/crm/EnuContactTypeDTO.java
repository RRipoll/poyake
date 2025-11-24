package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuContactTypeDTO extends DetachedRecord{

	public EnuContactTypeDTO(){
		super(MTBase.getTable("ENUCONTACTTYPE"));
	}

	public EnuContactTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUCONTACTTYPE"), rs);
	}

	public EnuContactTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUCONTACTTYPE"), pk);
	}

	public EnuContactTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUCONTACTTYPE"), whereClause);
	}

	public java.lang.Integer getContactTypeId(){ 
		return (java.lang.Integer) get(MTTableENUCONTACTTYPE.CONTACTTYPEID);
	}

	public void setContactTypeId(java.lang.Integer contactTypeId){ 
		set(MTTableENUCONTACTTYPE.CONTACTTYPEID, contactTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUCONTACTTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUCONTACTTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUCONTACTTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUCONTACTTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuContactTypeDTO insert() {
		return (EnuContactTypeDTO) super.insert();
	}

	public static EnuContactTypeDTO find(String whereExpression) {
		try {
			return new EnuContactTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}