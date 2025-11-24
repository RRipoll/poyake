package com.jsantos.metadata.example;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class VBookDTO extends DetachedRecord{

	public VBookDTO(){
		super(MTBase.getTable("VBOOK"));
	}

	public VBookDTO(ResultSet rs){
		super(MTBase.getTable("VBOOK"), rs);
	}

	public VBookDTO(Integer pk) {
		super(MTBase.getTable("VBOOK"), pk);
	}

	public VBookDTO(String whereClause) {
		super(MTBase.getTable("VBOOK"), whereClause);
	}

	public java.lang.Integer getBookId(){ 
		return (java.lang.Integer) get(MTTableVBOOK.BOOKID);
	}

	public void setBookId(java.lang.Integer bookId){ 
		set(MTTableVBOOK.BOOKID, bookId);
	} 

	public java.lang.String getTitle(){ 
		return (java.lang.String) get(MTTableVBOOK.TITLE);
	}

	public void setTitle(java.lang.String title){ 
		set(MTTableVBOOK.TITLE, title);
	} 

	public java.lang.Integer getAuthorId(){ 
		return (java.lang.Integer) get(MTTableVBOOK.AUTHORID);
	}

	public void setAuthorId(java.lang.Integer authorId){ 
		set(MTTableVBOOK.AUTHORID, authorId);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableVBOOK.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableVBOOK.DESCRIPTION, description);
	} 

	public java.lang.Integer getDoc(){ 
		return (java.lang.Integer) get(MTTableVBOOK.DOC);
	}

	public void setDoc(java.lang.Integer doc){ 
		set(MTTableVBOOK.DOC, doc);
	} 

	public java.lang.String getOtherAuthor(){ 
		return (java.lang.String) get(MTTableVBOOK.OTHERAUTHOR);
	}

	public void setOtherAuthor(java.lang.String otherAuthor){ 
		set(MTTableVBOOK.OTHERAUTHOR, otherAuthor);
	} 

	public void update() {
		super.update();
	}

	public VBookDTO insert() {
		return (VBookDTO) super.insert();
	}

	public static VBookDTO find(String whereExpression) {
		try {
			return new VBookDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}