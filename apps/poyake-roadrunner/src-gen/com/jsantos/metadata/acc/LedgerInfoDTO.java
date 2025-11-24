package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class LedgerInfoDTO extends DetachedRecord{

	public LedgerInfoDTO(){
		super(MTBase.getTable("LEDGERINFO"));
	}

	public LedgerInfoDTO(ResultSet rs){
		super(MTBase.getTable("LEDGERINFO"), rs);
	}

	public LedgerInfoDTO(Integer pk) {
		super(MTBase.getTable("LEDGERINFO"), pk);
	}

	public LedgerInfoDTO(String whereClause) {
		super(MTBase.getTable("LEDGERINFO"), whereClause);
	}

	public java.lang.Integer getLedgerInfoId(){ 
		return (java.lang.Integer) get(MTTableLEDGERINFO.LEDGERINFOID);
	}

	public void setLedgerInfoId(java.lang.Integer ledgerInfoId){ 
		set(MTTableLEDGERINFO.LEDGERINFOID, ledgerInfoId);
	} 

	public void update() {
		super.update();
	}

	public LedgerInfoDTO insert() {
		return (LedgerInfoDTO) super.insert();
	}

	public static LedgerInfoDTO find(String whereExpression) {
		try {
			return new LedgerInfoDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}