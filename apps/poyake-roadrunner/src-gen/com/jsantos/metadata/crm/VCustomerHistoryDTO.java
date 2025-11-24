package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VCustomerHistoryDTO extends DetachedRecord{

	public VCustomerHistoryDTO(){
		super(MTBase.getTable("VCUSTOMERHISTORY"));
	}

	public VCustomerHistoryDTO(ResultSet rs){
		super(MTBase.getTable("VCUSTOMERHISTORY"), rs);
	}

	public VCustomerHistoryDTO(Integer pk) {
		super(MTBase.getTable("VCUSTOMERHISTORY"), pk);
	}

	public VCustomerHistoryDTO(String whereClause) {
		super(MTBase.getTable("VCUSTOMERHISTORY"), whereClause);
	}

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableVCUSTOMERHISTORY.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableVCUSTOMERHISTORY.STARTDATE, startDate);
	} 

	public java.lang.String getObjectType(){ 
		return (java.lang.String) get(MTTableVCUSTOMERHISTORY.OBJECTTYPE);
	}

	public void setObjectType(java.lang.String objectType){ 
		set(MTTableVCUSTOMERHISTORY.OBJECTTYPE, objectType);
	} 

	public java.lang.String getAction(){ 
		return (java.lang.String) get(MTTableVCUSTOMERHISTORY.ACTION);
	}

	public void setAction(java.lang.String action){ 
		set(MTTableVCUSTOMERHISTORY.ACTION, action);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERHISTORY.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableVCUSTOMERHISTORY.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERHISTORY.ID);
	}

	public void setId(java.lang.Integer id){ 
		set(MTTableVCUSTOMERHISTORY.ID, id);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERHISTORY.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableVCUSTOMERHISTORY.REVISIONID, revisionId);
	} 

	public java.lang.Integer getPrevRevisionId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERHISTORY.PREVREVISIONID);
	}

	public void setPrevRevisionId(java.lang.Integer prevRevisionId){ 
		set(MTTableVCUSTOMERHISTORY.PREVREVISIONID, prevRevisionId);
	} 

	public java.lang.String getMtTable(){ 
		return (java.lang.String) get(MTTableVCUSTOMERHISTORY.MTTABLE);
	}

	public void setMtTable(java.lang.String mtTable){ 
		set(MTTableVCUSTOMERHISTORY.MTTABLE, mtTable);
	} 

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) get(MTTableVCUSTOMERHISTORY.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		set(MTTableVCUSTOMERHISTORY.CUSTOMERID, customerId);
	} 

	public void update() {
		super.update();
	}

	public VCustomerHistoryDTO insert() {
		return (VCustomerHistoryDTO) super.insert();
	}

	public static VCustomerHistoryDTO find(String whereExpression) {
		try {
			return new VCustomerHistoryDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}