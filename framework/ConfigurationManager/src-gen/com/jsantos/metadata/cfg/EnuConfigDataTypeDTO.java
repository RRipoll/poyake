package com.jsantos.metadata.cfg;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.SQLException;

public class EnuConfigDataTypeDTO{
	DetachedRecord dr;

	public EnuConfigDataTypeDTO(){
		dr = new DetachedRecord(MT.ENUCONFIGDATATYPE);
	}

	public EnuConfigDataTypeDTO(Integer pk) throws SQLException{
		dr = new DetachedRecord(MT.ENUCONFIGDATATYPE,pk);
	}

	public java.lang.Integer getConfigurationDataType(){ 
		return (java.lang.Integer) dr.get(MTTableENUCONFIGDATATYPE.CONFIGURATIONDATATYPE);
	}

	public void setConfigurationDataType(java.lang.Integer configurationDataType){ 
		dr.set(MTTableENUCONFIGDATATYPE.CONFIGURATIONDATATYPE, configurationDataType);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) dr.get(MTTableENUCONFIGDATATYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		dr.set(MTTableENUCONFIGDATATYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) dr.get(MTTableENUCONFIGDATATYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		dr.set(MTTableENUCONFIGDATATYPE.DESCRIPTION, description);
	} 

	public void update() {
		dr.update();
	}

	public void insert() {
		dr.insert();
	}
}