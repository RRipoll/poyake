package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class StoreValuesEventDTO extends DetachedRecord{

	public StoreValuesEventDTO(){
		super(MTBase.getTable("STOREVALUESEVENT"));
	}

	public StoreValuesEventDTO(ResultSet rs){
		super(MTBase.getTable("STOREVALUESEVENT"), rs);
	}

	public StoreValuesEventDTO(Integer pk) {
		super(MTBase.getTable("STOREVALUESEVENT"), pk);
	}

	public StoreValuesEventDTO(String whereClause) {
		super(MTBase.getTable("STOREVALUESEVENT"), whereClause);
	}

	public java.lang.String getStoreValuesEventid(){ 
		return (java.lang.String) get(MTTableSTOREVALUESEVENT.STOREVALUESEVENTID);
	}

	public void setStoreValuesEventid(java.lang.String storeValuesEventid){ 
		set(MTTableSTOREVALUESEVENT.STOREVALUESEVENTID, storeValuesEventid);
	} 

	public java.lang.String getEventName(){ 
		return (java.lang.String) get(MTTableSTOREVALUESEVENT.EVENTNAME);
	}

	public void setEventName(java.lang.String eventName){ 
		set(MTTableSTOREVALUESEVENT.EVENTNAME, eventName);
	} 

	public java.lang.String getData(){ 
		return (java.lang.String) get(MTTableSTOREVALUESEVENT.DATA);
	}

	public void setData(java.lang.String data){ 
		set(MTTableSTOREVALUESEVENT.DATA, data);
	} 

	public java.lang.String getLog(){ 
		return (java.lang.String) get(MTTableSTOREVALUESEVENT.LOG);
	}

	public void setLog(java.lang.String log){ 
		set(MTTableSTOREVALUESEVENT.LOG, log);
	} 

	public java.lang.Integer getStatus(){ 
		return (java.lang.Integer) get(MTTableSTOREVALUESEVENT.STATUS);
	}

	public void setStatus(java.lang.Integer status){ 
		set(MTTableSTOREVALUESEVENT.STATUS, status);
	} 

	public java.lang.Object getEvent(){ 
		return (java.lang.Object) get(MTTableSTOREVALUESEVENT.EVENT);
	}

	public void setEvent(java.lang.Object event){ 
		set(MTTableSTOREVALUESEVENT.EVENT, event);
	} 

	public void update() {
		super.update();
	}

	public StoreValuesEventDTO insert() {
		return (StoreValuesEventDTO) super.insert();
	}

	public static StoreValuesEventDTO find(String whereExpression) {
		try {
			return new StoreValuesEventDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}