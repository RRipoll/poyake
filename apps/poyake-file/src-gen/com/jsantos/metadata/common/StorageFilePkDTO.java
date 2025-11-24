package com.jsantos.metadata.common;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class StorageFilePkDTO extends DetachedRecord{

	public StorageFilePkDTO(){
		super(MTBase.getTable("STORAGEFILEPK"));
	}

	public StorageFilePkDTO(ResultSet rs){
		super(MTBase.getTable("STORAGEFILEPK"), rs);
	}

	public StorageFilePkDTO(Integer pk) {
		super(MTBase.getTable("STORAGEFILEPK"), pk);
	}

	public StorageFilePkDTO(String whereClause) {
		super(MTBase.getTable("STORAGEFILEPK"), whereClause);
	}

	public java.lang.Integer getStorageFileId(){ 
		return (java.lang.Integer) get(MTTableSTORAGEFILEPK.STORAGEFILEID);
	}

	public void setStorageFileId(java.lang.Integer storageFileId){ 
		set(MTTableSTORAGEFILEPK.STORAGEFILEID, storageFileId);
	} 

	public void update() {
		super.update();
	}

	public StorageFilePkDTO insert() {
		return (StorageFilePkDTO) super.insert();
	}

	public static StorageFilePkDTO find(String whereExpression) {
		try {
			return new StorageFilePkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}