package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class RunTestEventDefinitionDTO extends DetachedRecord{

	public RunTestEventDefinitionDTO(){
		super(MTBase.getTable("RUNTESTEVENTDEFINITION"));
	}

	public RunTestEventDefinitionDTO(ResultSet rs){
		super(MTBase.getTable("RUNTESTEVENTDEFINITION"), rs);
	}

	public RunTestEventDefinitionDTO(Integer pk) {
		super(MTBase.getTable("RUNTESTEVENTDEFINITION"), pk);
	}

	public RunTestEventDefinitionDTO(String whereClause) {
		super(MTBase.getTable("RUNTESTEVENTDEFINITION"), whereClause);
	}

	public java.lang.String getEventDefinitionUuid(){ 
		return (java.lang.String) get(MTTableRUNTESTEVENTDEFINITION.EVENTDEFINITIONUUID);
	}

	public void setEventDefinitionUuid(java.lang.String eventDefinitionUuid){ 
		set(MTTableRUNTESTEVENTDEFINITION.EVENTDEFINITIONUUID, eventDefinitionUuid);
	} 

	public java.lang.String getEventTypeId(){ 
		return (java.lang.String) get(MTTableRUNTESTEVENTDEFINITION.EVENTTYPEID);
	}

	public void setEventTypeId(java.lang.String eventTypeId){ 
		set(MTTableRUNTESTEVENTDEFINITION.EVENTTYPEID, eventTypeId);
	} 

	public java.lang.String getEventName(){ 
		return (java.lang.String) get(MTTableRUNTESTEVENTDEFINITION.EVENTNAME);
	}

	public void setEventName(java.lang.String eventName){ 
		set(MTTableRUNTESTEVENTDEFINITION.EVENTNAME, eventName);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableRUNTESTEVENTDEFINITION.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableRUNTESTEVENTDEFINITION.DESCRIPTION, description);
	} 

	public java.lang.Integer getSelected(){ 
		return (java.lang.Integer) get(MTTableRUNTESTEVENTDEFINITION.SELECTED);
	}

	public void setSelected(java.lang.Integer selected){ 
		set(MTTableRUNTESTEVENTDEFINITION.SELECTED, selected);
	} 

	public java.lang.String getTestId(){ 
		return (java.lang.String) get(MTTableRUNTESTEVENTDEFINITION.TESTID);
	}

	public void setTestId(java.lang.String testId){ 
		set(MTTableRUNTESTEVENTDEFINITION.TESTID, testId);
	} 

	public java.lang.Integer getRepetitionNumber(){ 
		return (java.lang.Integer) get(MTTableRUNTESTEVENTDEFINITION.REPETITIONNUMBER);
	}

	public void setRepetitionNumber(java.lang.Integer repetitionNumber){ 
		set(MTTableRUNTESTEVENTDEFINITION.REPETITIONNUMBER, repetitionNumber);
	} 

	public void update() {
		super.update();
	}

	public RunTestEventDefinitionDTO insert() {
		return (RunTestEventDefinitionDTO) super.insert();
	}

	public static RunTestEventDefinitionDTO find(String whereExpression) {
		try {
			return new RunTestEventDefinitionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}