package com.jsantos.metadata.example;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class GenreDTO extends DetachedRecord{

	public GenreDTO(){
		super(MTBase.getTable("GENRE"));
	}

	public GenreDTO(ResultSet rs){
		super(MTBase.getTable("GENRE"), rs);
	}

	public GenreDTO(Integer pk) {
		super(MTBase.getTable("GENRE"), pk);
	}

	public GenreDTO(String whereClause) {
		super(MTBase.getTable("GENRE"), whereClause);
	}

	public java.lang.Integer getGenreId(){ 
		return (java.lang.Integer) get(MTTableGENRE.GENREID);
	}

	public void setGenreId(java.lang.Integer genreId){ 
		set(MTTableGENRE.GENREID, genreId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableGENRE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableGENRE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableGENRE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableGENRE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public GenreDTO insert() {
		return (GenreDTO) super.insert();
	}

	public static GenreDTO find(String whereExpression) {
		try {
			return new GenreDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}