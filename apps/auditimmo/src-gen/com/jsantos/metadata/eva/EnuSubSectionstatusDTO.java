package com.jsantos.metadata.eva;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.ResultSet;

public class EnuSubSectionstatusDTO extends DetachedRecord{

	public EnuSubSectionstatusDTO(){
		super(MT.ENUSUBSECTIONSTATUS);
	}

	public EnuSubSectionstatusDTO(ResultSet rs){
		super(MT.ENUSUBSECTIONSTATUS, rs);
	}

	public EnuSubSectionstatusDTO(Integer pk) {
		super(MT.ENUSUBSECTIONSTATUS,pk);
	}

	public EnuSubSectionstatusDTO(String whereClause) {
		super(MT.ENUSUBSECTIONSTATUS,whereClause);
	}

	public java.lang.Integer getSubSectionStatusId(){ 
		return (java.lang.Integer) get(MTTableENUSUBSECTIONSTATUS.SUBSECTIONSTATUSID);
	}

	public void setSubSectionStatusId(java.lang.Integer subSectionStatusId){ 
		set(MTTableENUSUBSECTIONSTATUS.SUBSECTIONSTATUSID, subSectionStatusId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableENUSUBSECTIONSTATUS.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableENUSUBSECTIONSTATUS.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableENUSUBSECTIONSTATUS.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableENUSUBSECTIONSTATUS.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EnuSubSectionstatusDTO insert() {
		return (EnuSubSectionstatusDTO) super.insert();
	}

	public static EnuSubSectionstatusDTO find(String whereExpression) {
		try {
			return new EnuSubSectionstatusDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}