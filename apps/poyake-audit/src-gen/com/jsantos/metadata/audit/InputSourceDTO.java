package com.jsantos.metadata.audit;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class InputSourceDTO extends DetachedRecord{

	public InputSourceDTO(){
		super(MTBase.getTable("INPUTSOURCE"));
	}

	public InputSourceDTO(ResultSet rs){
		super(MTBase.getTable("INPUTSOURCE"), rs);
	}

	public InputSourceDTO(Integer pk) {
		super(MTBase.getTable("INPUTSOURCE"), pk);
	}

	public InputSourceDTO(String whereClause) {
		super(MTBase.getTable("INPUTSOURCE"), whereClause);
	}

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableINPUTSOURCE.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableINPUTSOURCE.INPUTSOURCEID, inputSourceId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableINPUTSOURCE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableINPUTSOURCE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableINPUTSOURCE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableINPUTSOURCE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public InputSourceDTO insert() {
		return (InputSourceDTO) super.insert();
	}

	public static InputSourceDTO find(String whereExpression) {
		try {
			return new InputSourceDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}