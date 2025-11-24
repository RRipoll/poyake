package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuCustomerTypeDTO extends DetachedRecord{

	public EnuCustomerTypeDTO(){
		super(MTBase.getTable("ENUCUSTOMERTYPE"));
	}

	public EnuCustomerTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUCUSTOMERTYPE"), rs);
	}

	public EnuCustomerTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUCUSTOMERTYPE"), pk);
	}

	public EnuCustomerTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUCUSTOMERTYPE"), whereClause);
	}

	public java.lang.Integer getCustomerTypeId(){ 
		return (java.lang.Integer) get(MTTableENUCUSTOMERTYPE.CUSTOMERTYPEID);
	}

	public void setCustomerTypeId(java.lang.Integer customerTypeId){ 
		set(MTTableENUCUSTOMERTYPE.CUSTOMERTYPEID, customerTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUCUSTOMERTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUCUSTOMERTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUCUSTOMERTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUCUSTOMERTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuCustomerTypeDTO insert() {
		return (EnuCustomerTypeDTO) super.insert();
	}

	public static EnuCustomerTypeDTO find(String whereExpression) {
		try {
			return new EnuCustomerTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}