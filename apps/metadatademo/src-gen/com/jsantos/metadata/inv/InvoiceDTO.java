package com.jsantos.metadata.inv;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class InvoiceDTO extends DetachedRecord{

	public InvoiceDTO(){
		super(MTBase.getTable("INVOICE"));
	}

	public InvoiceDTO(ResultSet rs){
		super(MTBase.getTable("INVOICE"), rs);
	}

	public InvoiceDTO(Integer pk) {
		super(MTBase.getTable("INVOICE"), pk);
	}

	public InvoiceDTO(String whereClause) {
		super(MTBase.getTable("INVOICE"), whereClause);
	}

	public java.lang.Integer getInvoiceId(){ 
		return (java.lang.Integer) get(MTTableINVOICE.INVOICEID);
	}

	public void setInvoiceId(java.lang.Integer invoiceId){ 
		set(MTTableINVOICE.INVOICEID, invoiceId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableINVOICE.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableINVOICE.CREATED, created);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableINVOICE.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableINVOICE.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public InvoiceDTO insert() {
		return (InvoiceDTO) super.insert();
	}

	public static InvoiceDTO find(String whereExpression) {
		try {
			return new InvoiceDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}