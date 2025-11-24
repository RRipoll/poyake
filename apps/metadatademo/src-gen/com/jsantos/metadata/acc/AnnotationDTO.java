package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class AnnotationDTO extends DetachedRecord{

	public AnnotationDTO(){
		super(MTBase.getTable("ANNOTATION"));
	}

	public AnnotationDTO(ResultSet rs){
		super(MTBase.getTable("ANNOTATION"), rs);
	}

	public AnnotationDTO(Integer pk) {
		super(MTBase.getTable("ANNOTATION"), pk);
	}

	public AnnotationDTO(String whereClause) {
		super(MTBase.getTable("ANNOTATION"), whereClause);
	}

	public java.lang.Integer getAnnotationId(){ 
		return (java.lang.Integer) get(MTTableANNOTATION.ANNOTATIONID);
	}

	public void setAnnotationId(java.lang.Integer annotationId){ 
		set(MTTableANNOTATION.ANNOTATIONID, annotationId);
	} 

	public java.lang.Integer getAnnotationTypeId(){ 
		return (java.lang.Integer) get(MTTableANNOTATION.ANNOTATIONTYPEID);
	}

	public void setAnnotationTypeId(java.lang.Integer annotationTypeId){ 
		set(MTTableANNOTATION.ANNOTATIONTYPEID, annotationTypeId);
	} 

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTableANNOTATION.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTableANNOTATION.POSTINGDATE, postingDate);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableANNOTATION.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableANNOTATION.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public AnnotationDTO insert() {
		return (AnnotationDTO) super.insert();
	}

	public static AnnotationDTO find(String whereExpression) {
		try {
			return new AnnotationDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}