package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VAccountBalanceDTO extends DetachedRecord{

	public VAccountBalanceDTO(){
		super(MTBase.getTable("VACCOUNTBALANCE"));
	}

	public VAccountBalanceDTO(ResultSet rs){
		super(MTBase.getTable("VACCOUNTBALANCE"), rs);
	}

	public VAccountBalanceDTO(Integer pk) {
		super(MTBase.getTable("VACCOUNTBALANCE"), pk);
	}

	public VAccountBalanceDTO(String whereClause) {
		super(MTBase.getTable("VACCOUNTBALANCE"), whereClause);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVACCOUNTBALANCE.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVACCOUNTBALANCE.CUSTOMERID, customerId);
	} 

	public java.math.BigDecimal getBalance(){ 
		return (java.math.BigDecimal) get(MTTableVACCOUNTBALANCE.BALANCE);
	}

	public void setBalance(java.math.BigDecimal balance){ 
		set(MTTableVACCOUNTBALANCE.BALANCE, balance);
	} 

	public void update() {
		super.update();
	}

	public VAccountBalanceDTO insert() {
		return (VAccountBalanceDTO) super.insert();
	}

	public static VAccountBalanceDTO find(String whereExpression) {
		try {
			return new VAccountBalanceDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}