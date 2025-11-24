package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CheckParameterItemDTO extends DetachedRecord{

	public CheckParameterItemDTO(){
		super(MTBase.getTable("CHECKPARAMETERITEM"));
	}

	public CheckParameterItemDTO(ResultSet rs){
		super(MTBase.getTable("CHECKPARAMETERITEM"), rs);
	}

	public CheckParameterItemDTO(Integer pk) {
		super(MTBase.getTable("CHECKPARAMETERITEM"), pk);
	}

	public CheckParameterItemDTO(String whereClause) {
		super(MTBase.getTable("CHECKPARAMETERITEM"), whereClause);
	}

	public java.lang.String getValueName(){ 
		return (java.lang.String) get(MTTableCHECKPARAMETERITEM.VALUENAME);
	}

	public void setValueName(java.lang.String valueName){ 
		set(MTTableCHECKPARAMETERITEM.VALUENAME, valueName);
	} 

	public java.lang.Integer getOperator(){ 
		return (java.lang.Integer) get(MTTableCHECKPARAMETERITEM.OPERATOR);
	}

	public void setOperator(java.lang.Integer operator){ 
		set(MTTableCHECKPARAMETERITEM.OPERATOR, operator);
	} 

	public java.lang.Integer getCheckValueTypeId(){ 
		return (java.lang.Integer) get(MTTableCHECKPARAMETERITEM.CHECKVALUETYPEID);
	}

	public void setCheckValueTypeId(java.lang.Integer checkValueTypeId){ 
		set(MTTableCHECKPARAMETERITEM.CHECKVALUETYPEID, checkValueTypeId);
	} 

	public java.lang.String getCheckValue(){ 
		return (java.lang.String) get(MTTableCHECKPARAMETERITEM.CHECKVALUE);
	}

	public void setCheckValue(java.lang.String checkValue){ 
		set(MTTableCHECKPARAMETERITEM.CHECKVALUE, checkValue);
	} 

	public void update() {
		super.update();
	}

	public CheckParameterItemDTO insert() {
		return (CheckParameterItemDTO) super.insert();
	}

	public static CheckParameterItemDTO find(String whereExpression) {
		try {
			return new CheckParameterItemDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}