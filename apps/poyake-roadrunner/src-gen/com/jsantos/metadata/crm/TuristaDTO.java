package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class TuristaDTO extends DetachedRecord{

	public TuristaDTO(){
		super(MTBase.getTable("TURISTA"));
	}

	public TuristaDTO(ResultSet rs){
		super(MTBase.getTable("TURISTA"), rs);
	}

	public TuristaDTO(Integer pk) {
		super(MTBase.getTable("TURISTA"), pk);
	}

	public TuristaDTO(String whereClause) {
		super(MTBase.getTable("TURISTA"), whereClause);
	}

	public java.lang.Integer getTuristaId(){ 
		return (java.lang.Integer) get(MTTableTURISTA.TURISTAID);
	}

	public void setTuristaId(java.lang.Integer turistaId){ 
		set(MTTableTURISTA.TURISTAID, turistaId);
	} 

	public java.lang.Integer getCountryId(){ 
		return (java.lang.Integer) get(MTTableTURISTA.COUNTRYID);
	}

	public void setCountryId(java.lang.Integer countryId){ 
		set(MTTableTURISTA.COUNTRYID, countryId);
	} 

	public void update() {
		super.update();
	}

	public TuristaDTO insert() {
		return (TuristaDTO) super.insert();
	}

	public static TuristaDTO find(String whereExpression) {
		try {
			return new TuristaDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}