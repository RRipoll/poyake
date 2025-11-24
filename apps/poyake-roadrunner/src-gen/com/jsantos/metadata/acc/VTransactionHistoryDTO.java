package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VTransactionHistoryDTO extends DetachedRecord{

	public VTransactionHistoryDTO(){
		super(MTBase.getTable("VTRANSACTIONHISTORY"));
	}

	public VTransactionHistoryDTO(ResultSet rs){
		super(MTBase.getTable("VTRANSACTIONHISTORY"), rs);
	}

	public VTransactionHistoryDTO(Integer pk) {
		super(MTBase.getTable("VTRANSACTIONHISTORY"), pk);
	}

	public VTransactionHistoryDTO(String whereClause) {
		super(MTBase.getTable("VTRANSACTIONHISTORY"), whereClause);
	}

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTableVTRANSACTIONHISTORY.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTableVTRANSACTIONHISTORY.POSTINGDATE, postingDate);
	} 

	public java.lang.Integer getLedgerItemId(){ 
		return (java.lang.Integer) get(MTTableVTRANSACTIONHISTORY.LEDGERITEMID);
	}

	public void setLedgerItemId(java.lang.Integer ledgerItemId){ 
		set(MTTableVTRANSACTIONHISTORY.LEDGERITEMID, ledgerItemId);
	} 

	public java.lang.Integer getTransactionTypeId(){ 
		return (java.lang.Integer) get(MTTableVTRANSACTIONHISTORY.TRANSACTIONTYPEID);
	}

	public void setTransactionTypeId(java.lang.Integer transactionTypeId){ 
		set(MTTableVTRANSACTIONHISTORY.TRANSACTIONTYPEID, transactionTypeId);
	} 

	public java.math.BigDecimal getAmount(){ 
		return (java.math.BigDecimal) get(MTTableVTRANSACTIONHISTORY.AMOUNT);
	}

	public void setAmount(java.math.BigDecimal amount){ 
		set(MTTableVTRANSACTIONHISTORY.AMOUNT, amount);
	} 

	public java.math.BigDecimal getBalance(){ 
		return (java.math.BigDecimal) get(MTTableVTRANSACTIONHISTORY.BALANCE);
	}

	public void setBalance(java.math.BigDecimal balance){ 
		set(MTTableVTRANSACTIONHISTORY.BALANCE, balance);
	} 

	public java.lang.Integer getTripId(){ 
		return (java.lang.Integer) get(MTTableVTRANSACTIONHISTORY.TRIPID);
	}

	public void setTripId(java.lang.Integer tripId){ 
		set(MTTableVTRANSACTIONHISTORY.TRIPID, tripId);
	} 

	public java.lang.Integer getPaymentId(){ 
		return (java.lang.Integer) get(MTTableVTRANSACTIONHISTORY.PAYMENTID);
	}

	public void setPaymentId(java.lang.Integer paymentId){ 
		set(MTTableVTRANSACTIONHISTORY.PAYMENTID, paymentId);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVTRANSACTIONHISTORY.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVTRANSACTIONHISTORY.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public VTransactionHistoryDTO insert() {
		return (VTransactionHistoryDTO) super.insert();
	}

	public static VTransactionHistoryDTO find(String whereExpression) {
		try {
			return new VTransactionHistoryDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}