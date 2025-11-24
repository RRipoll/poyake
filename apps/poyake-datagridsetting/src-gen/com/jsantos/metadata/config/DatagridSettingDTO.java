package com.jsantos.metadata.config;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class DatagridSettingDTO extends DetachedRecord{

	public DatagridSettingDTO(){
		super(MTBase.getTable("DATAGRIDSETTING"));
	}

	public DatagridSettingDTO(ResultSet rs){
		super(MTBase.getTable("DATAGRIDSETTING"), rs);
	}

	public DatagridSettingDTO(Integer pk) {
		super(MTBase.getTable("DATAGRIDSETTING"), pk);
	}

	public DatagridSettingDTO(String whereClause) {
		super(MTBase.getTable("DATAGRIDSETTING"), whereClause);
	}

	public java.lang.String getDataGridSettingId(){ 
		return (java.lang.String) get(MTTableDATAGRIDSETTING.DATAGRIDSETTINGID);
	}

	public void setDataGridSettingId(java.lang.String dataGridSettingId){ 
		set(MTTableDATAGRIDSETTING.DATAGRIDSETTINGID, dataGridSettingId);
	} 

	public java.lang.String getSearchName(){ 
		return (java.lang.String) get(MTTableDATAGRIDSETTING.SEARCHNAME);
	}

	public void setSearchName(java.lang.String searchName){ 
		set(MTTableDATAGRIDSETTING.SEARCHNAME, searchName);
	} 

	public com.jsantos.common.model.SettingDTO getData(){ 
		return (com.jsantos.common.model.SettingDTO) get(MTTableDATAGRIDSETTING.DATA);
	}

	public void setData(com.jsantos.common.model.SettingDTO data){ 
		set(MTTableDATAGRIDSETTING.DATA, data);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableDATAGRIDSETTING.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableDATAGRIDSETTING.CREATED, created);
	} 

	public java.lang.Integer getInputUserGroupId(){ 
		return (java.lang.Integer) get(MTTableDATAGRIDSETTING.INPUTUSERGROUPID);
	}

	public void setInputUserGroupId(java.lang.Integer inputUserGroupId){ 
		set(MTTableDATAGRIDSETTING.INPUTUSERGROUPID, inputUserGroupId);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableDATAGRIDSETTING.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableDATAGRIDSETTING.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableDATAGRIDSETTING.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableDATAGRIDSETTING.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public DatagridSettingDTO insert() {
		return (DatagridSettingDTO) super.insert();
	}

	public static DatagridSettingDTO find(String whereExpression) {
		try {
			return new DatagridSettingDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}