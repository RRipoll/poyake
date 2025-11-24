package com.jsantos.metadata;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class BookDTO extends DetachedRecord{

	public BookDTO(){
		super(MTBase.getTable("BOOK"));
	}

	public BookDTO(ResultSet rs){
		super(MTBase.getTable("BOOK"), rs);
	}

	public BookDTO(Integer pk) {
		super(MTBase.getTable("BOOK"), pk);
	}

	public BookDTO(String whereClause) {
		super(MTBase.getTable("BOOK"), whereClause);
	}

	public java.lang.Integer getBookId(){ 
		return (java.lang.Integer) get(MTTableBOOK.BOOKID);
	}

	public void setBookId(java.lang.Integer bookId){ 
		set(MTTableBOOK.BOOKID, bookId);
	} 

	public java.lang.String getTitle(){ 
		return (java.lang.String) get(MTTableBOOK.TITLE);
	}

	public void setTitle(java.lang.String title){ 
		set(MTTableBOOK.TITLE, title);
	} 

	public java.lang.Integer getAuthorId(){ 
		return (java.lang.Integer) get(MTTableBOOK.AUTHORID);
	}

	public void setAuthorId(java.lang.Integer authorId){ 
		set(MTTableBOOK.AUTHORID, authorId);
	} 

	public void update() {
		super.update();
	}

	public BookDTO insert() {
		return (BookDTO) super.insert();
	}

	public static BookDTO find(String whereExpression) {
		try {
			return new BookDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}