package com.jsantos.metadata.cs;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VCaseSearchDTO extends DetachedRecord{

	public VCaseSearchDTO(){
		super(MTBase.getTable("VCASESEARCH"));
	}

	public VCaseSearchDTO(ResultSet rs){
		super(MTBase.getTable("VCASESEARCH"), rs);
	}

	public VCaseSearchDTO(Integer pk) {
		super(MTBase.getTable("VCASESEARCH"), pk);
	}

	public VCaseSearchDTO(String whereClause) {
		super(MTBase.getTable("VCASESEARCH"), whereClause);
	}

	public java.lang.Integer getCsCaseId(){ 
		return (java.lang.Integer) get(MTTableVCASESEARCH.CSCASEID);
	}

	public void setCsCaseId(java.lang.Integer csCaseId){ 
		set(MTTableVCASESEARCH.CSCASEID, csCaseId);
	} 

	public java.lang.String getSubject(){ 
		return (java.lang.String) get(MTTableVCASESEARCH.SUBJECT);
	}

	public void setSubject(java.lang.String subject){ 
		set(MTTableVCASESEARCH.SUBJECT, subject);
	} 

	public java.lang.Integer getCaseTypeId(){ 
		return (java.lang.Integer) get(MTTableVCASESEARCH.CASETYPEID);
	}

	public void setCaseTypeId(java.lang.Integer caseTypeId){ 
		set(MTTableVCASESEARCH.CASETYPEID, caseTypeId);
	} 

	public java.lang.Integer getCaseStatusId(){ 
		return (java.lang.Integer) get(MTTableVCASESEARCH.CASESTATUSID);
	}

	public void setCaseStatusId(java.lang.Integer caseStatusId){ 
		set(MTTableVCASESEARCH.CASESTATUSID, caseStatusId);
	} 

	public java.lang.Integer getCasePriorityId(){ 
		return (java.lang.Integer) get(MTTableVCASESEARCH.CASEPRIORITYID);
	}

	public void setCasePriorityId(java.lang.Integer casePriorityId){ 
		set(MTTableVCASESEARCH.CASEPRIORITYID, casePriorityId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableVCASESEARCH.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableVCASESEARCH.STARTDATE, startDate);
	} 

	public java.lang.Integer getManualReviewRequired(){ 
		return (java.lang.Integer) get(MTTableVCASESEARCH.MANUALREVIEWREQUIRED);
	}

	public void setManualReviewRequired(java.lang.Integer manualReviewRequired){ 
		set(MTTableVCASESEARCH.MANUALREVIEWREQUIRED, manualReviewRequired);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableVCASESEARCH.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableVCASESEARCH.INPUTUSERID, inputUserId);
	} 

	public java.lang.String getCustomers(){ 
		return (java.lang.String) get(MTTableVCASESEARCH.CUSTOMERS);
	}

	public void setCustomers(java.lang.String customers){ 
		set(MTTableVCASESEARCH.CUSTOMERS, customers);
	} 

	public java.lang.Integer getDocumentation(){ 
		return (java.lang.Integer) get(MTTableVCASESEARCH.DOCUMENTATION);
	}

	public void setDocumentation(java.lang.Integer documentation){ 
		set(MTTableVCASESEARCH.DOCUMENTATION, documentation);
	} 

	public void update() {
		super.update();
	}

	public VCaseSearchDTO insert() {
		return (VCaseSearchDTO) super.insert();
	}

	public static VCaseSearchDTO find(String whereExpression) {
		try {
			return new VCaseSearchDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}