package com.jsantos.factory.audit;

import com.jsantos.factory.appinfo.IProvider;

public interface IAuditUIProvider  extends IProvider{

	
	public boolean isImplemented();
	void UserSearchScreen(Object mainArea);
	void CreateOrUpdateUserScreen(Object mainArea);
	
}
