package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class RestEventDefinitionDTO extends DetachedRecord{

	public RestEventDefinitionDTO(){
		super(MTBase.getTable("RESTEVENTDEFINITION"));
	}

	public RestEventDefinitionDTO(ResultSet rs){
		super(MTBase.getTable("RESTEVENTDEFINITION"), rs);
	}

	public RestEventDefinitionDTO(Integer pk) {
		super(MTBase.getTable("RESTEVENTDEFINITION"), pk);
	}

	public RestEventDefinitionDTO(String whereClause) {
		super(MTBase.getTable("RESTEVENTDEFINITION"), whereClause);
	}

	public java.lang.String getEventDefinitionUuid(){ 
		return (java.lang.String) get(MTTableRESTEVENTDEFINITION.EVENTDEFINITIONUUID);
	}

	public void setEventDefinitionUuid(java.lang.String eventDefinitionUuid){ 
		set(MTTableRESTEVENTDEFINITION.EVENTDEFINITIONUUID, eventDefinitionUuid);
	} 

	public java.lang.String getEventTypeId(){ 
		return (java.lang.String) get(MTTableRESTEVENTDEFINITION.EVENTTYPEID);
	}

	public void setEventTypeId(java.lang.String eventTypeId){ 
		set(MTTableRESTEVENTDEFINITION.EVENTTYPEID, eventTypeId);
	} 

	public java.lang.String getEventName(){ 
		return (java.lang.String) get(MTTableRESTEVENTDEFINITION.EVENTNAME);
	}

	public void setEventName(java.lang.String eventName){ 
		set(MTTableRESTEVENTDEFINITION.EVENTNAME, eventName);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableRESTEVENTDEFINITION.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableRESTEVENTDEFINITION.DESCRIPTION, description);
	} 

	public java.lang.Integer getSelected(){ 
		return (java.lang.Integer) get(MTTableRESTEVENTDEFINITION.SELECTED);
	}

	public void setSelected(java.lang.Integer selected){ 
		set(MTTableRESTEVENTDEFINITION.SELECTED, selected);
	} 

	public java.lang.String getUrl(){ 
		return (java.lang.String) get(MTTableRESTEVENTDEFINITION.URL);
	}

	public void setUrl(java.lang.String url){ 
		set(MTTableRESTEVENTDEFINITION.URL, url);
	} 

	public java.lang.Integer getHttpMethod(){ 
		return (java.lang.Integer) get(MTTableRESTEVENTDEFINITION.HTTPMETHOD);
	}

	public void setHttpMethod(java.lang.Integer httpMethod){ 
		set(MTTableRESTEVENTDEFINITION.HTTPMETHOD, httpMethod);
	} 

	public java.lang.Object getParameters(){ 
		return (java.lang.Object) get(MTTableRESTEVENTDEFINITION.PARAMETERS);
	}

	public void setParameters(java.lang.Object parameters){ 
		set(MTTableRESTEVENTDEFINITION.PARAMETERS, parameters);
	} 

	public java.lang.String getJson(){ 
		return (java.lang.String) get(MTTableRESTEVENTDEFINITION.JSON);
	}

	public void setJson(java.lang.String json){ 
		set(MTTableRESTEVENTDEFINITION.JSON, json);
	} 

	public void update() {
		super.update();
	}

	public RestEventDefinitionDTO insert() {
		return (RestEventDefinitionDTO) super.insert();
	}

	public static RestEventDefinitionDTO find(String whereExpression) {
		try {
			return new RestEventDefinitionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}