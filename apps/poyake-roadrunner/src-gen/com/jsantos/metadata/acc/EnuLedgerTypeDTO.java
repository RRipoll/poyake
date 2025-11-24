package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuLedgerTypeDTO extends DetachedRecord{

	public EnuLedgerTypeDTO(){
		super(MTBase.getTable("ENULEDGERTYPE"));
	}

	public EnuLedgerTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENULEDGERTYPE"), rs);
	}

	public EnuLedgerTypeDTO(Integer pk) {
		super(MTBase.getTable("ENULEDGERTYPE"), pk);
	}

	public EnuLedgerTypeDTO(String whereClause) {
		super(MTBase.getTable("ENULEDGERTYPE"), whereClause);
	}

	public java.lang.Integer getLedgerTypeId(){ 
		return (java.lang.Integer) get(MTTableENULEDGERTYPE.LEDGERTYPEID);
	}

	public void setLedgerTypeId(java.lang.Integer ledgerTypeId){ 
		set(MTTableENULEDGERTYPE.LEDGERTYPEID, ledgerTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENULEDGERTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENULEDGERTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENULEDGERTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENULEDGERTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuLedgerTypeDTO insert() {
		return (EnuLedgerTypeDTO) super.insert();
	}

	public static EnuLedgerTypeDTO find(String whereExpression) {
		try {
			return new EnuLedgerTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}