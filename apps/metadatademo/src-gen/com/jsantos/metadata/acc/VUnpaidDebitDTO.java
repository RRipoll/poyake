package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VUnpaidDebitDTO extends DetachedRecord{

	public VUnpaidDebitDTO(){
		super(MTBase.getTable("VUNPAIDDEBIT"));
	}

	public VUnpaidDebitDTO(ResultSet rs){
		super(MTBase.getTable("VUNPAIDDEBIT"), rs);
	}

	public VUnpaidDebitDTO(Integer pk) {
		super(MTBase.getTable("VUNPAIDDEBIT"), pk);
	}

	public VUnpaidDebitDTO(String whereClause) {
		super(MTBase.getTable("VUNPAIDDEBIT"), whereClause);
	}

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableVUNPAIDDEBIT.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableVUNPAIDDEBIT.REVISIONID, revisionId);
	} 

	public java.math.BigDecimal getUnAllocated(){ 
		return (java.math.BigDecimal) get(MTTableVUNPAIDDEBIT.UNALLOCATED);
	}

	public void setUnAllocated(java.math.BigDecimal unAllocated){ 
		set(MTTableVUNPAIDDEBIT.UNALLOCATED, unAllocated);
	} 

	public java.math.BigDecimal getFullAmount(){ 
		return (java.math.BigDecimal) get(MTTableVUNPAIDDEBIT.FULLAMOUNT);
	}

	public void setFullAmount(java.math.BigDecimal fullAmount){ 
		set(MTTableVUNPAIDDEBIT.FULLAMOUNT, fullAmount);
	} 

	public java.math.BigDecimal getAllocated(){ 
		return (java.math.BigDecimal) get(MTTableVUNPAIDDEBIT.ALLOCATED);
	}

	public void setAllocated(java.math.BigDecimal allocated){ 
		set(MTTableVUNPAIDDEBIT.ALLOCATED, allocated);
	} 

	public java.lang.Integer getLedgerItemId(){ 
		return (java.lang.Integer) get(MTTableVUNPAIDDEBIT.LEDGERITEMID);
	}

	public void setLedgerItemId(java.lang.Integer ledgerItemId){ 
		set(MTTableVUNPAIDDEBIT.LEDGERITEMID, ledgerItemId);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVUNPAIDDEBIT.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVUNPAIDDEBIT.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public VUnpaidDebitDTO insert() {
		return (VUnpaidDebitDTO) super.insert();
	}

	public static VUnpaidDebitDTO find(String whereExpression) {
		try {
			return new VUnpaidDebitDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}