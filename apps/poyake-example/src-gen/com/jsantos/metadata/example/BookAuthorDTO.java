package com.jsantos.metadata.example;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class BookAuthorDTO extends DetachedRecord{

	public BookAuthorDTO(){
		super(MTBase.getTable("BOOKAUTHOR"));
	}

	public BookAuthorDTO(ResultSet rs){
		super(MTBase.getTable("BOOKAUTHOR"), rs);
	}

	public BookAuthorDTO(Integer pk) {
		super(MTBase.getTable("BOOKAUTHOR"), pk);
	}

	public BookAuthorDTO(String whereClause) {
		super(MTBase.getTable("BOOKAUTHOR"), whereClause);
	}

	public java.lang.Integer getBookAuthorId(){ 
		return (java.lang.Integer) get(MTTableBOOKAUTHOR.BOOKAUTHORID);
	}

	public void setBookAuthorId(java.lang.Integer bookAuthorId){ 
		set(MTTableBOOKAUTHOR.BOOKAUTHORID, bookAuthorId);
	} 

	public java.lang.Integer getBookId(){ 
		return (java.lang.Integer) get(MTTableBOOKAUTHOR.BOOKID);
	}

	public void setBookId(java.lang.Integer bookId){ 
		set(MTTableBOOKAUTHOR.BOOKID, bookId);
	} 

	public java.lang.Integer getAuthorId(){ 
		return (java.lang.Integer) get(MTTableBOOKAUTHOR.AUTHORID);
	}

	public void setAuthorId(java.lang.Integer authorId){ 
		set(MTTableBOOKAUTHOR.AUTHORID, authorId);
	} 

	public void update() {
		super.update();
	}

	public BookAuthorDTO insert() {
		return (BookAuthorDTO) super.insert();
	}

	public static BookAuthorDTO find(String whereExpression) {
		try {
			return new BookAuthorDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}