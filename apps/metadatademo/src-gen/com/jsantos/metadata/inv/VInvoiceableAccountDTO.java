package com.jsantos.metadata.inv;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VInvoiceableAccountDTO extends DetachedRecord{

	public VInvoiceableAccountDTO(){
		super(MTBase.getTable("VINVOICEABLEACCOUNT"));
	}

	public VInvoiceableAccountDTO(ResultSet rs){
		super(MTBase.getTable("VINVOICEABLEACCOUNT"), rs);
	}

	public VInvoiceableAccountDTO(Integer pk) {
		super(MTBase.getTable("VINVOICEABLEACCOUNT"), pk);
	}

	public VInvoiceableAccountDTO(String whereClause) {
		super(MTBase.getTable("VINVOICEABLEACCOUNT"), whereClause);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVINVOICEABLEACCOUNT.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVINVOICEABLEACCOUNT.CUSTOMERID, customerId);
	} 

	public java.math.BigDecimal getBalance(){ 
		return (java.math.BigDecimal) get(MTTableVINVOICEABLEACCOUNT.BALANCE);
	}

	public void setBalance(java.math.BigDecimal balance){ 
		set(MTTableVINVOICEABLEACCOUNT.BALANCE, balance);
	} 

	public void update() {
		super.update();
	}

	public VInvoiceableAccountDTO insert() {
		return (VInvoiceableAccountDTO) super.insert();
	}

	public static VInvoiceableAccountDTO find(String whereExpression) {
		try {
			return new VInvoiceableAccountDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}