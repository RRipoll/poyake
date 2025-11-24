package com.jsantos.metadata.common;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class TemplateDTO extends DetachedRecord{

	public TemplateDTO(){
		super(MTBase.getTable("TEMPLATE"));
	}

	public TemplateDTO(ResultSet rs){
		super(MTBase.getTable("TEMPLATE"), rs);
	}

	public TemplateDTO(Integer pk) {
		super(MTBase.getTable("TEMPLATE"), pk);
	}

	public TemplateDTO(String whereClause) {
		super(MTBase.getTable("TEMPLATE"), whereClause);
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

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableTEMPLATE.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableTEMPLATE.CREATED, created);
	} 

	public java.lang.String getBody(){ 
		return (java.lang.String) get(MTTableTEMPLATE.BODY);
	}

	public void setBody(java.lang.String body){ 
		set(MTTableTEMPLATE.BODY, body);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableTEMPLATE.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableTEMPLATE.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableTEMPLATE.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableTEMPLATE.INPUTSOURCEID, inputSourceId);
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