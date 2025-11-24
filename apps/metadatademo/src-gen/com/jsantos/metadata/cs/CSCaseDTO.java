package com.jsantos.metadata.cs;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class CSCaseDTO extends AutoHistoryDetachedRecord{

	public CSCaseDTO(){
		super(MTBase.getTable("CSCASE"));
	}

	public CSCaseDTO(ResultSet rs){
		super(MTBase.getTable("CSCASE"), rs);
	}

	public CSCaseDTO(Integer pk) {
		super(MTBase.getTable("CSCASE"), pk);
	}

	public CSCaseDTO(String whereClause) {
		super(MTBase.getTable("CSCASE"), whereClause);
	}

	public CSCaseDTO(Boolean isMainFk, Integer pk) {
		super(MTBase.getTable("CSCASE"),isMainFk, pk);
	}

	public java.lang.Integer getCsCaseId(){ 
		return (java.lang.Integer) get(MTTableCSCASE.CSCASEID);
	}

	public void setCsCaseId(java.lang.Integer csCaseId){ 
		set(MTTableCSCASE.CSCASEID, csCaseId);
	} 

	public java.lang.String getSubject(){ 
		return (java.lang.String) get(MTTableCSCASE.SUBJECT);
	}

	public void setSubject(java.lang.String subject){ 
		set(MTTableCSCASE.SUBJECT, subject);
	} 

	public java.lang.Integer getCaseTypeId(){ 
		return (java.lang.Integer) get(MTTableCSCASE.CASETYPEID);
	}

	public void setCaseTypeId(java.lang.Integer caseTypeId){ 
		set(MTTableCSCASE.CASETYPEID, caseTypeId);
	} 

	public java.lang.Integer getCaseStatusId(){ 
		return (java.lang.Integer) get(MTTableCSCASE.CASESTATUSID);
	}

	public void setCaseStatusId(java.lang.Integer caseStatusId){ 
		set(MTTableCSCASE.CASESTATUSID, caseStatusId);
	} 

	public java.lang.Integer getCasePriorityId(){ 
		return (java.lang.Integer) get(MTTableCSCASE.CASEPRIORITYID);
	}

	public void setCasePriorityId(java.lang.Integer casePriorityId){ 
		set(MTTableCSCASE.CASEPRIORITYID, casePriorityId);
	} 

	public java.lang.Integer getManualReviewRequired(){ 
		return (java.lang.Integer) get(MTTableCSCASE.MANUALREVIEWREQUIRED);
	}

	public void setManualReviewRequired(java.lang.Integer manualReviewRequired){ 
		set(MTTableCSCASE.MANUALREVIEWREQUIRED, manualReviewRequired);
	} 

	public java.util.Date getExpectedStatusTransitionDate(){ 
		return (java.util.Date) get(MTTableCSCASE.EXPECTEDSTATUSTRANSITIONDATE);
	}

	public void setExpectedStatusTransitionDate(java.util.Date expectedStatusTransitionDate){ 
		set(MTTableCSCASE.EXPECTEDSTATUSTRANSITIONDATE, expectedStatusTransitionDate);
	} 

	public java.lang.Integer getDocumentation(){ 
		return (java.lang.Integer) get(MTTableCSCASE.DOCUMENTATION);
	}

	public void setDocumentation(java.lang.Integer documentation){ 
		set(MTTableCSCASE.DOCUMENTATION, documentation);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableCSCASE.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableCSCASE.REVISIONID, revisionId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableCSCASE.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableCSCASE.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableCSCASE.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableCSCASE.ENDDATE, endDate);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableCSCASE.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableCSCASE.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableCSCASE.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableCSCASE.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public CSCaseDTO insert() {
		return (CSCaseDTO) super.insert();
	}

	public static CSCaseDTO find(String whereExpression) {
		try {
			return new CSCaseDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}