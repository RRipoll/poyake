package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class StoreValuesTestDTO extends DetachedRecord{

	public StoreValuesTestDTO(){
		super(MTBase.getTable("STOREVALUESTEST"));
	}

	public StoreValuesTestDTO(ResultSet rs){
		super(MTBase.getTable("STOREVALUESTEST"), rs);
	}

	public StoreValuesTestDTO(Integer pk) {
		super(MTBase.getTable("STOREVALUESTEST"), pk);
	}

	public StoreValuesTestDTO(String whereClause) {
		super(MTBase.getTable("STOREVALUESTEST"), whereClause);
	}

	public java.lang.Integer getStoreValuestestId(){ 
		return (java.lang.Integer) get(MTTableSTOREVALUESTEST.STOREVALUESTESTID);
	}

	public void setStoreValuestestId(java.lang.Integer storeValuestestId){ 
		set(MTTableSTOREVALUESTEST.STOREVALUESTESTID, storeValuestestId);
	} 

	public java.lang.String getTestRunner_Api_Url(){ 
		return (java.lang.String) get(MTTableSTOREVALUESTEST.TESTRUNNER_API_URL);
	}

	public void setTestRunner_Api_Url(java.lang.String testRunner_Api_Url){ 
		set(MTTableSTOREVALUESTEST.TESTRUNNER_API_URL, testRunner_Api_Url);
	} 

	public java.lang.String getApp_Api_Url(){ 
		return (java.lang.String) get(MTTableSTOREVALUESTEST.APP_API_URL);
	}

	public void setApp_Api_Url(java.lang.String app_Api_Url){ 
		set(MTTableSTOREVALUESTEST.APP_API_URL, app_Api_Url);
	} 

	public java.lang.String getJob_Api_Url(){ 
		return (java.lang.String) get(MTTableSTOREVALUESTEST.JOB_API_URL);
	}

	public void setJob_Api_Url(java.lang.String job_Api_Url){ 
		set(MTTableSTOREVALUESTEST.JOB_API_URL, job_Api_Url);
	} 

	public java.lang.Object getStoreValuesEvents(){ 
		return (java.lang.Object) get(MTTableSTOREVALUESTEST.STOREVALUESEVENTS);
	}

	public void setStoreValuesEvents(java.lang.Object storeValuesEvents){ 
		set(MTTableSTOREVALUESTEST.STOREVALUESEVENTS, storeValuesEvents);
	} 

	public void update() {
		super.update();
	}

	public StoreValuesTestDTO insert() {
		return (StoreValuesTestDTO) super.insert();
	}

	public static StoreValuesTestDTO find(String whereExpression) {
		try {
			return new StoreValuesTestDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}