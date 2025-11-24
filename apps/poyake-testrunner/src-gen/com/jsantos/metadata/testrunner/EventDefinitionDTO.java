package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EventDefinitionDTO extends DetachedRecord{

	public EventDefinitionDTO(){
		super(MTBase.getTable("EVENTDEFINITION"));
	}

	public EventDefinitionDTO(ResultSet rs){
		super(MTBase.getTable("EVENTDEFINITION"), rs);
	}

	public EventDefinitionDTO(Integer pk) {
		super(MTBase.getTable("EVENTDEFINITION"), pk);
	}

	public EventDefinitionDTO(String whereClause) {
		super(MTBase.getTable("EVENTDEFINITION"), whereClause);
	}

	public java.lang.String getEventDefinitionUuid(){ 
		return (java.lang.String) get(MTTableEVENTDEFINITION.EVENTDEFINITIONUUID);
	}

	public void setEventDefinitionUuid(java.lang.String eventDefinitionUuid){ 
		set(MTTableEVENTDEFINITION.EVENTDEFINITIONUUID, eventDefinitionUuid);
	} 

	public java.lang.String getEventTypeId(){ 
		return (java.lang.String) get(MTTableEVENTDEFINITION.EVENTTYPEID);
	}

	public void setEventTypeId(java.lang.String eventTypeId){ 
		set(MTTableEVENTDEFINITION.EVENTTYPEID, eventTypeId);
	} 

	public java.lang.String getEventName(){ 
		return (java.lang.String) get(MTTableEVENTDEFINITION.EVENTNAME);
	}

	public void setEventName(java.lang.String eventName){ 
		set(MTTableEVENTDEFINITION.EVENTNAME, eventName);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableEVENTDEFINITION.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableEVENTDEFINITION.DESCRIPTION, description);
	} 

	public java.lang.Object getEventDefinition(){ 
		return (java.lang.Object) get(MTTableEVENTDEFINITION.EVENTDEFINITION);
	}

	public void setEventDefinition(java.lang.Object eventDefinition){ 
		set(MTTableEVENTDEFINITION.EVENTDEFINITION, eventDefinition);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableEVENTDEFINITION.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableEVENTDEFINITION.CREATED, created);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableEVENTDEFINITION.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableEVENTDEFINITION.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableEVENTDEFINITION.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableEVENTDEFINITION.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public EventDefinitionDTO insert() {
		return (EventDefinitionDTO) super.insert();
	}

	public static EventDefinitionDTO find(String whereExpression) {
		try {
			return new EventDefinitionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}