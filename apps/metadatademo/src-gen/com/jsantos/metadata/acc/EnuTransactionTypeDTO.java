package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuTransactionTypeDTO extends DetachedRecord{

	public EnuTransactionTypeDTO(){
		super(MTBase.getTable("ENUTRANSACTIONTYPE"));
	}

	public EnuTransactionTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENUTRANSACTIONTYPE"), rs);
	}

	public EnuTransactionTypeDTO(Integer pk) {
		super(MTBase.getTable("ENUTRANSACTIONTYPE"), pk);
	}

	public EnuTransactionTypeDTO(String whereClause) {
		super(MTBase.getTable("ENUTRANSACTIONTYPE"), whereClause);
	}

	public java.lang.Integer getTransactionTypeId(){ 
		return (java.lang.Integer) get(MTTableENUTRANSACTIONTYPE.TRANSACTIONTYPEID);
	}

	public void setTransactionTypeId(java.lang.Integer transactionTypeId){ 
		set(MTTableENUTRANSACTIONTYPE.TRANSACTIONTYPEID, transactionTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUTRANSACTIONTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUTRANSACTIONTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUTRANSACTIONTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUTRANSACTIONTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuTransactionTypeDTO insert() {
		return (EnuTransactionTypeDTO) super.insert();
	}

	public static EnuTransactionTypeDTO find(String whereExpression) {
		try {
			return new EnuTransactionTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}