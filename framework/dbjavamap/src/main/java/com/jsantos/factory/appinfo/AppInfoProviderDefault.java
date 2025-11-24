package com.jsantos.factory.appinfo;

import java.sql.SQLException;
import java.util.HashMap;

public class AppInfoProviderDefault implements IAppInfoProvider {

	HashMap<String, Object> cacheValues = new HashMap<String, Object>();
	public final Integer INPUTUSERDEFAULT=1;
	
	@Override
	public  Object get(String key, Integer inputUserGroupId
			) throws SQLException{
		if(cacheValues.size()==0)init();	
		return cacheValues.get(key);
		}

	@Override
	public  void set(String key, Object value, Integer inputUserGroupId
			) throws SQLException{
		cacheValues.put(key, value);	
	}
	
	
	private void init() throws SQLException {
		set(NasFolder.LOG, "/logs",INPUTUSERDEFAULT
				);
		set(NasFolder.INPUT, "/input",INPUTUSERDEFAULT
				);
		set(NasFolder.TRANSACTIONFILES, "/input/transactionfiles",INPUTUSERDEFAULT
				);
		set(NasFolder.MANUALTESTS, "/test/manualtests",INPUTUSERDEFAULT
				);
		set(NasFolder.AUTOMATEDTESTS, "/test/automatedtests",INPUTUSERDEFAULT
				);
		set(NasFolder.REPORTS, "/output/reports",INPUTUSERDEFAULT
				);
		set(NasFolder.OUTPUT, "/output",INPUTUSERDEFAULT
				);
		set(NasFolder.COLLECTIONS, "/output/collections",INPUTUSERDEFAULT
				);
		set(NasFolder.TMP, "/tmp",INPUTUSERDEFAULT
				);
		set(NasFolder.BLACKLIST, "/output/blacklist",INPUTUSERDEFAULT
				);
		set(NasFolder.DOCEXAMPLE, "/example/input/documents/",INPUTUSERDEFAULT
				);
		set(NasFolder.PATH, "",INPUTUSERDEFAULT
				);
	}
/*
	@Override
	public Object get(String key) throws SQLException {
		
		return get(key,INPUTUSERDEFAULT);
	}

	

	@Override
	public Object getInputUserDefault() {
		
		 return INPUTUSERDEFAULT;
	}

	@Override
	public void set(String key, Object value) throws SQLException {
		set(key, value, INPUTUSERDEFAULT);
		
	}
*/
	

	
	
	
}
