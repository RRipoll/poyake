package com.jsantos.metadata.cs;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CustomerCaseDTO extends DetachedRecord{

	public CustomerCaseDTO(){
		super(MTBase.getTable("CUSTOMERCASE"));
	}

	public CustomerCaseDTO(ResultSet rs){
		super(MTBase.getTable("CUSTOMERCASE"), rs);
	}

	public CustomerCaseDTO(Integer pk) {
		super(MTBase.getTable("CUSTOMERCASE"), pk);
	}

	public CustomerCaseDTO(String whereClause) {
		super(MTBase.getTable("CUSTOMERCASE"), whereClause);
	}

	public java.lang.Integer getCustomercaseId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERCASE.CUSTOMERCASEID);
	}

	public void setCustomercaseId(java.lang.Integer customercaseId){ 
		set(MTTableCUSTOMERCASE.CUSTOMERCASEID, customercaseId);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERCASE.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableCUSTOMERCASE.CUSTOMERID, customerId);
	} 

	public java.lang.Integer getCsCaseId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERCASE.CSCASEID);
	}

	public void setCsCaseId(java.lang.Integer csCaseId){ 
		set(MTTableCUSTOMERCASE.CSCASEID, csCaseId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableCUSTOMERCASE.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableCUSTOMERCASE.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERCASE.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableCUSTOMERCASE.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableCUSTOMERCASE.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableCUSTOMERCASE.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public CustomerCaseDTO insert() {
		return (CustomerCaseDTO) super.insert();
	}

	public static CustomerCaseDTO find(String whereExpression) {
		try {
			return new CustomerCaseDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}