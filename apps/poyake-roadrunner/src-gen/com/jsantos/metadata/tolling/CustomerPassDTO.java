package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CustomerPassDTO extends DetachedRecord{

	public CustomerPassDTO(){
		super(MTBase.getTable("CUSTOMERPASS"));
	}

	public CustomerPassDTO(ResultSet rs){
		super(MTBase.getTable("CUSTOMERPASS"), rs);
	}

	public CustomerPassDTO(Integer pk) {
		super(MTBase.getTable("CUSTOMERPASS"), pk);
	}

	public CustomerPassDTO(String whereClause) {
		super(MTBase.getTable("CUSTOMERPASS"), whereClause);
	}

	public java.lang.Integer getCustomerPassId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERPASS.CUSTOMERPASSID);
	}

	public void setCustomerPassId(java.lang.Integer customerPassId){ 
		set(MTTableCUSTOMERPASS.CUSTOMERPASSID, customerPassId);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERPASS.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableCUSTOMERPASS.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getPassId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERPASS.PASSID);
	}

	public void setPassId(java.lang.Integer passId){ 
		set(MTTableCUSTOMERPASS.PASSID, passId);
	} 

	public java.util.Date getStartEffectiveDate(){ 
		return (java.util.Date) get(MTTableCUSTOMERPASS.STARTEFFECTIVEDATE);
	}

	public void setStartEffectiveDate(java.util.Date startEffectiveDate){ 
		set(MTTableCUSTOMERPASS.STARTEFFECTIVEDATE, startEffectiveDate);
	} 

	public java.util.Date getEndEffectiveDate(){ 
		return (java.util.Date) get(MTTableCUSTOMERPASS.ENDEFFECTIVEDATE);
	}

	public void setEndEffectiveDate(java.util.Date endEffectiveDate){ 
		set(MTTableCUSTOMERPASS.ENDEFFECTIVEDATE, endEffectiveDate);
	} 

	public void update() {
		super.update();
	}

	public CustomerPassDTO insert() {
		return (CustomerPassDTO) super.insert();
	}

	public static CustomerPassDTO find(String whereExpression) {
		try {
			return new CustomerPassDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}