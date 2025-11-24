package com.jsantos.metadata.general;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.metadata.MT;
import java.sql.ResultSet;

public class TemplateDTO extends DetachedRecord{

	public TemplateDTO(){
		super(MT.TEMPLATE);
	}

	public TemplateDTO(ResultSet rs){
		super(MT.TEMPLATE, rs);
	}

	public TemplateDTO(Integer pk) {
		super(MT.TEMPLATE,pk);
	}

	public TemplateDTO(String whereClause) {
		super(MT.TEMPLATE,whereClause);
	}

	public java.lang.Integer getTemplateId(){ 
		return (java.lang.Integer) get(MTTableTEMPLATE.TEMPLATEID);
	}

	public void setTemplateId(java.lang.Integer templateId){ 
		set(MTTableTEMPLATE.TEMPLATEID, templateId);
	} 

	public java.lang.Integer getEnuTemplateTypeId(){ 
		return (java.lang.Integer) get(MTTableTEMPLATE.ENUTEMPLATETYPEID);
	}

	public void setEnuTemplateTypeId(java.lang.Integer enuTemplateTypeId){ 
		set(MTTableTEMPLATE.ENUTEMPLATETYPEID, enuTemplateTypeId);
	} 

	public java.lang.Integer getEnuLocaleId(){ 
		return (java.lang.Integer) get(MTTableTEMPLATE.ENULOCALEID);
	}

	public void setEnuLocaleId(java.lang.Integer enuLocaleId){ 
		set(MTTableTEMPLATE.ENULOCALEID, enuLocaleId);
	} 

	public java.sql.Date getPostingDate(){ 
		return (java.sql.Date) get(MTTableTEMPLATE.POSTINGDATE);
	}

	public void setPostingDate(java.sql.Date postingDate){ 
		set(MTTableTEMPLATE.POSTINGDATE, postingDate);
	} 

	public java.lang.String getBody(){ 
		return (java.lang.String) get(MTTableTEMPLATE.BODY);
	}

	public void setBody(java.lang.String body){ 
		set(MTTableTEMPLATE.BODY, body);
	} 

	public void update() {
		super.update();
	}

	public TemplateDTO insert() {
		return (TemplateDTO) super.insert();
	}

	public static TemplateDTO find(String whereExpression) {
		try {
			return new TemplateDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}