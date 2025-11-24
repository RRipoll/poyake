package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VTripPaymentDTO extends DetachedRecord{

	public VTripPaymentDTO(){
		super(MTBase.getTable("VTRIPPAYMENT"));
	}

	public VTripPaymentDTO(ResultSet rs){
		super(MTBase.getTable("VTRIPPAYMENT"), rs);
	}

	public VTripPaymentDTO(Integer pk) {
		super(MTBase.getTable("VTRIPPAYMENT"), pk);
	}

	public VTripPaymentDTO(String whereClause) {
		super(MTBase.getTable("VTRIPPAYMENT"), whereClause);
	}

	public java.lang.Integer getTripId(){ 
		return (java.lang.Integer) get(MTTableVTRIPPAYMENT.TRIPID);
	}

	public void setTripId(java.lang.Integer tripId){ 
		set(MTTableVTRIPPAYMENT.TRIPID, tripId);
	} 

	public java.lang.Integer getPaymentId(){ 
		return (java.lang.Integer) get(MTTableVTRIPPAYMENT.PAYMENTID);
	}

	public void setPaymentId(java.lang.Integer paymentId){ 
		set(MTTableVTRIPPAYMENT.PAYMENTID, paymentId);
	} 

	public java.math.BigDecimal getPaymentAmount(){ 
		return (java.math.BigDecimal) get(MTTableVTRIPPAYMENT.PAYMENTAMOUNT);
	}

	public void setPaymentAmount(java.math.BigDecimal paymentAmount){ 
		set(MTTableVTRIPPAYMENT.PAYMENTAMOUNT, paymentAmount);
	} 

	public java.math.BigDecimal getAllocatedAmount(){ 
		return (java.math.BigDecimal) get(MTTableVTRIPPAYMENT.ALLOCATEDAMOUNT);
	}

	public void setAllocatedAmount(java.math.BigDecimal allocatedAmount){ 
		set(MTTableVTRIPPAYMENT.ALLOCATEDAMOUNT, allocatedAmount);
	} 

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTableVTRIPPAYMENT.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTableVTRIPPAYMENT.POSTINGDATE, postingDate);
	} 

	public void update() {
		super.update();
	}

	public VTripPaymentDTO insert() {
		return (VTripPaymentDTO) super.insert();
	}

	public static VTripPaymentDTO find(String whereExpression) {
		try {
			return new VTripPaymentDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}