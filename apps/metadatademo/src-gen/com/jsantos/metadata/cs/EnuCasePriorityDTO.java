package com.jsantos.metadata.cs;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuCasePriorityDTO extends DetachedRecord{

	public EnuCasePriorityDTO(){
		super(MTBase.getTable("ENUCASEPRIORITY"));
	}

	public EnuCasePriorityDTO(ResultSet rs){
		super(MTBase.getTable("ENUCASEPRIORITY"), rs);
	}

	public EnuCasePriorityDTO(Integer pk) {
		super(MTBase.getTable("ENUCASEPRIORITY"), pk);
	}

	public EnuCasePriorityDTO(String whereClause) {
		super(MTBase.getTable("ENUCASEPRIORITY"), whereClause);
	}

	public java.lang.Integer getCasePriorityId(){ 
		return (java.lang.Integer) get(MTTableENUCASEPRIORITY.CASEPRIORITYID);
	}

	public void setCasePriorityId(java.lang.Integer casePriorityId){ 
		set(MTTableENUCASEPRIORITY.CASEPRIORITYID, casePriorityId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUCASEPRIORITY.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUCASEPRIORITY.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUCASEPRIORITY.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUCASEPRIORITY.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuCasePriorityDTO insert() {
		return (EnuCasePriorityDTO) super.insert();
	}

	public static EnuCasePriorityDTO find(String whereExpression) {
		try {
			return new EnuCasePriorityDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}