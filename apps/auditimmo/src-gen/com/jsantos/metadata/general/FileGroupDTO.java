package com.jsantos.metadata.general;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.ResultSet;

public class FileGroupDTO extends DetachedRecord{

	public FileGroupDTO(){
		super(MT.FILEGROUP);
	}

	public FileGroupDTO(ResultSet rs){
		super(MT.FILEGROUP, rs);
	}

	public FileGroupDTO(Integer pk) {
		super(MT.FILEGROUP,pk);
	}

	public FileGroupDTO(String whereClause) {
		super(MT.FILEGROUP,whereClause);
	}

	public java.lang.Integer getFileGroupId(){ 
		return (java.lang.Integer) get(MTTableFILEGROUP.FILEGROUPID);
	}

	public void setFileGroupId(java.lang.Integer fileGroupId){ 
		set(MTTableFILEGROUP.FILEGROUPID, fileGroupId);
	} 

	public java.sql.Timestamp getPostingDate(){ 
		return (java.sql.Timestamp) get(MTTableFILEGROUP.POSTINGDATE);
	}

	public void setPostingDate(java.sql.Timestamp postingDate){ 
		set(MTTableFILEGROUP.POSTINGDATE, postingDate);
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