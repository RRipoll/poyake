package com.jsantos.metadata.cfg;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.SQLException;

public class ConfigListValueDTO{
	DetachedRecord dr;

	public ConfigListValueDTO(){
		dr = new DetachedRecord(MT.CONFIGLISTVALUE);
	}

	public ConfigListValueDTO(Integer pk) throws SQLException{
		dr = new DetachedRecord(MT.CONFIGLISTVALUE,pk);
	}

	public java.lang.Integer getConfigSetValueId(){ 
		return (java.lang.Integer) dr.get(MTTableCONFIGLISTVALUE.CONFIGSETVALUEID);
	}

	public void setConfigSetValueId(java.lang.Integer configSetValueId){ 
		dr.set(MTTableCONFIGLISTVALUE.CONFIGSETVALUEID, configSetValueId);
	} 

	public java.lang.Integer getConfigKeyId(){ 
		return (java.lang.Integer) dr.get(MTTableCONFIGLISTVALUE.CONFIGKEYID);
	}

	public void setConfigKeyId(java.lang.Integer configKeyId){ 
		dr.set(MTTableCONFIGLISTVALUE.CONFIGKEYID, configKeyId);
	} 

	public java.lang.String getValue(){ 
		return (java.lang.String) dr.get(MTTableCONFIGLISTVALUE.VALUE);
	}

	public void setValue(java.lang.String value){ 
		dr.set(MTTableCONFIGLISTVALUE.VALUE, value);
	} 

	public void update() {
		dr.update();
	}

	public void insert() {
		dr.insert();
	}
}