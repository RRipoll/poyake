package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EventStatusDTO extends DetachedRecord{

	public EventStatusDTO(){
		super(MTBase.getTable("EVENTSTATUS"));
	}

	public EventStatusDTO(ResultSet rs){
		super(MTBase.getTable("EVENTSTATUS"), rs);
	}

	public EventStatusDTO(Integer pk) {
		super(MTBase.getTable("EVENTSTATUS"), pk);
	}

	public EventStatusDTO(String whereClause) {
		super(MTBase.getTable("EVENTSTATUS"), whereClause);
	}

	public java.lang.Integer getEventStatusId(){ 
		return (java.lang.Integer) get(MTTableEVENTSTATUS.EVENTSTATUSID);
	}

	public void setEventStatusId(java.lang.Integer eventStatusId){ 
		set(MTTableEVENTSTATUS.EVENTSTATUSID, eventStatusId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableEVENTSTATUS.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableEVENTSTATUS.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableEVENTSTATUS.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableEVENTSTATUS.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EventStatusDTO insert() {
		return (EventStatusDTO) super.insert();
	}

	public static EventStatusDTO find(String whereExpression) {
		try {
			return new EventStatusDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}