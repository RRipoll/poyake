package com.jsantos.metadata.general;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.ResultSet;

public class StorageFileDTO extends DetachedRecord{

	public StorageFileDTO(){
		super(MT.STORAGEFILE);
	}

	public StorageFileDTO(ResultSet rs){
		super(MT.STORAGEFILE, rs);
	}

	public StorageFileDTO(Integer pk) {
		super(MT.STORAGEFILE,pk);
	}

	public StorageFileDTO(String whereClause) {
		super(MT.STORAGEFILE,whereClause);
	}

	public java.lang.Integer getStorageFileId(){ 
		return (java.lang.Integer) get(MTTableSTORAGEFILE.STORAGEFILEID);
	}

	public void setStorageFileId(java.lang.Integer storageFileId){ 
		set(MTTableSTORAGEFILE.STORAGEFILEID, storageFileId);
	} 

	public java.lang.String getUrl(){ 
		return (java.lang.String) get(MTTableSTORAGEFILE.URL);
	}

	public void setUrl(java.lang.String url){ 
		set(MTTableSTORAGEFILE.URL, url);
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

	public java.sql.Timestamp getPostingDate(){ 
		return (java.sql.Timestamp) get(MTTableSTORAGEFILE.POSTINGDATE);
	}

	public void setPostingDate(java.sql.Timestamp postingDate){ 
		set(MTTableSTORAGEFILE.POSTINGDATE, postingDate);
	} 

	public java.lang.String getOriginalFileName(){ 
		return (java.lang.String) get(MTTableSTORAGEFILE.ORIGINALFILENAME);
	}

	public void setOriginalFileName(java.lang.String originalFileName){ 
		set(MTTableSTORAGEFILE.ORIGINALFILENAME, originalFileName);
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