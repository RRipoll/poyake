package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class PersonOrCompanyPkDTO extends DetachedRecord{

	public PersonOrCompanyPkDTO(){
		super(MTBase.getTable("PERSONORCOMPANYPK"));
	}

	public PersonOrCompanyPkDTO(ResultSet rs){
		super(MTBase.getTable("PERSONORCOMPANYPK"), rs);
	}

	public PersonOrCompanyPkDTO(Integer pk) {
		super(MTBase.getTable("PERSONORCOMPANYPK"), pk);
	}

	public PersonOrCompanyPkDTO(String whereClause) {
		super(MTBase.getTable("PERSONORCOMPANYPK"), whereClause);
	}

	public java.lang.Integer getPersonOrCompanyId(){ 
		return (java.lang.Integer) get(MTTablePERSONORCOMPANYPK.PERSONORCOMPANYID);
	}

	public void setPersonOrCompanyId(java.lang.Integer personOrCompanyId){ 
		set(MTTablePERSONORCOMPANYPK.PERSONORCOMPANYID, personOrCompanyId);
	} 

	public void update() {
		super.update();
	}

	public PersonOrCompanyPkDTO insert() {
		return (PersonOrCompanyPkDTO) super.insert();
	}

	public static PersonOrCompanyPkDTO find(String whereExpression) {
		try {
			return new PersonOrCompanyPkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}