package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EventDefFolderDTO extends DetachedRecord{

	public EventDefFolderDTO(){
		super(MTBase.getTable("EVENTDEFFOLDER"));
	}

	public EventDefFolderDTO(ResultSet rs){
		super(MTBase.getTable("EVENTDEFFOLDER"), rs);
	}

	public EventDefFolderDTO(Integer pk) {
		super(MTBase.getTable("EVENTDEFFOLDER"), pk);
	}

	public EventDefFolderDTO(String whereClause) {
		super(MTBase.getTable("EVENTDEFFOLDER"), whereClause);
	}

	public java.lang.String getEventdeffolderUuid(){ 
		return (java.lang.String) get(MTTableEVENTDEFFOLDER.EVENTDEFFOLDERUUID);
	}

	public void setEventdeffolderUuid(java.lang.String eventdeffolderUuid){ 
		set(MTTableEVENTDEFFOLDER.EVENTDEFFOLDERUUID, eventdeffolderUuid);
	} 

	public java.lang.String getParentfolderUuid(){ 
		return (java.lang.String) get(MTTableEVENTDEFFOLDER.PARENTFOLDERUUID);
	}

	public void setParentfolderUuid(java.lang.String parentfolderUuid){ 
		set(MTTableEVENTDEFFOLDER.PARENTFOLDERUUID, parentfolderUuid);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableEVENTDEFFOLDER.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableEVENTDEFFOLDER.DESCRIPTION, description);
	} 

	public java.lang.String getEventDefinitionUuid(){ 
		return (java.lang.String) get(MTTableEVENTDEFFOLDER.EVENTDEFINITIONUUID);
	}

	public void setEventDefinitionUuid(java.lang.String eventDefinitionUuid){ 
		set(MTTableEVENTDEFFOLDER.EVENTDEFINITIONUUID, eventDefinitionUuid);
	} 

	public void update() {
		super.update();
	}

	public EventDefFolderDTO insert() {
		return (EventDefFolderDTO) super.insert();
	}

	public static EventDefFolderDTO find(String whereExpression) {
		try {
			return new EventDefFolderDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}