package com.jsantos.metadata.cs;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuCaseTypeDTO extends DetachedRecord{

	public EnuCaseTypeDTO(){
		super(MTBase.getTable("ENUCASETYPE"));
	}

	public EnuCaseTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUCASETYPE"), rs);
	}

	public EnuCaseTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUCASETYPE"), pk);
	}

	public EnuCaseTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUCASETYPE"), whereClause);
	}

	public java.lang.Integer getCaseTypeId(){ 
		return (java.lang.Integer) get(MTTableENUCASETYPE.CASETYPEID);
	}

	public void setCaseTypeId(java.lang.Integer caseTypeId){ 
		set(MTTableENUCASETYPE.CASETYPEID, caseTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUCASETYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUCASETYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUCASETYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUCASETYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuCaseTypeDTO insert() {
		return (EnuCaseTypeDTO) super.insert();
	}

	public static EnuCaseTypeDTO find(String whereExpression) {
		try {
			return new EnuCaseTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}