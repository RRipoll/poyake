package com.jsantos.factory.locale;

import java.util.Locale;

import com.jsantos.factory.appinfo.IProvider;

public interface ILocaleProvider  extends IProvider{

	public Locale getLocale();
	
}
