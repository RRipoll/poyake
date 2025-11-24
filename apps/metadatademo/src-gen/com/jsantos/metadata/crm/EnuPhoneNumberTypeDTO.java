package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuPhoneNumberTypeDTO extends DetachedRecord{

	public EnuPhoneNumberTypeDTO(){
		super(MTBase.getTable("ENUPHONENUMBERTYPE"));
	}

	public EnuPhoneNumberTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUPHONENUMBERTYPE"), rs);
	}

	public EnuPhoneNumberTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUPHONENUMBERTYPE"), pk);
	}

	public EnuPhoneNumberTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUPHONENUMBERTYPE"), whereClause);
	}

	public java.lang.Integer getPhoneNumberTypeId(){ 
		return (java.lang.Integer) get(MTTableENUPHONENUMBERTYPE.PHONENUMBERTYPEID);
	}

	public void setPhoneNumberTypeId(java.lang.Integer phoneNumberTypeId){ 
		set(MTTableENUPHONENUMBERTYPE.PHONENUMBERTYPEID, phoneNumberTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUPHONENUMBERTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUPHONENUMBERTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUPHONENUMBERTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUPHONENUMBERTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuPhoneNumberTypeDTO insert() {
		return (EnuPhoneNumberTypeDTO) super.insert();
	}

	public static EnuPhoneNumberTypeDTO find(String whereExpression) {
		try {
			return new EnuPhoneNumberTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}