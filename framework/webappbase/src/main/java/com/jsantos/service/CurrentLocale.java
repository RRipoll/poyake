package com.jsantos.service;

import java.util.Locale;

import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;

import com.jsantos.factory.locale.ILocaleProvider;


public class CurrentLocale implements ILocaleProvider{
	
	@Override
	public  Locale getLocale() {
		Locale locale= Locale.ENGLISH;
		try {
			 locale =   (Locale)Executions.getCurrent().getSession().getAttribute(Attributes.PREFERRED_LOCALE);
		} catch (Exception e) {
			;
		}
		return locale;
	}
}
