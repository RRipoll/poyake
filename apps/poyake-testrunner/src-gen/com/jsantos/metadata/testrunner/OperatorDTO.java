package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class OperatorDTO extends DetachedRecord{

	public OperatorDTO(){
		super(MTBase.getTable("OPERATOR"));
	}

	public OperatorDTO(ResultSet rs){
		super(MTBase.getTable("OPERATOR"), rs);
	}

	public OperatorDTO(Integer pk) {
		super(MTBase.getTable("OPERATOR"), pk);
	}

	public OperatorDTO(String whereClause) {
		super(MTBase.getTable("OPERATOR"), whereClause);
	}

	public java.lang.Integer getOperatorId(){ 
		return (java.lang.Integer) get(MTTableOPERATOR.OPERATORID);
	}

	public void setOperatorId(java.lang.Integer operatorId){ 
		set(MTTableOPERATOR.OPERATORID, operatorId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableOPERATOR.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableOPERATOR.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableOPERATOR.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableOPERATOR.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public OperatorDTO insert() {
		return (OperatorDTO) super.insert();
	}

	public static OperatorDTO find(String whereExpression) {
		try {
			return new OperatorDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}