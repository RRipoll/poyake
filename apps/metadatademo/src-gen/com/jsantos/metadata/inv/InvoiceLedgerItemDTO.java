package com.jsantos.metadata.inv;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class InvoiceLedgerItemDTO extends DetachedRecord{

	public InvoiceLedgerItemDTO(){
		super(MTBase.getTable("INVOICELEDGERITEM"));
	}

	public InvoiceLedgerItemDTO(ResultSet rs){
		super(MTBase.getTable("INVOICELEDGERITEM"), rs);
	}

	public InvoiceLedgerItemDTO(Integer pk) {
		super(MTBase.getTable("INVOICELEDGERITEM"), pk);
	}

	public InvoiceLedgerItemDTO(String whereClause) {
		super(MTBase.getTable("INVOICELEDGERITEM"), whereClause);
	}

	public java.lang.Integer getInvoiceId(){ 
		return (java.lang.Integer) get(MTTableINVOICELEDGERITEM.INVOICEID);
	}

	public void setInvoiceId(java.lang.Integer invoiceId){ 
		set(MTTableINVOICELEDGERITEM.INVOICEID, invoiceId);
	} 

	public java.lang.Integer getLedgerItemId(){ 
		return (java.lang.Integer) get(MTTableINVOICELEDGERITEM.LEDGERITEMID);
	}

	public void setLedgerItemId(java.lang.Integer ledgerItemId){ 
		set(MTTableINVOICELEDGERITEM.LEDGERITEMID, ledgerItemId);
	} 

	public void update() {
		super.update();
	}

	public InvoiceLedgerItemDTO insert() {
		return (InvoiceLedgerItemDTO) super.insert();
	}

	public static InvoiceLedgerItemDTO find(String whereExpression) {
		try {
			return new InvoiceLedgerItemDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}