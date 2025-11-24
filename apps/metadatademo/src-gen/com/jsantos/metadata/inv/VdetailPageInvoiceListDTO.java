package com.jsantos.metadata.inv;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VdetailPageInvoiceListDTO extends DetachedRecord{

	public VdetailPageInvoiceListDTO(){
		super(MTBase.getTable("VDETAILPAGEINVOICELIST"));
	}

	public VdetailPageInvoiceListDTO(ResultSet rs){
		super(MTBase.getTable("VDETAILPAGEINVOICELIST"), rs);
	}

	public VdetailPageInvoiceListDTO(Integer pk) {
		super(MTBase.getTable("VDETAILPAGEINVOICELIST"), pk);
	}

	public VdetailPageInvoiceListDTO(String whereClause) {
		super(MTBase.getTable("VDETAILPAGEINVOICELIST"), whereClause);
	}

	public java.lang.Integer getInvoiceid(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGEINVOICELIST.INVOICEID);
	}

	public void setInvoiceid(java.lang.Integer invoiceid){ 
		set(MTTableVDETAILPAGEINVOICELIST.INVOICEID, invoiceid);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableVDETAILPAGEINVOICELIST.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableVDETAILPAGEINVOICELIST.CREATED, created);
	} 

	public java.math.BigDecimal getAmountDue(){ 
		return (java.math.BigDecimal) get(MTTableVDETAILPAGEINVOICELIST.AMOUNTDUE);
	}

	public void setAmountDue(java.math.BigDecimal amountDue){ 
		set(MTTableVDETAILPAGEINVOICELIST.AMOUNTDUE, amountDue);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVDETAILPAGEINVOICELIST.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVDETAILPAGEINVOICELIST.CUSTOMERID, customerId);
	} 

	public java.lang.String getUrl(){ 
		return (java.lang.String) get(MTTableVDETAILPAGEINVOICELIST.URL);
	}

	public void setUrl(java.lang.String url){ 
		set(MTTableVDETAILPAGEINVOICELIST.URL, url);
	} 

	public void update() {
		super.update();
	}

	public VdetailPageInvoiceListDTO insert() {
		return (VdetailPageInvoiceListDTO) super.insert();
	}

	public static VdetailPageInvoiceListDTO find(String whereExpression) {
		try {
			return new VdetailPageInvoiceListDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}