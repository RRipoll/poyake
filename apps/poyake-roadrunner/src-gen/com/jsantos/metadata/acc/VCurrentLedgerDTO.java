package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VCurrentLedgerDTO extends DetachedRecord{

	public VCurrentLedgerDTO(){
		super(MTBase.getTable("VCURRENTLEDGER"));
	}

	public VCurrentLedgerDTO(ResultSet rs){
		super(MTBase.getTable("VCURRENTLEDGER"), rs);
	}

	public VCurrentLedgerDTO(Integer pk) {
		super(MTBase.getTable("VCURRENTLEDGER"), pk);
	}

	public VCurrentLedgerDTO(String whereClause) {
		super(MTBase.getTable("VCURRENTLEDGER"), whereClause);
	}

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableVCURRENTLEDGER.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableVCURRENTLEDGER.REVISIONID, revisionId);
	} 

	public java.lang.Integer getLedgerItemId(){ 
		return (java.lang.Integer) get(MTTableVCURRENTLEDGER.LEDGERITEMID);
	}

	public void setLedgerItemId(java.lang.Integer ledgerItemId){ 
		set(MTTableVCURRENTLEDGER.LEDGERITEMID, ledgerItemId);
	} 

	public java.lang.Integer getLedgerInfoId(){ 
		return (java.lang.Integer) get(MTTableVCURRENTLEDGER.LEDGERINFOID);
	}

	public void setLedgerInfoId(java.lang.Integer ledgerInfoId){ 
		set(MTTableVCURRENTLEDGER.LEDGERINFOID, ledgerInfoId);
	} 

	public java.lang.Integer getTransactionTypeId(){ 
		return (java.lang.Integer) get(MTTableVCURRENTLEDGER.TRANSACTIONTYPEID);
	}

	public void setTransactionTypeId(java.lang.Integer transactionTypeId){ 
		set(MTTableVCURRENTLEDGER.TRANSACTIONTYPEID, transactionTypeId);
	} 

	public java.lang.Integer getLedgerTypeId(){ 
		return (java.lang.Integer) get(MTTableVCURRENTLEDGER.LEDGERTYPEID);
	}

	public void setLedgerTypeId(java.lang.Integer ledgerTypeId){ 
		set(MTTableVCURRENTLEDGER.LEDGERTYPEID, ledgerTypeId);
	} 

	public java.lang.Integer getAnnotationId(){ 
		return (java.lang.Integer) get(MTTableVCURRENTLEDGER.ANNOTATIONID);
	}

	public void setAnnotationId(java.lang.Integer annotationId){ 
		set(MTTableVCURRENTLEDGER.ANNOTATIONID, annotationId);
	} 

	public java.math.BigDecimal getAmount(){ 
		return (java.math.BigDecimal) get(MTTableVCURRENTLEDGER.AMOUNT);
	}

	public void setAmount(java.math.BigDecimal amount){ 
		set(MTTableVCURRENTLEDGER.AMOUNT, amount);
	} 

	public java.math.BigDecimal getBalance(){ 
		return (java.math.BigDecimal) get(MTTableVCURRENTLEDGER.BALANCE);
	}

	public void setBalance(java.math.BigDecimal balance){ 
		set(MTTableVCURRENTLEDGER.BALANCE, balance);
	} 

	public void update() {
		super.update();
	}

	public VCurrentLedgerDTO insert() {
		return (VCurrentLedgerDTO) super.insert();
	}

	public static VCurrentLedgerDTO find(String whereExpression) {
		try {
			return new VCurrentLedgerDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}