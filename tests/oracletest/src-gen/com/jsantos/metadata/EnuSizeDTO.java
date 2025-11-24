package com.jsantos.metadata;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.SQLException;

public class EnuSizeDTO{
	DetachedRecord dr;

	public EnuSizeDTO(){
		dr = new DetachedRecord(MT.ENUSIZE);
	}

	public EnuSizeDTO(Integer pk) throws SQLException{
		dr = new DetachedRecord(MT.ENUSIZE,pk);
	}

	public java.lang.Integer getSizeId(){ 
		return (java.lang.Integer) dr.get(MTTableENUSIZE.SIZEID);
	}

	public void setSizeId(java.lang.Integer sizeId){ 
		dr.set(MTTableENUSIZE.SIZEID, sizeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) dr.get(MTTableENUSIZE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		dr.set(MTTableENUSIZE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescripion(){ 
		return (java.lang.String) dr.get(MTTableENUSIZE.DESCRIPION);
	}

	public void setDescripion(java.lang.String descripion){ 
		dr.set(MTTableENUSIZE.DESCRIPION, descripion);
	} 

	public void update() {
		dr.update();
	}

	public void insert() {
		dr.insert();
	}
}