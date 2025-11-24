package com.jsantos.metadata.recorder;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class RecorderDataDTO extends DetachedRecord{

	public RecorderDataDTO(){
		super(MTBase.getTable("RECORDERDATA"));
	}

	public RecorderDataDTO(ResultSet rs){
		super(MTBase.getTable("RECORDERDATA"), rs);
	}

	public RecorderDataDTO(Integer pk) {
		super(MTBase.getTable("RECORDERDATA"), pk);
	}

	public RecorderDataDTO(String whereClause) {
		super(MTBase.getTable("RECORDERDATA"), whereClause);
	}

	public java.lang.Integer getRecorderDataId(){ 
		return (java.lang.Integer) get(MTTableRECORDERDATA.RECORDERDATAID);
	}

	public void setRecorderDataId(java.lang.Integer recorderDataId){ 
		set(MTTableRECORDERDATA.RECORDERDATAID, recorderDataId);
	} 

	public java.lang.Integer getRecorderTypeId(){ 
		return (java.lang.Integer) get(MTTableRECORDERDATA.RECORDERTYPEID);
	}

	public void setRecorderTypeId(java.lang.Integer recorderTypeId){ 
		set(MTTableRECORDERDATA.RECORDERTYPEID, recorderTypeId);
	} 

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTableRECORDERDATA.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTableRECORDERDATA.POSTINGDATE, postingDate);
	} 

	public java.lang.String getTableName(){ 
		return (java.lang.String) get(MTTableRECORDERDATA.TABLENAME);
	}

	public void setTableName(java.lang.String tableName){ 
		set(MTTableRECORDERDATA.TABLENAME, tableName);
	} 

	public java.lang.String getData(){ 
		return (java.lang.String) get(MTTableRECORDERDATA.DATA);
	}

	public void setData(java.lang.String data){ 
		set(MTTableRECORDERDATA.DATA, data);
	} 

	public java.lang.Integer getDeleted(){ 
		return (java.lang.Integer) get(MTTableRECORDERDATA.DELETED);
	}

	public void setDeleted(java.lang.Integer deleted){ 
		set(MTTableRECORDERDATA.DELETED, deleted);
	} 

	public void update() {
		super.update();
	}

	public RecorderDataDTO insert() {
		return (RecorderDataDTO) super.insert();
	}

	public static RecorderDataDTO find(String whereExpression) {
		try {
			return new RecorderDataDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}