package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EventParameterDTO extends DetachedRecord{

	public EventParameterDTO(){
		super(MTBase.getTable("EVENTPARAMETER"));
	}

	public EventParameterDTO(ResultSet rs){
		super(MTBase.getTable("EVENTPARAMETER"), rs);
	}

	public EventParameterDTO(Integer pk) {
		super(MTBase.getTable("EVENTPARAMETER"), pk);
	}

	public EventParameterDTO(String whereClause) {
		super(MTBase.getTable("EVENTPARAMETER"), whereClause);
	}

	public java.lang.String getEventTypeId(){ 
		return (java.lang.String) get(MTTableEVENTPARAMETER.EVENTTYPEID);
	}

	public void setEventTypeId(java.lang.String eventTypeId){ 
		set(MTTableEVENTPARAMETER.EVENTTYPEID, eventTypeId);
	} 

	public java.lang.String getEventName(){ 
		return (java.lang.String) get(MTTableEVENTPARAMETER.EVENTNAME);
	}

	public void setEventName(java.lang.String eventName){ 
		set(MTTableEVENTPARAMETER.EVENTNAME, eventName);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableEVENTPARAMETER.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableEVENTPARAMETER.DESCRIPTION, description);
	} 

	public java.lang.Integer getSelected(){ 
		return (java.lang.Integer) get(MTTableEVENTPARAMETER.SELECTED);
	}

	public void setSelected(java.lang.Integer selected){ 
		set(MTTableEVENTPARAMETER.SELECTED, selected);
	} 

	public void update() {
		super.update();
	}

	public EventParameterDTO insert() {
		return (EventParameterDTO) super.insert();
	}

	public static EventParameterDTO find(String whereExpression) {
		try {
			return new EventParameterDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}