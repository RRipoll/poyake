package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class CheckParamEventDefinitionDTO extends DetachedRecord{

	public CheckParamEventDefinitionDTO(){
		super(MTBase.getTable("CHECKPARAMEVENTDEFINITION"));
	}

	public CheckParamEventDefinitionDTO(ResultSet rs){
		super(MTBase.getTable("CHECKPARAMEVENTDEFINITION"), rs);
	}

	public CheckParamEventDefinitionDTO(Integer pk) {
		super(MTBase.getTable("CHECKPARAMEVENTDEFINITION"), pk);
	}

	public CheckParamEventDefinitionDTO(String whereClause) {
		super(MTBase.getTable("CHECKPARAMEVENTDEFINITION"), whereClause);
	}

	public java.lang.String getEventDefinitionUuid(){ 
		return (java.lang.String) get(MTTableCHECKPARAMEVENTDEFINITION.EVENTDEFINITIONUUID);
	}

	public void setEventDefinitionUuid(java.lang.String eventDefinitionUuid){ 
		set(MTTableCHECKPARAMEVENTDEFINITION.EVENTDEFINITIONUUID, eventDefinitionUuid);
	} 

	public java.lang.String getEventTypeId(){ 
		return (java.lang.String) get(MTTableCHECKPARAMEVENTDEFINITION.EVENTTYPEID);
	}

	public void setEventTypeId(java.lang.String eventTypeId){ 
		set(MTTableCHECKPARAMEVENTDEFINITION.EVENTTYPEID, eventTypeId);
	} 

	public java.lang.String getEventName(){ 
		return (java.lang.String) get(MTTableCHECKPARAMEVENTDEFINITION.EVENTNAME);
	}

	public void setEventName(java.lang.String eventName){ 
		set(MTTableCHECKPARAMEVENTDEFINITION.EVENTNAME, eventName);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableCHECKPARAMEVENTDEFINITION.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableCHECKPARAMEVENTDEFINITION.DESCRIPTION, description);
	} 

	public java.lang.Integer getSelected(){ 
		return (java.lang.Integer) get(MTTableCHECKPARAMEVENTDEFINITION.SELECTED);
	}

	public void setSelected(java.lang.Integer selected){ 
		set(MTTableCHECKPARAMEVENTDEFINITION.SELECTED, selected);
	} 

	public java.lang.Object getParameters(){ 
		return (java.lang.Object) get(MTTableCHECKPARAMEVENTDEFINITION.PARAMETERS);
	}

	public void setParameters(java.lang.Object parameters){ 
		set(MTTableCHECKPARAMEVENTDEFINITION.PARAMETERS, parameters);
	} 

	public void update() {
		super.update();
	}

	public CheckParamEventDefinitionDTO insert() {
		return (CheckParamEventDefinitionDTO) super.insert();
	}

	public static CheckParamEventDefinitionDTO find(String whereExpression) {
		try {
			return new CheckParamEventDefinitionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}