package com.jsantos.metadata.common;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class FileshowDTO extends DetachedRecord{

	public FileshowDTO(){
		super(MTBase.getTable("FILESHOW"));
	}

	public FileshowDTO(ResultSet rs){
		super(MTBase.getTable("FILESHOW"), rs);
	}

	public FileshowDTO(Integer pk) {
		super(MTBase.getTable("FILESHOW"), pk);
	}

	public FileshowDTO(String whereClause) {
		super(MTBase.getTable("FILESHOW"), whereClause);
	}

	public java.lang.Integer getFileGroupId(){ 
		return (java.lang.Integer) get(MTTableFILESHOW.FILEGROUPID);
	}

	public void setFileGroupId(java.lang.Integer fileGroupId){ 
		set(MTTableFILESHOW.FILEGROUPID, fileGroupId);
	} 

	public void update() {
		super.update();
	}

	public FileshowDTO insert() {
		return (FileshowDTO) super.insert();
	}

	public static FileshowDTO find(String whereExpression) {
		try {
			return new FileshowDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}