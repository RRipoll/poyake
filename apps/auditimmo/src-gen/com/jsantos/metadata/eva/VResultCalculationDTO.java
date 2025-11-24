package com.jsantos.metadata.eva;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.ResultSet;

public class VResultCalculationDTO extends DetachedRecord{

	public VResultCalculationDTO(){
		super(MT.VRESULTCALCULATION);
	}

	public VResultCalculationDTO(ResultSet rs){
		super(MT.VRESULTCALCULATION, rs);
	}

	public VResultCalculationDTO(Integer pk) {
		super(MT.VRESULTCALCULATION,pk);
	}

	public VResultCalculationDTO(String whereClause) {
		super(MT.VRESULTCALCULATION,whereClause);
	}

	public java.lang.Integer getEvaluationId(){ 
		return (java.lang.Integer) get(MTTableVRESULTCALCULATION.EVALUATIONID);
	}

	public void setEvaluationId(java.lang.Integer evaluationId){ 
		set(MTTableVRESULTCALCULATION.EVALUATIONID, evaluationId);
	} 

	public java.lang.Integer getLevel(){ 
		return (java.lang.Integer) get(MTTableVRESULTCALCULATION.LEVEL);
	}

	public void setLevel(java.lang.Integer level){ 
		set(MTTableVRESULTCALCULATION.LEVEL, level);
	} 

	public java.lang.Integer getEvaluationSectionTypeId(){ 
		return (java.lang.Integer) get(MTTableVRESULTCALCULATION.EVALUATIONSECTIONTYPEID);
	}

	public void setEvaluationSectionTypeId(java.lang.Integer evaluationSectionTypeId){ 
		set(MTTableVRESULTCALCULATION.EVALUATIONSECTIONTYPEID, evaluationSectionTypeId);
	} 

	public void update() {
		super.update();
	}

	public VResultCalculationDTO insert() {
		return (VResultCalculationDTO) super.insert();
	}

	public static VResultCalculationDTO find(String whereExpression) {
		try {
			return new VResultCalculationDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}