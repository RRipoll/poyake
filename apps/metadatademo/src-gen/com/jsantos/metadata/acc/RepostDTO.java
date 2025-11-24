package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class RepostDTO extends DetachedRecord{

	public RepostDTO(){
		super(MTBase.getTable("REPOST"));
	}

	public RepostDTO(ResultSet rs){
		super(MTBase.getTable("REPOST"), rs);
	}

	public RepostDTO(Integer pk) {
		super(MTBase.getTable("REPOST"), pk);
	}

	public RepostDTO(String whereClause) {
		super(MTBase.getTable("REPOST"), whereClause);
	}

	public java.lang.Integer getFromRevisionId(){ 
		return (java.lang.Integer) get(MTTableREPOST.FROMREVISIONID);
	}

	public void setFromRevisionId(java.lang.Integer fromRevisionId){ 
		set(MTTableREPOST.FROMREVISIONID, fromRevisionId);
	} 

	public java.lang.Integer getToRevisionId(){ 
		return (java.lang.Integer) get(MTTableREPOST.TOREVISIONID);
	}

	public void setToRevisionId(java.lang.Integer toRevisionId){ 
		set(MTTableREPOST.TOREVISIONID, toRevisionId);
	} 

	public void update() {
		super.update();
	}

	public RepostDTO insert() {
		return (RepostDTO) super.insert();
	}

	public static RepostDTO find(String whereExpression) {
		try {
			return new RepostDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}