package com.jsantos.metadata.common;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class FileGroupDTO extends DetachedRecord{

	public FileGroupDTO(){
		super(MTBase.getTable("FILEGROUP"));
	}

	public FileGroupDTO(ResultSet rs){
		super(MTBase.getTable("FILEGROUP"), rs);
	}

	public FileGroupDTO(Integer pk) {
		super(MTBase.getTable("FILEGROUP"), pk);
	}

	public FileGroupDTO(String whereClause) {
		super(MTBase.getTable("FILEGROUP"), whereClause);
	}

	public java.lang.Integer getFileGroupId(){ 
		return (java.lang.Integer) get(MTTableFILEGROUP.FILEGROUPID);
	}

	public void setFileGroupId(java.lang.Integer fileGroupId){ 
		set(MTTableFILEGROUP.FILEGROUPID, fileGroupId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableFILEGROUP.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableFILEGROUP.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableFILEGROUP.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableFILEGROUP.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableFILEGROUP.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableFILEGROUP.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public FileGroupDTO insert() {
		return (FileGroupDTO) super.insert();
	}

	public static FileGroupDTO find(String whereExpression) {
		try {
			return new FileGroupDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}