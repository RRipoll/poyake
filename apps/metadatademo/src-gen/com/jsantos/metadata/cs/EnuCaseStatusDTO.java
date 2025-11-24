package com.jsantos.metadata.cs;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuCaseStatusDTO extends DetachedRecord{

	public EnuCaseStatusDTO(){
		super(MTBase.getTable("ENUCASESTATUS"));
	}

	public EnuCaseStatusDTO(ResultSet rs){
		super(MTBase.getTable("ENUCASESTATUS"), rs);
	}

	public EnuCaseStatusDTO(Integer pk) {
		super(MTBase.getTable("ENUCASESTATUS"), pk);
	}

	public EnuCaseStatusDTO(String whereClause) {
		super(MTBase.getTable("ENUCASESTATUS"), whereClause);
	}

	public java.lang.Integer getCaseStatusId(){ 
		return (java.lang.Integer) get(MTTableENUCASESTATUS.CASESTATUSID);
	}

	public void setCaseStatusId(java.lang.Integer caseStatusId){ 
		set(MTTableENUCASESTATUS.CASESTATUSID, caseStatusId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUCASESTATUS.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUCASESTATUS.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUCASESTATUS.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUCASESTATUS.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuCaseStatusDTO insert() {
		return (EnuCaseStatusDTO) super.insert();
	}

	public static EnuCaseStatusDTO find(String whereExpression) {
		try {
			return new EnuCaseStatusDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}