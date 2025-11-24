package com.jsantos.metadata.recorder;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EnuRecorderTypeDTO extends DetachedRecord{

	public EnuRecorderTypeDTO(){
		super(MTBase.getTable("ENURECORDERTYPE"));
	}

	public EnuRecorderTypeDTO(ResultSet rs){
		super(MTBase.getTable("ENURECORDERTYPE"), rs);
	}

	public EnuRecorderTypeDTO(Integer pk) {
		super(MTBase.getTable("ENURECORDERTYPE"), pk);
	}

	public EnuRecorderTypeDTO(String whereClause) {
		super(MTBase.getTable("ENURECORDERTYPE"), whereClause);
	}

	public java.lang.Integer getEnuRecorderTypeId(){ 
		return (java.lang.Integer) get(MTTableENURECORDERTYPE.ENURECORDERTYPEID);
	}

	public void setEnuRecorderTypeId(java.lang.Integer enuRecorderTypeId){ 
		set(MTTableENURECORDERTYPE.ENURECORDERTYPEID, enuRecorderTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENURECORDERTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENURECORDERTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENURECORDERTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENURECORDERTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuRecorderTypeDTO insert() {
		return (EnuRecorderTypeDTO) super.insert();
	}

	public static EnuRecorderTypeDTO find(String whereExpression) {
		try {
			return new EnuRecorderTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}