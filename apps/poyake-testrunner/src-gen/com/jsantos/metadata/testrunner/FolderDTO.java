package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class FolderDTO extends DetachedRecord{

	public FolderDTO(){
		super(MTBase.getTable("FOLDER"));
	}

	public FolderDTO(ResultSet rs){
		super(MTBase.getTable("FOLDER"), rs);
	}

	public FolderDTO(Integer pk) {
		super(MTBase.getTable("FOLDER"), pk);
	}

	public FolderDTO(String whereClause) {
		super(MTBase.getTable("FOLDER"), whereClause);
	}

	public java.lang.String getFolderUuid(){ 
		return (java.lang.String) get(MTTableFOLDER.FOLDERUUID);
	}

	public void setFolderUuid(java.lang.String folderUuid){ 
		set(MTTableFOLDER.FOLDERUUID, folderUuid);
	} 

	public java.lang.String getParentfolderUuid(){ 
		return (java.lang.String) get(MTTableFOLDER.PARENTFOLDERUUID);
	}

	public void setParentfolderUuid(java.lang.String parentfolderUuid){ 
		set(MTTableFOLDER.PARENTFOLDERUUID, parentfolderUuid);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableFOLDER.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableFOLDER.DESCRIPTION, description);
	} 

	public java.lang.String getTestUuid(){ 
		return (java.lang.String) get(MTTableFOLDER.TESTUUID);
	}

	public void setTestUuid(java.lang.String testUuid){ 
		set(MTTableFOLDER.TESTUUID, testUuid);
	} 

	public void update() {
		super.update();
	}

	public FolderDTO insert() {
		return (FolderDTO) super.insert();
	}

	public static FolderDTO find(String whereExpression) {
		try {
			return new FolderDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}