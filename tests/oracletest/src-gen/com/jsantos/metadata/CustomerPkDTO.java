package com.jsantos.metadata;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.SQLException;

public class CustomerPkDTO{
	DetachedRecord dr;

	public CustomerPkDTO(){
		dr = new DetachedRecord(MT.CUSTOMERPK);
	}

	public CustomerPkDTO(Integer pk) throws SQLException{
		dr = new DetachedRecord(MT.CUSTOMERPK,pk);
	}

	public java.lang.Integer getCustomerId(){ 
		return (java.lang.Integer) dr.get(MTTableCUSTOMERPK.CUSTOMERID);
	}

	public void setCustomerId(java.lang.Integer customerId){ 
		dr.set(MTTableCUSTOMERPK.CUSTOMERID, customerId);
	} 

	public void update() {
		dr.update();
	}

	public void insert() {
		dr.insert();
	}
}