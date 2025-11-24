package com.jsantos.metadata.cfg;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.SQLException;

public class ConfigValueDTO{
	DetachedRecord dr;

	public ConfigValueDTO(){
		dr = new DetachedRecord(MT.CONFIGVALUE);
	}

	public ConfigValueDTO(Integer pk) throws SQLException{
		dr = new DetachedRecord(MT.CONFIGVALUE,pk);
	}

	public java.lang.Integer getConfigKeyId(){ 
		return (java.lang.Integer) dr.get(MTTableCONFIGVALUE.CONFIGKEYID);
	}

	public void setConfigKeyId(java.lang.Integer configKeyId){ 
		dr.set(MTTableCONFIGVALUE.CONFIGKEYID, configKeyId);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) dr.get(MTTableCONFIGVALUE.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		dr.set(MTTableCONFIGVALUE.REVISIONID, revisionId);
	} 

	public java.lang.String getValue(){ 
		return (java.lang.String) dr.get(MTTableCONFIGVALUE.VALUE);
	}

	public void setValue(java.lang.String value){ 
		dr.set(MTTableCONFIGVALUE.VALUE, value);
	} 

	public java.sql.Timestamp getStartDate(){ 
		return (java.sql.Timestamp) dr.get(MTTableCONFIGVALUE.STARTDATE);
	}

	public void setStartDate(java.sql.Timestamp startDate){ 
		dr.set(MTTableCONFIGVALUE.STARTDATE, startDate);
	} 

	public java.sql.Timestamp getEndDate(){ 
		return (java.sql.Timestamp) dr.get(MTTableCONFIGVALUE.ENDDATE);
	}

	public void setEndDate(java.sql.Timestamp endDate){ 
		dr.set(MTTableCONFIGVALUE.ENDDATE, endDate);
	} 

	public void update() {
		dr.update();
	}

	public void insert() {
		dr.insert();
	}
}