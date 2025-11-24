package com.jsantos.metadata.common;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuTemplateTypeDTO extends DetachedRecord{

	public EnuTemplateTypeDTO(){
		super(MTBase.getTable("ENUTEMPLATETYPE"));
	}

	public EnuTemplateTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUTEMPLATETYPE"), rs);
	}

	public EnuTemplateTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUTEMPLATETYPE"), pk);
	}

	public EnuTemplateTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUTEMPLATETYPE"), whereClause);
	}

	public java.lang.Integer getEnuTemplateTypeId(){ 
		return (java.lang.Integer) get(MTTableENUTEMPLATETYPE.ENUTEMPLATETYPEID);
	}

	public void setEnuTemplateTypeId(java.lang.Integer enuTemplateTypeId){ 
		set(MTTableENUTEMPLATETYPE.ENUTEMPLATETYPEID, enuTemplateTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUTEMPLATETYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUTEMPLATETYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUTEMPLATETYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUTEMPLATETYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuTemplateTypeDTO insert() {
		return (EnuTemplateTypeDTO) super.insert();
	}

	public static EnuTemplateTypeDTO find(String whereExpression) {
		try {
			return new EnuTemplateTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}