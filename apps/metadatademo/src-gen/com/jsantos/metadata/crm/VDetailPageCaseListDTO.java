package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VDetailPageCaseListDTO extends DetachedRecord{

	public VDetailPageCaseListDTO(){
		super(MTBase.getTable("VDETAILPAGECASELIST"));
	}

	public VDetailPageCaseListDTO(ResultSet rs){
		super(MTBase.getTable("VDETAILPAGECASELIST"), rs);
	}

	public VDetailPageCaseListDTO(Integer pk) {
		super(MTBase.getTable("VDETAILPAGECASELIST"), pk);
	}

	public VDetailPageCaseListDTO(String whereClause) {
		super(MTBase.getTable("VDETAILPAGECASELIST"), whereClause);
	}

	public java.lang.Integer getCsCaseId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGECASELIST.CSCASEID);
	}

	public void setCsCaseId(java.lang.Integer csCaseId){ 
		set(MTTableVDETAILPAGECASELIST.CSCASEID, csCaseId);
	} 

	public java.lang.String getSubject(){ 
		return (java.lang.String) get(MTTableVDETAILPAGECASELIST.SUBJECT);
	}

	public void setSubject(java.lang.String subject){ 
		set(MTTableVDETAILPAGECASELIST.SUBJECT, subject);
	} 

	public java.lang.Integer getCaseTypeId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGECASELIST.CASETYPEID);
	}

	public void setCaseTypeId(java.lang.Integer caseTypeId){ 
		set(MTTableVDETAILPAGECASELIST.CASETYPEID, caseTypeId);
	} 

	public java.lang.Integer getCaseStatusId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGECASELIST.CASESTATUSID);
	}

	public void setCaseStatusId(java.lang.Integer caseStatusId){ 
		set(MTTableVDETAILPAGECASELIST.CASESTATUSID, caseStatusId);
	} 

	public java.lang.Integer getCasePriorityId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGECASELIST.CASEPRIORITYID);
	}

	public void setCasePriorityId(java.lang.Integer casePriorityId){ 
		set(MTTableVDETAILPAGECASELIST.CASEPRIORITYID, casePriorityId);
	} 

	public java.lang.Integer getManualReviewRequired(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGECASELIST.MANUALREVIEWREQUIRED);
	}

	public void setManualReviewRequired(java.lang.Integer manualReviewRequired){ 
		set(MTTableVDETAILPAGECASELIST.MANUALREVIEWREQUIRED, manualReviewRequired);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGECASELIST.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVDETAILPAGECASELIST.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public VDetailPageCaseListDTO insert() {
		return (VDetailPageCaseListDTO) super.insert();
	}

	public static VDetailPageCaseListDTO find(String whereExpression) {
		try {
			return new VDetailPageCaseListDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}