package com.jsantos.metadata.cfg;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.SQLException;

public class VCurrentConfigValuesDTO{
	DetachedRecord dr;

	public VCurrentConfigValuesDTO(){
		dr = new DetachedRecord(MT.VCURRENTCONFIGVALUES);
	}

	public VCurrentConfigValuesDTO(Integer pk) throws SQLException{
		dr = new DetachedRecord(MT.VCURRENTCONFIGVALUES,pk);
	}

	public java.lang.Integer getConfigKeyId(){ 
		return (java.lang.Integer) dr.get(MTTableVCURRENTCONFIGVALUES.CONFIGKEYID);
	}

	public void setConfigKeyId(java.lang.Integer configKeyId){ 
		dr.set(MTTableVCURRENTCONFIGVALUES.CONFIGKEYID, configKeyId);
	} 

	public java.lang.String getFullPath(){ 
		return (java.lang.String) dr.get(MTTableVCURRENTCONFIGVALUES.FULLPATH);
	}

	public void setFullPath(java.lang.String fullPath){ 
		dr.set(MTTableVCURRENTCONFIGVALUES.FULLPATH, fullPath);
	} 

	public java.lang.String getValue(){ 
		return (java.lang.String) dr.get(MTTableVCURRENTCONFIGVALUES.VALUE);
	}

	public void setValue(java.lang.String value){ 
		dr.set(MTTableVCURRENTCONFIGVALUES.VALUE, value);
	} 

	public void update() {
		dr.update();
	}

	public void insert() {
		dr.insert();
	}
}