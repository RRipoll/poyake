package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class LedgerItemDTO extends DetachedRecord{

	public LedgerItemDTO(){
		super(MTBase.getTable("LEDGERITEM"));
	}

	public LedgerItemDTO(ResultSet rs){
		super(MTBase.getTable("LEDGERITEM"), rs);
	}

	public LedgerItemDTO(Integer pk) {
		super(MTBase.getTable("LEDGERITEM"), pk);
	}

	public LedgerItemDTO(String whereClause) {
		super(MTBase.getTable("LEDGERITEM"), whereClause);
	}

	public java.lang.Integer getLedgerItemId(){ 
		return (java.lang.Integer) get(MTTableLEDGERITEM.LEDGERITEMID);
	}

	public void setLedgerItemId(java.lang.Integer ledgerItemId){ 
		set(MTTableLEDGERITEM.LEDGERITEMID, ledgerItemId);
	} 

	public void update() {
		super.update();
	}

	public LedgerItemDTO insert() {
		return (LedgerItemDTO) super.insert();
	}

	public static LedgerItemDTO find(String whereExpression) {
		try {
			return new LedgerItemDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}