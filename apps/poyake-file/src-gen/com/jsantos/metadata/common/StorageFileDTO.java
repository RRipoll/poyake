package com.jsantos.metadata.common;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class StorageFileDTO extends AutoHistoryDetachedRecord{

	public StorageFileDTO(){
		super(MTBase.getTable("STORAGEFILE"));
	}

	public StorageFileDTO(ResultSet rs){
		super(MTBase.getTable("STORAGEFILE"), rs);
	}

	public StorageFileDTO(Integer pk) {
		super(MTBase.getTable("STORAGEFILE"), pk);
	}

	public StorageFileDTO(String whereClause) {
		super(MTBase.getTable("STORAGEFILE"), whereClause);
	}

	public StorageFileDTO(Boolean isMainFk, Integer pk) {
		super(MTBase.getTable("STORAGEFILE"),isMainFk, pk);
	}

	public java.lang.Integer getStorageFileId(){ 
		return (java.lang.Integer) get(MTTableSTORAGEFILE.STORAGEFILEID);
	}

	public void setStorageFileId(java.lang.Integer storageFileId){ 
		set(MTTableSTORAGEFILE.STORAGEFILEID, storageFileId);
	} 

	public java.lang.String getLocation(){ 
		return (java.lang.String) get(MTTableSTORAGEFILE.LOCATION);
	}

	public void setLocation(java.lang.String location){ 
		set(MTTableSTORAGEFILE.LOCATION, location);
	} 

	public java.lang.String getProvider(){ 
		return (java.lang.String) get(MTTableSTORAGEFILE.PROVIDER);
	}

	public void setProvider(java.lang.String provider){ 
		set(MTTableSTORAGEFILE.PROVIDER, provider);
	} 

	public java.lang.String getMimeType(){ 
		return (java.lang.String) get(MTTableSTORAGEFILE.MIMETYPE);
	}

	public void setMimeType(java.lang.String mimeType){ 
		set(MTTableSTORAGEFILE.MIMETYPE, mimeType);
	} 

	public java.lang.String getFileName(){ 
		return (java.lang.String) get(MTTableSTORAGEFILE.FILENAME);
	}

	public void setFileName(java.lang.String fileName){ 
		set(MTTableSTORAGEFILE.FILENAME, fileName);
	} 

	public java.lang.Integer getFileGroupId(){ 
		return (java.lang.Integer) get(MTTableSTORAGEFILE.FILEGROUPID);
	}

	public void setFileGroupId(java.lang.Integer fileGroupId){ 
		set(MTTableSTORAGEFILE.FILEGROUPID, fileGroupId);
	} 

	public java.lang.String getOriginalFileName(){ 
		return (java.lang.String) get(MTTableSTORAGEFILE.ORIGINALFILENAME);
	}

	public void setOriginalFileName(java.lang.String originalFileName){ 
		set(MTTableSTORAGEFILE.ORIGINALFILENAME, originalFileName);
	} 

	public java.lang.String getTags(){ 
		return (java.lang.String) get(MTTableSTORAGEFILE.TAGS);
	}

	public void setTags(java.lang.String tags){ 
		set(MTTableSTORAGEFILE.TAGS, tags);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableSTORAGEFILE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableSTORAGEFILE.DESCRIPTION, description);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableSTORAGEFILE.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableSTORAGEFILE.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableSTORAGEFILE.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableSTORAGEFILE.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableSTORAGEFILE.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableSTORAGEFILE.INPUTSOURCEID, inputSourceId);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableSTORAGEFILE.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableSTORAGEFILE.REVISIONID, revisionId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableSTORAGEFILE.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableSTORAGEFILE.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableSTORAGEFILE.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableSTORAGEFILE.ENDDATE, endDate);
	} 

	public void update() {
		super.update();
	}

	public StorageFileDTO insert() {
		return (StorageFileDTO) super.insert();
	}

	public static StorageFileDTO find(String whereExpression) {
		try {
			return new StorageFileDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}