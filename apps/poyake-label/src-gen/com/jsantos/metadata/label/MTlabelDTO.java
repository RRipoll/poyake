package com.jsantos.metadata.label;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class MTlabelDTO extends DetachedRecord{

	public MTlabelDTO(){
		super(MTBase.getTable("MTLABEL"));
	}

	public MTlabelDTO(ResultSet rs){
		super(MTBase.getTable("MTLABEL"), rs);
	}

	public MTlabelDTO(Integer pk) {
		super(MTBase.getTable("MTLABEL"), pk);
	}

	public MTlabelDTO(String whereClause) {
		super(MTBase.getTable("MTLABEL"), whereClause);
	}

	public java.lang.String getMtLabelId(){ 
		return (java.lang.String) get(MTTableMTLABEL.MTLABELID);
	}

	public void setMtLabelId(java.lang.String mtLabelId){ 
		set(MTTableMTLABEL.MTLABELID, mtLabelId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableMTLABEL.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableMTLABEL.SHORTCODE, shortCode);
	} 

	public java.lang.String getScreen(){ 
		return (java.lang.String) get(MTTableMTLABEL.SCREEN);
	}

	public void setScreen(java.lang.String screen){ 
		set(MTTableMTLABEL.SCREEN, screen);
	} 

	public java.lang.String getEn_US(){ 
		return (java.lang.String) get(MTTableMTLABEL.EN_US);
	}

	public void setEn_US(java.lang.String en_US){ 
		set(MTTableMTLABEL.EN_US, en_US);
	} 

	public java.lang.String getEs_ES(){ 
		return (java.lang.String) get(MTTableMTLABEL.ES_ES);
	}

	public void setEs_ES(java.lang.String es_ES){ 
		set(MTTableMTLABEL.ES_ES, es_ES);
	} 

	public void update() {
		super.update();
	}

	public MTlabelDTO insert() {
		return (MTlabelDTO) super.insert();
	}

	public static MTlabelDTO find(String whereExpression) {
		try {
			return new MTlabelDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}