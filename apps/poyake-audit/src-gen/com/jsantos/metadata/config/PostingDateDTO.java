package com.jsantos.metadata.config;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class PostingDateDTO extends DetachedRecord{

	public PostingDateDTO(){
		super(MTBase.getTable("POSTINGDATE"));
	}

	public PostingDateDTO(ResultSet rs){
		super(MTBase.getTable("POSTINGDATE"), rs);
	}

	public PostingDateDTO(Integer pk) {
		super(MTBase.getTable("POSTINGDATE"), pk);
	}

	public PostingDateDTO(String whereClause) {
		super(MTBase.getTable("POSTINGDATE"), whereClause);
	}

	public java.lang.Integer getPostingDateId(){ 
		return (java.lang.Integer) get(MTTablePOSTINGDATE.POSTINGDATEID);
	}

	public void setPostingDateId(java.lang.Integer postingDateId){ 
		set(MTTablePOSTINGDATE.POSTINGDATEID, postingDateId);
	} 

	public java.util.Date getPostingDate(){ 
		return (java.util.Date) get(MTTablePOSTINGDATE.POSTINGDATE);
	}

	public void setPostingDate(java.util.Date postingDate){ 
		set(MTTablePOSTINGDATE.POSTINGDATE, postingDate);
	} 

	public java.util.Date getLastUpdated(){ 
		return (java.util.Date) get(MTTablePOSTINGDATE.LASTUPDATED);
	}

	public void setLastUpdated(java.util.Date lastUpdated){ 
		set(MTTablePOSTINGDATE.LASTUPDATED, lastUpdated);
	} 

	public void update() {
		super.update();
	}

	public PostingDateDTO insert() {
		return (PostingDateDTO) super.insert();
	}

	public static PostingDateDTO find(String whereExpression) {
		try {
			return new PostingDateDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}