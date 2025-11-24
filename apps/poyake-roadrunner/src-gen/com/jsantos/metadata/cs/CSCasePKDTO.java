package com.jsantos.metadata.cs;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CSCasePKDTO extends DetachedRecord{

	public CSCasePKDTO(){
		super(MTBase.getTable("CSCASEPK"));
	}

	public CSCasePKDTO(ResultSet rs){
		super(MTBase.getTable("CSCASEPK"), rs);
	}

	public CSCasePKDTO(Integer pk) {
		super(MTBase.getTable("CSCASEPK"), pk);
	}

	public CSCasePKDTO(String whereClause) {
		super(MTBase.getTable("CSCASEPK"), whereClause);
	}

	public java.lang.Integer getCsCaseId(){ 
		return (java.lang.Integer) get(MTTableCSCASEPK.CSCASEID);
	}

	public void setCsCaseId(java.lang.Integer csCaseId){ 
		set(MTTableCSCASEPK.CSCASEID, csCaseId);
	} 

	public void update() {
		super.update();
	}

	public CSCasePKDTO insert() {
		return (CSCasePKDTO) super.insert();
	}

	public static CSCasePKDTO find(String whereExpression) {
		try {
			return new CSCasePKDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}