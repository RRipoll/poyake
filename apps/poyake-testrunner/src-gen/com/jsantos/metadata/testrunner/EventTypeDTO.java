package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EventTypeDTO extends DetachedRecord{

	public EventTypeDTO(){
		super(MTBase.getTable("EVENTTYPE"));
	}

	public EventTypeDTO(ResultSet rs){
		super(MTBase.getTable("EVENTTYPE"), rs);
	}

	public EventTypeDTO(Integer pk) {
		super(MTBase.getTable("EVENTTYPE"), pk);
	}

	public EventTypeDTO(String whereClause) {
		super(MTBase.getTable("EVENTTYPE"), whereClause);
	}

	public java.lang.String getEventTypeId(){ 
		return (java.lang.String) get(MTTableEVENTTYPE.EVENTTYPEID);
	}

	public void setEventTypeId(java.lang.String eventTypeId){ 
		set(MTTableEVENTTYPE.EVENTTYPEID, eventTypeId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableEVENTTYPE.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableEVENTTYPE.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableEVENTTYPE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableEVENTTYPE.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public EventTypeDTO insert() {
		return (EventTypeDTO) super.insert();
	}

	public static EventTypeDTO find(String whereExpression) {
		try {
			return new EventTypeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}