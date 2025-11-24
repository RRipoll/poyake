package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class AllocationDTO extends DetachedRecord{

	public AllocationDTO(){
		super(MTBase.getTable("ALLOCATION"));
	}

	public AllocationDTO(ResultSet rs){
		super(MTBase.getTable("ALLOCATION"), rs);
	}

	public AllocationDTO(Integer pk) {
		super(MTBase.getTable("ALLOCATION"), pk);
	}

	public AllocationDTO(String whereClause) {
		super(MTBase.getTable("ALLOCATION"), whereClause);
	}

	public java.lang.Integer getAllocationId(){ 
		return (java.lang.Integer) get(MTTableALLOCATION.ALLOCATIONID);
	}

	public void setAllocationId(java.lang.Integer allocationId){ 
		set(MTTableALLOCATION.ALLOCATIONID, allocationId);
	} 

	public java.lang.Integer getCreditRevisionId(){ 
		return (java.lang.Integer) get(MTTableALLOCATION.CREDITREVISIONID);
	}

	public void setCreditRevisionId(java.lang.Integer creditRevisionId){ 
		set(MTTableALLOCATION.CREDITREVISIONID, creditRevisionId);
	} 

	public java.lang.Integer getDebitRevisionId(){ 
		return (java.lang.Integer) get(MTTableALLOCATION.DEBITREVISIONID);
	}

	public void setDebitRevisionId(java.lang.Integer debitRevisionId){ 
		set(MTTableALLOCATION.DEBITREVISIONID, debitRevisionId);
	} 

	public java.math.BigDecimal getAmount(){ 
		return (java.math.BigDecimal) get(MTTableALLOCATION.AMOUNT);
	}

	public void setAmount(java.math.BigDecimal amount){ 
		set(MTTableALLOCATION.AMOUNT, amount);
	} 

	public java.lang.Integer getStartAnnotationId(){ 
		return (java.lang.Integer) get(MTTableALLOCATION.STARTANNOTATIONID);
	}

	public void setStartAnnotationId(java.lang.Integer startAnnotationId){ 
		set(MTTableALLOCATION.STARTANNOTATIONID, startAnnotationId);
	} 

	public java.lang.Integer getEndAnnotationId(){ 
		return (java.lang.Integer) get(MTTableALLOCATION.ENDANNOTATIONID);
	}

	public void setEndAnnotationId(java.lang.Integer endAnnotationId){ 
		set(MTTableALLOCATION.ENDANNOTATIONID, endAnnotationId);
	} 

	public void update() {
		super.update();
	}

	public AllocationDTO insert() {
		return (AllocationDTO) super.insert();
	}

	public static AllocationDTO find(String whereExpression) {
		try {
			return new AllocationDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}