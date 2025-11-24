package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class TrParameterDTO extends DetachedRecord{

	public TrParameterDTO(){
		super(MTBase.getTable("TRPARAMETER"));
	}

	public TrParameterDTO(ResultSet rs){
		super(MTBase.getTable("TRPARAMETER"), rs);
	}

	public TrParameterDTO(Integer pk) {
		super(MTBase.getTable("TRPARAMETER"), pk);
	}

	public TrParameterDTO(String whereClause) {
		super(MTBase.getTable("TRPARAMETER"), whereClause);
	}

	public java.lang.String getLabel(){ 
		return (java.lang.String) get(MTTableTRPARAMETER.LABEL);
	}

	public void setLabel(java.lang.String label){ 
		set(MTTableTRPARAMETER.LABEL, label);
	} 

	public java.lang.Integer getTrParameterTypeId(){ 
		return (java.lang.Integer) get(MTTableTRPARAMETER.TRPARAMETERTYPEID);
	}

	public void setTrParameterTypeId(java.lang.Integer trParameterTypeId){ 
		set(MTTableTRPARAMETER.TRPARAMETERTYPEID, trParameterTypeId);
	} 

	public java.lang.String getValue(){ 
		return (java.lang.String) get(MTTableTRPARAMETER.VALUE);
	}

	public void setValue(java.lang.String value){ 
		set(MTTableTRPARAMETER.VALUE, value);
	} 

	public void update() {
		super.update();
	}

	public TrParameterDTO insert() {
		return (TrParameterDTO) super.insert();
	}

	public static TrParameterDTO find(String whereExpression) {
		try {
			return new TrParameterDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}