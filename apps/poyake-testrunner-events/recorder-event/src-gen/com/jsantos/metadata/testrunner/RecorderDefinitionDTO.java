package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class RecorderDefinitionDTO extends DetachedRecord{

	public RecorderDefinitionDTO(){
		super(MTBase.getTable("RECORDERDEFINITION"));
	}

	public RecorderDefinitionDTO(ResultSet rs){
		super(MTBase.getTable("RECORDERDEFINITION"), rs);
	}

	public RecorderDefinitionDTO(Integer pk) {
		super(MTBase.getTable("RECORDERDEFINITION"), pk);
	}

	public RecorderDefinitionDTO(String whereClause) {
		super(MTBase.getTable("RECORDERDEFINITION"), whereClause);
	}

	public java.lang.String getEventDefinitionUuid(){ 
		return (java.lang.String) get(MTTableRECORDERDEFINITION.EVENTDEFINITIONUUID);
	}

	public void setEventDefinitionUuid(java.lang.String eventDefinitionUuid){ 
		set(MTTableRECORDERDEFINITION.EVENTDEFINITIONUUID, eventDefinitionUuid);
	} 

	public java.lang.String getEventTypeId(){ 
		return (java.lang.String) get(MTTableRECORDERDEFINITION.EVENTTYPEID);
	}

	public void setEventTypeId(java.lang.String eventTypeId){ 
		set(MTTableRECORDERDEFINITION.EVENTTYPEID, eventTypeId);
	} 

	public java.lang.String getEventName(){ 
		return (java.lang.String) get(MTTableRECORDERDEFINITION.EVENTNAME);
	}

	public void setEventName(java.lang.String eventName){ 
		set(MTTableRECORDERDEFINITION.EVENTNAME, eventName);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableRECORDERDEFINITION.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableRECORDERDEFINITION.DESCRIPTION, description);
	} 

	public java.lang.Integer getSelected(){ 
		return (java.lang.Integer) get(MTTableRECORDERDEFINITION.SELECTED);
	}

	public void setSelected(java.lang.Integer selected){ 
		set(MTTableRECORDERDEFINITION.SELECTED, selected);
	} 

	public java.lang.Object getFiles(){ 
		return (java.lang.Object) get(MTTableRECORDERDEFINITION.FILES);
	}

	public void setFiles(java.lang.Object files){ 
		set(MTTableRECORDERDEFINITION.FILES, files);
	} 

	public void update() {
		super.update();
	}

	public RecorderDefinitionDTO insert() {
		return (RecorderDefinitionDTO) super.insert();
	}

	public static RecorderDefinitionDTO find(String whereExpression) {
		try {
			return new RecorderDefinitionDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}