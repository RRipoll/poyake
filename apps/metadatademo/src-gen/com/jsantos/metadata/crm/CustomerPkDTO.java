package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CustomerPkDTO extends DetachedRecord{

	public CustomerPkDTO(){
		super(MTBase.getTable("CUSTOMERPK"));
	}

	public CustomerPkDTO(ResultSet rs){
		super(MTBase.getTable("CUSTOMERPK"), rs);
	}

	public CustomerPkDTO(Integer pk) {
		super(MTBase.getTable("CUSTOMERPK"), pk);
	}

	public CustomerPkDTO(String whereClause) {
		super(MTBase.getTable("CUSTOMERPK"), whereClause);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERPK.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableCUSTOMERPK.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public CustomerPkDTO insert() {
		return (CustomerPkDTO) super.insert();
	}

	public static CustomerPkDTO find(String whereExpression) {
		try {
			return new CustomerPkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}