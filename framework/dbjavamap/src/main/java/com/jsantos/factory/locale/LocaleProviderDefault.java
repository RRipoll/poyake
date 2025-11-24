package com.jsantos.factory.locale;

import java.util.Locale;

public class LocaleProviderDefault implements ILocaleProvider{

	@Override
	public Locale getLocale() {
			Locale locale= Locale.ENGLISH;
			return locale;
		}
		

}
