package com.jsantos.metadata.recorder;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class RecorderMasterDTO extends DetachedRecord{

	public RecorderMasterDTO(){
		super(MTBase.getTable("RECORDERMASTER"));
	}

	public RecorderMasterDTO(ResultSet rs){
		super(MTBase.getTable("RECORDERMASTER"), rs);
	}

	public RecorderMasterDTO(Integer pk) {
		super(MTBase.getTable("RECORDERMASTER"), pk);
	}

	public RecorderMasterDTO(String whereClause) {
		super(MTBase.getTable("RECORDERMASTER"), whereClause);
	}

	public java.lang.Integer getRecorderMasterId(){ 
		return (java.lang.Integer) get(MTTableRECORDERMASTER.RECORDERMASTERID);
	}

	public void setRecorderMasterId(java.lang.Integer recorderMasterId){ 
		set(MTTableRECORDERMASTER.RECORDERMASTERID, recorderMasterId);
	} 

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTableRECORDERMASTER.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTableRECORDERMASTER.POSTINGDATE, postingDate);
	} 

	public java.lang.String getSession(){ 
		return (java.lang.String) get(MTTableRECORDERMASTER.SESSION);
	}

	public void setSession(java.lang.String session){ 
		set(MTTableRECORDERMASTER.SESSION, session);
	} 

	public java.lang.Integer getDeleted(){ 
		return (java.lang.Integer) get(MTTableRECORDERMASTER.DELETED);
	}

	public void setDeleted(java.lang.Integer deleted){ 
		set(MTTableRECORDERMASTER.DELETED, deleted);
	} 

	public void update() {
		super.update();
	}

	public RecorderMasterDTO insert() {
		return (RecorderMasterDTO) super.insert();
	}

	public static RecorderMasterDTO find(String whereExpression) {
		try {
			return new RecorderMasterDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}