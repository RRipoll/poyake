package com.jsantos.metadata.inv;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VinvoiceHeaderDTO extends DetachedRecord{

	public VinvoiceHeaderDTO(){
		super(MTBase.getTable("VINVOICEHEADER"));
	}

	public VinvoiceHeaderDTO(ResultSet rs){
		super(MTBase.getTable("VINVOICEHEADER"), rs);
	}

	public VinvoiceHeaderDTO(Integer pk) {
		super(MTBase.getTable("VINVOICEHEADER"), pk);
	}

	public VinvoiceHeaderDTO(String whereClause) {
		super(MTBase.getTable("VINVOICEHEADER"), whereClause);
	}

	public java.lang.String getRecipientName(){ 
		return (java.lang.String) get(MTTableVINVOICEHEADER.RECIPIENTNAME);
	}

	public void setRecipientName(java.lang.String recipientName){ 
		set(MTTableVINVOICEHEADER.RECIPIENTNAME, recipientName);
	} 

	public java.lang.String getAddress1(){ 
		return (java.lang.String) get(MTTableVINVOICEHEADER.ADDRESS1);
	}

	public void setAddress1(java.lang.String address1){ 
		set(MTTableVINVOICEHEADER.ADDRESS1, address1);
	} 

	public java.lang.String getAddress2(){ 
		return (java.lang.String) get(MTTableVINVOICEHEADER.ADDRESS2);
	}

	public void setAddress2(java.lang.String address2){ 
		set(MTTableVINVOICEHEADER.ADDRESS2, address2);
	} 

	public java.lang.String getCity(){ 
		return (java.lang.String) get(MTTableVINVOICEHEADER.CITY);
	}

	public void setCity(java.lang.String city){ 
		set(MTTableVINVOICEHEADER.CITY, city);
	} 

	public java.lang.String getPostalCode(){ 
		return (java.lang.String) get(MTTableVINVOICEHEADER.POSTALCODE);
	}

	public void setPostalCode(java.lang.String postalCode){ 
		set(MTTableVINVOICEHEADER.POSTALCODE, postalCode);
	} 

	public java.lang.String getState(){ 
		return (java.lang.String) get(MTTableVINVOICEHEADER.STATE);
	}

	public void setState(java.lang.String state){ 
		set(MTTableVINVOICEHEADER.STATE, state);
	} 

	public java.util.Date getNoticeDate(){ 
		return (java.util.Date) get(MTTableVINVOICEHEADER.NOTICEDATE);
	}

	public void setNoticeDate(java.util.Date noticeDate){ 
		set(MTTableVINVOICEHEADER.NOTICEDATE, noticeDate);
	} 

	public java.util.Date getDueDate(){ 
		return (java.util.Date) get(MTTableVINVOICEHEADER.DUEDATE);
	}

	public void setDueDate(java.util.Date dueDate){ 
		set(MTTableVINVOICEHEADER.DUEDATE, dueDate);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVINVOICEHEADER.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVINVOICEHEADER.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getInvoiceId(){ 
		return (java.lang.Integer) get(MTTableVINVOICEHEADER.INVOICEID);
	}

	public void setInvoiceId(java.lang.Integer invoiceId){ 
		set(MTTableVINVOICEHEADER.INVOICEID, invoiceId);
	} 

	public java.lang.String getLpnumber(){ 
		return (java.lang.String) get(MTTableVINVOICEHEADER.LPNUMBER);
	}

	public void setLpnumber(java.lang.String lpnumber){ 
		set(MTTableVINVOICEHEADER.LPNUMBER, lpnumber);
	} 

	public java.math.BigDecimal getTotalDue(){ 
		return (java.math.BigDecimal) get(MTTableVINVOICEHEADER.TOTALDUE);
	}

	public void setTotalDue(java.math.BigDecimal totalDue){ 
		set(MTTableVINVOICEHEADER.TOTALDUE, totalDue);
	} 

	public void update() {
		super.update();
	}

	public VinvoiceHeaderDTO insert() {
		return (VinvoiceHeaderDTO) super.insert();
	}

	public static VinvoiceHeaderDTO find(String whereExpression) {
		try {
			return new VinvoiceHeaderDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}