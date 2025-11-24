package com.jsantos.custom.menu;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.util.MapValues;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public interface IMenuProvider {

	

	boolean isImplemented();

	Component getMenu(Component parent,Component mainArea, MapValues<Object> data);
	
	String getProviderName();
	
	

}
