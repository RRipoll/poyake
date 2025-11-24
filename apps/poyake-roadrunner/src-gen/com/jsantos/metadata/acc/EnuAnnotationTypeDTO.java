package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuAnnotationTypeDTO extends DetachedRecord{

	public EnuAnnotationTypeDTO(){
		super(MTBase.getTable("ENUANNOTATIONTYPE"));
	}

	public EnuAnnotationTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUANNOTATIONTYPE"), rs);
	}

	public EnuAnnotationTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUANNOTATIONTYPE"), pk);
	}

	public EnuAnnotationTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUANNOTATIONTYPE"), whereClause);
	}

	public java.lang.Integer getAnnotationTypeId(){ 
		return (java.lang.Integer) get(MTTableENUANNOTATIONTYPE.ANNOTATIONTYPEID);
	}

	public void setAnnotationTypeId(java.lang.Integer annotationTypeId){ 
		set(MTTableENUANNOTATIONTYPE.ANNOTATIONTYPEID, annotationTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUANNOTATIONTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUANNOTATIONTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUANNOTATIONTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUANNOTATIONTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuAnnotationTypeDTO insert() {
		return (EnuAnnotationTypeDTO) super.insert();
	}

	public static EnuAnnotationTypeDTO find(String whereExpression) {
		try {
			return new EnuAnnotationTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}