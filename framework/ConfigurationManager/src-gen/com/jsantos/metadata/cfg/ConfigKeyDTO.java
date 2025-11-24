package com.jsantos.metadata.cfg;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.SQLException;

public class ConfigKeyDTO{
	DetachedRecord dr;

	public ConfigKeyDTO(){
		dr = new DetachedRecord(MT.CONFIGKEY);
	}

	public ConfigKeyDTO(Integer pk) throws SQLException{
		dr = new DetachedRecord(MT.CONFIGKEY,pk);
	}

	public java.lang.Integer getConfigKeyId(){ 
		return (java.lang.Integer) dr.get(MTTableCONFIGKEY.CONFIGKEYID);
	}

	public void setConfigKeyId(java.lang.Integer configKeyId){ 
		dr.set(MTTableCONFIGKEY.CONFIGKEYID, configKeyId);
	} 

	public java.lang.String getFullPath(){ 
		return (java.lang.String) dr.get(MTTableCONFIGKEY.FULLPATH);
	}

	public void setFullPath(java.lang.String fullPath){ 
		dr.set(MTTableCONFIGKEY.FULLPATH, fullPath);
	} 

	public java.lang.Integer getConfigKeyTypeId(){ 
		return (java.lang.Integer) dr.get(MTTableCONFIGKEY.CONFIGKEYTYPEID);
	}

	public void setConfigKeyTypeId(java.lang.Integer configKeyTypeId){ 
		dr.set(MTTableCONFIGKEY.CONFIGKEYTYPEID, configKeyTypeId);
	} 

	public java.lang.Integer getConfigDataTypeId(){ 
		return (java.lang.Integer) dr.get(MTTableCONFIGKEY.CONFIGDATATYPEID);
	}

	public void setConfigDataTypeId(java.lang.Integer configDataTypeId){ 
		dr.set(MTTableCONFIGKEY.CONFIGDATATYPEID, configDataTypeId);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) dr.get(MTTableCONFIGKEY.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		dr.set(MTTableCONFIGKEY.DESCRIPTION, description);
	} 

	public java.lang.String getDefaultValue(){ 
		return (java.lang.String) dr.get(MTTableCONFIGKEY.DEFAULTVALUE);
	}

	public void setDefaultValue(java.lang.String defaultValue){ 
		dr.set(MTTableCONFIGKEY.DEFAULTVALUE, defaultValue);
	} 

	public java.lang.Boolean getIsStatic(){ 
		return (java.lang.Boolean) dr.get(MTTableCONFIGKEY.ISSTATIC);
	}

	public void setIsStatic(java.lang.Boolean isStatic){ 
		dr.set(MTTableCONFIGKEY.ISSTATIC, isStatic);
	} 

	public void update() {
		dr.update();
	}

	public void insert() {
		dr.insert();
	}
}