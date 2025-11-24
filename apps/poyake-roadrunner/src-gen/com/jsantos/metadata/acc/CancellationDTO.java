package com.jsantos.metadata.acc;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CancellationDTO extends DetachedRecord{

	public CancellationDTO(){
		super(MTBase.getTable("CANCELLATION"));
	}

	public CancellationDTO(ResultSet rs){
		super(MTBase.getTable("CANCELLATION"), rs);
	}

	public CancellationDTO(Integer pk) {
		super(MTBase.getTable("CANCELLATION"), pk);
	}

	public CancellationDTO(String whereClause) {
		super(MTBase.getTable("CANCELLATION"), whereClause);
	}

	public java.lang.Integer getCancelledRevisionId(){ 
		return (java.lang.Integer) get(MTTableCANCELLATION.CANCELLEDREVISIONID);
	}

	public void setCancelledRevisionId(java.lang.Integer cancelledRevisionId){ 
		set(MTTableCANCELLATION.CANCELLEDREVISIONID, cancelledRevisionId);
	} 

	public java.lang.Integer getCancellingRevisionId(){ 
		return (java.lang.Integer) get(MTTableCANCELLATION.CANCELLINGREVISIONID);
	}

	public void setCancellingRevisionId(java.lang.Integer cancellingRevisionId){ 
		set(MTTableCANCELLATION.CANCELLINGREVISIONID, cancellingRevisionId);
	} 

	public void update() {
		super.update();
	}

	public CancellationDTO insert() {
		return (CancellationDTO) super.insert();
	}

	public static CancellationDTO find(String whereExpression) {
		try {
			return new CancellationDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}