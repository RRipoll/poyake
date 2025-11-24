package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class LedgerDTO extends DetachedRecord{

	public LedgerDTO(){
		super(MTBase.getTable("LEDGER"));
	}

	public LedgerDTO(ResultSet rs){
		super(MTBase.getTable("LEDGER"), rs);
	}

	public LedgerDTO(Integer pk) {
		super(MTBase.getTable("LEDGER"), pk);
	}

	public LedgerDTO(String whereClause) {
		super(MTBase.getTable("LEDGER"), whereClause);
	}

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableLEDGER.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableLEDGER.REVISIONID, revisionId);
	} 

	public java.lang.Integer getLedgerItemId(){ 
		return (java.lang.Integer) get(MTTableLEDGER.LEDGERITEMID);
	}

	public void setLedgerItemId(java.lang.Integer ledgerItemId){ 
		set(MTTableLEDGER.LEDGERITEMID, ledgerItemId);
	} 

	public java.lang.Integer getLedgerInfoId(){ 
		return (java.lang.Integer) get(MTTableLEDGER.LEDGERINFOID);
	}

	public void setLedgerInfoId(java.lang.Integer ledgerInfoId){ 
		set(MTTableLEDGER.LEDGERINFOID, ledgerInfoId);
	} 

	public java.lang.Integer getTransactionTypeId(){ 
		return (java.lang.Integer) get(MTTableLEDGER.TRANSACTIONTYPEID);
	}

	public void setTransactionTypeId(java.lang.Integer transactionTypeId){ 
		set(MTTableLEDGER.TRANSACTIONTYPEID, transactionTypeId);
	} 

	public java.lang.Integer getLedgerTypeId(){ 
		return (java.lang.Integer) get(MTTableLEDGER.LEDGERTYPEID);
	}

	public void setLedgerTypeId(java.lang.Integer ledgerTypeId){ 
		set(MTTableLEDGER.LEDGERTYPEID, ledgerTypeId);
	} 

	public java.lang.Integer getAnnotationId(){ 
		return (java.lang.Integer) get(MTTableLEDGER.ANNOTATIONID);
	}

	public void setAnnotationId(java.lang.Integer annotationId){ 
		set(MTTableLEDGER.ANNOTATIONID, annotationId);
	} 

	public java.math.BigDecimal getAmount(){ 
		return (java.math.BigDecimal) get(MTTableLEDGER.AMOUNT);
	}

	public void setAmount(java.math.BigDecimal amount){ 
		set(MTTableLEDGER.AMOUNT, amount);
	} 

	public java.math.BigDecimal getBalance(){ 
		return (java.math.BigDecimal) get(MTTableLEDGER.BALANCE);
	}

	public void setBalance(java.math.BigDecimal balance){ 
		set(MTTableLEDGER.BALANCE, balance);
	} 

	public void update() {
		super.update();
	}

	public LedgerDTO insert() {
		return (LedgerDTO) super.insert();
	}

	public static LedgerDTO find(String whereExpression) {
		try {
			return new LedgerDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}