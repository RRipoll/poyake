package com.jsantos.service;


import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.extendeddto.StoreValuesTestExtDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;

public interface ITestEventRunner {
	
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody);

	public void showStarting(String url, Object parameters, String json);
	
	public StoreValuesTestExtDTO runEvent(IDetachedRecord event, StoreValuesTestExtDTO storeValues) throws Exception ;
	
	public String forEventType();
	
	default IDetachedRecord mapper(IDetachedRecord dr) {
		return dr;
	}
	public IDetailContainer getDetailContainer();
	
	public MTTable getMTTable();
	
	public default String getDescription() {
    	return forEventType();
    }
}
