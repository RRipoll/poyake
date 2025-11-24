package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class BalanceDTO extends DetachedRecord{

	public BalanceDTO(){
		super(MTBase.getTable("BALANCE"));
	}

	public BalanceDTO(ResultSet rs){
		super(MTBase.getTable("BALANCE"), rs);
	}

	public BalanceDTO(Integer pk) {
		super(MTBase.getTable("BALANCE"), pk);
	}

	public BalanceDTO(String whereClause) {
		super(MTBase.getTable("BALANCE"), whereClause);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableBALANCE.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableBALANCE.CUSTOMERID, customerId);
	} 

	public java.math.BigDecimal getBalanceAmount(){ 
		return (java.math.BigDecimal) get(MTTableBALANCE.BALANCEAMOUNT);
	}

	public void setBalanceAmount(java.math.BigDecimal balanceAmount){ 
		set(MTTableBALANCE.BALANCEAMOUNT, balanceAmount);
	} 

	public void update() {
		super.update();
	}

	public BalanceDTO insert() {
		return (BalanceDTO) super.insert();
	}

	public static BalanceDTO find(String whereExpression) {
		try {
			return new BalanceDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}