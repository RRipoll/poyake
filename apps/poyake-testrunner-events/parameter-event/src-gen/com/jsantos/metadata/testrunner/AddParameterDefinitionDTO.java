package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class AddParameterDefinitionDTO extends DetachedRecord{

	public AddParameterDefinitionDTO(){
		super(MTBase.getTable("ADDPARAMETERDEFINITION"));
	}

	public AddParameterDefinitionDTO(ResultSet rs){
		super(MTBase.getTable("ADDPARAMETERDEFINITION"), rs);
	}

	public AddParameterDefinitionDTO(Integer pk) {
		super(MTBase.getTable("ADDPARAMETERDEFINITION"), pk);
	}

	public AddParameterDefinitionDTO(String whereClause) {
		super(MTBase.getTable("ADDPARAMETERDEFINITION"), whereClause);
	}

	public java.lang.String getEventDefinitionUuid(){ 
		return (java.lang.String) get(MTTableADDPARAMETERDEFINITION.EVENTDEFINITIONUUID);
	}

	public void setEventDefinitionUuid(java.lang.String eventDefinitionUuid){ 
		set(MTTableADDPARAMETERDEFINITION.EVENTDEFINITIONUUID, eventDefinitionUuid);
	} 

	public java.lang.String getEventTypeId(){ 
		return (java.lang.String) get(MTTableADDPARAMETERDEFINITION.EVENTTYPEID);
	}

	public void setEventTypeId(java.lang.String eventTypeId){ 
		set(MTTableADDPARAMETERDEFINITION.EVENTTYPEID, eventTypeId);
	} 

	public java.lang.String getEventName(){ 
		return (java.lang.String) get(MTTableADDPARAMETERDEFINITION.EVENTNAME);
	}

	public void setEventName(java.lang.String eventName){ 
		set(MTTableADDPARAMETERDEFINITION.EVENTNAME, eventName);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableADDPARAMETERDEFINITION.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableADDPARAMETERDEFINITION.DESCRIPTION, description);
	} 

	public java.lang.Integer getSelected(){ 
		return (java.lang.Integer) get(MTTableADDPARAMETERDEFINITION.SELECTED);
	}

	public void setSelected(java.lang.Integer selected){ 
		set(MTTableADDPARAMETERDEFINITION.SELECTED, selected);
	} 

	public java.lang.Object getParameters(){ 
		return (java.lang.Object) get(MTTableADDPARAMETERDEFINITION.PARAMETERS);
	}

	public void setParameters(java.lang.Object parameters){ 
		set(MTTableADDPARAMETERDEFINITION.PARAMETERS, parameters);
	} 

	public void update() {
		super.update();
	}

	public AddParameterDefinitionDTO insert() {
		return (AddParameterDefinitionDTO) super.insert();
	}

	public static AddParameterDefinitionDTO find(String whereExpression) {
		try {
			return new AddParameterDefinitionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}