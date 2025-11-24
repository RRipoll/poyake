package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VUnallocatedCreditDTO extends DetachedRecord{

	public VUnallocatedCreditDTO(){
		super(MTBase.getTable("VUNALLOCATEDCREDIT"));
	}

	public VUnallocatedCreditDTO(ResultSet rs){
		super(MTBase.getTable("VUNALLOCATEDCREDIT"), rs);
	}

	public VUnallocatedCreditDTO(Integer pk) {
		super(MTBase.getTable("VUNALLOCATEDCREDIT"), pk);
	}

	public VUnallocatedCreditDTO(String whereClause) {
		super(MTBase.getTable("VUNALLOCATEDCREDIT"), whereClause);
	}

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableVUNALLOCATEDCREDIT.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableVUNALLOCATEDCREDIT.REVISIONID, revisionId);
	} 

	public java.math.BigDecimal getUnAllocated(){ 
		return (java.math.BigDecimal) get(MTTableVUNALLOCATEDCREDIT.UNALLOCATED);
	}

	public void setUnAllocated(java.math.BigDecimal unAllocated){ 
		set(MTTableVUNALLOCATEDCREDIT.UNALLOCATED, unAllocated);
	} 

	public java.math.BigDecimal getFullAmount(){ 
		return (java.math.BigDecimal) get(MTTableVUNALLOCATEDCREDIT.FULLAMOUNT);
	}

	public void setFullAmount(java.math.BigDecimal fullAmount){ 
		set(MTTableVUNALLOCATEDCREDIT.FULLAMOUNT, fullAmount);
	} 

	public java.lang.Integer getLedgerItemId(){ 
		return (java.lang.Integer) get(MTTableVUNALLOCATEDCREDIT.LEDGERITEMID);
	}

	public void setLedgerItemId(java.lang.Integer ledgerItemId){ 
		set(MTTableVUNALLOCATEDCREDIT.LEDGERITEMID, ledgerItemId);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVUNALLOCATEDCREDIT.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVUNALLOCATEDCREDIT.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public VUnallocatedCreditDTO insert() {
		return (VUnallocatedCreditDTO) super.insert();
	}

	public static VUnallocatedCreditDTO find(String whereExpression) {
		try {
			return new VUnallocatedCreditDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}