package com.jsantos.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.Hashtable;

import com.jsantos.common.util.MapValues;
import com.jsantos.custom.extendeddto.AppInfoExtDTO;
import com.jsantos.factory.appinfo.IAppInfoProvider;
import com.jsantos.factory.audit.AuditFactory;
import com.jsantos.metadata.MTAuditData;
import com.jsantos.metadata.config.AppInfoDTO;


public class AppInfoProvider implements IAppInfoProvider{
	
	//public final Integer INPUTUSERDEFAULT=1;
	

	Hashtable<String, String> cacheValues = new Hashtable<String, String>();
	Hashtable<String, Date> cacheDates = new Hashtable<String, Date>();
	Boolean cacheEnabled = null;
	static final long CACHE_TIMEOUT_MS = 10000;
	
	public  Object get(String key, Integer inputUserGroupId
			) throws SQLException{
		if (isCacheEnabled()){
			if (null != cacheDates.get(key) && CACHE_TIMEOUT_MS > new Date().getTime() - cacheDates.get(key).getTime())
				if (null != cacheValues.get(key))
					return cacheValues.get(key);
		}
		
		AppInfoExtDTO appInfoDTO= new AppInfoExtDTO();
		
		appInfoDTO.load(key,inputUserGroupId);
		
		return appInfoDTO.getSValue();
	}
	
	 public boolean isCacheEnabled() throws SQLException{
		return true;
	}
	
	public  void set(String key, Object svalue, Integer inputUserGroupId
			) throws SQLException{
		
		if(null==inputUserGroupId)inputUserGroupId=1;
		AppInfoDTO appInfoDTO= new AppInfoDTO("skey='"+key+"'");
		appInfoDTO.setSKey(key);
		appInfoDTO.setSValue(svalue.toString());
		appInfoDTO.setInputUserGroupId(inputUserGroupId);
		appInfoDTO.insertOrUpdate();
	}
/*
	@Override
	public Object get(String key) throws SQLException {
		
		return get(key,AuditFactory.getProvider().);
	}
*/
/*	
	@Override
	public void set(String key, Object value) throws SQLException {
		
		set( key,  value,INPUTUSERDEFAULT);
	}
*/
/*	
	@Override
	public Object getInputUserDefault() {
		
		 return INPUTUSERDEFAULT;
	}
*/
}