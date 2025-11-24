package com.jsantos.metadata.inv;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VitemInvoiceDetailDTO extends DetachedRecord{

	public VitemInvoiceDetailDTO(){
		super(MTBase.getTable("VITEMINVOICEDETAIL"));
	}

	public VitemInvoiceDetailDTO(ResultSet rs){
		super(MTBase.getTable("VITEMINVOICEDETAIL"), rs);
	}

	public VitemInvoiceDetailDTO(Integer pk) {
		super(MTBase.getTable("VITEMINVOICEDETAIL"), pk);
	}

	public VitemInvoiceDetailDTO(String whereClause) {
		super(MTBase.getTable("VITEMINVOICEDETAIL"), whereClause);
	}

	public java.util.Date getLaneExitDate(){ 
		return (java.util.Date) get(MTTableVITEMINVOICEDETAIL.LANEEXITDATE);
	}

	public void setLaneExitDate(java.util.Date laneExitDate){ 
		set(MTTableVITEMINVOICEDETAIL.LANEEXITDATE, laneExitDate);
	} 

	public java.lang.Integer getTripId(){ 
		return (java.lang.Integer) get(MTTableVITEMINVOICEDETAIL.TRIPID);
	}

	public void setTripId(java.lang.Integer tripId){ 
		set(MTTableVITEMINVOICEDETAIL.TRIPID, tripId);
	} 

	public java.lang.Integer getPassId(){ 
		return (java.lang.Integer) get(MTTableVITEMINVOICEDETAIL.PASSID);
	}

	public void setPassId(java.lang.Integer passId){ 
		set(MTTableVITEMINVOICEDETAIL.PASSID, passId);
	} 

	public java.lang.String getLpnumber(){ 
		return (java.lang.String) get(MTTableVITEMINVOICEDETAIL.LPNUMBER);
	}

	public void setLpnumber(java.lang.String lpnumber){ 
		set(MTTableVITEMINVOICEDETAIL.LPNUMBER, lpnumber);
	} 

	public java.math.BigDecimal getFareAmount(){ 
		return (java.math.BigDecimal) get(MTTableVITEMINVOICEDETAIL.FAREAMOUNT);
	}

	public void setFareAmount(java.math.BigDecimal fareAmount){ 
		set(MTTableVITEMINVOICEDETAIL.FAREAMOUNT, fareAmount);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVITEMINVOICEDETAIL.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVITEMINVOICEDETAIL.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getInvoiceId(){ 
		return (java.lang.Integer) get(MTTableVITEMINVOICEDETAIL.INVOICEID);
	}

	public void setInvoiceId(java.lang.Integer invoiceId){ 
		set(MTTableVITEMINVOICEDETAIL.INVOICEID, invoiceId);
	} 

	public void update() {
		super.update();
	}

	public VitemInvoiceDetailDTO insert() {
		return (VitemInvoiceDetailDTO) super.insert();
	}

	public static VitemInvoiceDetailDTO find(String whereExpression) {
		try {
			return new VitemInvoiceDetailDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}