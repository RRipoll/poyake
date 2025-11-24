package com.jsantos.metadata.example;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class AuthorDTO extends DetachedRecord{

	public AuthorDTO(){
		super(MTBase.getTable("AUTHOR"));
	}

	public AuthorDTO(ResultSet rs){
		super(MTBase.getTable("AUTHOR"), rs);
	}

	public AuthorDTO(Integer pk) {
		super(MTBase.getTable("AUTHOR"), pk);
	}

	public AuthorDTO(String whereClause) {
		super(MTBase.getTable("AUTHOR"), whereClause);
	}

	public java.lang.Integer getAuthorId(){ 
		return (java.lang.Integer) get(MTTableAUTHOR.AUTHORID);
	}

	public void setAuthorId(java.lang.Integer authorId){ 
		set(MTTableAUTHOR.AUTHORID, authorId);
	} 

	public java.lang.String getFullName(){ 
		return (java.lang.String) get(MTTableAUTHOR.FULLNAME);
	}

	public void setFullName(java.lang.String fullName){ 
		set(MTTableAUTHOR.FULLNAME, fullName);
	} 

	public java.lang.String getNote(){ 
		return (java.lang.String) get(MTTableAUTHOR.NOTE);
	}

	public void setNote(java.lang.String note){ 
		set(MTTableAUTHOR.NOTE, note);
	} 

	public void update() {
		super.update();
	}

	public AuthorDTO insert() {
		return (AuthorDTO) super.insert();
	}

	public static AuthorDTO find(String whereExpression) {
		try {
			return new AuthorDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}