package com.jsantos.metadata.payment;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class PaymentDTO extends DetachedRecord{

	public PaymentDTO(){
		super(MTBase.getTable("PAYMENT"));
	}

	public PaymentDTO(ResultSet rs){
		super(MTBase.getTable("PAYMENT"), rs);
	}

	public PaymentDTO(Integer pk) {
		super(MTBase.getTable("PAYMENT"), pk);
	}

	public PaymentDTO(String whereClause) {
		super(MTBase.getTable("PAYMENT"), whereClause);
	}

	public java.lang.Integer getPaymentId(){ 
		return (java.lang.Integer) get(MTTablePAYMENT.PAYMENTID);
	}

	public void setPaymentId(java.lang.Integer paymentId){ 
		set(MTTablePAYMENT.PAYMENTID, paymentId);
	} 

	public java.math.BigDecimal getAmount(){ 
		return (java.math.BigDecimal) get(MTTablePAYMENT.AMOUNT);
	}

	public void setAmount(java.math.BigDecimal amount){ 
		set(MTTablePAYMENT.AMOUNT, amount);
	} 

	public java.lang.Integer getPaymentTypeId(){ 
		return (java.lang.Integer) get(MTTablePAYMENT.PAYMENTTYPEID);
	}

	public void setPaymentTypeId(java.lang.Integer paymentTypeId){ 
		set(MTTablePAYMENT.PAYMENTTYPEID, paymentTypeId);
	} 

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTablePAYMENT.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTablePAYMENT.POSTINGDATE, postingDate);
	} 

	public java.lang.Integer getLedgerInfoId(){ 
		return (java.lang.Integer) get(MTTablePAYMENT.LEDGERINFOID);
	}

	public void setLedgerInfoId(java.lang.Integer ledgerInfoId){ 
		set(MTTablePAYMENT.LEDGERINFOID, ledgerInfoId);
	} 

	public void update() {
		super.update();
	}

	public PaymentDTO insert() {
		return (PaymentDTO) super.insert();
	}

	public static PaymentDTO find(String whereExpression) {
		try {
			return new PaymentDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}