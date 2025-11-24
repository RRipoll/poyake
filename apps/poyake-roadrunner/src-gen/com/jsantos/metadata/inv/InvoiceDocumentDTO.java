package com.jsantos.metadata.inv;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class InvoiceDocumentDTO extends DetachedRecord{

	public InvoiceDocumentDTO(){
		super(MTBase.getTable("INVOICEDOCUMENT"));
	}

	public InvoiceDocumentDTO(ResultSet rs){
		super(MTBase.getTable("INVOICEDOCUMENT"), rs);
	}

	public InvoiceDocumentDTO(Integer pk) {
		super(MTBase.getTable("INVOICEDOCUMENT"), pk);
	}

	public InvoiceDocumentDTO(String whereClause) {
		super(MTBase.getTable("INVOICEDOCUMENT"), whereClause);
	}

	public java.lang.Integer getInvoiceDocumentId(){ 
		return (java.lang.Integer) get(MTTableINVOICEDOCUMENT.INVOICEDOCUMENTID);
	}

	public void setInvoiceDocumentId(java.lang.Integer invoiceDocumentId){ 
		set(MTTableINVOICEDOCUMENT.INVOICEDOCUMENTID, invoiceDocumentId);
	} 

	public java.lang.Integer getInvoiceId(){ 
		return (java.lang.Integer) get(MTTableINVOICEDOCUMENT.INVOICEID);
	}

	public void setInvoiceId(java.lang.Integer invoiceId){ 
		set(MTTableINVOICEDOCUMENT.INVOICEID, invoiceId);
	} 

	public java.math.BigDecimal getAmountDue(){ 
		return (java.math.BigDecimal) get(MTTableINVOICEDOCUMENT.AMOUNTDUE);
	}

	public void setAmountDue(java.math.BigDecimal amountDue){ 
		set(MTTableINVOICEDOCUMENT.AMOUNTDUE, amountDue);
	} 

	public java.lang.Integer getSentToPostalAddressRevisionId(){ 
		return (java.lang.Integer) get(MTTableINVOICEDOCUMENT.SENTTOPOSTALADDRESSREVISIONID);
	}

	public void setSentToPostalAddressRevisionId(java.lang.Integer sentToPostalAddressRevisionId){ 
		set(MTTableINVOICEDOCUMENT.SENTTOPOSTALADDRESSREVISIONID, sentToPostalAddressRevisionId);
	} 

	public java.lang.Integer getFileGroupId(){ 
		return (java.lang.Integer) get(MTTableINVOICEDOCUMENT.FILEGROUPID);
	}

	public void setFileGroupId(java.lang.Integer fileGroupId){ 
		set(MTTableINVOICEDOCUMENT.FILEGROUPID, fileGroupId);
	} 

	public void update() {
		super.update();
	}

	public InvoiceDocumentDTO insert() {
		return (InvoiceDocumentDTO) super.insert();
	}

	public static InvoiceDocumentDTO find(String whereExpression) {
		try {
			return new InvoiceDocumentDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}