package com.jsantos.metadata.cfg;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.SQLException;

public class EnuConfigKeyTypeDTO{
	DetachedRecord dr;

	public EnuConfigKeyTypeDTO(){
		dr = new DetachedRecord(MT.ENUCONFIGKEYTYPE);
	}

	public EnuConfigKeyTypeDTO(Integer pk) throws SQLException{
		dr = new DetachedRecord(MT.ENUCONFIGKEYTYPE,pk);
	}

	public java.lang.Integer getConfigKeyTypeId(){ 
		return (java.lang.Integer) dr.get(MTTableENUCONFIGKEYTYPE.CONFIGKEYTYPEID);
	}

	public void setConfigKeyTypeId(java.lang.Integer configKeyTypeId){ 
		dr.set(MTTableENUCONFIGKEYTYPE.CONFIGKEYTYPEID, configKeyTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) dr.get(MTTableENUCONFIGKEYTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		dr.set(MTTableENUCONFIGKEYTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) dr.get(MTTableENUCONFIGKEYTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		dr.set(MTTableENUCONFIGKEYTYPE.DESCRIPTION, description);
	} 

	public void update() {
		dr.update();
	}

	public void insert() {
		dr.insert();
	}
}